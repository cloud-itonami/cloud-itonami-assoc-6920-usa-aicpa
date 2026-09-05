(ns association.facts-test
  "What the catalog claims about itself, asserted.

  The ns docstring says every entry cites an OFFICIAL aicpa.org /
  aicpa-cima.com / pub.aicpa.org URL and that a rule not in the table has no
  spec-basis. Those are the two claims a reader relies on, so they are checked
  here rather than left to the prose."
  (:require [clojure.test :refer [deftest is testing]]
            [clojure.string :as str]
            [clojure.edn :as edn]
            [association.facts :as facts]))

(def ^:private entries (vec (facts/spec-basis "aicpa")))

(deftest aicpa-has-spec-basis
  (is (seq entries) "an empty catalog satisfies every 'every entry ...' test below")
  (is (every? #(= "6920" (:association-rule/isic %)) entries))
  (is (every? #(= "USA" (:association-rule/country %)) entries))
  (is (every? #(= "aicpa" (:association-rule/association %)) entries)))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "keidanren")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest every-entry-cites-an-official-aicpa-url
  ;; The claim in the ns docstring. A citation on some other host, or on plain
  ;; http, is exactly the thing this repo says it will not carry.
  (let [official #{"pub.aicpa.org" "www.aicpa-cima.com" "us.aicpa.org" "www.aicpa.org"}]
    (doseq [e entries]
      (testing (:association-rule/id e)
        (let [url (:association-rule/url e)]
          (is (string? url))
          (is (str/starts-with? url "https://"))
          (is (contains? official (second (re-find #"^https://([^/]+)/" url)))
              "the host must be one AICPA actually publishes on")
          (is (= :official-association-site (:association-rule/url-provenance e))))))))

(deftest entry-ids-are-unique-and-namespaced
  (is (= (count entries) (count (distinct (map :association-rule/id entries)))))
  (is (every? #(str/starts-with? (:association-rule/id %) "aicpa.") entries)))

(deftest every-entry-is-titled-and-dated-where-a-date-was-found
  ;; Dates are recorded ONLY where the source carried one, so this asserts the
  ;; fields that are always present and leaves the optional ones to the parity
  ;; test, which checks them per entry against the port.
  (doseq [e entries]
    (testing (:association-rule/id e)
      (is (not (str/blank? (:association-rule/title e))))
      (is (not (str/blank? (:association-rule/retrieved-at e))))
      (is (seq (:association-rule/topic e)) "a rule nobody can find by topic is not in the catalog"))))

(deftest the-tx-data-carries-the-same-catalog
  ;; data/datascript-tx.edn is what tools/gen_kotoba.cljs reads. If it drifts
  ;; from the .cljc, the port is generated from facts this namespace does not
  ;; hold and the federation query answers differently than this code does.
  (let [tx (edn/read-string (slurp "data/datascript-tx.edn"))
        strip #(-> % (dissoc :association-rule/topic))]
    (is (= (count entries) (count tx)))
    (is (= (mapv strip entries) (mapv strip tx))
        "every non-topic field, entry by entry, in order")
    (is (= (mapv #(set (:association-rule/topic %)) entries)
           (mapv #(set (:association-rule/topic %)) tx))
        "topic is a set in the .cljc and a vector in the tx-data; the members must match")))

(deftest coverage-is-honest
  (let [c (facts/coverage ["aicpa" "keidanren"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["keidanren"] (:missing-associations c)))
    (is (str/includes? (:note c) (str (count entries) " aicpa rules"))
        "the note states the count, so it must be computed from the catalog")))

(deftest by-topic-filters
  (is (= ["aicpa.bylaws-and-council-resolutions"]
         (mapv :association-rule/id (facts/by-topic "aicpa" :governance))))
  (is (= ["aicpa.sas-au-c-currently-effective"
          "aicpa.ssars-ar-c-currently-effective"
          "aicpa.ssae-at-c-currently-effective"]
         (mapv :association-rule/id (facts/by-topic "aicpa" :assurance)))
      "a topic that matches several entries must return all of them, in catalog order")
  (is (= ["aicpa.trust-services-criteria" "aicpa.soc-2-description-criteria"]
         (mapv :association-rule/id (facts/by-topic "aicpa" :soc))))
  (is (empty? (facts/by-topic "aicpa" :labor)))
  (is (empty? (facts/by-topic "keidanren" :ethics))))

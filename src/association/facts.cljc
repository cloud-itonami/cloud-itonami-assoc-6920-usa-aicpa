(ns association.facts
  "Industry self-regulatory rule catalog for the American Institute of
  Certified Public Accountants (AICPA) -- an 8th industry-association-
  level source (see cloud-itonami-assoc-6419-jpn-zenginkyo, -6512-jpn-sonpo,
  -6612-jpn-jsda, -6419-deu-bankenverband, -6612-usa-finra, -6512-usa-naic,
  -6920-jpn-jicpa for the first seven) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). Aligned to ISIC 6920
  (accounting/tax/audit) -- the SAME ISIC code as jicpa (JPN), completing
  a 4th same-ISIC cross-country pair (after 6419, 6512, 6612). Every
  entry cites an OFFICIAL aicpa.org / aicpa-cima.com / pub.aicpa.org URL
  -- never fabricated. A rule not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.

  Code of Professional Conduct was verified by directly reading the
  source PDF cover page text via the Read tool (same strictest-tier
  verification as sonpo/bankenverband/naic/jicpa) -- \"Effective December
  15, 2014. Updated for all official releases through December 2025.\"
  is printed on the document's own cover page. The Bylaws download page
  was directly WebFetch-verified.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"aicpa"
   [{:association-rule/id "aicpa.code-of-professional-conduct"
     :association-rule/title "Code of Professional Conduct"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://pub.aicpa.org/codeofconduct/ethicsresources/et-cod.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2014-12-15"
     :association-rule/last-revised-date "2025-12"
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:ethics :member-conduct}}
    {:association-rule/id "aicpa.bylaws-and-council-resolutions"
     :association-rule/title "AICPA Bylaws and Implementing Resolutions of Council"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.aicpa-cima.com/resources/download/aicpa-bylaws-and-implementing-resolutions-of-council"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6920-usa-aicpa Wave 0 (ADR-2607141700): "
                 (count (get catalog "aicpa")) " aicpa rules seeded with an "
                 "official citation. Extend `association.facts/catalog`, "
                 "never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))

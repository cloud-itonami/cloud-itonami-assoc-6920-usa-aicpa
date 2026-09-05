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

  How each citation was confirmed, and what that does and does not say:

  - Code of Professional Conduct: the source PDF's own cover page was read
    (\"Effective December 15, 2014. Updated for all official releases
    through December 2025.\"). Strictest tier -- the document says its own
    name and dates.
  - Every other entry: the official download page was fetched and the
    document title it names was compared to the title recorded here. That
    confirms the URL resolves to the named document; it does NOT mean the
    PDF behind it was opened, so dates are recorded ONLY where the
    document's own title or the page's statement about the document
    carried them. Entries with no date carry none on purpose.

  A 200 alone is not confirmation. aicpa-cima.com serves a JavaScript
  shell for these routes and the retired us.aicpa.org/research/standards/*
  paths all 301 to one generic landing page, so a status code and even a
  distinct byte count can be identical for a live citation and a dead
  one. The title on the rendered page is what was compared.")

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
     :association-rule/topic #{:governance}}
    {:association-rule/id "aicpa.sas-au-c-currently-effective"
     :association-rule/title "AICPA SASs – currently effective"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/aicpa-statements-on-auditing-standards-currently-effective"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2026-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:auditing :assurance}}
    {:association-rule/id "aicpa.ssars-ar-c-currently-effective"
     :association-rule/title "AICPA SSARSs – currently effective"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/aicpa-ssarss-currently-effective"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2026-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:compilation-review :assurance}}
    {:association-rule/id "aicpa.ssae-at-c-currently-effective"
     :association-rule/title "AICPA SSAEs – currently effective"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/aicpa-ssaes-currently-effective"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2026-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:attestation :assurance}}
    {:association-rule/id "aicpa.statements-on-standards-for-tax-services"
     :association-rule/title "Statements on Standards for Tax Services No. 1–4 (1/1/2024)"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/revised-statements-on-standards-for-tax-services-no-1-4-1-1-2024"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2024-01-01"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:tax :member-conduct}}
    {:association-rule/id "aicpa.quality-management-standards-no-1"
     :association-rule/title "AICPA Statement on Quality Management Standards No. 1"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/aicpa-statement-on-quality-management-standards-no-1"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:quality-management}}
    {:association-rule/id "aicpa.peer-review-standards"
     :association-rule/title "Clarified AICPA Standards For Performing and Reporting On Peer Reviews"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/clarified-aicpa-standards-for-performing-and-reporting-on-peer-reviews"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2026-02-28"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:peer-review :quality-management}}
    {:association-rule/id "aicpa.trust-services-criteria"
     :association-rule/title "2017 Trust Services Criteria (With Revised Points of Focus — 2022)"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/2017-trust-services-criteria-with-revised-points-of-focus-2022"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2017"
     :association-rule/last-revised-date "2022"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:soc :information-security}}
    {:association-rule/id "aicpa.soc-2-description-criteria"
     :association-rule/title "2018 SOC 2® Description Criteria (With Revised Implementation Guidance – 2022)"
     :association-rule/association "aicpa"
     :association-rule/isic "6920"
     :association-rule/country "USA"
     :association-rule/kind :professional-standard
     :association-rule/url "https://www.aicpa-cima.com/resources/download/get-description-criteria-for-your-organizations-soc-2-r-report"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2018"
     :association-rule/last-revised-date "2022"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:soc :information-security}}]})

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
      :note (str "cloud-itonami-assoc-6920-usa-aicpa (ADR-2607141700): "
                 (count (get catalog "aicpa")) " aicpa rules, each citing an "
                 "official AICPA URL confirmed to resolve to the named "
                 "document. Extend `association.facts/catalog`, "
                 "never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))

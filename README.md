# cloud-itonami-assoc-6920-usa-aicpa

Industry self-regulatory rule catalog for the **American Institute of
Certified Public Accountants** (AICPA) — an 8th industry-association-
level source alongside
[`cloud-itonami-assoc-6419-jpn-zenginkyo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-jpn-zenginkyo),
[`cloud-itonami-assoc-6512-jpn-sonpo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-jpn-sonpo),
[`cloud-itonami-assoc-6612-jpn-jsda`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-jpn-jsda),
[`cloud-itonami-assoc-6419-deu-bankenverband`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-deu-bankenverband),
[`cloud-itonami-assoc-6612-usa-finra`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-usa-finra),
[`cloud-itonami-assoc-6512-usa-naic`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-usa-naic),
and
[`cloud-itonami-assoc-6920-jpn-jicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-jpn-jicpa).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Aligned to **ISIC 6920** (accounting/tax/audit) — the SAME code as
jicpa (JPN), completing a 4th same-ISIC cross-country pair (after 6419,
6512, 6612) via the federation query.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on AICPA's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth, authored by
  hand.
- `data/datascript-tx.edn` — the same catalog as DataScript tx-data (query
  it alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources
  via `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).
- `src/association_facts.kotoba` — the same catalog as Kotoba, reaching the
  oracle, wasm and both native ISAs. **Generated** by `tools/gen_kotoba.cljs`
  from the tx-data; do not edit by hand, regenerate:

  ```
  nbb tools/gen_kotoba.cljs
  ```

The `.cljc` is written by hand and the `.kotoba` is generated from the
`.edn`, so the two faces are produced independently — which is the only
reason `test/association_facts_kotoba_parity_test.clj` comparing them field
by field means anything. Do not "simplify" that by generating both from one
source.

## How the citations were checked

- **Code of Professional Conduct** — the source PDF's own cover page was
  read ("Effective December 15, 2014. Updated for all official releases
  through December 2025."). Strictest tier: the document states its own name
  and dates.
- **Every other entry** — the official download page was fetched and the
  document title it names was compared against the title recorded here. That
  confirms the URL resolves to the named document. It does *not* mean the PDF
  behind it was opened, so a date is recorded **only** where the document's
  own title, or the page's statement about the document, carried one. Entries
  with no date carry none on purpose, and the parity test asserts the port
  omits it on exactly those entries.

**A 200 is not confirmation.** `aicpa-cima.com` serves a JavaScript shell for
these routes, and the retired `us.aicpa.org/research/standards/*` paths all
301 to a single generic landing page — so status code, content type and even
a plausible byte count look the same for a live citation and a dead one. The
rendered title is what was compared.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Rule text itself
remains AICPA's; this repo stores only citation metadata (id/title/url/
dates), not full rule text.

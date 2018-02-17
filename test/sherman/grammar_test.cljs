(ns sherman.grammar-test
  (:require [cljs.test :refer-macros [is testing async]]
            [cljs.spec.alpha :as s]
            [devcards.core :refer-macros [deftest]]))


(defn- bracketed [term]
  (and (.startsWith term "#") (.endsWith term "#")))


(deftest test-helpers
  (is (not (bracketed "hi"))))


(s/def :sherman.grammar/expanding-symbol
  (s/and string?))


(deftest test-expanding-symbols
  (is (s/valid? :sherman.grammar/expanding-symbol "#expands#"))
  (is (not (s/valid? :sherman.grammar/expanding-symbol "non-expanding")))
  )


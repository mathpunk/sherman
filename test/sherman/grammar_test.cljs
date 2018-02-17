(ns sherman.grammar-test
  (:require [sherman.helpers :refer [bracketed]]
            [cljs.test :refer-macros [is testing async]]
            [cljs.spec.alpha :as s]
            [devcards.core :refer-macros [deftest]]))


(s/def :sherman.grammar/expanding-symbol
  (s/and string?
         #(bracketed %)))


(deftest test-expanding-symbols
  (is (s/valid? :sherman.grammar/expanding-symbol "#expands#"))
  (is (not (s/valid? :sherman.grammar/expanding-symbol "non-expanding")))
  (is (not (s/valid? :sherman.grammar/expanding-symbol "#mistake"))))


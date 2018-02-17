(ns sherman.grammar-test
  (:require [cljs.test :refer-macros [is testing async]]
            [cljs.spec.alpha :as s]
            [devcards.core :refer-macros [deftest]]))

(deftest test-testing-in-grammar
  (is (= true true)))


#_(s/def :sherman.grammar/expanding-symbol string?)


(deftest test-expanding-symbols
  (is (s/valid? :sherman.grammar/expanding-symbol "#expands#")))


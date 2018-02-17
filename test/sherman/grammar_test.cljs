(ns sherman.grammar-test
  (:require [cljs.test :refer-macros [is testing async]]
            [cljs.spec.alpha :as s]
            [devcards.core :refer-macros [deftest]]))

(deftest test-testing-in-grammar
  (is (= true true)))


#_(deftest test-expansion-symbol
    (is (s/valid? :server.sherman.grammar.core/expanding-symbol "#expanding#"))
    (is (not (s/valid? :server.sherman.grammar.core/expanding-symbol "non-expanding")))
    )

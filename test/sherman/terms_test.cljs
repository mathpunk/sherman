(ns sherman.terms-test
  (:require [sherman.terms]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))


(deftest test-testing-in-grammar
  (is (= true true)))


(deftest test-expanding-symbols
  (is (s/valid? :sherman.terms/expanding-symbol "#expands#"))
  (is (not (s/valid? :sherman.terms/expanding-symbol "terminating")))
  (is (not (s/valid? :sherman.terms/expanding-symbol "#mistake")))
  (is (not (s/valid? :sherman.terms/expanding-symbol "mista#e"))))


(deftest test-terminating-symbols
  (is (s/valid? :sherman.terms/terminating-symbol "terminating"))
  (is (not (s/valid? :sherman.terms/terminating-symbol "#expanding#")))
  (is (not (s/valid? :sherman.terms/terminating-symbol "#error"))))


(deftest test-valid-sequences
  (is (s/valid? :sherman.terms/valid-sequence ["terminating" "sequences" "are" "fine"]))
  (is (s/valid? :sherman.terms/valid-sequence ["#sequences#" "with" "#expanding#" "terms" "are" "#too#"]))
  (is (not (s/valid? :sherman.terms/valid-sequence ["however" "no" "#mistakes" "are#" "per#mitted" "at" "#all#"]))))


(deftest test-valid-simple-terms
  (is (s/valid? :sherman.terms/valid-term "#expands#"))
  (is (s/valid? :sherman.terms/valid-term "This also #expands#"))
  (is (s/valid? :sherman.terms/valid-term "Validity can be #complicated#, my friend"))
  (is (s/valid? :sherman.terms/valid-term "Alas, poor #friend#: An #expander#'s #punctuation#? #Irrelevant#."))
  (is (s/valid? :sherman.terms/valid-term "Even the m-dash, #friend#---that's valid."))
  (is (s/valid? :sherman.terms/valid-term "A #expander#'s punctuation shouldn't #matter#."))
  (is (s/valid? :sherman.terms/valid-term "Mind you not everything has to expand."))
  (is (not (s/valid? :sherman.terms/valid-term "But terms with #mistakes should be rejected"))))


(deftest test-valid-modified-terms
  (is (s/valid? :sherman.terms/valid-term "#name.capitalize#")))


(cljs.test/run-tests)

(ns sherman.corpora-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [sherman.corpora :as corpora]
            [cljs.spec.alpha :as s]))


(deftest test-testing-in-corpora
  (is (= true true)))


(deftest test-loading-corpus
  (let [corpus (corpora/load-corpus ["humans" "tolkienCharacterNames"])]
    (is (contains? corpus "names"))
    (is (contains? corpus "description")))
  (let [corpus (corpora/load-corpus ["materials" "gemstones"])]
    (is (contains? corpus "description"))
    (is (contains? corpus "source"))
    (is (contains? corpus "gemstones"))))


(cljs.test/run-tests)

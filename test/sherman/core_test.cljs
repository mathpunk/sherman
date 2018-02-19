(ns sherman.core-test
  (:require [sherman.core]
            [cljs.test :refer-macros [deftest is testing async]]
            [cljs.spec.alpha :as s]))


(deftest test-testing-in-core
  (is (= true true)))


(cljs.test/run-tests)

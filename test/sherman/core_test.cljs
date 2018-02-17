(ns sherman.core-test
  (:require [cljs.test :refer-macros [is testing async]]
            [cljs.spec.alpha :as s]
            [devcards.core :refer-macros [deftest]]))

(deftest test-testing-in-core
  (is (= true true)))





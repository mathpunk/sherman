(ns sherman.helpers-test
  (:require [sherman.helpers :as help]
            [cljs.test :refer-macros [deftest is testing async]]
            [cljs.spec.alpha :as s]))


(deftest test-helpers
  (is (not (help/bracketed "hi"))))

(ns sherman.magic-test
  (:require [sherman.magic :as magic]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))


(deftest test-magic-rules
  (is (s/valid? :sherman.rules/rules magic/magic-rules)))


(cljs.test/run-tests)

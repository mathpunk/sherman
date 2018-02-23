(ns sherman.magic-test
  (:require [sherman.magic :as magic]
            [sherman.grammar :as g]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))


(deftest test-magic-rules
  (do
    (s/explain :sherman.rules/rules magic/rules)
    (is (s/valid? :sherman.rules/rules magic/rules))))


(println "")
(dotimes [n 10]
  (println (g/trace magic/rules "spell"))
  (println (g/trace magic/rules "item")))

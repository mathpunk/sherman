(ns sherman.magic-test
  (:require [sherman.magic :as magic]
            [sherman.grammar :as g]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))

(deftest testing-in-magic
  (is (= true true)))


(deftest test-magic-choices
  (let [choices (vals magic/rules)]
    (is (every? #(s/valid? :sherman.rules/choices %) choices))))


(deftest test-magic-rules
  (do
    (s/explain :sherman.rules/rules magic/rules)
    (is (s/valid? :sherman.rules/rules magic/rules))))


(defn sample-magic [int]
  (println "")
  (dotimes [n int]
    (println (g/trace magic/rules "spell"))
    (println (g/trace magic/rules "item"))))

(sample-magic 5)

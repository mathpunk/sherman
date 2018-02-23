(ns sherman.oaths-test
  (:require [sherman.oaths :as oaths]
            [sherman.grammar :as g]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))


(deftest testing-in-oaths
  (is (= true true)))


(deftest test-oath-choices
  (let [choices (vals oaths/rules)]
    (is (every? #(s/valid? :sherman.rules/choices %) choices))))


(deftest test-oath-rules
  (is (s/valid? :sherman.rules/rules oaths/rules))
  (s/explain :sherman.rules/rules oaths/rules))


(defn sample-oaths [int]
  (println "")
  (dotimes [n int]
    (println (g/trace oaths/rules "oath"))))


(sample-oaths 10)


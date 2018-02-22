(ns sherman.oaths-test
  (:require [sherman.oaths :as oaths]
            [sherman.grammar :as g]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))


(deftest testing-in-oaths
  (is (= true true)))


(deftest test-god-choices
  (is (s/valid? :sherman.rules/choices oaths/god-choices))
  (is (s/valid? :sherman.rules/choices oaths/dark-god-choices))
  )


(deftest test-oath-rules
  (is (s/valid? :sherman.rules/rules oaths/rules)))


(println "")
(dotimes [n 5]
  (println (g/trace oaths/rules "oath")))

(ns sherman.grammar-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [sherman.grammar :as g]
            [cljs.spec.alpha :as s]))


(deftest test-testing-in-grammar
  (is (= true true)))


(deftest test-grammar-creation
  (let [rules {"character" ["cat" "dog"]
               "macguffin" ["bed" "mat" "spot"]
               "story" ["The #character# sat on the #character#'s #macguffin#."]}]
    (is (g/grammar rules))))


(deftest test-generation
  (let [simple-rules {"character-one" ["man"]
                      "character-two" ["dog"]
                      "verb" ["bites"]
                      "story" ["#character-one.capitalize# #verb# #character-two#."]}
        generator (g/grammar simple-rules)]
    (is (= (.flatten generator "#story#") "Man bites dog."))
    #_(is (= (g/generate generator "story") "Man bites dog."))
    ))


(cljs.test/run-tests)

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


(deftest test-trace-generation
  (let [simple-rules {"character-one" ["man"]
                      "character-two" ["dog"]
                      "verb" ["bites"]
                      "story" ["#character-one.capitalize# #verb# #character-two#."]}
        generator (g/grammar simple-rules)]
    (is (= (.flatten generator "#story#") "Man bites dog."))
    (is (= (g/trace simple-rules "story") "Man bites dog."))
    ))


(deftest test-applying-rules-to-templates
  (let [simple-rules {"food" ["milkshakes"]
                      "sentiment" ["delicious"]}]
    (is (= (g/apply simple-rules "#food.capitalize# are #sentiment#!")
           "Milkshakes are delicious!"))
    (is (= (g/apply simple-rules "There's nothing more #sentiment# than #food.a#.")
           "There's nothing more delicious than a milkshakes."))
    (is (= (g/apply simple-rules
                    "#food.capitalize# are #sentiment#!"
                    "#food.capitalize# are #sentiment#!")
           "Milkshakes are delicious!"))))


(deftest test-grammar-inputs-are-rules
  (let [good-rules {"food" ["milkshakes" "artichokes"]
                    "preference" ["like" "hate"]
                    "sentiment" ["delicious" "repellent"]
                    "sentence" ["I #preference# #food#" "#food.capitalize# are #sentiment#"]}]
    (is (s/valid? :sherman.rules/rules good-rules)) ;; Validating test input
    ;; TODO: Test that grammar yields a helpful error message when given invalid rules.
    ))




(cljs.test/run-tests)

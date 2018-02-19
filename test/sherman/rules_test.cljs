(ns sherman.rules-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [sherman.rules]
            [cljs.spec.alpha :as s]))


(deftest test-testing-of-rules
  (is (= true true)))


(deftest test-choices
  (is (s/valid? :sherman.rules/choices ["ham" "cheese" "egg"]))
  (is (s/valid? :sherman.rules/choices ["shinies" "sword of #dangerous#" "shield of #protective#" "#artefact#"]))
  (is (not (s/valid? :sherman.rules/choices ["#errors" "mistakes#" "other"]))))


(deftest test-valid-rules-map
  (let [wizard-story {"wizard" ["Gandalf" "Saruman" "Snape" "Dumbledore" "Zatanna" "John Constantine"]
                      "verb" ["killed" "kissed"]
                      "exclamation" ["I can't believe #wizard# #verb# #wizard#!"]}
        mistake-story {"character" ["Abel" "Beth"]
                       "verb" ["#mistook" "took"]
                       "object" ["hat" "ride#"]
                       "story" ["#character# #verb# #character# for a #object#"]}]
    (is (s/valid? :sherman.rules/rules wizard-story))
    (is (not (s/valid? :sherman.rules/rules mistake-story)))))


(deftest test-valid-sentences
  (let [rules {"food" ["milkshakes" "artichokes"]
               "preference" ["like" "hate"]
               "sentiment" ["delicious" "repellent"]
               "sentence" ["I #preference# #food#" "#food.capitalize# are #sentiment#"]}
        sentence-choices (rules "sentence")
        sample-sentence (first sentence-choices)]
    (is (s/valid? :sherman.terms/valid-term sample-sentence))
    (s/explain :sherman.rules/choices sentence-choices)
    (is (s/valid? :sherman.rules/choices sentence-choices))
    ))


(cljs.test/run-tests)

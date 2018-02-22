(ns sherman.rules-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [sherman.magic :as magic]
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
    (is (not (s/valid? :sherman.rules/rules mistake-story)))
    ;; TODO: any expander should appear in the map as a key
    ))


(deftest test-valid-sentences
  (let [rules {"food" ["milkshakes" "artichokes"]
               "preference" ["like" "hate"]
               "sentiment" ["delicious" "repellent"]
               "sentence" ["I #preference# #food#" "#food.capitalize# are #sentiment#"]}
        sentence-choices (rules "sentence")
        sample-sentence (first sentence-choices)]
    (is (s/valid? :sherman.terms/valid-term sample-sentence))
    (is (s/valid? :sherman.rules/choices sentence-choices))))


(deftest test-loaded-magic-elements
  (is (s/valid? :sherman.rules/rules magic/wizard))
  (is (s/valid? :sherman.rules/rules magic/monster))
  (is (s/valid? :sherman.rules/rules magic/ethnicity))
  (is (s/valid? :sherman.rules/rules magic/profession))
  (is (s/valid? :sherman.rules/rules magic/prepared))
  #_(is (s/valid? :sherman.rules/rules magic/artifact))
  (is (s/valid? :sherman.rules/rules magic/jewelry))
  (is (s/valid? :sherman.rules/rules magic/lovecraftian))
  (is (s/valid? :sherman.rules/rules magic/clothing))
  (is (s/valid? :sherman.rules/rules magic/item))
  (is (s/valid? :sherman.rules/rules magic/projection))
  (is (s/valid? :sherman.rules/rules magic/projectile))
  (is (s/valid? :sherman.rules/rules magic/element))
  (is (s/valid? :sherman.rules/rules magic/necromantic))
  (is (s/valid? :sherman.rules/rules magic/charm))
  (is (s/valid? :sherman.rules/rules magic/gemstone))
  (is (s/valid? :sherman.rules/rules magic/illusory))
  (is (s/valid? :sherman.rules/rules magic/thaumaturgy))
  (is (s/valid? :sherman.rules/rules magic/adjective))
  (is (s/valid? :sherman.rules/rules magic/fortune))
  (is (s/valid? :sherman.rules/rules magic/fate))
  (is (s/valid? :sherman.rules/rules magic/end))
  (is (s/valid? :sherman.rules/rules magic/fluid))
  (is (s/valid? :sherman.rules/rules magic/metal))
  (is (s/valid? :sherman.rules/rules magic/spell))
  (is (s/valid? :sherman.rules/rules magic/item))
  )


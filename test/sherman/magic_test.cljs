(ns sherman.magic-test
  (:require [sherman.magic :as magic]
            [sherman.grammar :as g]
            [cljs.test :refer-macros [deftest is testing]]
            [cljs.spec.alpha :as s]))



(deftest test--magic-elements
  (is (s/valid? :sherman.rules/rules magic/adjective))
  (is (s/valid? :sherman.rules/rules magic/animal))
  (is (s/valid? :sherman.rules/rules magic/artefact))
  (is (s/valid? :sherman.rules/rules magic/charm))
  (is (s/valid? :sherman.rules/rules magic/clothing))
  (is (s/valid? :sherman.rules/rules magic/corpus))
  (is (s/valid? :sherman.rules/rules magic/description))
  (is (s/valid? :sherman.rules/rules magic/element))
  (is (s/valid? :sherman.rules/rules magic/end))
  (is (s/valid? :sherman.rules/rules magic/ethnicity))
  (is (s/valid? :sherman.rules/rules magic/fate))
  (is (s/valid? :sherman.rules/rules magic/fluid))
  (is (s/valid? :sherman.rules/rules magic/fortune))
  (is (s/valid? :sherman.rules/rules magic/gemstone))
  (is (s/valid? :sherman.rules/rules magic/illusory))
  (is (s/valid? :sherman.rules/rules magic/item))
  (is (s/valid? :sherman.rules/rules magic/jewelry))
  (is (s/valid? :sherman.rules/rules magic/lovecraftian))
  (is (s/valid? :sherman.rules/rules magic/metal))
  (is (s/valid? :sherman.rules/rules magic/monster))
  (is (s/valid? :sherman.rules/rules magic/necromantic))
  (is (s/valid? :sherman.rules/rules magic/prepared))
  (is (s/valid? :sherman.rules/rules magic/profession))
  (is (s/valid? :sherman.rules/rules magic/projectile))
  (is (s/valid? :sherman.rules/rules magic/projection))
  (is (s/valid? :sherman.rules/rules magic/quality))
  (is (s/valid? :sherman.rules/rules magic/spell))
  (is (s/valid? :sherman.rules/rules magic/text))
  (is (s/valid? :sherman.rules/rules magic/thaumaturgy))
  (is (s/valid? :sherman.rules/rules magic/weapon))
  (is (s/valid? :sherman.rules/rules magic/wizard)))


(deftest test-magic-rules
  (do
    (s/explain :sherman.rules/rules magic/rules)
    (is (s/valid? :sherman.rules/rules magic/rules))))



(println "")
(dotimes [n 10]
  (println (g/trace magic/rules "spell"))
  (println (g/trace magic/rules "item")))

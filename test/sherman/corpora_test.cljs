(ns sherman.corpora-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [sherman.corpora :as corpora]
            [cljs.spec.alpha :as s]))


(deftest test-testing-in-corpora
  (is (= true true)))


(deftest test-get
  (let [corpus (corpora/get-corpus ["materials" "gemstones"])]
    (is (contains? corpus "description"))
    (is (contains? corpus "source"))
    (is (contains? corpus "gemstones"))))


(deftest test-retrieve
  (let [planets (corpora/retrieve-items ["science" "planets"] "planets")]
    (is (vector? planets))
    (is (every? (fn [planet] (and (contains? planet "name")
                                  (contains? planet "moons")))))))


(deftest test-collection-helpers
  (let [planet-maps (corpora/retrieve-items ["science" "planets"] "planets")
        planets (corpora/join-field planet-maps "name")
        moons (corpora/join-field planet-maps "moons")]
    (is (coll? planets))
    (is (some #{"Mercury"} planets))
    (is (coll? moons))
    (is (some #{"Moon"} moons))))



;; science minor_planets
;; science planets

;; Nice corpora
;; ---------------------
;; humans norwayFirstNamesBoys
;; humans norwayFirstNamesGirls
;; humans spanishFirstNamesGirls
;; humans spanishFirstNamesBoys
;; mythology greek_titans
;; mythology lovecraft
;; - deities
;; mythology greek_gods
;; mythology norse_gods

;; roles
;; archetypes character characters
;; divination tarot_interpretations tarot_interpretations
;; - keywords
;; - name (split "/" into two)
;; - only if suit is "major"

;; qualities
;; archetypes event events
;; animals common animals
;; humans descriptions descriptions
;; materials layperson-metals
;; words encouraging_words
;; words literature lovecraft_words

;; items
;; materials abridged-body-fluids
;; mythology greek_monsters + human bodyParts + like, wings and stuff
;; mythology greek_monsters
;; mythology monsters

;; plants plants
;; - instruments (?) name
;; - adjective wand of #plant#



;; words literatore spells, incantation (maybe for wizards)


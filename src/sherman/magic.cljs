(ns sherman.magic
  (:require [sherman.corpora :as corpora]))


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
;; science minor_planets
;; science planets

;; words literatore spells, incantation (maybe for wizards)


;; People
(def wizard-names ["Gandalf" "Zigil" "Zatanna" "Erowid" "Urza" "Glinda" "Rincewind" "Garibaldi" "Slaariel" "Hippolyta"])

(defn clean-name [character-name]
  (-> character-name
      (clojure.string/replace "(Steward)" "")
      (clojure.string/replace #"\(\w+ Age\)" "")
      (clojure.string/trim)))

(def tolkien-names
  (let [corpus (corpora/load-corpus ["humans" "tolkienCharacterNames"])]
    (map clean-name (corpus "names"))))

(def wizard {"wizard" (concat wizard-names tolkien-names)})
(def ethnicity {"ethnicity" ["elvish" "dwarven" "ogrish" "halfling" "orcish" "goblin"]})
(def profession {"profession" ["fighter" "thief" "rogue" "bard" "druid" "ranger" "wizard" "cleric" "shaman" "warrior" "paladin"]})

;; Items
(def jewelry {"jewelry" ["torque" "ring" "pendant" "jewel" "amulet"]})
(def clothing {"clothing" ["cape" "shroud" "shawl" "sweater" "cloak" "belt" "helm" "mantle"]})

;; TODO: Something terrible happens in this version of artefacts
#_(def artifact
    (let [artifacts (get (corpora/load-corpus ["archetypes" "artifact"]) "artifacts")
          all-names (fn [artifact] (conj (artifact "synonyms") (artifact "name")))
          artifact-names (vector (mapcat all-names artifacts))
          other-artifacts ["wand" "music box" "scroll" "mask"]]
      {"artifact" (concat artifact-names other-artifacts)}))

(def reading {"text" {"book" "scroll" "tome" "tablet"}})
(def artefact {"artefact" ["#jewelry#" "#clothing#" "#text#"]})

(def fluid
  (let [corpus (corpora/load-corpus ["materials" "abridged-body-fluids"])
        fluids (get corpus "abridged body fluids")]
    {"fluid" fluids}))
(def monster
  (let [monsters (get (corpora/load-corpus ["mythology" "monsters"]) "names")]
    {"monster" monsters}))

;; Magic
(def projection {"projection" ["#element#" "hail of #projectile#" "rain of #projectile#" "burst of #element#"]})
(def projectile {"projectile" ["glitter" "#element#" "blades" "thorns" "stones" "sparks"]})
(def charm {"charm" ["charm" "cantrip" "dweomer" "incantation" "enchantment"]})
(def element {"element" ["flame" "fire" "frost" "cold" "lightning" "wind"]})

;; Schools
(def necromantic {"necromantic" ["gloomy" "regretful" "mourning" "undying" "death"]})
(def illusory {"illusory" ["illusory" "glittering" "prismatic" "phantasmic" "bewildering"]})
(def thaumaturgy {"thaumaturgy" ["evocation" "thaumaturgy" "invocation" "abjuration" "divination" "channeling" "sorcery"]})

;; Qualities
(def lovecraftian
  (let [corpus (corpora/load-corpus ["words" "literature" "lovecraft_words"])]
    {"lovecraftian" (get corpus "words")}))
(def adjective {"adjective" ["steely" "stalwart" "crafty" "endless" "subtle" "#lovecraftian#" "#necromantic#" "#illusory#" "creeping" "violent" "ubiquitous" "troubled"]})
(def gemstone {"gemstone" ((corpora/load-corpus ["materials" "gemstones"]) "gemstones")})
(def metal
  (let [metals (get (corpora/load-corpus ["materials" "layperson-metals"]) "layperson metals")]
    {"metal" metals}))
(def prepared
  {"prepared" ["enchanted" "cursed" "boiled" "steeped" "herbed" "poisoned"]})

;; Ends
(def fortune {"fortune" ["fortune" "wishes" "luck" "protection" "second chances" "courage" "fortitude"]})
(def fate {"fate" ["fate" "doom" "toil" "forever" "emancipation" "allure" "imprisonment" "mortality" "rebirth"]})
(def end  {"end" ["#fate#" "#fortune#"]})

;; Sentences
(def spell {"spell" ["#projectile# of #wizard#"
                     "#wizard#'s #necromantic# #charm#"
                     "#wizard#'s #illusory# #charm#"
                     "#wizard#'s #illusory# #projectile#"
                     "#element# #charm# of the #adjective#"
                     "bonds of #metal#"
                     "blast of #lovecraftian# #projectile#"
                     "#wizard#'s #necromantic# #projectile#"]})

(def item {"item" ["#ethnicity.a# #clothing# of #end#"
                   "#profession.a#'s #jewelry# of #fortune#"
                   "#wizard#'s #item# of #adjective# #end#"
                   "#item# of #thaumaturgy#"
                   "#gemstone# #jewelry# of #adjective# #end#"
                   "#fluid# of #monster#"
                   "#prepared# #monster#'s #fluid#"
                   ]})

;; Assembly
(def magic-rules (merge wizard
                        monster
                        ethnicity
                        profession
                        jewelry
                        clothing
                        projection
                        projectile
                        element
                        necromantic
                        charm
                        illusory
                        thaumaturgy
                        adjective
                        fortune
                        fate
                        end
                        artifact
                        item

                        prepared
                        lovecraftian
                        gemstone
                        fluid
                        metal

                        spell
                        item))

(ns sherman.magic
  (:require [sherman.corpora :as corpora]))


;; People
(def wizard-names ["Gandalf" "Zigil" "Zatanna" "Erowid" "Urza" "Glinda" "Rincewind" "Garibaldi" "Slaariel" "Hippolyta"])
(def tolkien-names
  (let [corpus (corpora/load-corpus ["humans" "tolkienCharacterNames"])]
    (corpus "names")))
(def wizard {"wizard" (concat wizard-names tolkien-names)})
(def ethnicity {"ethnicity" ["elvish" "dwarven" "ogrish" "halfling" "orcish" "goblin"]})
(def profession {"profession" ["fighter" "thief" "rogue" "bard" "druid" "ranger" "wizard" "cleric" "shaman" "warrior" "paladin"]})

;; Items
(def artefact {"artefact" ["wand" "staff" "music box" "scroll" "book" "#jewelry#" "#clothing#" "tome"]})
(def jewelry {"jewelry" ["torque" "ring" "pendant" "jewel" "amulet"]})
(def clothing {"clothing" ["cape" "shroud" "shawl" "sweater" "cloak" "belt" "helm" "mantle"]})

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
(def adjective {"adjective" ["steely" "stalwart" "crafty" "endless" "subtle" "#necromantic#" "#illusory#"
                             "creeping" "violent" "ubiquitous" "troubled"]})
(def gemstone {"gemstone" ((corpora/load-corpus ["materials" "gemstones"]) "gemstones")})

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
                     "#wizard#'s #necromantic# #projectile#"]})

(def item {"item" ["#ethnicity.a# #clothing# of #end#"
                   "#profession.a#'s #jewelry# of #fortune#"
                   "#wizard#'s #artefact# of #adjective# #end#"
                   "#artefact# of #thaumaturgy#"
                   "#gemstone# #jewelry# of #adjective# #end#"
                   ]})

;; Assembly
(def magic-rules (merge wizard 
                        ethnicity 
                        profession 
                        artefact 
                        jewelry 
                        clothing 
                        projection 
                        projectile 
                        element 
                        necromantic 
                        charm
                        gemstone
                        illusory
                        thaumaturgy 
                        adjective 
                        fortune 
                        fate 
                        end 
                        spell 
                        item))


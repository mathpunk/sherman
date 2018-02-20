(ns sherman.magic
  (:require [sherman.grammar :refer [grammar]]))


;; People
(def wizard {"wizard" ["Gandalf" "Zigil" "Zatanna" "Erowid" "Urza"]})
(def ethnicity {"ethnicity" ["elvish" "dwarven" "ogrish" "halfling"]})
(def profession {"profession" ["fighter" "thief" "rogue" "bard" "druid" "ranger" "wizard" "cleric" "shaman" "warrior" "paladin"]})

;; Items
(def artefact {"artefact" ["wand" "staff" "music box" "scroll" "book" "#jewelry#" "#clothing#"]})
(def jewelry {"jewelry" ["torque" "ring" "pendant" "jewel" "amulet"]})
(def clothing {"clothing" ["cape" "shroud" "shawl" "sweater" "cloak" "belt" "helm" "mantle"]})

;; Magic
(def projection {"projection" ["#element#" "hail of #projectile#" "rain of #projectile#"]})
(def projectile {"projectile" ["glitter" "#element#" "blades" "thorns" "stones" "sparks"]})
(def element {"element" ["flame" "fire" "frost" "cold" "lightning" "wind"]})

;; Schools
(def necromantic {"necromantic" ["gloomy" "regretful" "mourning" "undying" "death"]})
(def illusion {"illusion" ["glittering" "prismatic" "phantasmic" "bewildering"]})
(def thaumaturgy {"thaumaturgy" ["evocation" "thaumaturgy" "invocation" "abjuration" "divination" "channeling" "sorcery"]})

;; Qualities
(def adjective {"adjective" ["steely" "stalwart" "crafty" "endless" "subtle"
                             "creeping" "violent" "ubiquitous" "saucy" "troubled"]})

;; Ends
(def fortune {"fortune" ["fortune" "wishes" "luck" "protection" "second chances" "courage" "fortitude"]})
(def fate {"fate" ["fate" "doom" "toil" "ending" "forever"]})
(def end  {"end" ["#fate#" "#fortune#"]})

;; Sentences
(def spell {"spell" ["#wizard#'s #projection#"
                     "#necromantic# #projectile# of #wizard#"
                     "#illusion# #projectile# of #wizard#"]})

(def item {"item" ["#ethnicity.a# #clothing# of #end#"
                   "#profession.a#'s #jewelry# of #fortune#"
                   "#wizard#'s #artefact# of #adjective# #end#"
                   "the #artefact# of #thaumaturgy#"]})

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
                        illusion 
                        thaumaturgy 
                        adjective 
                        fortune 
                        fate 
                        end 
                        spell 
                        item))


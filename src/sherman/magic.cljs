(ns sherman.magic
  (:require [clojure.string]
            [sherman.corpora :as corpora]))

;; TODO: It's great fun to add things to this, but there's significant duplication of information in this haphazard method. What helpers could be appropriate?

;; People
(def wizard-names ["Gandalf" "Zigil" "Zatanna" "Erowid" "Urza" "Glinda" "Rincewind" "Garibaldi" "Slaariel" "Hippolyta"])

(def wizard {"wizard" (concat wizard-names corpora/tolkien-names)})
(def ethnicity {"ethnicity" ["elvish" "dwarven" "ogrish" "halfling" "orcish" "goblin"]})
(def profession {"profession" ["fighter" "thief" "rogue" "bard" "druid" "ranger" "wizard" "cleric" "shaman" "warrior" "paladin"]})

;; Items
(def jewelry {"jewelry" ["torque" "bracer" "anklet" "choker" "ring" "pendant" "jewel" "amulet"]})
(def clothing {"clothing" ["cape" "shroud" "shawl" "sweater" "cap" "hat" "cloak" "belt" "helm" "mantle"]})
(def text {"text" ["book" "scroll" "tome" "tablet" "codex"]})

(def artefact {"artefact" (concat ["music box" "wand" "#jewelry#" "#clothing#" "#text#"]
                                  corpora/artefacts)})


;; Living things
(def fluid {"fluid" corpora/body-fluids})

(def monster {"monster" corpora/monsters})

(def animal {"animal" corpora/common-animals})

;; Magic
(def projection {"projection" ["#element#" "hail of #projectile#" "rain of #projectile#" "burst of #element#"]})
(def projectile {"projectile" ["glitter" "#element#" "blades" "thorns" "stones" "sparks"]})
(def charm {"charm" ["charm" "cantrip" "dweomer" "incantation" "enchantment"]})
(def element {"element" ["flame" "fire" "frost" "cold" "lightning" "wind"]})

;; Schools
(def necromantic {"necromantic" ["gloomy" "regretful" "mourning" "undying" "death"]})
(def illusory {"illusory" ["illusory" "glittering" "prismatic" "phantasmic" "bewildering"]})
(def thaumaturgy {"thaumaturgy" ["evocation" "thaumaturgy" "invocation" "abjuration" "divination" "channeling" "sorcery" "enchantment" "necromancy" "illusions"]})

;; Qualities
(def lovecraftian {"lovecraftian" corpora/lovecraft-words})

(def adjective {"adjective" ["steely" "stalwart" "crafty" "endless" "subtle" "#lovecraftian#" "#necromantic#" "#illusory#" "creeping" "violent" "ubiquitous" "troubled"]})

(def description
  {"description" corpora/human-descriptions})

(def gemstone {"gemstone" corpora/gemstones})

(def metal {"metal" corpora/common-metals})

(def prepared
  {"prepared" ["enchanted" "cursed" "boiled" "steeped" "herbed" "poisoned"]})

;; Ends
(def fortune {"fortune" ["fortune" "wishes" "luck" "protection" "second chances" "courage" "fortitude"]})
(def fate {"fate" ["fate" "doom" "toil" "forever" "emancipation" "allure" "imprisonment" "mortality" "rebirth"]})
(def end  {"end" ["#fate#" "#fortune#"]})
(def quality {"quality" ["reflexes" "agility" "strength" "wisdom" "speed" "perspicuity" "fortitude" "courage"]})
(def corpus {"collection" ["library" "tower" "crypt" "tomb"]})
(def weapon {"weapon" ["bow" "arrow" "dart" "sword" "axe" "dagger" "mace" "flail"]})

;; Sentences
(def spell {"spell" ["#projectile# of #wizard#"
                     "#charm# of #animal#-like #quality#"
                     "#wizard#'s #necromantic# #charm#"
                     "#wizard#'s #illusory# #charm#"
                     "#wizard#'s #illusory# #projection#"
                     "#wizard#'s blast of #lovecraftian# #projectile#"
                     "#element# #charm# of the #adjective#"
                     "ward against #monster#s"
                     "beguile #animal#s"
                     "#wizard#'s bonds of #metal#"
                     "#wizard#'s #necromantic# #projection#"]})

(def item {"item" ["#ethnicity.a# #clothing# of #end#"
                   "#monster#bane #weapon#"
                   "#profession.a#'s #jewelry# of #fortune#"
                   "#wizard#'s #artefact# of #adjective# #end#"
                   "a fragment of #charm.a# from #wizard#'s grimoire"
                   "#clothing# of the #description# #animal#"
                   "#lovecraftian.a# #text# from #wizard#'s #collection#"
                   "#illusory.a# #metal# #jewelry#"
                   "#gemstone# #jewelry# of #adjective# #end#"
                   "#animal.a#, mummified for #thaumaturgy#"
                   "#fluid# of #monster#"
                   "#prepared# #monster#'s #fluid#"
                   ]})

;; Assembly
(def rules (merge
            adjective
            animal
            artefact
            charm
            clothing
            corpus
            description
            element
            end
            ethnicity
            fate
            fluid
            fortune
            gemstone
            illusory
            item
            jewelry
            lovecraftian
            metal
            monster
            necromantic
            prepared
            profession
            projectile
            projection
            quality
            spell
            text
            thaumaturgy
            weapon
            wizard
            ))

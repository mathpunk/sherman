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
(def artifacts
  (let [artifact-maps (get (corpora/get-corpus ["archetypes" "artifact"]) "artifacts")
        all-names (fn [artifact] (conj (artifact "synonyms") (artifact "name")))
        artifact-names (mapcat all-names artifact-maps)
        other-artifacts ["wand" "music box"]]
    (concat (into [] artifact-names) other-artifacts)))
(def artefact {"artefact" (concat ["#jewelry#" "#clothing#" "#text#"] artifacts)})

(def fluid
  (let [corpus (corpora/get-corpus ["materials" "abridged-body-fluids"])
        fluids (get corpus "abridged body fluids")]
    {"fluid" fluids}))
(def monster
  (let [monsters (get (corpora/get-corpus ["mythology" "monsters"]) "names")]
    {"monster" monsters}))
(def animal
  (let [animals (get (corpora/get-corpus ["animals" "common"]) "animals")]
    {"animal" animals}
    ))

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
(def lovecraftian
  (let [corpus (corpora/get-corpus ["words" "literature" "lovecraft_words"])]
    {"lovecraftian" (get corpus "words")}))
(def adjective {"adjective" ["steely" "stalwart" "crafty" "endless" "subtle" "#lovecraftian#" "#necromantic#" "#illusory#" "creeping" "violent" "ubiquitous" "troubled"]})
(def description
  (let [corpus (corpora/get-corpus ["humans" "descriptions"])]
    {"description" (get corpus "descriptions")}))
(def gemstone {"gemstone" ((corpora/get-corpus ["materials" "gemstones"]) "gemstones")})
(def metal
  (let [metals (get (corpora/get-corpus ["materials" "layperson-metals"]) "layperson metals")]
    {"metal" metals}))
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
(def rules (merge wizard
                  description
                  animal
                  text
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
                  artefact
                  prepared
                  lovecraftian
                  gemstone
                  fluid
                  metal
                  weapon
                  quality
                  corpus
                  spell
                  item))

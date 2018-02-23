(ns sherman.corpora
  (:require [cognitect.transit :as transit]
            [clojure.string :as string]
            ["fs" :as fs]))


(defn get-corpus
  "Typically, this gets a map with description key and a key similar to but not identical to the file's name."
  [path-keys]
  (let [filename (str "./resources/corpora/data/"
                      (clojure.string/join "/" path-keys)
                      ".json")
        reader (transit/reader :json)
        file-contents (fs/readFileSync filename)]
    (transit/read reader file-contents)))


(defn retrieve-items
  "Give it both the path to the file, and the key or keys you want to do a get-in with. This probably returns a vector of strings or a vector of maps."
  [path-keys & map-keys]
  (-> (get-corpus path-keys)
      (get-in map-keys)))


(defn join-field [maps key]
  (let [joined (into [] (map #(get % key) maps))]
    (if (sequential? joined)
      (flatten joined)
      joined)))


;; Corpora
;; =================

(def body-fluids
  (retrieve-items ["materials" "abridged-body-fluids"] "abridged body fluids"))

(def body-parts
  (retrieve-items ["humans" "bodyParts"] "bodyParts"))

(def planets (-> (retrieve-items ["science" "planets"] "planets")
                 (join-field "name")))

(def minor-planets (retrieve-items ["science" "minor_planets"] "minor_planets"))

(def tolkien-names
  (let [characters (retrieve-items ["humans" "tolkienCharacterNames"] "names")
        clean-name (comp string/trim #(string/replace % #"\(.+\)" ""))] ;; e.g, remove "(First Age)"
    (map clean-name characters)))

(def greek-gods
  (retrieve-items ["mythology" "greek_myths_master"] "greek_gods"))

(def norse-gods
  (retrieve-items ["mythology" "norse_gods"] "norse_deities" "gods"))

(def norse-goddesses
  (retrieve-items ["mythology" "norse_gods"] "norse_deities" "goddesses"))

(def lovecraft-gods
  (retrieve-items ["mythology" "lovecraft"] "deities"))

(def monsters
  (retrieve-items ["mythology" "monsters"] "names"))

(def common-animals
  (retrieve-items ["animals" "common"] "animals"))

(def lovecraft-words
  (retrieve-items ["words" "literature" "lovecraft_words"] "words"))

(def human-descriptions
  (retrieve-items ["humans" "descriptions"] "descriptions"))

(def gemstones
  (retrieve-items ["materials" "gemstones"] "gemstones"))

(def common-metals
  (retrieve-items ["materials" "layperson-metals"] "layperson metals"))

(def artefacts
  ;; This is a more complicated and interesting data set, but for now let's just retrieve the artefacts
  (let [items (retrieve-items ["archetypes" "artifact"] "artifacts")
        artefact-names (join-field items "name")

        artefact-synonyms (join-field items "synonyms")]
    (concat artefact-synonyms artefact-names)))

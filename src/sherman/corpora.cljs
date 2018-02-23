(ns sherman.corpora
  (:require [cognitect.transit :as transit]
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

(def planets (-> (retrieve-items ["science" "planets"] "planets")
                 (join-field "name")))
(def minor-planets (retrieve-items ["science" "minor_planets"] "minor_planets"))



(defn clean-name [character-name]
  (-> character-name
      (clojure.string/replace #"\(.+\)" "")
      (clojure.string/trim)))

(def tolkien-names
  (->> (retrieve-items ["humans" "tolkienCharacterNames"] "names")
       (map clean-name)))


(def body-parts
  (retrieve-items ["humans" "bodyParts"] "bodyParts"))

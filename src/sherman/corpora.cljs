(ns sherman.corpora
  (:require [cognitect.transit :as transit]
            ["fs" :as fs]))


(defn load-corpus [path-keys]
  (let [filename (str "./resources/corpora/data/"
                      (clojure.string/join "/" path-keys)
                      ".json")
        reader (transit/reader :json)
        file-contents (fs/readFileSync filename)]
    (transit/read reader file-contents)))


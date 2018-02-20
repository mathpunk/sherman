(ns sherman.server
  (:require [sherman.grammar :as grammar]
            [sherman.magic :as magic]
            [cljs.nodejs :as nodejs]))

(defonce express (nodejs/require "express"))
(defonce http (nodejs/require "http"))

                                        ; Create our app.
(def app (express))

(. app (get "/magic/spell"
            (fn [req res]
              (. res
                 (send
                  (grammar/trace magic/magic-rules (rand-nth [ "spell" "item" ])))))))

(. app (get "/magic/item"
            (fn [req res]
              (. res
                 (send
                  (grammar/trace magic/magic-rules (rand-nth [ "spell" "item" ])))))))


                                        ; Listen on port 3000.
(defn -main [& args]
  (let [port 3000]
    (println (str "Serving magic on port " port))
    (doto (.createServer http #(app %1 %2))
      (.listen 3000))))

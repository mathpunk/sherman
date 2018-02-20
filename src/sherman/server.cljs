(ns sherman.server
  (:require [sherman.grammar :as grammar]
            [sherman.magic :as magic]
            [cljs.nodejs :as nodejs]))

(defonce express (nodejs/require "express"))
(defonce http (nodejs/require "http"))


(def app (express))


(defn send-trace [req res sentence]
  (let [message (grammar/trace magic/magic-rules sentence)]
    (. res (send message))))


(. app (get "/magic/spell"
            (fn [req res]
              (send-trace req res "spell"))))


(. app (get "/magic/item"
            (fn [req res]
              (send-trace req res "item"))))


(defn -main [& args]
  (let [port 3000]
    (println (str "Serving magic on port " port))
    (doto (.createServer http #(app %1 %2))
      (.listen 3000))))

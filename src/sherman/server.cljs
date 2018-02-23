(ns sherman.server
  (:require [sherman.grammar :as grammar]
            [sherman.magic :as magic]
            [sherman.oaths :as oaths]
            [cljs.nodejs :as nodejs]))

(defonce express (nodejs/require "express"))
(defonce http (nodejs/require "http"))


(def app (express))


(defn send-trace [req res rules sentence]
  (let [message (grammar/trace rules sentence)]
    (. res (send message))))


(. app (get "/magic/spell"
            (fn [req res]
              (send-trace req res magic/rules "spell"))))


(. app (get "/magic/item"
            (fn [req res]
              (send-trace req res magic/rules "item"))))


(. app (get "/oath"
            (fn [req res]
              (send-trace req res oaths/rules "oath"))))


(defn main [& args]
  (let [port 3000]
    (println (str "Serving magic and oaths on port " port))
    (doto (.createServer http #(app %1 %2))
      (.listen 3000))))

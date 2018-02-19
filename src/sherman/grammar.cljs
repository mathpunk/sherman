(ns sherman.grammar
  (:require [cljs.nodejs :as nodejs]
            [cljs.spec.alpha :as s]))


(def tracery (nodejs/require "tracery-grammar"))


(defn grammar [rules]
  (let [base-grammar (.createGrammar tracery (clj->js rules))]
    (.addModifiers base-grammar (.-baseEngModifiers tracery))
    base-grammar))


(defn generate [rules template-name]
  (.flatten (grammar rules) (str "#" template-name "#")))


#_(defn template [rules & templates]
    (let [sentence-patterns (vec templates)
          sentence-name (str (gensym))
          complete-rules (assoc rules sentence-name sentence-patterns)]
      (trace complete-rules sentence-name)))


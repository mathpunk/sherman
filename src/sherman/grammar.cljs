(ns sherman.grammar
  (:refer-clojure :exclude [apply])
  (:require [cljs.nodejs :as nodejs]
            [cljs.spec.alpha :as s]))


(def tracery (nodejs/require "tracery-grammar"))


(defn grammar [rules]
  (let [base-grammar (.createGrammar tracery (clj->js rules))]
    (.addModifiers base-grammar (.-baseEngModifiers tracery))
    base-grammar))


(defn trace
  "Generate a sentence from rules and a template name. Note, this is different
  from making a generator that you then act on, which could be an okay interface
  too."
  [rules template-name]
  (.flatten (grammar rules) (str "#" template-name "#")))


(defn apply [rules & templates]
  (let [sentence-patterns (vec templates)
        sentence-name (str (gensym))
        complete-rules (assoc rules sentence-name sentence-patterns)]
    (trace complete-rules sentence-name)))

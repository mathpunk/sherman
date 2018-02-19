(ns sherman.terms
  (:require [cljs.nodejs :as nodejs]
            [cljs.spec.alpha :as s]))


(defn- count-hashes [term]
  (count (re-seq #"#" term)))


(defn- hash-bracketed [term]
  (let [hash-occurrences (count-hashes term)
        test-endpoints (and (clojure.string/starts-with? term "#")
                            (clojure.string/ends-with? term "#"))]
    (and test-endpoints (= 2 hash-occurrences))))


(s/def ::expanding-symbol
  (s/and string?
         (fn [term] (= 2 (count-hashes term)))))


(s/def ::terminating-symbol
  (s/and string?
         (fn [term] (= 0 (count-hashes term)))))


(defn- tokenize [term]
  (clojure.string/split term #"\s+"))


(s/def ::valid-sequence
  (s/* (s/alt :expanding ::expanding-symbol :terminating ::terminating-symbol)))


(s/def ::valid-term
  (fn [term]
    (s/valid? ::valid-sequence (tokenize term))))

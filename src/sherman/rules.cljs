(ns sherman.rules
  (:require [cljs.spec.alpha :as s]))


(s/def ::choices (s/coll-of :sherman.terms/valid-term))


(s/def ::rules (s/map-of string? ::choices))

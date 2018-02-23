(ns sherman.oaths
  (:require [clojure.string :as string]
            [sherman.corpora :as corpora]))

(def fluid-choices
  (filter #(= 1 (count (string/split % #" "))) corpora/body-fluids))

(def god-choices
  (concat corpora/greek-gods corpora/norse-gods corpora/norse-goddesses corpora/lovecraft-gods))

(def rules
  {"god" god-choices
   "planet" corpora/planets
   "body-part" corpora/body-parts
   "fluid" fluid-choices
   "oath" ["#god#'s #fluid#!"
           "Moons of #planet#!"
           "By the #body-part# of #god#!"
           "Great #god#!"]
   })

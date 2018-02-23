(ns sherman.oaths
  (:require [sherman.corpora :as corpora]))


(def god-choices
  (let [greek-corpus (corpora/get-corpus ["mythology" "greek_myths_master"])
        norse-corpus (corpora/get-corpus [ "mythology" "norse_gods" ])]
    (concat (get greek-corpus "greek_titans") (get greek-corpus "greek_gods")
            (get-in norse-corpus ["norse_deities" "gods"])
            (get-in norse-corpus ["norse_deities" "goddesses"]))))


(def dark-god-choices
  (let [lovecraft-corpus (corpora/get-corpus ["mythology" "lovecraft"])]
    (get lovecraft-corpus "deities")))


(def rules
  {"god" god-choices
   "dark-god" dark-god-choices
   "planet" corpora/planets
   "body-part" corpora/body-parts
   "whoever" ["#god#" "#dark-god#"]
   "oath" ["#whoever#'s blood!"
           "Moons of #planet#!"
           "By the #body-part# of #god#!"
           "Great #whoever#!"]
   })






(ns sherman.oaths
  (:require [sherman.corpora :as corpora]))


(def god-choices
  (let [greek-corpus (corpora/load-corpus ["mythology" "greek_myths_master"])
        norse-corpus (corpora/load-corpus [ "mythology" "norse_gods" ])]
    (concat (get greek-corpus "greek_titans") (get greek-corpus "greek_gods")
            (get-in norse-corpus ["norse_deities" "gods"])
            (get-in norse-corpus ["norse_deities" "goddesses"]))))


(def dark-god-choices
  (let [lovecraft-corpus (corpora/load-corpus ["mythology" "lovecraft"])]
    (get lovecraft-corpus "deities")))


(def rules
  {"god" god-choices
   "dark-god" dark-god-choices
   "whoever" ["#god#" "#dark-god#"]
   "oath" ["#whoever#'s blood!"
           "Great #whoever#!"]
   })






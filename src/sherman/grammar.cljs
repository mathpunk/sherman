(ns sherman.grammar
  (:require [sherman.helpers :as help]
            [cljs.test :refer-macros [deftest is testing run-tests]]
            [cljs.spec.alpha :as s]))


(s/def :sherman.grammar/expanding-symbol
  (s/and string?
         #(help/bracketed %)))

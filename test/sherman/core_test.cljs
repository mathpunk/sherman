(ns sherman.core-test
  (:require [cljs.test :refer-macros [is testing async]]
            [devcards.core :refer-macros [deftest]]))

(deftest a-test
  (testing "FIXME, I fail."
    (async done
           (js/setTimeout
            (fn []
              (throw (js/Error. "Jibber")))
            100))))

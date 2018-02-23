(ns sherman.core
  (:require [sherman.magic :as magic]
            [sherman.grammar :as grammar]))


(defn -main [& args]
  (let [rules (merge magic/rules {"spell-or-item" ["#spell#" "#item#"]})]
    (dotimes [n 50]
      (println (grammar/trace rules "spell-or-item")))))

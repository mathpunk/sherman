(ns sherman.helpers)


(defn bracketed [term]
  (and (clojure.string/starts-with? term "#") (clojure.string/ends-with? term "#")))

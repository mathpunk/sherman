(ns sherman.grammar
  (:require [sherman.helpers :refer [bracketed]]
            [cljs.test :refer-macros [deftest is testing run-tests]]
            [cljs.spec.alpha :as s]))


(s/def :sherman.grammar/expanding-symbol
  (s/and string?
         #(bracketed %)))

;; ERROR in (test-expanding-symbols) (cljs/spec/alpha.js:190:104)
;; expected: (s/valid? :sherman.grammar/expanding-symbol "#expands#")
;; actual: #object[Error Error: Unable to resolve spec: :sherman.grammar/expanding-symbol]

;; Ran 3 tests containing 3 assertions.
;; 0 failures, 1 errors.


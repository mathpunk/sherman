(defproject sherman "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.2"]]
  :npm {:dependencies [[source-map-support "0.4.0"]
                       [tracery-grammar "2.7.3"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets [:target-path "out" "release"]
  :target-path "target"
  :tach {:test-runner-ns 'runners.test-runner
         :source-paths ["src" "test"]
         ;; :force-non-zero-exit-on-test-failure? true ;; useful for c.i.
         :cache? true
         :cache-path "out"
         :debug? true
         })

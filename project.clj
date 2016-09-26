(defproject clojurescript-tdd-application "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[devcards "0.2.1-7"]
								 [lein-doo "0.1.7"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.227"]]
  :plugins [[lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]
            [lein-doo "0.1.7"]
            [lein-figwheel "0.5.6"]]
  :clean-targets ^{:protect false} [:target-path "out" "resources/public/cljs"]
  :figwheel { :css-dirs ["resources/public/css"] }
  :cljsbuild {
    :test-commands {"test" ["lein" "doo" "phantom" "test" "once"]}
    :builds [{:id "dev"             ; development configuration
              :source-paths ["src"] ; Paths to monitor for build
              :figwheel true        ; Enable figwheel
              :compiler {:main clojurescript_tdd_application.core     ; your main namespace
                         :asset-path "cljs/out"                       ; Where to load dependendt files go, mind you this one is relative
                         :output-to "resources/public/cljs/main.js"   ; Where the main file will be built
												 :output-dir "resources/public/cljs/out"      ; Directory for temporary files
												 :source-map-timestamp true}                  ; Sourcemaps hurray!
							}
						 {:id "test"
							:source-paths ["src" "test"]
							:compiler {:main runners.doo
												 :optimizations :none
												 :output-to "resources/public/cljs/tests/all-tests.js"}}
             {:id "devcards-test"
              :source-paths ["src" "test"]
              :figwheel {:devcards true}
              :compiler {:main runners.browser
                         :optimizations :none
                         :asset-path "cljs/tests/out"
                         :output-dir "resources/public/cljs/tests/out"
                         :output-to "resources/public/cljs/tests/all-tests.js"
                         :source-map-timestamp true}}

]})

(defproject liberator-tutorial "0.1.0-SNAPSHOT"
  :description "FIXME: Programming Test for Flexian"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.12.2"]]
  :ring {:handler liberator-tutorial.core/handler}
  :dependencies [[org.clojure/clojure "1.9.0"]
    [liberator "0.15.1"]
    [compojure "1.6.0"]
    [ring/ring-core "1.6.3"]
    [ring/ring-json "0.4.0"]
  ])

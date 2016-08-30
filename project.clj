(defproject com.rentpath/rp-reflect-clj "0.1.0-SNAPSHOT"
  :description "Reflection helpers for Clojure's clojure.lang.Reflector class"
  :url "https://github.com/rentpath/rp-reflect"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:rentpath/rp-reflect.git"}
  :deploy-repositories [["releases" :clojars]]
  :global-vars {*warn-on-reflection* true}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]]}})

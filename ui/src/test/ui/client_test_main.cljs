(ns ui.client-test-main
  (:require ui.tests-to-run
            [fulcro-spec.selectors :as sel]
            [fulcro-spec.suite :as suite]))

(enable-console-print!)

(suite/def-test-suite client-tests {:ns-regex #"ui..*-spec"}
  {:default   #{::sel/none :focused}
   :available #{:focused}})


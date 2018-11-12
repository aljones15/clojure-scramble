(ns ui.ui.root
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]
    [ui.ui.scramble-form :refer [ui-scramble-form ScrambleForm]]
  )
)

;; The main UI of your application
(defsc Root [this {:keys [word]}]
  {:query [{:word (prim/get-query ScrambleForm)}]
   :initial-state (fn [params] 
     {:word (prim/get-initial-state ScrambleForm{:one "" :two ""})})
  }
  (dom/div :.flex-container
    (ui-scramble-form word)
  )
)

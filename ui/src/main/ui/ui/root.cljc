(ns ui.ui.root
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]
    [ui.ui.scramble-form :refer [ui-scramble-form ScrambleForm]]
    [fulcro-css.css-injection :as injection]
  )
)

(def flex-rules [:.flex-container :#form-scramble {
  :display "flex"
  :flex-direction "column"
  :justify-content "center"
  :align-items "center"
}])


;; The main UI of your application
(defsc Root [this {:keys [word scramble]} computed {:keys [flex-container]} ]
  {:query [{:word (prim/get-query ScrambleForm)} :scramble]
   :initial-state (fn [params] 
     {:word (prim/get-initial-state ScrambleForm{:one "" :two ""}) :scramble false})
   :css [flex-rules]
  }
  (dom/div {:className flex-container}
    (injection/style-element {:component this})
    (ui-scramble-form word)
    (dom/h3 nil (str "Scramble is " scramble))
  )
)

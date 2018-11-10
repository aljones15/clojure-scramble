(ns ui.ui.root
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]
    [ui.ui.scramble :refer [ui-scramble-form]]))

;; The main UI of your application

(defsc Root [this props]
  (dom/div :.flex-container
    (ui-scramble-form)
  )
)

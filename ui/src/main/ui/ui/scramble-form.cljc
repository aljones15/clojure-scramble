(ns ui.ui.scramble
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]))

(defsc ScrambleForm [this {:keys [ui/word-one ui/word-two]}]
  {:query [:ui/word-one :ui/word-two] 
   :initial-state {:ui/word-one "" :ui/word-two ""}}
  (dom/form :#form-scramble
    (dom/input {:id "input-word-one" :placeholder "word one" :type "text" :value word-one})
    (dom/input {:id "input-word-two" :placeholder "word two" :type "text" :value word-two})
    (dom/button {:form "form-scramble" :type "submit" :formMethod "post" :formAction ::api-endpoint} "Scramble")
  )
)

(def ui-scramble-form (prim/factory ScrambleForm))

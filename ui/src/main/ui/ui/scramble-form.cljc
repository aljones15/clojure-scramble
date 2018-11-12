(ns ui.ui.scramble-form
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]
    [fulcro.client.mutations :refer [defmutation]]
  )
)
(defn extract-value [event]
  "get the value from a react synthetic event"
  (aget event "target" "value")
)

(defmutation word-update [{:keys [word k]}]
  (action [{:keys [state]}]
    (swap! state update-in [:word] assoc k word)
  )
)

(defn handle-input [el k]
  "handles in the input from the words"
  (fn [e]
    (let [word (extract-value e)]
      (prim/transact! el `[(word-update {:word ~word :k ~k})])
    )
  )
)

(defsc ScrambleForm [this {:keys [one two]}]
  {:query [:one :two] 
   :initial-state (fn [{:keys [one two]}] {:one one :two two})}
  (dom/form :#form-scramble {:onSubmit #((.-preventDefault %)(println one two)) }
    (dom/input {
       :id "input-word-one"
       :placeholder "word one"
       :type "text"
       :value one
       :onChange (handle-input this :one)}
    )
    (dom/input {
      :id "input-word-two"
      :placeholder "word two"
      :type "text"
      :value two
      :onChange (handle-input this :two)}
    )
    (dom/button {
      :form "form-scramble"
      :type "submit"
      :formMethod "post"
      :onClick #((.-preventDefault %) (println "one is " one))
      :formAction ::api-endpoint} 
      "Scramble"
    )
  )
)

(def ui-scramble-form (prim/factory ScrambleForm))

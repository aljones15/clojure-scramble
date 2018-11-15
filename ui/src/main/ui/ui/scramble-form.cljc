(ns ui.ui.scramble-form
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    #?(:cljs [fulcro.client.dom :as dom] :clj [fulcro.client.dom-server :as dom])
    [ui.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [fulcro.i18n :as i18n :refer [tr trf]]
  )
)

(defn extract-value [event]
  "get the value from a react synthetic event"
  (aget event "target" "value")
)


(defn handle-input [el k]
  "handles in the input from the words"
  (fn [e]
    (let [word (extract-value e)]
      (prim/transact! el `[(api/word-update {:word ~word :k ~k})])
    )
  )
)

(defn handle-submit [el one two]
  (fn [e]
    (println "handle submit" "one" one  "two" two)
    (.preventDefault e)
    (prim/transact! el `[(api/scramble {"words" [~one, ~two]})])
  )
)

(def flex-item-rules [:.flex-item {
  :margin "0.5rem"
}])

(def btn-rules [:button [:&.flex-item{
  :background-color "#47ec47"
}]])

(defsc ScrambleForm [this {:keys [one two]} computed {:keys [flex-item]}]
  {:query [:one :two] 
   :initial-state (fn [{:keys [one two]}] {:one one :two two})
   :css [flex-item-rules btn-rules]
  }
  (dom/form :#form-scramble {:onSubmit (handle-submit this one two) }
    (dom/input {
       :id "input-word-one"
       :className flex-item
       :placeholder "word one"
       :type "text"
       :value one
       :required true
       :pattern "[a-z]+"
       :onChange (handle-input this :one)}
    )
    (dom/input {
      :id "input-word-two"
      :className flex-item
      :placeholder "word two"
      :type "text"
      :value two
      :required true
      :pattern "[a-z]+"
      :onChange (handle-input this :two)}
    )
    (dom/button {
      :form "form-scramble"
      :className flex-item
      :type "submit" }
      "Scramble"
    )
  )
)

(def ui-scramble-form (prim/factory ScrambleForm))

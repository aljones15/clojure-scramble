(ns ui.api.mutations
  (:require
    [fulcro.client.mutations :refer [defmutation]]
    [fulcro.client.logging :as log]))

;; Place your client mutations here

(comment

(defmutation mutation-symbol
  "docstring"
  [params]
  (action [{:keys [state] :as env}]
    (swap! state ...))
  (rest-api [env] true)
  (remote [env] true))

(defmutation ping-left [params]
  (action [{:keys [state]}]
    (swap! state update-in [:left/by-id 5 :left/value] inc))
  (refresh [env] [:left/value]))

)

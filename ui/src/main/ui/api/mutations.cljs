(ns ui.api.mutations
  (:require
    [fulcro.client.mutations :refer [defmutation]]
    [fulcro.client.logging :as log]
    [fulcro.client.data-fetch :as df]
  )
)

;; Place your client mutations here

(defmutation word-update [{:keys [word k]}]
  (action [{:keys [state]}]
    (swap! state update-in [:word] assoc k word)
  )
)

(defmutation scramble? [{:keys [one two]}]
  (action [{:keys [state]}]
      (swap! state assoc :scramble true)
  )
  (rest [env] true)
)

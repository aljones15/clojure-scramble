(ns liberator-tutorial.core
  (:require [liberator.core :refer [resource defresource]]
            [liberator-tutorial.scramble :refer [scramble?]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params]]
            [compojure.core :refer [defroutes ANY POST]]
            [ring.middleware.cors :refer [wrap-cors]]
  )
)

(defn index [] "try posting to /scramble")

(defn scramble-unwrap [json] (let [words (get json "words")] {:scramble (scramble? words)}))
(defn body-unwrap [ctx] (let [body (get-in ctx [:request :json-params])] body))
(defn valid-words? [json] (let [words (get json "words")] (or (nil? words) (< (count words) 2))))

(defresource scramble-handler []
  :allowed-methods [:post :options]
  :available-media-types ["application/json"]
  :malformed? (fn [ctx] (valid-words? (body-unwrap ctx)))
  :handle-created (fn [ctx] (scramble-unwrap (body-unwrap ctx)))
)

(defroutes app
  (ANY "/" [] (index))
  (POST "/scramble"[] (scramble-handler))
)

(def handler
  (-> app
      (wrap-cors 
        :access-control-allow-origin [#"https?://localhost:[0-9]+"]
        :access-control-allow-methods [:get :post]
        :access-control-allow-headers ["Accept" "Content-Type"]
      )
      wrap-params
      wrap-json-params
  )
)

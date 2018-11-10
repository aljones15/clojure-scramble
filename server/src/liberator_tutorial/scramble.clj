(ns liberator-tutorial.scramble
  (:require [clojure.string :as str])
)

(defn word-2-count
  "turns the second word into a map of letters with counts"
  [[w & ord] result] (
    cond
      (nil? w) result 
      (nil? (result w)) (word-2-count ord (assoc result w 1))
      :else (word-2-count ord (assoc result w (+ 1 (result w)))) 
  )
)

(defn check-count [source-word]
  "checks if the word-2-count could spell each other"
  (fn [acc letter letter-count]
    (cond
      (= acc false) false
      (nil? (get source-word letter)) false
      (< (source-word letter) letter-count) false
      :else true
    )
  )
)


(defn check-scramble [word-one word-two]
  (let [
    word-one-count (word-2-count word-one {})
    word-two-count (word-2-count word-two {})
   ]
    (reduce-kv (check-count word-one-count) true word-two-count)
  )
)

(defn scramble? [[word-one word-two]]
  (cond
    (nil? word-two) false
    (nil? word-one) false
    (> (count word-two) (count word-one)) false
    (= word-one word-two) true
    (check-scramble word-one word-two) true
    :else false
  )
)

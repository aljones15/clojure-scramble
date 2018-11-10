(ns liberator-tutorial.scramble
  (:require [clojure.string :as str])
)

(defn word-2-count
  "turns the second word into a map of letters with counts"
  ([[w & ord]] (word-2-count ord (hash-map w 1)))
  ([[w & ord] result] (
    cond 
      (nil? ord) (assoc result w (+ 1 (result w)))
      (nil? (result w)) (word-2-count ord (assoc result w 1))
      :else (word-2-count ord (assoc result w (+ 1 (result w)))) 
  ))
)

(defn scramble? [[word-one, word-two]]
  (cond
    (nil? word-two) false
    (nil? word-one) false
    (> (count word-two) (count word-one)) false
    (= word-one word-two) true
    :else [word-one word-two]
  )
)

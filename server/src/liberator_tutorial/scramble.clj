(ns liberator-tutorial.scramble)

(defn scramble? [[word-one, word-two]]
  (cond
    (nil? word-two) false
    (nil? word-one) false
    (> (count word-two) (count word-one)) false
    (= word-one word-two) true
    :else [word-one word-two]
  )
)

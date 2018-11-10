(ns liberator-tutorial.scramble-test
  (:require [clojure.test :refer :all]
            [liberator-tutorial.scramble :refer [scramble? word-2-count]]))

(deftest scramble-test
  (testing "should return true for an anagram"
    (is (= (scramble? ["cat" "act"]) true))
  )
  (testing "should return true if the first word contains all letters in a shorter second word"
    (is (= (scramble? ["builder" "bud"])true))
  )
  (testing "should return true if both strings are empty"
    (is (= (scramble? ["" ""]) true))
  )
  (testing "should return false if the second world is longer than the first word"
    (is (= (scramble? ["dog" "dogg"]) false))
  )
  (testing "should return false if there is only one item in the list"
    (is (= (scramble? ["one"]) false))
  )
)

(deftest word-2-count-test
  (testing "should return a map"
    (is (= (word-2-count "aabcc") {\a 2 \b 1 \c 2}))
  )
)

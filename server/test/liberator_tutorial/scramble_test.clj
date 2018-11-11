(ns liberator-tutorial.scramble-test
  (:require [clojure.test :refer :all]
            [liberator-tutorial.scramble :refer [scramble? word-2-count check-scramble]]))

(deftest scramble-test
  (testing "should return true for an anagram"
    (is (= (scramble? ["cat" "act"]) true))
  )
  (testing "should return true for rekqodlw world"
    (is (= (scramble? ["rekqodlw" "world"]) true))
  )
  (testing "should return true for cedewaraaossoqqyt codewars"
    (is (= (scramble? ["cedewaraaossoqqyt" "codewars"]) true))
  )
  (testing "should return false for katas steak"
    (is (= (scramble? ["katas” “steak"]) false))
  )
  (testing "should return false if same length but missing letters"
    (is (= (scramble? ["cat" "bat"]) false))
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
    (is (= (word-2-count "aabcc" {}) {\a 2 \b 1 \c 2}))
  )
  (testing "should return all ones for cat"
    (is (= (word-2-count "cat" {}) {\c 1 \a 1 \t 1}))
  )
  (testing "should return all ones bat"
    (is (= (word-2-count "bat" {}) {\b 1 \a 1 \t 1}))
  )
  (testing "should return all ones rekqodlw"
    (is (= (word-2-count "rekqodlw" {}) {\r 1 \e 1 \k 1 \q 1 \o 1 \d 1 \l 1 \w 1}))
  )
  (testing "should return all ones world"
    (is (= (word-2-count "world" {}) {\w 1 \o 1 \r 1 \l 1 \d 1}))
  )
)

(deftest check-scramble-test 
  (testing "cat bat should return false"
    (is (= (check-scramble "cat" "bat") false))
  )
  (testing "rekqodlw worldshould return true"
    (is (= (check-scramble "rekqodlw" "world") true))
  )
)

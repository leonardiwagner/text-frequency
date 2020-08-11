(ns text-frequency.core-test
  (:require [clojure.test :refer :all]
            [text-frequency.core :as text-frequency]))

(deftest should-count-words
  (let [text "two two one four four four four three three three"
        result (text-frequency/count-words text)
        expectation {:four 4 :three 3 :two 2 :one 1}]
    (is (= result expectation))))

(deftest should-sort-words
  (let [words {:two 2 :three 3 :four 4 :one 1}
        result (text-frequency/sort-words words)
        expectation {:four 4 :three 3 :two 2 :one 1}]
    (is (= result expectation))))

(deftest merge-count-words
  (let [words1 {:two 1 :three 2 :four 1}
        words2 {:two 1 :three 1 :four 3}
        result (text-frequency/merge-words words1 words2)
        expectation {:two 2 :three 3 :four 4}]
    (is (= result expectation))))

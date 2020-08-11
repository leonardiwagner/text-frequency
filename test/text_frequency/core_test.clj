(ns text-frequency.core-test
  (:require [clojure.test :refer :all]
            [text-frequency.core :as text-frequency]))

(deftest should-count-words
  (let [text "two two one four four four four three three three"
        result (text-frequency/count-words text)
        expectation {:four 4 :three 3 :two 2 :one 1}]
    (is (= result expectation))))

(ns text-frequency.core)

(defn count-words [text]
  (let [words (clojure.string/split text #" ")]
    (reduce
      (fn [coll word]
        (if (contains? coll (keyword word))
          (update coll (keyword word) inc)
          (assoc coll (keyword word) 1)))
      {} words)))

(defn merge-words [words1 words2]
  (reduce
    (fn [coll word]
      (if (contains? coll (keyword word))
        (update coll (keyword word) + (get words2 word))
        (assoc coll (keyword word) (get words2 (keyword word)))))
    words1 (keys words2)))

(defn sort-words [words]
  (into (sorted-map-by
          #(compare (get words %2)
                    (get words %1)))
        words))

(defn -main []
  (-> "two two one three three"
      (count-words)
      (merge-words {:three 1})
      (sort-words)
      (println)))


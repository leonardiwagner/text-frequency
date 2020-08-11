(ns text-frequency.core)

(defn count-words [text]
  (let [words (clojure.string/split text #" ")]
    (reduce
      (fn [coll word]
        (if (contains? coll (keyword word))
          (update coll (keyword word) inc)
          (assoc coll (keyword word) 1)))
      {} words)))

(defn sort-words [words]
  (into (sorted-map-by
          #(compare (get words %2)
                    (get words %1)))
        words))

(defn -main []
  (-> "two two one three three three"
      (count-words)
      (sort-words)
      (println)))


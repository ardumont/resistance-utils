(ns resistor.core
  (:use [midje.sweet]))

(fact (+ 1 1) => 2)

;; there are multiple resistor schemes
;; col1 col2 power precision-percentage
;; col1 col2 col3 power precision-percentage

;; the color for the first 2 resistance colors from left to right
(def colors {:black  0
             :brown  1
             :red    2
             :orange 3
             :yellow 4
             :green  5
             :blue   6
             :violet 7
             :grey   8
             :white  9
             ;; precision percentage
             :silver 10
             :gold   5})

(defn unit
  [s]
  (read-string (clojure.string/join "" s)))

(fact
  (unit [1 0 0]) => 100)

;; A multi method to compute the resistor's capacity
(defmulti resistor count)

;; for 3 rings color
(defmethod resistor 3
  [r]
  (let [f (map colors (take 2 r))
        l (repeat (colors (last r)) 0)]
    (unit (concat f l))))

(fact "3 ring resistor"
  (resistor [:brown :black :orange]) => 10000)

(future-fact "4 ring resistor"
  (resistor [:brown :black :orange :silver]))

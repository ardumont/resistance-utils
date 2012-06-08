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

(defn precision "Given a number and a precision, return the range"
  [n p]
  (let [np (* n (/ p 100))]
    [(- n np) (+ n np)]))

(fact
  (precision 100 10) => [90 110])

(defn unit "Given a vector of digits, return the numbers"
  [s]
  (read-string (clojure.string/join "" s)))

(fact
  (unit [1 0 0]) => 100
  (unit [9 8 7]) => 987)

(defn compute-resistor "Given a resistor and a number n, compute the resistor's capacity"
  [r n]
  (let [f (map colors (take n r))
        l (repeat (colors (last r)) 0)]
    (unit (concat f l))))

(fact
  (compute-resistor [:brown :black :orange]       2) => 10000
  (compute-resistor [:brown :black :orange :blue] 3) => 103000000)

;; A multi method to compute the resistor's capacity
(defmulti resistor count)

;; for 3 ring color resistor
(defmethod resistor 3
  [r]
  (compute-resistor r 2))

(fact "3 ring resistor"
  (resistor [:brown :black :orange]) => 10000)

;; 4 ring color resistor
(defmethod resistor 4
  [r]
  (let [p (colors (last r))
        c (resistor (butlast r))]
    (precision c p)))

(fact "4 ring resistor"
  (resistor [:brown :black :orange :silver]) => [9000 11000]
  (resistor [:brown :black :orange :gold]) => [9500 10500])

(defmethod resistor 5
  [r]
  (let [p (colors (last r))
        c (compute-resistor (butlast r) 3)]
    (precision c p)))

(fact "5 ring resistor"
  (resistor [:brown :black :orange :blue :silver]) => [92700000 113300000])

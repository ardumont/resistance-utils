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
             :silver "10%"
             :gold   "5%"})

(defmulti resistor count)

(defmethod resistor 3
  [[a b c]]
  (concat  [(colors a)] [(colors b)] (repeat (colors c) 0)) )

(fact
  (resistor [:brown :black :orange]) => [1 0 0 0 0])

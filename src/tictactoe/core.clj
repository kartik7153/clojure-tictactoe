(ns tictactoe.core
  (:gen-class))
;marking an square
;find the value of the square

;Data Structure options
;map of tuple to string
;vector of vectors

; Four states
; 
(def empty-board [[" " " " " "] [" " " " " "] [" " " " " "]])

(defn transpose-board [board]
  (apply mapv vector board))

(defn show-row
  [row]
  (str "| " (clojure.string/join " | " row) " |"))

(defn show-board
  [board]
  (clojure.string/join "\n" (for [row board] (show-row row))) )

(defn get-square
  [board x y]
  {:pre [(<= 0 x 2) (<= 0 y 2)]}
  (get-in board [x y]))

(defn check-row
  [board x]
  (apply = (get board x)))


(defn check-diagonal
  [board x y]
             (if (= x y)
               (apply = (for [i (range 3)]  (get-in board [i i])))
              (apply = (for [i (range 3)] (get-in board [i (- 2 i)])))))

(defn check-result
  [board x y]
  (if (or (check-row board x) (check-row (transpose-board board) y) (check-diagonal board x y))
    (print (str (get-square board x y) " wins"))
    (print "no winner yet")))

(defn mark-square
  [board x y v]
  {:pre [(<= 0 x 2) (<= 0 y 2) (or (= v "X") (= v "O")(= v " "))
         (= (get-square board x y) " ")]}
  (assoc-in board [x y] v))

(defn board-state [board] nil)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))



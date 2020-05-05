(ns sunflowerseastar.tetris
  (:require
   [sunflowerseastar.helpers :refer [math-jax-wrapper]]
   [sunflowerseastar.components :refer [clojure-code iframe]]))

(defn tetris []
  (math-jax-wrapper
   [:div.content
    (iframe "https://tetris.sunflowerseastar.com"
            [:p.iframe-note [:strong "enter"] ": " [:em "rotate"] " (and " [:em "restart"] "), "
             [:strong "left"] "/" [:strong "right"] ": " [:em "move piece"] ", "
             [:strong "d"] ": " [:em "advance downward"] ", "
             [:strong "p"] ": " [:em "toggle pause"] ", "
             [:strong "r"] ": " [:em "restart"]]
            false)
    [:div.content-inner
     [:h2 "Tetris"]
     [:p "A friend of mine said, " [:em "So they say, once you start writing tetris, it’ll pretty much write itself. And it’s easy."] " Thinking he was right, I wanted to see if I could write Tetris on my return flight after our visit."]
     [:p "I sent him an email the next day telling him how far I got with the code, and I told him that it wasn’t as easy as he made it out to be—he was wrong. He replied to my email with a working tetris implementation in JavaScript, and said it only took him a couple hours. He was right—haha, fantastic!"]
     [:p "Inspired, I finished up my version. I didn’t throw too many bells and whistles at it, but it’ll count completed lines and advance a level every 10 lines (by decreasing the “tick” speed)."]
     [:p "The setup is similar to the chess implementation in that it’s " [:a {:href "https://github.com/reagent-project/reagent" :rel "noreferrer" :target "_blank"} "reagent"] " with global game state up top (examples truncated):"]

     [:pre
      [:span.code-label "clojure"]
      [:code.clojure "
(defonce board-width 10)
(defonce board-height 20)
(defonce queue-length 1)
(defonce tick-duration-multiplier 0.9)

(defonce game-initial-state {:is-paused true
                             :active-piece-type nil
                             :active-piece-color nil
                             :game-over true
                             :rows-completed 0
                             :piece-queue nil
                             :level 1
                             :bump-level false
                             :tick-duration 700
                             :board (generate-board board-width board-height)})

"]]

     [:p "...and then state-updaters:"]

     [:pre
      [:span.code-label "clojure"]
      [:code.clojure "
(defn end-game! []
  (do (swap! game assoc :game-over true)
      (js/clearInterval @tick-interval)
      (swap! game assoc :is-paused true)))

(defn rotate! []
  (let [{:keys [active-piece-type board]} @game
        new-xs-ys (board->rotated-active-xs-ys active-piece-type board)]
    (xs-ys->replace-actives! new-xs-ys)))
"]]

     [:p "...and then a board!"]

     [:pre
      [:span.code-label "clojure"]
      [:code.clojure "
[:div.board
 (map-indexed
  (fn [y row]
    (map-indexed
     (fn [x square]
       (let [{:keys [color]} square]
         [:div.square
          {:key (str x y)
           :style {:grid-column (+ x 1) :grid-row (+ y 1)
                   :grid-template-columns \"repeat(10, 10%)\"
                   :background color}}]))
     row))
  (:board @game))]
"]]

     [:p "I have this dream of writing the board in multiple matrices and using an APL inside Clojure like " [:a {:href "https://github.com/phantomics/april" :rel "noreferrer" :target "_blank"} "april"] " to calculate rotations and boundaries. But I don‘t know if that‘ll ever become reality or not. Meanwhile, I have helpers to figure out what’s possible:"]

           (clojure-code
"
(defn get-x-y [board x-y]
  (let [x (first x-y) y (second x-y)]
    (if (x-y-in-bounds? x-y board)
      (get-square x y board)
      nil)))

(defn get-actives [board]
  (->> board
       flatten
       (filter #(= (:active %) true))))

(defn xs-ys-in-bounds? [xs-ys board]
  (let [board-width (count (first board))
        board-height (count board)
        xs (map first xs-ys)
        ys (map second xs-ys)
        max-x (reduce max xs)
        min-x (reduce min xs)
        x-in-bounds (and (>= min-x 0) (< max-x board-width))
        min-y (reduce min ys)
        max-y (reduce max ys)
        y-in-bounds (and (>= min-y 0) (< max-y board-height))]
    (and x-in-bounds y-in-bounds)))

(defn xs-ys-are-free? [xs-ys board]
  (->> xs-ys
       (map #(get-x-y board %))
       (filter #(not (true? (:active %))))
       (map nil?)
       (every? true?)))

(defn piece-can-rotate? [piece-type board]
  (let [new-xs-ys (board->rotated-active-xs-ys piece-type board)
        in-bounds (xs-ys-in-bounds? new-xs-ys board)]
    (and in-bounds (xs-ys-are-free? new-xs-ys board))))

(defn board-has-4-in-a-row? [board]
  (loop [rows (reverse board) col nil num 1]
    (let [r (first rows)
          pos (positions nil? r)
          count-pos (count pos)]
      (cond (not= count-pos 1) false
            (and (not (nil? col)) (not= (first pos) col)) false
            (and (= (first pos) col) (= num 4)) true
            :else (recur (rest rows) (first pos) (inc num))))))
")


     [:div.center
      [:a.link.content-link {:href "https://tetris.sunflowerseastar.com" :rel "noreferrer" :target "_blank"} "tetris"]
      [:a.link.content-link {:href "https://github.com/sunflowerseastar/tetris/blob/master/src/tetris/core.cljs" :rel "noreferrer" :target "_blank"} "code"]]


     ]]))

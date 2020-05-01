(ns sunflowerseastar.tetris
  (:require
   [sunflowerseastar.helpers :refer [math-jax-wrapper]]
   [sunflowerseastar.components :refer [clojure-code iframe]]))

(defn tetris []
  (math-jax-wrapper
   [:div.content
    (iframe "https://tetris.sunflowerseastar.com"
            [:p.note "space: rotate, left/right/down: move piece, p: toggle pause, r: restart"]
            false)
    [:div.content-inner
     [:h2 "Tetris"]
     [:p "A friend of mine said, 'So they say, once you start writing tetris, it'll pretty much write itself. And it's easy.' Thinking he was right, I wanted to see if I could write Tetris on my return flight after our visit."]
     [:p "It turns out he was wrong. I emailed him and told him that during the flight, I was able to get the board set up, and a square piece to fall and move left and right. He was underestimating it."]
     [:p "He replied to my email with a working tetris implementation in JavaScript, and it only took him a couple hours. So he was right!"]
     [:p "Oh well. I finished up my version anyhow. My version had different colors for the pieces, so maybe that's where all the complexity was. ;) "]
     ]]))

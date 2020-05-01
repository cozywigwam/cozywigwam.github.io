(ns sunflowerseastar.blackjack
  (:require
   [sunflowerseastar.helpers :refer [math-jax-wrapper]]
   [sunflowerseastar.components :refer [clojure-code iframe]]))

(defn blackjack []
  (math-jax-wrapper
   [:div.content
    (iframe "https://blackjack.sunflowerseastar.com")
    [:div.content-inner
     [:img {:src "blackjack.png"}]
     [:h2 "blackjack"]
     [:p "So I read something (maybe on lobste.rs?) about how programming playing cards is non-trivial. This was bad news for me, because I wasn’t able to shake the thought. How trivial would it be, I thought? How non-trivial would it be? I can’t just " [:em "not"] " know how trivial or not trivial this is!"]
     [:p "First, I need a data structure. I want it to feel easy to understand and work with."]
     (clojure-code "
(defn generate-deck []
  (vec (for [suit ['s 'c 'd 'h] rank [2 3 4 5 6 7 8 9 10 11 12 13 14]] {:suit suit :rank rank})))

(def deck (atom (generate-deck)))
")
     [:p "Looks serviceable. Now divide the deck."]
     (clojure-code "
(defn divide-deck [deck]
  (let [separation-point (+ (/ (count deck) 2) (- (rand-int 10) 5))]
    [(take separation-point deck) (drop separation-point deck)]))
")
     [:p "This " [:em "weighted shuffle"] " was fun to write: recursively choose every other card, except loosely, plus a normalizing parameter."]
     (clojure-code "
(defn weighted-shuffle [a b]
  (loop [a a b b l [] probably-a 50]
    (let [r (rand-int 100)]
      (cond (and (empty? a) (empty? b)) l
            (empty? a) (concat l b)
            (empty? b) (concat l a)
            (< r probably-a) (recur (rest a) b (conj l (first a)) (- probably-a 15))
            :else (recur a (rest b) (conj l (first b)) (+ probably-a 15))))))
")
     [:p "This is a one-player game (versus dealer), with no betting, so the state is minimal."]
     (clojure-code
      "
(def game-initial-state {:state :stopped
                         :turn :none
                         :current-split 0
                         :dealer-wins 0
                         :your-wins 0
                         :current-winner nil
                         :pushes 0
                         :show-stats false
                         :results []})

(def game (atom game-initial-state))
(def shoe (atom (generate-shoe)))
(def hands (atom {}))
(def draw-counter (atom 4))
")
     [:p [:em "cond"] " helps figure it all out."]
     (clojure-code
      "
(defn conclude-game! []
  (let [your-values (map value (@hands :you))
        dealer-value (value (nth (@hands :dealer) 0))]
    (do
      (doseq [your-value your-values]
        (cond (> your-value 21) (conclude :dealer \"dealer wins - you bust\")
              (> dealer-value 21) (conclude :you \"you win - dealer busts\")
              (= your-value dealer-value) (conclude :push \"push\")
              (= your-value 21) (conclude :you \"you win - blackjack :D\")
              (= dealer-value 21) (conclude :dealer \"dealer wins - blackjack\")
              (> dealer-value your-value) (conclude :dealer \"dealer wins - higher value\")
              :else (conclude :you \"you win - higher value\")))
      (end-game!))))
")

     [:div.center
      [:a.stand-alone {:href "https://blackjack.sunflowerseastar.com" :rel "noreferrer" :target "_blank"} "blackjack"]
      [:a.stand-alone {:href "https://github.com/sunflowerseastar/blackjack/blob/master/src/cards/blackjack.cljs" :rel "noreferrer" :target "_blank"} "code"]]

     ]]))

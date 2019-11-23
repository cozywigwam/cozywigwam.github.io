(ns sunflowerseastar.cellular-automata
  (:require
   [sunflowerseastar.helpers :refer [math-jax-wrapper]]
   [sunflowerseastar.components :refer [clojure-code]]))

(defn cellular-automata []
  (math-jax-wrapper
   [:div.chess.content-inner
    [:div.content-body
     [:div
      [:img {:src "cellular-automata.png"}]
      [:h2 "cellular-automata"]
      [:p "A friend of mine gave me a copy of " [:a {:href "https://www.wolframscience.com/nks/" :rel "noreferrer" :target "_blank"} "A New Kind of Science"] " when it came out. I enjoy the ideas and visuals. Upon hearing about the Wolfram Rule 30 Prizes, I got to thinking about how to write a " [:a {:href "https://cellular-automata.sunflowerseastar.com/" :rel "noreferrer" :target "_blank"} "visualizer"] " for the rules."]
      (clojure-code
       "
(defn cell [value is-last-column is-last-row]
  [:svg.cell {:view-box [0 0 10 10]
              :class [(if is-last-column \"is-last-column\") (if is-last-row \"is-last-row\")]
              :style {:fill (if (pos? value) \"black\" \"white\") :background (if (pos? value) \"black\" \"white\")}}
   [:rect {:width 10 :height 10}]])

(defn automata [data]
  (let [len (count (last data))]
    [:div.automata.hide-borders {:style {:display \"grid\" :grid-template-columns (str \"repeat(\" len \", \" (/ 100 len) \"%)\")}}
     (map-indexed (fn [y-idx row]
                    (map-indexed
                     (fn [x-idx value]
                       (let [is-last-column (zero? (mod (inc x-idx) len))
                             is-last-row (= (inc y-idx) (count data))]
                         ^{:key (str x-idx value)}
                         [cell value is-last-column is-last-row]))
                     row))
                  data)]))
")

      [:p "I won’t lie. It got a little weird."]
      (clojure-code
       "
(defn rule-translate [rule-set L C R]
  (let [L (pos? L)
        C (pos? C)
        R (pos? R)
        a (rule-set 0)
        b (rule-set 1)
        c (rule-set 2)
        d (rule-set 3)
        e (rule-set 4)
        f (rule-set 5)
        g (rule-set 6)
        h (rule-set 7)]
    (cond (and L C R) a
          (and L C (not R)) b
          (and L (not C) R) c
          (and L (not C) (not R)) d
          (and (not L) C R) e
          (and (not L) C (not R)) f
          (and (not L) (not C) R) g
          (and (not L) (not C) (not R)) h)))
")
      [:p "But it was fun. I waffled between whether to use " [:em "true"] "/" [:em "false"] " or " [:em "0"] "/" [:em "1"] ", and I refactored it from one side to the other and back."]

      [:div.center
       [:a.stand-alone {:href "https://cellular-automata.sunflowerseastar.com" :rel "noreferrer" :target "_blank"} "cellular-automata"]
       [:a.stand-alone {:href "https://github.com/sunflowerseastar/cellular-automata/blob/master/src/cellular_automata/core.cljs" :rel "noreferrer" :target "_blank"} "code"]]

      ]]]))

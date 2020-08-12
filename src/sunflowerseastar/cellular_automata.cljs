(ns sunflowerseastar.cellular-automata
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn cellular-automata []
  (component-mount-hook
   [:div
    (iframe "https://cellular-automata.sunflowerseastar.com")
    [:div.content-inner
     [:div
      [:h2 "Cellular Automata Explorer"]

      [:p "$2^3$ possibilites:"]
      (clojure-code
       "
(def rule-triads [[1 1 1]
                  [1 1 0]
                  [1 0 1]
                  [1 0 0]
                  [0 1 1]
                  [0 1 0]
                  [0 0 1]
                  [0 0 0]])
")

      [:p "Compute a block based on the triad above it:"]
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

      [:p "Toss it in a grid:"]
      (clojure-code
       "
(defn cell [value is-last-column is-last-row]
  [:svg.cell
   {:view-box [0 0 10 10]
    :class [(if is-last-column \"is-last-column\")
            (if is-last-row \"is-last-row\")]
    :style {:fill (if (pos? value) \"black\" \"white\")
            :background (if (pos? value) \"black\" \"white\")}}
   [:rect {:width 10 :height 10}]])

(defn automata [data]
  (let [len (count (last data))]
    [:div.automata.hide-borders
     {:style
      {:display \"grid\"
       :grid-template-columns (str \"repeat(\" len \", \" (/ 100 len) \"%)\")}}
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

      [:p "Fun! Check out intriguing rules like 30 and 193."]

      (links "https://cellular-automata.sunflowerseastar.com" "https://github.com/sunflowerseastar/cellular-automata/blob/master/src/cellular_automata/core.cljs")]]]))

(ns sunflowerseastar.home
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn home []
  (component-mount-hook
   [:div
    [:div.content-inner
     [:div.iframe-container.home-iframe
      [:iframe.iframe {:src "https://geometry.sunflowerseastar.com"}]]
     (clojure-code
      "
(defn phyllotaxis
  ([n] (phyllotaxis n 1))
  ([n constant]
   (let [theta (* n Math/PI (- 3 (Math/sqrt 5)))
         radius (* 24.6 (Math/sqrt n))
         x (* (Math/cos theta) radius constant)
         y (* (Math/sin theta) radius constant)]
     [x y theta])))

(defn phyllotaxis-component []
  [figure
   [:div.phyllotaxis
    (let [p (->> (range 1 @qty) (map phyllotaxis) x-y->percentages)
          size @size]
      (map (fn [[x y theta]] [circle ^{:key (str x y)} size x y]) p))]])
")]]))

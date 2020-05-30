(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.about :refer [about]]
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.tetris :refer [tetris]]
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.components :refer [header footer]]
   [tupelo.core :refer [spyx]]
   [goog.dom :as gdom]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]
   [reitit.coercion.spec :as rss]
   [spec-tools.data-spec :as ds]
   [fipp.edn :as fedn]
   [reagent.core :as reagent :refer [atom create-class]]))

(def has-initially-loaded (atom false))
(def route-transition-duration 400)

(def colors ["#d0d0ff" "#ffd3ad" "#b1e597" "#ffbad1" "#ff8c94" "#91cdf2" "#faedb9" ])

(def pages [{:name "chess" :component chess}
            {:name "tetris" :component tetris}
            {:name "blackjack" :component blackjack}
            {:name "ca" :component cellular-automata}
            {:name "about" :component about}])
(def page-color (atom (rand-nth colors)))

(def social [{:name "github" :url "https://github.com/sunflowerseastar"}
             {:name "soundcloud" :url "https://soundcloud.com/cyaneyedvireo"}
             {:name "sinistrocular" :url "https://sinistrocular.com"}
             {:name "twitter" :url "https://twitter.com/helianthoides"}])

(def route-is-transitioning-out (atom false))
(def route-is-transitioning (atom false))

(defonce match (atom nil))

(def routes
  [["/"
    {:name ::chess
     :title "chess"
     :view chess}]
   ["/tetris"
    {:name ::tetris
     :title "tetris"
     :view tetris}]
   ["/blackjack"
    {:name ::blackjack
     :title "blackjack"
     :view blackjack}]
   ["/cellular-automata"
    {:name ::cellular-automata
     :title "ca"
     :view cellular-automata}]
   ["/about"
    {:name ::about
     :title "about"
     :view about}]])

(def upcoming-page (atom ::chess))

(defn change-route! [name]
  (when (not @route-is-transitioning)
    (do (reset! route-is-transitioning-out true)
        (reset! route-is-transitioning true)
        (reset! page-color (rand-nth colors))
        (reset! upcoming-page name)
        (js/setTimeout #(rfe/push-state name) route-transition-duration)
        (js/setTimeout #(reset! route-is-transitioning-out false) route-transition-duration)
        (js/setTimeout #(reset! route-is-transitioning false) (+ 400 (* 2 route-transition-duration))))))

(defn main []
  (create-class
   {:component-did-mount (fn [] (js/setTimeout #(reset! has-initially-loaded true) 0))
    :reagent-render
    (fn [this]
      [:div.main.fade-in-1 {:class [(if @has-initially-loaded "has-initially-loaded")
                                    (when @route-is-transitioning "route-is-transitioning")]}
       (header routes social @upcoming-page @page-color change-route!)
       [:div.content-backdrop
        [:div.content {:class (when @route-is-transitioning-out "route-is-transitioning-out")
                       :style {:transition (str "opacity " route-transition-duration "ms ease-in-out")}}
         (if @match
           (let [view (-> @match :data :view)]
             [view @match]))]]
       (footer routes social @upcoming-page @page-color change-route!)])}))

(defn init! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [m] (do (reset! upcoming-page (-> m :data :name))
               (reset! match m)))
   {:use-fragment false})
  (reagent/render-component [main] (.getElementById js/document "app")))

(init!)

(defn ^:after-load on-reload []
  (init!))

(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.components :refer [header footer]]
   [sunflowerseastar.covid-19 :refer [covid-19]]
   [sunflowerseastar.home :refer [home]]
   [sunflowerseastar.kakuro :refer [kakuro]]
   [sunflowerseastar.tetris :refer [tetris]]
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

(def page-color (atom (rand-nth colors)))

(def social [{:name "github" :url "https://github.com/sunflowerseastar"}
             {:name "linkedin" :url "https://www.linkedin.com/in/grantsurlyn/"}
             {:name "sinistrocular" :url "https://sinistrocular.com"}])

(def route-is-transitioning-out (atom false))
(def route-is-transitioning (atom false))

(defonce match (atom nil))

(def routes
  [["/"
    {:name ::home
     :title "home"
     :view home}]
   ["/chess"
    {:name ::chess
     :title "chess"
     :view chess}]
   ["/tetris"
    {:name ::tetris
     :title "tetris"
     :view tetris}]
   ["/covid-19"
    {:name ::covid-19
     :title "covid-19"
     :view covid-19}]
   ["/blackjack"
    {:name ::blackjack
     :title "blackjack"
     :view blackjack}]
   ["/cellular-automata"
    {:name ::cellular-automata
     :title "ca"
     :view cellular-automata}]
   ["/kakuro"
    {:name ::kakuro
     :title "kakuro"
     :view kakuro}]])

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

(def router (rf/router routes {:data {:coercion rss/coercion}}))
(def header-footer-routes [::kakuro ::covid-19 ::chess ::tetris])

(defn main []
  (create-class
   {:component-did-mount (fn [] (js/setTimeout #(reset! has-initially-loaded true) 0))
    :reagent-render
    (fn [this]
      [:div.main.fade-in-1 {:class [(if @has-initially-loaded "has-initially-loaded")
                                    (when @route-is-transitioning "route-is-transitioning")]}
       (header router routes header-footer-routes social @upcoming-page @page-color change-route!)
       [:div.content-backdrop
        [:div.content {:class (when @route-is-transitioning-out "route-is-transitioning-out")
                       :style {:transition (str "opacity " route-transition-duration "ms ease-in-out")}}
         (if @match
           (let [view (-> @match :data :view)]
             [view @match]))]]
       (footer router routes header-footer-routes social @upcoming-page @page-color change-route!)])}))

(defn init! []
  (rfe/start!
   router
   (fn [m] (do (reset! upcoming-page (-> m :data :name))
               (reset! match m)))
   {:use-fragment false})
  (reagent/render-component [main] (.getElementById js/document "app")))

(init!)

(defn ^:after-load on-reload []
  (init!))

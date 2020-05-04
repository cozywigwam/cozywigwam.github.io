(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.tetris :refer [tetris]]
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.svgs :refer [get-svg]]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom create-class]]))

(def current-page (atom chess))
(def has-initially-loaded (atom false))

(defn get-app-element []
  (gdom/getElement "app"))

(defn main []
  (create-class
   {:component-did-mount (fn [] (js/setTimeout #(reset! has-initially-loaded true) 0))
    :reagent-render
    (fn [this]
      [:div.main.fade-in-1 {:class [(if @has-initially-loaded "has-initially-loaded")]}
       [:span.viewport-right-shadow]
       [:div.header
        [:div.left.fade-in-2
         [:h1.title "Sunflowerseastar"]
         [:div.link-column
          [:a.link {:on-click #(reset! current-page chess)} "chess"]
          [:a.link {:on-click #(reset! current-page tetris)} "tetris"]
          [:a.link {:on-click #(reset! current-page blackjack)} "blackjack"]
          [:a.link {:on-click #(reset! current-page cellular-automata)} "CA"]]]
        [:div.right.fade-in-2
         [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://github.com/sunflowerseastar"} [get-svg "github"]]
         [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://soundcloud.com/cyaneyedvireo"} [get-svg "soundcloud"]]
         [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://sinistrocular.com"} [get-svg "sinistrocular"]]
         [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://twitter.com/helianthoides"} [get-svg "twitter"]]]]
       [:div.content
        [@current-page]]])}))

(defn mount [el]
  (reagent/render-component [main] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))

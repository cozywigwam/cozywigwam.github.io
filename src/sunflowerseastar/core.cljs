(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.svgs :refer [get-svg]]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]))

(def current-page (atom chess))

(defn get-app-element []
  (gdom/getElement "app"))

(defn main []
  [:div.main
   [:span.viewport-right-shadow]
   [:div.header
    [:div.left
     [:h1.title "Sunflowerseastar"]
     [:div.link-column
      [:a.link {:on-click #(reset! current-page chess)} "chess"]
      [:a.link {:on-click #(reset! current-page blackjack)} "blackjack"]
      [:a.link {:on-click #(reset! current-page cellular-automata)} "CA"]]]
    [:div.right
     [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://github.com/sunflowerseastar"} [get-svg "github"]]
     [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://soundcloud.com/cyaneyedvireo"} [get-svg "soundcloud"]]
     [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://sinistrocular.com"} [get-svg "sinistrocular"]]
     [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://twitter.com/helianthoides"} [get-svg "twitter"]]]]
   [:div.content
    [@current-page]]])

(defn mount [el]
  (reagent/render-component [main] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))

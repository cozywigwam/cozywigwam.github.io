(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.tetris :refer [tetris]]
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.svgs :refer [get-svg]]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom create-class]]))

(def has-initially-loaded (atom false))

(def colors ["#d0d0ff" "#ffd3ad" "#b1e597" "#ffbad1" "#ff8c94" "#91cdf2" "#faedb9" ])

(defn get-app-element []
  (gdom/getElement "app"))

(def current-page (atom [:chess chess]))
(def pages [{:name "chess" :component chess}
            {:name "tetris" :component tetris}
            {:name "blackjack" :component blackjack}
            {:name "ca" :component cellular-automata}])

(defn main []
  (create-class
   {:component-did-mount (fn [] (js/setTimeout #(reset! has-initially-loaded true) 0))
    :reagent-render
    (fn [this]
      [:div.main.fade-in-1 {:class [(if @has-initially-loaded "has-initially-loaded")]}
       [:div.header
        [:div.flex-row
         [:div.left
          [:h1.title "Sunflowerseastar"]
          [:div.links-container
           (map
            (fn [{:keys [name component]}]
              [:a.link {:class (when (= (first @current-page) (keyword name)) "active")
                        :style {:color (when (= (first @current-page) (keyword name)) (rand-nth colors))}
                        :on-click #(reset! current-page [(keyword name) component])} name])
            pages)]]
         [:div.right
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://github.com/sunflowerseastar"} [get-svg "github"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://soundcloud.com/cyaneyedvireo"} [get-svg "soundcloud"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://sinistrocular.com"} [get-svg "sinistrocular"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://twitter.com/helianthoides"} [get-svg "twitter"]]]]]
       [:div.content
        [(second @current-page)]]])}))

(defn mount [el]
  (reagent/render-component [main] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))

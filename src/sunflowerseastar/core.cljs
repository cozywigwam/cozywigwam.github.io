(ns ^:figwheel-hooks sunflowerseastar.core
  (:require
   [sunflowerseastar.cellular-automata :refer [cellular-automata]]
   [sunflowerseastar.chess :refer [chess]]
   [sunflowerseastar.tetris :refer [tetris]]
   [sunflowerseastar.blackjack :refer [blackjack]]
   [sunflowerseastar.svgs :refer [get-svg]]
   [tupelo.core :refer [spyx]]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom create-class]]))

(def has-initially-loaded (atom false))
(def route-transition-duration 400)

(def colors ["#d0d0ff" "#ffd3ad" "#b1e597" "#ffbad1" "#ff8c94" "#91cdf2" "#faedb9" ])

(defn get-app-element []
  (gdom/getElement "app"))

(def current-page (atom [:chess chess]))
(def upcoming-page (atom [:chess chess]))
(def pages [{:name "chess" :component chess}
            {:name "tetris" :component tetris}
            {:name "blackjack" :component blackjack}
            {:name "ca" :component cellular-automata}])
(def page-color (atom (rand-nth colors)))

(def route-is-changing (atom false))

(defn change-route! [name component]
  (do (reset! route-is-changing true)
      (reset! page-color (rand-nth colors))
      (reset! upcoming-page [(keyword name) component])
      (js/setTimeout #(reset! current-page [(keyword name) component]) route-transition-duration)
      (js/setTimeout #(reset! route-is-changing false) (+ 100 route-transition-duration))))

(defn main []
  (create-class
   {:component-did-mount (fn [] (js/setTimeout #(reset! has-initially-loaded true) 0))
    :reagent-render
    (fn [this]
      [:div.main.fade-in-1 {:class (if @has-initially-loaded "has-initially-loaded")}
       [:div.header
        [:div.flex-row
         [:div.left
          [:h1.title "Sunflowerseastar"]
          [:div.links-container
           (map (fn [{:keys [name component]}]
                  (let [is-current-page (= (first @current-page) (keyword name))
                        is-upcoming-page (= (first @upcoming-page) (keyword name))]
                    [:a.link {:key name
                              :style {:color (when is-upcoming-page @page-color)}
                              :on-click #(when (and (not @route-is-changing) (not is-current-page))
                                           (change-route! name component))}
                     name]))
                pages)]]
         [:div.right
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://github.com/sunflowerseastar"} [get-svg "github"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://soundcloud.com/cyaneyedvireo"} [get-svg "soundcloud"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://sinistrocular.com"} [get-svg "sinistrocular"]]
          [:a.svg-link {:rel "noreferrer" :target "_blank" :href "https://twitter.com/helianthoides"} [get-svg "twitter"]]]]]
       [:div.content {:class (when @route-is-changing "route-is-changing")
                      :style {:transition (str "opacity " route-transition-duration "ms ease-in-out")}}
        [(second @current-page)]]])}))

(defn mount [el]
  (reagent/render-component [main] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))

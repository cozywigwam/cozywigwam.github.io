(ns sunflowerseastar.components
  (:require    [tupelo.core :refer [spyx]]
               [sunflowerseastar.svgs :refer [get-svg]]
               [reitit.frontend.easy :as rfe]))

(defn clojure-code [inner]
  [:pre
   [:span.code-label "clojure"]
   [:code.clojure inner]])

(defn iframe
  ([src] (iframe src nil true))
  ([src note] (iframe src note true))
  ([src note include-border]
   [:div.iframe-container
    [:iframe.iframe {:src src
                     :style {:borderBottom (if include-border "0.5px solid #ddd" "none")}}]
    note]))

(defn svg-link [name url]
  [:a.svg-link {:key name :rel "noreferrer" :target "_blank" :href url} [get-svg name]])

(defn header [pages routes social current-page upcoming-page page-color route-is-changing change-route!]
  (do (spyx routes)
      [:div.header
       [:div.flex-row
        [:div.left
         [:h1.title "Sunflowerseastar"]
         [:div.links-container

          (map (fn [[path {:keys [name title view]}]] (do (spyx path name view)
                                   [:a.link.link-dark-bg {:key name :href (rfe/href name)} title]
                                   )) routes)

          (map (fn [{:keys [name component]}]
                 (let [is-current-page (= (first current-page) (keyword name))
                       is-upcoming-page (= (first upcoming-page) (keyword name))]
                   [:a.link.link-dark-bg {:key name
                                          :style {:color (when is-upcoming-page page-color)}
                                          :on-click #(when (and (not route-is-changing) (not is-current-page))
                                                       (change-route! name component))}
                    name]))
               pages)]]
        [:div.right
         (map (fn [{:keys [name url]}] (svg-link name url)) social)]]]))

(defn footer [pages social current-page upcoming-page page-color route-is-changing change-route!]
  [:div.footer
   [:div.flex-row
    [:div.left
     [:div.links-container
      (map (fn [{:keys [name component]}]
             (let [is-current-page (= (first current-page) (keyword name))
                   is-upcoming-page (= (first upcoming-page) (keyword name))]
               [:a.link.link-dark-bg {:key name
                                      :style {:color (when is-upcoming-page page-color)}
                                      :on-click #(when (and (not route-is-changing) (not is-current-page))
                                                   (do (.scroll js/window (clj->js {:top 0 :left 0 :behavior "smooth"}))
                                                       (change-route! name component)))}
                name]))
           pages)]]
    [:div.right
     (map (fn [{:keys [name url]}] (svg-link name url)) social)]]])

(defn links [site-url github-url]
  [:div.center
   [:a.link.content-link {:href site-url :rel "noreferrer" :target "_blank"} "website"]
   [:a.link.content-link {:href github-url :rel "noreferrer" :target "_blank"} "code"]])

(ns sunflowerseastar.components
  (:require    [tupelo.core :refer [spyx]]
               [sunflowerseastar.svgs :refer [get-svg]]
               [reitit.frontend :as rf]
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

(defn header [router routes header-footer-routes social upcoming-page page-color change-route!]
  [:div.header
   [:div.flex-row
    [:div.left
     [:a {:style {:display "block"}
          :on-click #(change-route! :sunflowerseastar.core/about)}
      [:h1.title {:style {:cursor "pointer"}} "Sunflowerseastar"]]
     [:div.links-container
      (map (fn [header-route]
             (let [{{:keys [name title view]} :data} (rf/match-by-name router header-route)
                   is-active (= upcoming-page name)]
               [:a.link.link-dark-bg {:key name
                                      :class (when is-active "is-active")
                                      :style {:color (when is-active page-color)}
                                      :on-click #(when (not is-active)
                                                   (change-route! name))}
                title]))
           header-footer-routes)]]
    [:div.right
     (map (fn [{:keys [name url]}] (svg-link name url)) social)]]])

(defn footer [router routes header-footer-routes social upcoming-page page-color change-route!]
  [:div.footer
   [:div.flex-row
    [:div.left
     [:div.links-container
      (map (fn [header-route]
             (let [{{:keys [name title view]} :data} (rf/match-by-name router header-route)
                   is-active (= upcoming-page name)]
               [:a.link.link-dark-bg {:key name
                                      :class (when is-active "is-active")
                                      :style {:color (when is-active page-color)}
                                      :on-click #(when (not is-active)
                                                   (do (.scroll js/window (clj->js {:top 0 :left 0 :behavior "smooth"}))
                                                       (change-route! name)))}
                title]))
           header-footer-routes)]]
    [:div.right
     (map (fn [{:keys [name url]}] (svg-link name url)) social)]]])

(defn links [site-url github-url]
  [:div.center
   [:a.link.content-link {:href site-url :rel "noreferrer" :target "_blank"} "website"]
   [:a.link.content-link {:href github-url :rel "noreferrer" :target "_blank"} "code"]])

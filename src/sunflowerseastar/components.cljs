(ns sunflowerseastar.components
  (:require [sunflowerseastar.svgs :refer [get-svg]]))

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
  [:a.svg-link {:rel "noreferrer" :target "_blank" :href url} [get-svg name]])

(defn header [pages social current-page upcoming-page page-color route-is-changing cr!]
  [:div.header
   [:div.flex-row
    [:div.left
     [:h1.title "Sunflowerseastar"]
     [:div.links-container
      (map (fn [{:keys [name component]}]
             (let [is-current-page (= (first current-page) (keyword name))
                   is-upcoming-page (= (first upcoming-page) (keyword name))]
               [:a.link.header-link {:key name
                                     :style {:color (when is-upcoming-page page-color)}
                                     :on-click #(when (and (not route-is-changing) (not is-current-page))
                                                  (cr! name component))}
                name]))
           pages)]]
    [:div.right
     (map (fn [{:keys [name url]}] (svg-link name url)) social)]]])

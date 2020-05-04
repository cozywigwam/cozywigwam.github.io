(ns sunflowerseastar.components)

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

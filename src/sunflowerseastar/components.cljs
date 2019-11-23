(ns sunflowerseastar.components)

(defn clojure-code [inner]
  [:pre
   [:span.code-label "clojure"]
   [:code.clojure inner]])

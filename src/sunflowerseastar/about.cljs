(ns sunflowerseastar.about
  (:require
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn about []
  [:div
   [:div.content-inner
    [:p "Hello! My name is Grant. I'm a digital creator in San Francisco. I started making websites in the early 90s, back when html tags were all caps and elegant positioning solutions kept getting tabled."]
    [:p "I have a background in the humanities, and my work experience includes teaching, management, and sales."]
    [:p "Ongoing pursuits are program design, architecture, and functional programming. I read a good bit, especially technical books. Other interests include photography, music, and language."]

    [:div.iframe-container.about-iframe
     [:iframe.iframe {:src "https://geometry.sunflowerseastar.com"}]]

    [:div.center
     [:a.link.content-link {:href "https://github.com/sunflowerseastar" :rel "noreferrer" :target "_blank"} "code"]
     [:a.link.content-link {:href "https://www.linkedin.com/in/grantsurlyn/" :rel "noreferrer" :target "_blank"} "linkedin"]]
    ]])

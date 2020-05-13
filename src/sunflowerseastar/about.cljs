(ns sunflowerseastar.about
  (:require
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn about []
  [:div.content

   [:div.content-inner
    [:div

     [:p {:style {:paddingTop "6em"}} "Hello! My name is Grant. I'm a digital creator in San Francisco. I started making websites in the early 90s, back when html tags were all caps and elegant positioning solutions kept getting tabled. My technology work focuses on interactive, data-intensive UIs, and includes logic-heavy webapps, mobile solutions, high-profile websites, and business products for clients ranging from startups to international corporations."]
     [:p "My practice as a consultant is informed by my humanities background, and my work experience includes teaching and management. I enjoy working with teams to discover, implement, and communicate solutions that match problem shapes as clearly as possible. Some tools I use for measuring & maintaining project health include documentation, test suites, team dynamics, and VCS exploration."]
     [:p "Ongoing interests of mine are program design, architecture, and functional programming. I have an insatiable appetite for learning and exploring, so I read a good bit, particularly technical books. Other interests include photography, music, and language."]

     [:div.iframe-container.about-iframe
      [:iframe.iframe {:src "https://geometry.sunflowerseastar.com"}]]

     [:div.center
      [:a.link.content-link {:href "https://github.com/sunflowerseastar" :rel "noreferrer" :target "_blank"} "code"]
      [:a.link.content-link {:href "https://www.linkedin.com/in/grantsurlyn/" :rel "noreferrer" :target "_blank"} "linkedin"]]

     ]]])

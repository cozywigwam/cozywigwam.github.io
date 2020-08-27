(ns sunflowerseastar.home
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn home []
  (component-mount-hook
   [:div
    [:div.content-inner
     [:h3 "Welcome"]
     [:p "Hi, I’m Grant, a digital creator in San Francisco. I’m energized by building UIs, passionate people, and functional programming."]
     (iframe "https://cellular-automata.sunflowerseastar.com"
             :note [:p.iframe-note [:em "cellular automata explorer"]]
             :dotted true)
     [:h3 "Thirteen Ways of Looking at a Problem"]
     [:p "I enjoy hunting solutions and reducing captive ones to simple models. Tools I find helpful:"]
     [:ul [:li "drawing, diagramming, wireframing, whiteboarding"]
      [:li "reading, studying, problem space exploration"]
      [:li "soliciting honest feedback, finding blindspots"]
      [:li "interviews, cross-referenced notes"]
      [:li "open, vulnerable collaboration"]
      [:li "creating many prototypes at different speeds/scales"]
      [:li "“plan your work, work your plan”"]]
     (iframe "https://geometry.sunflowerseastar.com"
             :note [:p.iframe-note [:em "phyllotaxis"]])
     [:h3 "Principle Simplicity"]
     [:p "Communication that transcends our words is as powerful as it is fascinating. Minimalism extends beyond the visual layout, into program design and implementation."]
     [:p "I am thankful and lucky to have had so many strong teammates and wise managers (I just told you I was lucky!) through the years. Some favorite characteristics:"]
     [:ul [:li "listens closely"]
      [:li "distills/packages information appropriately"]
      [:li "believes in shared understanding"]
      [:li "open to ideas, same-team spirit"]
      [:li "strong inner drive to deliver excellence"]
      [:li "information-based decision-making"]]
     [:div.center
      [:a.link.content-link {:href "https://github.com/sunflowerseastar" :rel "noreferrer" :target "_blank"} "GitHub"]
      [:a.link.content-link {:href "https://www.linkedin.com/in/grantsurlyn/" :rel "noreferrer" :target "_blank"} "LinkedIn"]
      [:a.link.content-link {:href "https://twitter.com/helianthoides" :rel "noreferrer" :target "_blank"} "Twitter"]]]]))

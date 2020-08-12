(ns sunflowerseastar.home
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn home []
  (component-mount-hook
   [:div
    [:div.content-inner
     [:h3 "Welcome"]
     [:p "Hi, I’m Grant, a digital creator and freelance consultant in San Francisco. I specialize in building interactive UIs and everything else that comes along for the " [:span.nowrap "ride—testing,"] " documentation, back-end, design/UX, leading, training, scoping, assessing, planning, interviewing, tooling, writing, listening, you name it. I fell in love with creating websites back in the GeoCities days."]
     [:p "I’m energized by tricky problems, passionate teams, aggressive deadlines, and functional programming. When I’m not " [:em "M-x"] "’ing, I’m reading, looking at birds, making music, or backpacking with my family."]
     (iframe "https://cellular-automata.sunflowerseastar.com"
             :note [:p.iframe-note [:em "cellular automata explorer"]]
             :dotted true)
     [:h3 "Thirteen Ways of Looking at a Problem"]
     [:p "“How does it work?” This question pops into the minds of different people at different rates. For me, it’s constant. And when it strikes, " [:em "I feel like a jungle cat on the hunt!"] " (Lol, I wish it was that romantic. In reality, it’s more like coffee pot afternoons, with tired, rectangular, manpage eyes.) If you’re the problem-solver type, I assume you’ll be nodding your head " [:span.nowrap "here—there’s"] " no satisfaction quite like cracking the coconut."]
     (iframe "https://geometry.sunflowerseastar.com"
             :note [:p.iframe-note [:em "phyllotaxis"]])
     [:h3 "Principle Simplicity"]
     [:p "Communication that transcends our words is powerful and fascinating. The goal is intuition and accessibility. Minimalism extends well beyond the visual layout, into both program design and the implementation itself."]
     [:p "I am thankful and lucky to have had so many strong teammates and wise managers (I just said I was lucky!) through the years. Some favorite characteristics:"]
     [:ul [:li "listens eagerly and empathetically"]
      [:li "distills information appropriately"]
      [:li "believes in shared understanding"]
      [:li "always open to ideas, with a same-team spirit"]
      [:li "strong inner drive to deliver excellence"]
      [:li "makes information-based decisions"]
      [:li "carefully weighs trade-offs with nuance"]]
     [:p "Thank you for visiting my site. I am currently open to discussing engagements, and can be reached at 212-858-9138 or " [:a {:href "mailto:grant@sunflowerseastar.com"} "grant@sunflowerseastar.com"] "."]
     [:div.center
      [:a.link.content-link {:href "https://github.com/sunflowerseastar" :rel "noreferrer" :target "_blank"} "GitHub"]
      [:a.link.content-link {:href "https://www.linkedin.com/in/grantsurlyn/" :rel "noreferrer" :target "_blank"} "LinkedIn"]
      [:a.link.content-link {:href "https://twitter.com/helianthoides" :rel "noreferrer" :target "_blank"} "Twitter"]]]]))

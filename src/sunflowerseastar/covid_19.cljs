(ns sunflowerseastar.covid-19
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn covid-19 []
  (component-mount-hook
   [:div
    (iframe "https://covid-dashboard.sunflowerseastar.com")
    [:div.content-inner
     [:h2 "covid-19 dashboard"]
     [:p "This is a partial clone of " [:a {:href "https://coronavirus.jhu.edu/map.html" :rel "noreferrer" :target "_blank"} "the COVID-19 Dashboard by the Center for Systems Science and Engineering (CSSE) at Johns Hopkins University"] ". It utilizes the " [:a {:href "https://github.com/Day8/re-frame" :rel "noreferrer" :target "_blank"} "Re-frame"] " front-end framework (which sits on top of " [:a {:href "https://github.com/reagent-project/reagent" :rel "noreferrer" :target "_blank"} "Reagent"] ", on top of " [:a {:href "https://github.com/facebook/react" :rel "noreferrer" :target "_blank"} "React"] ") with " [:a {:href "https://github.com/noprompt/garden" :rel "noreferrer" :target "_blank"} "garden"] " styles, and a " [:a {:href "https://github.com/ring-clojure/ring" :rel "noreferrer" :target "_blank"} "ring"] " + " [:a {:href "https://github.com/weavejester/compojure" :rel "noreferrer" :target "_blank"} "compojure"] " stack on the back-end. Number-crunching is done with " [:a {:href "https://github.com/incanter/incanter" :rel "noreferrer" :target "_blank"} "Incanter"] " (with " [:a {:href "https://github.com/tel/clatrix" :rel "noreferrer" :target "_blank"} "Clatrix"] "/" [:a {:href "https://github.com/jblas-project/jblas" :rel "noreferrer" :target "_blank"} "jblas"] " under the hood), and maps/visualizations are with " [:a {:href "https://github.com/d3/d3" :rel "noreferrer" :target "_blank"} "D3"] ". Additional exploration for this project included " [:a {:href "https://github.com/metosin/muuntaja" :rel "noreferrer" :target "_blank"} "Muuntaja"] " for interceptor-style middleware, " [:a {:href "https://github.com/Day8/re-com" :rel "noreferrer" :target "_blank"} "re-com"] " front-end components, " [:a {:href "https://github.com/d3/d3-geo-projection/" :rel "noreferrer" :target "_blank"} "map"] " " [:a {:href "https://bl.ocks.org/mbostock/29cddc0006f8b98eff12e60dd08f59a7" :rel "noreferrer" :target "_blank"} "projections"] ", " [:a {:href "https://github.com/vega/vega" :rel "noreferrer" :target "_blank"} "Vega"] "/" [:a {:href "https://github.com/vega/vega-lite" :rel "noreferrer" :target "_blank"} "Vega-Lite"] "/" [:a {:href "https://github.com/metasoarous/oz" :rel "noreferrer" :target "_blank"} "Oz"] ", " [:a {:href "https://www.eclipse.org/jetty/" :rel "noreferrer" :target "_blank"} "jetty"] ", and " [:a {:href "https://systemd.io/" :rel "noreferrer" :target "_blank"} "systemd"] "."]

     [:p "A couple " [:a {:href "https://github.com/CSSEGISandData/COVID-19" :rel "noreferrer" :target "_blank"} "data"] "-slicing examples:"]
     (clojure-code "
(defn global-deaths [data]
  {:deaths-by-country
   (->> data (i/$rollup :sum :Deaths :Country_Region)
        (i/$order :Deaths :desc)
        to-vect)
   :total-deaths (reduce + (i/$ :Deaths data))})

(defn time-series-confirmed-global [data]
  (let [data-date-columns-only
        (i/$ [:not :Province/State :Country/Region :Lat :Long] data)
        dates (i/col-names data-date-columns-only)
        column-totals (->> data-date-columns-only
                           matrix
                           (reduce i/plus))]
    (map vector dates column-totals)))
")

     [:p "One challenge was " [:a {:href "https://clojurescript.org/reference/javascript-api" :rel "noreferrer" :target "_blank"} "interop"] ", which required some attention to " [:a {:href "https://github.com/thheller/shadow-cljs" :rel "noreferrer" :target "_blank"} "shadow-cljs"] " + " [:a {:href "https://gitlab.com/nikperic/lein-shadow" :rel "noreferrer" :target "_blank"} "lein-shadow"] ", and the " [:a {:href "https://developers.google.com/closure/compiler" :rel "noreferrer" :target "_blank"} "Google Closure Compiler's"] " " [:a {:href "https://github.com/google/closure-library/" :rel "noreferrer" :target "_blank"} "Closure Library"] ". A D3 snippet:"]

     (clojure-code "
(let [countries (topo/feature world (-> world .-objects .-countries))
      outline (clj->js {\"type\" \"Sphere\"})
      projection (-> (d3-geo/geoNaturalEarth1)
                     (.fitExtent (clj->js [[0.5 0.5] [(- width 0.5) (- height 0.5)]]) outline)
                     (.precision 0.1))
      path (d3-geo/geoPath projection)

      svg (-> js/d3 (.select (str \"#\" svg-el-id)))
      g (-> svg (.append \"g\"))
      radius (.scaleSqrt js/d3 (.extent js/d3 (.values js/Object data)) (clj->js [3 20]))]

  ;; ...

  (-> g
      (.append \"g\")
      (.selectAll \"path\")
      (.data (.-features countries))
      (.join \"path\")
      (.attr \"fill\", \"#f3f3f3\")
      (.attr \"d\" path)
      (.append \"title\")
      (.text #(str (-> % .-properties .-name)
                   \" – \"
                   (utility/nf (aget data (-> % .-properties .-name)))))))
")

     [:div.center
      [:a.link.content-link {:href "https://covid-dashboard.sunflowerseastar.com" :rel "noreferrer" :target "_blank"} "website"]
      [:a.link.content-link {:href "https://github.com/sunflowerseastar/covid-dashboard" :rel "noreferrer" :target "_blank"} "front"]
      [:a.link.content-link {:href "https://github.com/sunflowerseastar/covid-server" :rel "noreferrer" :target "_blank"} "back"]]]]))

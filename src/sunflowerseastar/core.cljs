(ns sunflowerseastar.core
  (:require-macros [sunflowerseastar.loader :as loader])
  (:import goog.history.Html5History)
  (:require [secretary.core :as secretary :refer-macros [defroute]]
            [accountant.core :as accountant]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as r]
            [reagent.session :as session]
            [cljsjs.showdown]))

(def notations (r/atom nil))

(def markdown-meta {:characters {:title "Characters" :subtitle "Distinction"}
                    :clojure {:title "Clojure" :subtitle "[Script]"}
                    :command-line {:title "Command Line" :subtitle "[~] # $ /"}
                    :emacs {:title "Emacs" :subtitle "+ Spacemacs"}
                    :git {:title "Git" :subtitle "Everything"}
                    :markup {:title "Markup" :subtitle "Crosshatch"}
                    :org {:title "Org" :subtitle "Eventually"}
                    :programming {:title "Programming" :subtitle "(verb noun)"}
                    :system {:title "System" :subtitle "We Get Signal"}
                    :vim {:title "Vim" :subtitle "Nirvana"}})

(defn md->html [s]
  (.makeHtml
   (doto (js/showdown.Converter.)
     (.setFlavor "github"))
   s))

(defn render-markdown [md]
  [:div
   {:dangerouslySetInnerHTML
    {:__html (md->html md)}}])

;; -------------------------
;; Views

(defn heading-group-no-link [{:keys [title subtitle]}]
  [:div.heading-group
   [:h1 title]
   (if subtitle [:h2 subtitle])])

(defn heading-group-link [{:keys [href title subtitle]}]
  [:a.heading-group {:key href :href href}
   [:h1 title]
   (if subtitle [:h2 subtitle])])

(defn notation-data->heading-group-link
  [[_ {:keys [filename title subtitle]
       :or {title filename
            subtitle "placeholder"}}]]
  (heading-group-link {:href (str "/notations/" filename)
                       :title title
                       :subtitle subtitle}))

(defn home-component []
  [:div
   (map notation-data->heading-group-link (sort @notations))
   [:hr]
   (heading-group-link {:href "/about" :title "About"})])

(defn footer-component []
  [:div.footer [:a.return-arrow {:href "/"} \☜]])

(defn notations-component [notation-name]
  (let [{:keys [content title subtitle]} ((keyword notation-name) @notations)]
    [:div
     (heading-group-no-link {:title title :subtitle subtitle})
     [render-markdown content]
     [:hr]
     (footer-component)]))

(defn about-component []
  [:div [:h1.no-margin-top "💻"]
   [:p "Hello, my name is Grant. I'm a digital creator in San Francisco."]
   [:p "This website notebook is written in "
    [:a {:href "https://orgmode.org/"}"Org mode"] " and built using "
    [:a {:href "https://clojure.org/"} "Clojure"] " and "
    [:a {:href "https://clojurescript.org/"} " ClojureScript"] "."]
   [:br]
   [:table [:tbody
            [:tr [:td "technology"]
             [:td [:a {:href "/"} "Sunflower Sea Star"]]]
            [:tr [:td "photography"]
             [:td [:a {:href "https://sinistrocular.com"} "Sinistrocular"]]]
            [:tr [:td "music"]
             [:td [:a {:href "https://soundcloud.com/cyaneyedvireo"} "Cyan-eyed Vireo"]]]]]
   [:section.table-cyan
    [:table [:tbody
             [:tr [:td [:a {:href "https://twitter.com/helianthoides"} "Twitter"]]
              [:td [:a {:href "https://github.com/sunflowerseastar"} "GitHub"]]
              [:td [:a {:href "https://www.linkedin.com/in/grantsurlyn"} "LinkedIn"]]]]]]
   [:section.table-green
    [:table [:tbody [:tr [:td "grant"] [:td "@"] [:td "[this domain]"]]]]]
   (footer-component)])

;; -------------------------
;; Initialize app

(defn page []
  [(session/get :current-page)])

(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (defroute "/" []
    (session/put! :current-page (home-component)))
  (defroute "/about" []
    (session/put! :current-page (about-component)))
  (defroute "/notations/:id" [id]
    (do
      (js/console.log (str "notations id is " id))
      (session/put! :current-page (notations-component id))))
  (hook-browser-navigation!))

(accountant/configure-navigation!
 {:nav-handler
  (fn [path]
    (secretary/dispatch! path))
  :path-exists?
  (fn [path]
    (secretary/locate-route path))})

(defn init! []
  (reset! notations
          (merge-with clojure.set/union markdown-meta
                      (loader/all-markdowns)))
  (app-routes)
  (r/render [:div.column [session/get :current-page]]
            (.getElementById js/document "app")))

(init!)

(defn ^:after-load on-reload []
  (do
    (js/console.log "reload")
    (init!)))

(ns sunflowerseastar.loader
  (:require [clojure.java.io :as io])
  (:import (java.io File)))

(def md-re #"\.md$")
(defn md? [f] (re-find md-re f))
(defn remove-extension [s] (clojure.string/replace s md-re ""))

(def files (filter #(.isFile %) (seq (.listFiles (io/file (io/resource "public/markdown"))))))
(def md-files (filter #(md? (.getName %)) files))

(defn file->data [file]
  (let [filename (-> file .getName remove-extension)]
    {(keyword filename) {:filename filename :content (slurp file)}}))

(defmacro all-markdowns []
  (try (reduce conj (map file->data md-files))
       (catch Exception ex
         ["Error" (with-out-str (println ex))])))

(defmacro get-markdown [f]
  (slurp (str "resources/public/markdown/" f ".md")))

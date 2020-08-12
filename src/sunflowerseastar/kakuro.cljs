(ns sunflowerseastar.kakuro
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn kakuro []
  (component-mount-hook
   [:div
    (iframe "https://kakuro.sunflowerseastar.com"
            :note [:p.iframe-note [:strong "s"] ": " [:em "solve"] ", "
                   [:strong "f"] ": " [:em "fix"] ", "
                   [:strong "c"] ": " [:em "clear"] ", "
                   [:strong "-"] "/" [:strong "+"] ": " [:em  "shrink"] "/" [:em "grow"]])
    [:div.content-inner
     [:h2 "Kakuro"]
     [:h3 "Mystery"]
     [:p [:em "It’s for you. What’s in there?"] " she asked, handing me a large, plain brown envelope."]
     [:p "I had no idea what was in there. There was no return address, no location information on the postmark, no clues from the stamp, no stray marks. My name and address were printed in the center, in a hand that didn’t strike me as familiar. Inside was one piece of paper, folded in half. It was a photocopy of a “Cross Sum” from a puzzle book. I hadn’t encountered a puzzle like this before (although I’ve come to learn that it’s quite popular), but instructions were included on the page."]
     [:blockquote "The numbers in the black squares in these puzzles refer to the sums of the digits to be filled into the empty spaces. The number below a diagonal line is the sum of the numbers below it. The number above a diagonal line is the sum of the numbers to the right of it. Place one digit (1 to 9, no zeros) in each square. IMPORTANT: No digit is used more than once in any particular combination."]
     [:p "Here's how I interpreted the instructions:"]
     [:blockquote "If you had to write a program to solve this for you, how would you do it? IMPORTANT: I bet you can’t write a program to solve this."]
     [:p "I don’t know which part of my brain adds sentences like that last one, but oh well. Another part of my brain whirred quietly, wondering how " [:em "indeed"] " I might code a solution to something like this. My first few attempts were off the mark, and I ended up shelving this combinatorial curiosity."]
     [:h3 "Fast Forward 7 Months"]
     [:p "One: another piece of mail, almost identical, arrived about a half a year later. Two: I stumbled on a Sudoku solver using " [:a {:href "https://github.com/clojure/core.logic/"} "core.logic"] ". I’d been poking through " [:a {:href "https://mitpress.mit.edu/books/reasoned-schemer"} "The Reasoned Schemer"] " earlier in the year, and I was pleasantly surprised to find the applied ideas more intuitive than I'd anticipated. The constraints to pass to " [:a {:href "http://minikanren.org/"} "miniKanren"] " for a kakuro solver could be the same as the rules for the puzzle itself:"]
     [:ul [:li "each entry is between 1 and 9, inclusive"]
      [:li "each row/column adds up to its “clue”"]
      [:li "each entry in a row/column is unique"]]
     [:p "Could it be that straight forward? Hmmm.... To start with, I boiled a board down to a list of its clues, with each one like this:"]

     (clojure-code "
[direction x y sum distance]
")

     [:p "From here, everything can be extrapolated—the size of the board, which squares are entries, and which squares are black. This means we can derive a list of coordinate pairs that represent the entry squares, and a respective " [:a {:href "https://github.com/clojure/core.logic/wiki/A-Core.logic-Primer#logic-variables"} "logic variable"] " (“lvar”) for each one. Now the overlapping columns and rows of contiguous entries (which I'm referring to as " [:em "lvar-groups"] " below) can share their respective constraints:"]

     (clojure-code "
(defn clues->solutions [clue-notation]
  (let [{:keys [lvp-lvar-map x-shape]} (clues->lvars-map clues)
        all-lvars (vals lvp-lvar-map)
        lvar-groups (clues->lvar-groups clues x-shape lvp-lvar-map)
        is-single-digit #(fd/in % (apply fd/domain (range 1 10)))]
    (-> (l/run* [q]
          (l/== q all-lvars)
          (l/everyg is-single-digit all-lvars)
          (l/everyg #(fd/distinct (:lvars %)) lvar-groups)
          (l/everyg adds-up lvar-groups))
        vec)))
")

     [:p "Yea! The solution is a vector of all the entry values, from left to right, top to bottom. I slapped an API endpoint in front of the solver, and put together a board builder front-end to talk to it. Take a look. I hope you like it!"]

     [:div.center
      [:a.link.content-link {:href "https://kakuro.sunflowerseastar.com" :rel "noreferrer" :target "_blank"} "website"]
      [:a.link.content-link {:href "https://github.com/sunflowerseastar/kakuro" :rel "noreferrer" :target "_blank"} "front"]
      [:a.link.content-link {:href "https://github.com/sunflowerseastar/kakuro-server" :rel "noreferrer" :target "_blank"} "back"]]
     ]]))

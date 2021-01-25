(ns sunflowerseastar.merels
  (:require
   [sunflowerseastar.helpers :refer [component-mount-hook]]
   [sunflowerseastar.components :refer [clojure-code iframe links]]))

(defn merels []
  (component-mount-hook
   [:div
    (iframe "https://merels.sunflowerseastar.com")
    [:div.content-inner
     [:h2 "Merels"]

     [:p "This is an ancient game of unclear origin and many names. You might recall Ovid mentioning it in his " [:em "Ars Amatoria (III, 365-8)"] ", a tome that we’re all of course intimately familiar with. ;) A merels board is a configuration of connected, nested squares that has been found etched in stones across the world for millenia. Extensions of the idea range from “naughts and crosses” (tic-tac-toe) to architecture and even religious iconography. The flavor presented above is its most common gaming variant, known as " [:a {:href "https://en.wikipedia.org/wiki/Nine_men%27s_morris"} "Nine Men’s Morris"] "."]

     [:p "Two players alternate placing their nine pieces on the board. When you form a “mill” (three in a row), remove one opponent piece. You cannot remove a piece that’s in a mill unless no others are available. Once all eighteen pieces have been placed, you now move a piece to an open, adjacent position for your turn. The same “form a mill and remove an opponent piece” rule applies. If you’re down to three pieces, you can “fly,” which means move a piece to any open position, not just adjacent ones. Gameplay ends when a player is reduced to two pieces, or is blocked from making any legal moves."]

     [:h3 "APL"]

     [:p "I’m not a good person to provide an introduction to APL because I’m a dilettante, even charitably speaking. But you’re actually reading this and I didn’t charge you any money, so I’m going for it. As a warning, APL isn’t everyone’s cup of tea. For instance, Dijkstra calls APL programmers “" [:a {:href "https://www.cs.utexas.edu/users/EWD/ewd04xx/EWD498.PDF"} "bums"] "”. Oh well. Once I stumbled upon it and read " [:a {:href "https://en.wikipedia.org/wiki/Kenneth_E._Iverson"} "Kenneth Iverson’s"] " " [:a {:href "https://www.eecg.utoronto.ca/~jzhu/csc326/readings/iverson.pdf"} "Notation as a Tool of Thought"] ", I was intrigued."]

     [:p "Originally, APL’s idea was to have special, purpose-built notation. You know, ye olde “thought tool” that I just linked to a couple paragraphs ago. The same way that mathematicians use special symbols to compress their ideas into a set of sharable, written comprehension, programmers deserved their own bespoke character set. Iverson devised an attractive and curious crew. Here’s a sample:"]

     (clojure-code "
⊂⊃∩⊥⊤|⍝⌿⍺⌈⌊_∇∆∘'⎕⍎⍕?⍵∊⍴∼↑↓⍳○⋆⊢¨¯<≤=≥>≠∨∧×
")

     [:p "Instead of having bools, ints, and floats, the basic data structure is the array: " [:a {:href "https://en.wikipedia.org/wiki/Array_programming"} "array-based programming"] " (cf. NumPy, MATLAB). Examples:"]

     (clojure-code "
⍝ array of 1 2 3
⍳3

⍝ 3x3x3 matrix, 1 to 9
3 3⍴⍳9

⍝ sort an array, low to high
X←22 1 88 12
X[⍋X]
")

     [:p "Golfy, right? Some of the APL community migrated away from the special characters to ASCII. Even Iverson himself, with " [:a {:href "https://en.wikipedia.org/wiki/J_(programming_language)"} "J"] " in 1990. Check out high-frequency trading guru " [:a {:href "https://en.wikipedia.org/wiki/Arthur_Whitney_(computer_scientist)"} "Arthur Whitney’s"] " " [:a {:href "https://en.wikipedia.org/wiki/A%2B_(programming_language)"} "A+"] ", " [:a {:href "https://en.wikipedia.org/wiki/K_(programming_language)"} "K"] ", and " [:a {:href "https://en.wikipedia.org/wiki/Q_(programming_language_from_Kx_Systems)"} "q"] ". And on the opposite end of the spectrum from Wall Street is the inimitable Nils Holm with " [:a {:href "http://t3x.org/klong/index.html"} "Klong"] "."]

     [:p "In an effort to get a feel for the real deal, I wanted the old school characters. I quickly found " [:a {:href "https://www.gnu.org/software/apl/index.html"} "GNU APL"] " by Jürgen Sauermann, along with the excellent editor " [:a {:href "https://github.com/lokedhs/gnu-apl-mode"} "gnu-apl-mode"] " by Elias Mårtenson with character keymapping and REPL connection. I found helpful learning resources on MicroAPL and Dyalog’s websites. The next twist was figuring out how to actually plug this stuff into a UI. Uh... how do I do that?"]

     [:h3 "JavaScript Crashes the Party"]

     [:p "Well, although the natural choice would be Andrew Sengul’s fantastic " [:a {:href "https://github.com/phantomics/april"} "April"] ", I found it easier and faster to plug in Nick Nickolov’s " [:a {:href "http://archive.vector.org.uk/art10501160"} "JavaScript APL"] ". To manage the DOM and connect the APL logic to the UI, I’m using some pieces of the " [:a {:href "https://github.com/thi-ng/umbrella"} "umbrella library"] " from the prolific and astounding powerhouse " [:a {:href "https://thi.ng/"} "Karsten Schmidt"] ". Here goes."]

     [:p "24 positions are available for the pieces (three 3x3’s with no middle, so 8 x 3 = 24), and a square grid that accommodates these 24 positions is a 7x7 grid. Here are the 49 nodes, with the available piece positions represented as 1’s:"]

     (clojure-code "
     1  0  0  1  0  0  1
     0  1  0  1  0  1  0
     0  0  1  1  1  0  0
     1  1  1  0  1  1  1
     0  0  1  1  1  0  0
     0  1  0  1  0  1  0
     1  0  0  1  0  0  1
")

     [:p "Here’s the same grid from 0 to 48. I’ll call this the “grid index,” since the markup is going to consist of these 49 squares, then arranged via CSS grid:"]

     (clojure-code "
     0  1  2  3  4  5  6
     7  8  9  10 11 12 13
     14 15 16 17 18 19 20
     21 22 23 24 25 26 27
     28 29 30 31 32 33 34
     35 36 37 38 39 40 41
     42 43 44 45 46 47 48
")

     [:p "If you take the 0-to-48 grid, these are the numbers that are possible piece positions:"]

     (clojure-code "
     0, 3, 6, 8, 10, 12, 16, 17, 18, 21, 22, 23, 25, 26, 27, 30, 31, 32, 36, 38, 40, 42, 45, 48
")

     [:p "The way that I chose to think of the three squares within APL is that each of them is its own 3x3, with the center simply ignored. The outermost merels square is the first APL 3x3, and the innermost is the last. For instance, if there’s a piece in the very top left of the board, and the bottom-center of the other two squares, it’d look like this:"]

     (clojure-code "
     1 0 0   0 0 0   0 0 0
     0 0 0   0 0 0   0 0 0
     0 0 0   0 1 0   0 1 0
")

     [:p "Looking back at the grid index above, the positions that have pieces would be 0, 31, and 38. As opposed to the grid index, the three APL squares would have these “APL indices,” and the corresponding positions would be 0, 16, and 25:"]

     (clojure-code "
     0 1 2    9 10 11   18 19 20
     3 4 5   12 13 14   21 22 23
     6 7 8   15 16 17   24 25 26
")

     [:p "The app data is managed using umbrella’s " [:a {:href "https://github.com/thi-ng/umbrella/tree/develop/packages/atom"} "atoms"] " (à la " [:a {:href "https://clojure.org/reference/atoms"} "Clojure atoms"] "), and the board itself is stored using the " [:em "aplIndex"] " version of the data. This is translated into the " [:em "gridIndex"] " version in order to be mapped to DOM components, and is already translated back to the " [:em "aplIndex"] " by the time the click events are handled. So basically, there’s a translation layer between " [:em "gridIndex"] " and " [:em "aplIndex"] " that’s just a dictionary (31 -> 16, 38 -> 25, etc.)."]

     [:p "A few housekeeping notes: first, there’s just a touch more to “three APL squares” than mentioned above. It’s actually two 27-length arrays, one for white and one for black. When APL handles them, it re-shapes them into “the three squares” before doing anything. Traditionally, APL’s arrays are 1-based. Nickolov’s JavaScript APL library is 0-based. When I’d use the GNU APL, I’d usually use it with its 1-based default, but it’s trivial to change it back and forth."]

     [:p "Whew! Okay, that was boring. But now that’s it’s set up, the fun part is the APL. As weird as this half-JS-half-APL is, and at risk of offending real APL coding bums with my code, here are some examples:"]

     (clojure-code "
export const aplPlacePiece = (board, aplIndex) =>
  apl(`b ← ${board} \n b[${aplIndex}] ← 1`);

export const aplPlaceAndRemovePiece = (board, aplPlaceIndex, aplRemoveIndex) =>
  apl(`b ← ${board} \n b[${aplPlaceIndex}] ← 1 \n b[${aplRemoveIndex}] ← 0`);

export const aplRemovePiece = (board, aplIndex) =>
  apl(`b ← ${board} \n b[${aplIndex}] ← 0`);

export const getNumberOfPieces = (board) => apl(`+/${board}`)[0];

export const isIndexInMill = (board, possibleMills) =>
  apl(`
squares ← ⊂[1 2] 3 3 3⍴${board}
flatten ← {⊃,/⍵}

intralines ← {(⍵[0;])(⍵[;0])(⍵[;2])(⍵[2;])}
intramills ← ∧/ ¨ flatten intralines ¨ squares

interlines ← {(⍵[0;1])(⍵[1;0])(⍵[1;2])(⍵[2;1])}
intermills ← ⊃ ∧/ interlines ¨ squares

allmills ← flatten intramills intermills

∨/ {⍵[${possibleMills}]} allmills
`)[0];
")

     [:p "Well, I hope that wasn’t too terribly anticlimactic. APL looks more magical when it’s happening in a REPL, to be honest, but that’s something that you can only learn for yourself. Anyway, I hope you found this to be at least curious if nothing else. It was a lot of fun."]

     (links "https://merels.sunflowerseastar.com" "https://github.com/sunflowerseastar/merels")]]))

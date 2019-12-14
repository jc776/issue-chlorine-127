(ns desktop.day1
  (:require [devcards.core :as dc :include-macros true]
            [cljs.test :refer [testing is are]]
            [clojure.string :as str]
            [shadow.resource :as res]))

;; quot does "divide & round down"
(defn fuel-required [mass]
  (- (quot mass 3) 2))


(dc/deftest fuel-examples
  (are [mass result] (= (fuel-required mass) result)
    12 2
    14 2
    1969 654
    100756 33583))

;; Q: should I use a file upload instead?
(def input (res/inline "input/day1.txt"))

(def input-modules
  (->> (str/split-lines input)
       (map js/parseInt)))

(def input-fuels
  (map fuel-required input-modules))

(dc/defcard input-modules
  "First 3 modules from puzzle input"
  (take 3 input-modules))

(dc/defcard input-fuels
  "First 3 fuel numbers for each of those"
  (take 3 input-fuels))

;; I'm surprised this isn't built in. OK.
(defn sum [xs]
  (reduce + xs))

(dc/defcard part-one
  "Total fuel for all inputs"
  (str (sum input-fuels)))

;; --- Part Two ---
(defn fuel-seq [mass]
   (when (> mass 0)
     (lazy-seq
       (cons mass (fuel-seq (fuel-required mass))))))

(defn module-fuel-seq [mass]
  "fuel-seq includes the input mass - this is only the fuel FOR that input"
  (fuel-seq (fuel-required mass)))

(defn module-fuel [mass]
  (sum (module-fuel-seq mass)))

(dc/deftest the-rocket-equation
  (testing "module-fuel-seq"
    (are [mass seq]
      (= (module-fuel-seq mass) seq)
      14 [2]
      1969 [654 216 70 21 5]
      100756 [33583 11192 3728 1240 411 135 43 12 2]))
  (testing "module-fuel totals"
    (are [mass total]
      (= (module-fuel mass) total)
      14 2
      1969 966
      100756 50346)))

(def module-fuel-totals
  (map module-fuel input-modules))

(dc/defcard input-fuels
  "First 3 'module with fuel' requirements"
  (take 3 module-fuel-totals))

(dc/defcard part-two
  "Total 'module with fuel' requirement for all inputs ('each module separately')"
  (str (sum module-fuel-totals)))

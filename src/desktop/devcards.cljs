(ns desktop.devcards
  (:require
    [cljsjs.react] ;; devcards#165
    [cljsjs.react.dom] ;; devcards#165
    [desktop.day1]
    [devcards.core :as dc :include-macros true]))

(defn ^:dev/after-load start! []
  (dc/start-devcard-ui!))

(defn init! [] (start!))

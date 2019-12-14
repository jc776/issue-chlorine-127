(ns dev
  (:require [shadow.cljs.devtools.server :as shadow.server]
            [shadow.cljs.devtools.api :as shadow]))
            
(comment
  (+ 1 1)
  (shadow/watch :app)
  (shadow/stop-worker :app)
  (shadow.server/start!)
  (require '[clojure.tools.deps.alpha.repl :refer [add-lib]]))

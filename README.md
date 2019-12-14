https://github.com/mauricioszabo/atom-chlorine/issues/127

1. Start shadow-cljs in terminal `clj -A:dev:shadow watch app`
2. With atom in this directory, `Chlorine: Connect Socket REPL`
3. I can eval JVM Clojure in `dev.clj` eg the `(+ 1 1)` line
4. Open "Devcards" (the shadow-cljs app) on `http://localhost:8700`
5. Use command `Chlorine: Connect Embedded`
6. Reagent error appears in console on first connect, see below
7. I can eval ClojureScript in `day1.cljs` eg the `(+ 1 1)` line
8. In `day1.cljs`, if I start typing `(js/aaa...`, I get `nil` lines in Chlorine REPL window as it autocompletes

## Environment
Atom 1.41.0 x64, Windows 10

chlorine 0.3.7
- Position of console: right
- prefer-clj 
- Nil lines occur with "Enable experimental" ON or OFF
- Refresh: simple

ink 0.11.7
- No settings changed
- Keybindings enabled

lisp-paredit 0.6.0
- Enabled
- Strict OFF
- Indentation Forms from https://gist.github.com/jasongilman/d1f70507bed021b48625
- Keybindings disabled

parinfer 1.23.0
- Smart Mode enabled
- Force Balance enabled
- Warn when bad enabled
- Keybindings enabled

Blank init script.
keymap:
```
'atom-text-editor[data-grammar~="clojure"]':
  'shift-enter': 'lisp-paredit:newline'
  'ctrl-enter': 'chlorine:evaluate-block'
```

## Error output

Nil autocomplete lines:
```
nil
desktop.day1=> nil
desktop.day1=> nil
desktop.day1=> nil
desktop.day1=> nil
desktop.day1=>
```

Reagent error:
```
cljs.user=> ------ WARNING - :undeclared-ns ------------------------------------------------
 Resource: :26:7
 No such namespace: reagent.core, could not locate reagent/core.cljs, reagent/core.cljc, or JavaScript source providing "reagent.core"
--------------------------------------------------------------------------------
------ WARNING - :undeclared-ns ------------------------------------------------
 Resource: :28:5
 No such namespace: reagent.ratom, could not locate reagent/ratom.cljs, reagent/ratom.cljc, or JavaScript source providing "reagent.ratom"
--------------------------------------------------------------------------------
------ WARNING - :undeclared-var -----------------------------------------------
 Resource: :28:5
 Use of undeclared Var reagent.ratom/RAtom
--------------------------------------------------------------------------------
------ WARNING - :undeclared-ns ------------------------------------------------
 Resource: :28:5
 No such namespace: reagent.ratom, could not locate reagent/ratom.cljs, reagent/ratom.cljc, or JavaScript source providing "reagent.ratom"
--------------------------------------------------------------------------------
------ WARNING - :undeclared-var -----------------------------------------------
 Resource: :28:5
 Use of undeclared Var reagent.ratom/RAtom
--------------------------------------------------------------------------------
------ WARNING - :undeclared-ns ------------------------------------------------
 Resource: :33:5
 No such namespace: reagent.ratom, could not locate reagent/ratom.cljs, reagent/ratom.cljc, or JavaScript source providing "reagent.ratom"
--------------------------------------------------------------------------------
------ WARNING - :undeclared-var -----------------------------------------------
 Resource: :33:5
 Use of undeclared Var reagent.ratom/RCursor
--------------------------------------------------------------------------------
------ WARNING - :undeclared-ns ------------------------------------------------
 Resource: :33:5
 No such namespace: reagent.ratom, could not locate reagent/ratom.cljs, reagent/ratom.cljc, or JavaScript source providing "reagent.ratom"
--------------------------------------------------------------------------------
------ WARNING - :undeclared-var -----------------------------------------------
 Resource: :33:5
 Use of undeclared Var reagent.ratom/RCursor
--------------------------------------------------------------------------------
```

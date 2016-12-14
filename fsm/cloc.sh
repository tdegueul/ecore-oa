#!/bin/bash
npm i -g cloc

cloc_project() {
  cloc "$1" --json --out="./cloc/$2.json"
}

mkdir -p ./cloc

cloc_project fr.inria.diverse.expression.algebra expression
cloc_project fr.inria.diverse.fsm.algebra3 fsm
cloc_project fr.inria.diverse.gfsm.algebra gfsm
cloc_project fr.inria.diverse.gtfsm.algebra gtfsm
cloc_project fr.inria.diverse.tfsm.algebra3 tfsm

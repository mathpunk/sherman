
# Sherman

Let's play with replacement grammars by wrapping Tracery.js in self-hosted ClojureScript

## Goals

Autodidactic goals:
* Learn about JavaScript interop 
* Learn about self-hosted ClojureScript
* Experiment with using clojure.spec in code that is mainly or wholly test-driven

Library goals:
* Validate grammar rules
* Integrate interesting sources for words (specifically dariusk/corpora)
* Create procedurally generated content for game jams and bots and such...
* ...accessible through command-line and http interfaces

## Usage

Currently I'm working either in the repl, or running `lumo -K -c $(lein classpath) -m sherman.core`. 

TODO:
+ `lein classpath` takes a long time to run. Can this information be cached?
+ command-line options to generate from different grammars?
+ microservice pattern: ways to spin up a node server that responds to requests with traces from grammars

## Grammar Ideas

What sorts of flavor text could be useful to generate for games? 

* Spell and Item names
* Power-up names
* Character biographies
* Organization names and motivations
* Oaths ("By the gleaming elbows of Hera!")
* Insults
* Recipes
* Dialogue
* Journal entries

## Thanks To

* GalaxyKate, for creating Tracery (http://tracery.io) and for her "Generative Art and Procedural Content starter kit":
  + a 30 minute talk: https://www.youtube.com/watch?v=WumyfLEa6bU
  + an in-depth post: http://galaxykate0.tumblr.com/post/139774965871/so-you-want-to-build-a-generator
  + a friendly zine: http://www.galaxykate.com/pdfs/galaxykate-zine-encyclopedia.pdf
* Emily Short, for her many contributions to the field of interactive fiction. She [blogs](https://emshort.blog/) extensively on interactive fiction and conversation modeling, and I really enjoyed [this talk](https://www.youtube.com/watch?v=narjui3em1k) on procedural text generation and collaborating with the machine to, in this case, create a travel guide.
* George Buckenham, for packaging Tracery for Node.js: https://github.com/v21/tracery


## Why 'sherman'?

After photographer Cindy Sherman. The idea of making numerous grammars in different genres and purposes made me think of her make-up and costuming in her many [self-portraits](https://www.google.com/search?as_st=y&tbm=isch&as_q=cindy+sherman+self-portraits).

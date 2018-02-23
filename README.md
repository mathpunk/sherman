
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

## Prerequisites

* Node.js
* npm
* shadow-cljs (`npm install shadow-cljs --global`)

## Usage

Who **couldn't*** use `Castamir the Usurper's mantle of ubiquitous second chances`, or `an orcish sweater of courage`? Wouldn't `Túrin's regretful cantrip` help you during your day? Don't you sometimes feel like raising your arms to the sky and shouting, `By the forehead of Chaos!`?

### As a web service

First build the code with `shadow-cljs compile app`. Then run `node dist/sherman-server.js` This will start a server at `localhost:3000`. You can query it with

* `curl localhost:3000/magic/spell` for a magic spell name
* `curl localhost:3000/magic/item` for a magic item name
* `curl localhost:3000/oath` to get an exclamation

Or, visit these urls in your browser for the same effect.

### As a command line script

tk

## Testing

My strategy is to run `shadow-cljs watch compile test` to keep an up-to-date test file generated, then in a separate process run chokidar (`npm install chokidar-cli --global`) to watch for changes in that file with `chokidar out/node-tests.js -c 'node out/node-tests.js'`.

## TODO

+ add grammars
+ continue complexifying current grammar(s)
+ consider more complex REST service; maybe it starts with a base grammar and users can add symbols and expanders to it?

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

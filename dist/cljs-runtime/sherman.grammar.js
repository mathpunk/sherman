goog.provide('sherman.grammar');
goog.require('cljs.core');
goog.require('cljs.nodejs');
goog.require('cljs.spec.alpha');
sherman.grammar.tracery = (cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1 ? cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1("tracery-grammar") : cljs.nodejs.require.call(null,"tracery-grammar"));
sherman.grammar.grammar = (function sherman$grammar$grammar(rules){
var base_grammar = sherman.grammar.tracery.createGrammar(cljs.core.clj__GT_js(rules));
base_grammar.addModifiers(sherman.grammar.tracery.baseEngModifiers);

return base_grammar;
});
/**
 * Generate a sentence from rules and a template name. Note, this is different
 *   from making a generator that you then act on, which could be an okay interface
 *   too.
 */
sherman.grammar.trace = (function sherman$grammar$trace(rules,template_name){
return sherman.grammar.grammar(rules).flatten(["#",cljs.core.str.cljs$core$IFn$_invoke$arity$1(template_name),"#"].join(''));
});
sherman.grammar.apply = (function sherman$grammar$apply(var_args){
var args__6412__auto__ = [];
var len__6405__auto___32021 = arguments.length;
var i__6406__auto___32022 = (0);
while(true){
if((i__6406__auto___32022 < len__6405__auto___32021)){
args__6412__auto__.push((arguments[i__6406__auto___32022]));

var G__32023 = (i__6406__auto___32022 + (1));
i__6406__auto___32022 = G__32023;
continue;
} else {
}
break;
}

var argseq__6413__auto__ = ((((1) < args__6412__auto__.length))?(new cljs.core.IndexedSeq(args__6412__auto__.slice((1)),(0),null)):null);
return sherman.grammar.apply.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__6413__auto__);
});

sherman.grammar.apply.cljs$core$IFn$_invoke$arity$variadic = (function (rules,templates){
var sentence_patterns = cljs.core.vec(templates);
var sentence_name = [cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.gensym.cljs$core$IFn$_invoke$arity$0())].join('');
var complete_rules = cljs.core.assoc.cljs$core$IFn$_invoke$arity$3(rules,sentence_name,sentence_patterns);
return sherman.grammar.trace(complete_rules,sentence_name);
});

sherman.grammar.apply.cljs$lang$maxFixedArity = (1);

sherman.grammar.apply.cljs$lang$applyTo = (function (seq32019){
var G__32020 = cljs.core.first(seq32019);
var seq32019__$1 = cljs.core.next(seq32019);
return sherman.grammar.apply.cljs$core$IFn$_invoke$arity$variadic(G__32020,seq32019__$1);
});


//# sourceMappingURL=sherman.grammar.js.map

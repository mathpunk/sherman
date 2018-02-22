goog.provide('cljs.nodejs');
goog.require('cljs.core');
cljs.nodejs.require = require;
cljs.nodejs.process = process;
cljs.nodejs.enable_util_print_BANG_ = (function cljs$nodejs$enable_util_print_BANG_(){
cljs.core._STAR_print_newline_STAR_ = false;

cljs.core._STAR_print_fn_STAR_ = (function() { 
var G__30944__delegate = function (args){
return console.log.apply(console,cljs.core.into_array.cljs$core$IFn$_invoke$arity$1(args));
};
var G__30944 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__30945__i = 0, G__30945__a = new Array(arguments.length -  0);
while (G__30945__i < G__30945__a.length) {G__30945__a[G__30945__i] = arguments[G__30945__i + 0]; ++G__30945__i;}
  args = new cljs.core.IndexedSeq(G__30945__a,0,null);
} 
return G__30944__delegate.call(this,args);};
G__30944.cljs$lang$maxFixedArity = 0;
G__30944.cljs$lang$applyTo = (function (arglist__30946){
var args = cljs.core.seq(arglist__30946);
return G__30944__delegate(args);
});
G__30944.cljs$core$IFn$_invoke$arity$variadic = G__30944__delegate;
return G__30944;
})()
;

cljs.core._STAR_print_err_fn_STAR_ = (function() { 
var G__30947__delegate = function (args){
return console.error.apply(console,cljs.core.into_array.cljs$core$IFn$_invoke$arity$1(args));
};
var G__30947 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__30948__i = 0, G__30948__a = new Array(arguments.length -  0);
while (G__30948__i < G__30948__a.length) {G__30948__a[G__30948__i] = arguments[G__30948__i + 0]; ++G__30948__i;}
  args = new cljs.core.IndexedSeq(G__30948__a,0,null);
} 
return G__30947__delegate.call(this,args);};
G__30947.cljs$lang$maxFixedArity = 0;
G__30947.cljs$lang$applyTo = (function (arglist__30949){
var args = cljs.core.seq(arglist__30949);
return G__30947__delegate(args);
});
G__30947.cljs$core$IFn$_invoke$arity$variadic = G__30947__delegate;
return G__30947;
})()
;

return null;
});

//# sourceMappingURL=cljs.nodejs.js.map

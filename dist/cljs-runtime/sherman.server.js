goog.provide('sherman.server');
goog.require('cljs.core');
goog.require('sherman.grammar');
goog.require('sherman.magic');
goog.require('sherman.oaths');
goog.require('cljs.nodejs');
if(typeof sherman.server.express !== 'undefined'){
} else {
sherman.server.express = (cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1 ? cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1("express") : cljs.nodejs.require.call(null,"express"));
}
if(typeof sherman.server.http !== 'undefined'){
} else {
sherman.server.http = (cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1 ? cljs.nodejs.require.cljs$core$IFn$_invoke$arity$1("http") : cljs.nodejs.require.call(null,"http"));
}
sherman.server.app = (sherman.server.express.cljs$core$IFn$_invoke$arity$0 ? sherman.server.express.cljs$core$IFn$_invoke$arity$0() : sherman.server.express.call(null));
sherman.server.send_trace = (function sherman$server$send_trace(req,res,rules,sentence){
var message = sherman.grammar.trace(rules,sentence);
return res.send(message);
});
sherman.server.app.get("/magic/spell",(function (req,res){
return sherman.server.send_trace(req,res,sherman.magic.magic_rules,"spell");
}));
sherman.server.app.get("/magic/item",(function (req,res){
return sherman.server.send_trace(req,res,sherman.magic.magic_rules,"item");
}));
sherman.server.app.get("/oath",(function (req,res){
return sherman.server.send_trace(req,res,sherman.oaths.rules,"oath");
}));
sherman.server.main = (function sherman$server$main(var_args){
var args__6412__auto__ = [];
var len__6405__auto___28476 = arguments.length;
var i__6406__auto___28477 = (0);
while(true){
if((i__6406__auto___28477 < len__6405__auto___28476)){
args__6412__auto__.push((arguments[i__6406__auto___28477]));

var G__28478 = (i__6406__auto___28477 + (1));
i__6406__auto___28477 = G__28478;
continue;
} else {
}
break;
}

var argseq__6413__auto__ = ((((0) < args__6412__auto__.length))?(new cljs.core.IndexedSeq(args__6412__auto__.slice((0)),(0),null)):null);
return sherman.server.main.cljs$core$IFn$_invoke$arity$variadic(argseq__6413__auto__);
});

sherman.server.main.cljs$core$IFn$_invoke$arity$variadic = (function (args){
var port = (3000);
cljs.core.println.cljs$core$IFn$_invoke$arity$variadic(cljs.core.prim_seq.cljs$core$IFn$_invoke$arity$2([["Serving magic and oaths on port ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(port)].join('')], 0));

var G__28475 = sherman.server.http.createServer(((function (port){
return (function (p1__28472_SHARP_,p2__28473_SHARP_){
return (sherman.server.app.cljs$core$IFn$_invoke$arity$2 ? sherman.server.app.cljs$core$IFn$_invoke$arity$2(p1__28472_SHARP_,p2__28473_SHARP_) : sherman.server.app.call(null,p1__28472_SHARP_,p2__28473_SHARP_));
});})(port))
);
G__28475.listen((3000));

return G__28475;
});

sherman.server.main.cljs$lang$maxFixedArity = (0);

sherman.server.main.cljs$lang$applyTo = (function (seq28474){
return sherman.server.main.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq28474));
});


//# sourceMappingURL=sherman.server.js.map

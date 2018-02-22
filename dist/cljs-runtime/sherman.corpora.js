goog.provide('sherman.corpora');
goog.require('cljs.core');
goog.require('cognitect.transit');
goog.require('shadow.js.shim.module$fs');
sherman.corpora.load_corpus = (function sherman$corpora$load_corpus(path_keys){
var filename = ["./resources/corpora/data/",cljs.core.str.cljs$core$IFn$_invoke$arity$1(clojure.string.join.cljs$core$IFn$_invoke$arity$2("/",path_keys)),".json"].join('');
var reader = cognitect.transit.reader.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"json","json",1279968570));
var file_contents = shadow.js.shim.module$fs.readFileSync(filename);
return cognitect.transit.read(reader,file_contents);
});

//# sourceMappingURL=sherman.corpora.js.map

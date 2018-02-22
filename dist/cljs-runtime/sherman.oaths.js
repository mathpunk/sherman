goog.provide('sherman.oaths');
goog.require('cljs.core');
goog.require('sherman.corpora');
sherman.oaths.god_choices = (function (){var greek_corpus = sherman.corpora.load_corpus(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["mythology","greek_myths_master"], null));
var norse_corpus = sherman.corpora.load_corpus(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["mythology","norse_gods"], null));
return cljs.core.concat.cljs$core$IFn$_invoke$arity$variadic(cljs.core.get.cljs$core$IFn$_invoke$arity$2(greek_corpus,"greek_titans"),cljs.core.get.cljs$core$IFn$_invoke$arity$2(greek_corpus,"greek_gods"),cljs.core.prim_seq.cljs$core$IFn$_invoke$arity$2([cljs.core.get_in.cljs$core$IFn$_invoke$arity$2(norse_corpus,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["norse_deities","gods"], null)),cljs.core.get_in.cljs$core$IFn$_invoke$arity$2(norse_corpus,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["norse_deities","goddesses"], null))], 0));
})();
sherman.oaths.dark_god_choices = (function (){var lovecraft_corpus = sherman.corpora.load_corpus(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["mythology","lovecraft"], null));
return cljs.core.get.cljs$core$IFn$_invoke$arity$2(lovecraft_corpus,"deities");
})();
sherman.oaths.rules = new cljs.core.PersistentArrayMap(null, 4, ["god",sherman.oaths.god_choices,"dark-god",sherman.oaths.dark_god_choices,"whoever",new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["#god#","#dark-god#"], null),"oath",new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["#whoever#'s blood!","Great #whoever#!"], null)], null);

//# sourceMappingURL=sherman.oaths.js.map

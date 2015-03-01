function sharedjsbridge(){var nb='',ob=0,pb='gwt.codesvr=',qb='gwt.hosted=',rb='gwt.hybrid',sb='sharedjsbridge',tb='__gwt_marker_sharedjsbridge',ub='<script id="',vb='"><\/script>',wb='SCRIPT',xb='#',yb='?',zb='/',Ab=1,Bb='base',Cb='img',Db='clear.cache.gif',Eb='meta',Fb='name',Gb='gwt:property',Hb='content',Ib='=',Jb='gwt:onPropertyErrorFn',Kb='Bad handler "',Lb='" for "gwt:onPropertyErrorFn"',Mb='gwt:onLoadErrorFn',Nb='" for "gwt:onLoadErrorFn"',Ob='Single-script hosted mode not yet implemented. See issue ',Pb='http://code.google.com/p/google-web-toolkit/issues/detail?id=2079',Qb='362AFEC990AD6A4A2306818013F5EAE7',Rb=':',Sb='DOMContentLoaded',Tb=50;var k=nb,l=ob,m=pb,n=qb,o=rb,p=sb,q=tb,r=ub,s=vb,t=wb,u=xb,v=yb,w=zb,A=Ab,B=Bb,C=Cb,D=Db,F=Eb,G=Fb,H=Gb,I=Hb,J=Ib,K=Jb,L=Kb,M=Lb,N=Mb,O=Nb,P=Ob,Q=Pb,R=Qb,S=Rb,T=Sb,U=Tb;var V=window,W=document,X,Y,Z=k,$={},_=[],ab=[],bb=[],cb=l,db,eb;if(!V.__gwt_stylesLoaded){V.__gwt_stylesLoaded={}}if(!V.__gwt_scriptsLoaded){V.__gwt_scriptsLoaded={}}function fb(){var b=false;try{var c=V.location.search;return (c.indexOf(m)!=-1||(c.indexOf(n)!=-1||V.external&&V.external.gwtOnLoad))&&c.indexOf(o)==-1}catch(a){}fb=function(){return b};return b}
function gb(){if(X&&Y){X(db,p,Z,cb)}}
function hb(){var e,f=q,g;W.write(r+f+s);g=W.getElementById(f);e=g&&g.previousSibling;while(e&&e.tagName!=t){e=e.previousSibling}function h(a){var b=a.lastIndexOf(u);if(b==-1){b=a.length}var c=a.indexOf(v);if(c==-1){c=a.length}var d=a.lastIndexOf(w,Math.min(c,b));return d>=l?a.substring(l,d+A):k}
;if(e&&e.src){Z=h(e.src)}if(Z==k){var i=W.getElementsByTagName(B);if(i.length>l){Z=i[i.length-A].href}else{Z=h(W.location.href)}}else if(Z.match(/^\w+:\/\//)){}else{var j=W.createElement(C);j.src=Z+D;Z=h(j.src)}if(g){g.parentNode.removeChild(g)}}
function ib(){var b=document.getElementsByTagName(F);for(var c=l,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(G),g;if(f){if(f==H){g=e.getAttribute(I);if(g){var h,i=g.indexOf(J);if(i>=l){f=g.substring(l,i);h=g.substring(i+A)}else{f=g;h=k}$[f]=h}}else if(f==K){g=e.getAttribute(I);if(g){try{eb=eval(g)}catch(a){alert(L+g+M)}}}else if(f==N){g=e.getAttribute(I);if(g){try{db=eval(g)}catch(a){alert(L+g+O)}}}}}}
__gwt_isKnownPropertyValue=function(a,b){return b in _[a]};__gwt_getMetaProperty=function(a){var b=$[a];return b==null?null:b};sharedjsbridge.onScriptLoad=function(a){sharedjsbridge=null;X=a;gb()};if(fb()){alert(P+Q);return}hb();ib();try{var jb;jb=R;var kb=jb.indexOf(S);if(kb!=-1){cb=Number(jb.substring(kb+A))}}catch(a){return}var lb;function mb(){if(!Y){Y=true;gb();if(W.removeEventListener){W.removeEventListener(T,mb,false)}if(lb){clearInterval(lb)}}}
if(W.addEventListener){W.addEventListener(T,function(){mb()},false)}var lb=setInterval(function(){if(/loaded|complete/.test(W.readyState)){mb()}},U)}
sharedjsbridge();(function () {var $gwt_version = "2.7.0";var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var $stats = $wnd.__gwtStatsEvent ? function(a) {$wnd.__gwtStatsEvent(a)} : null;var $strongName = '362AFEC990AD6A4A2306818013F5EAE7';function k(){}
function K(){}
function S(){}
function lc(){}
function hc(){}
function W(){U()}
function yc(){return w}
function Sc(a){this.b=a}
function Xc(a){this.a=a}
function _c(a){this.a=a}
function md(a){ld(a,a.a)}
function Ac(){md(new rd)}
function n(){n=hc;m=new k}
function H(){H=hc;G=new K}
function Lc(){l.call(this)}
function Nc(){l.call(this)}
function cd(){l.call(this)}
function l(){Q(this,this.b)}
function bd(a){this.b=a;this.a=a}
function rd(){this.a=(yd(),td)}
function F(){r!=0&&(r=0);t=-1}
function wc(){uc==null&&(uc=[])}
function Qc(a){return a.a<a.b.o()}
function Pc(a){return Math.floor(a)}
function ad(a,b){return Wc(a.a,b)}
function cb(a,b){return Hc(a,b)}
function Q(a,b){P();O.i(a,b)}
function jb(a,b){return a!=null&&hb(a,b)}
function kb(a){return a==null?null:a}
function o(a){n();this.b=null;this.a=a}
function Cc(){++Bc;this.c=null;this.a=null}
function Oc(a){this.b=a;Q(this,this.b)}
function zd(a,b,c){this.b=a;this.c=b;this.a=c}
function nc(a,b,c){return {l:a,m:b,h:c}}
function u(a,b,c){return a.apply(b,c);var d}
function fc(a){var b=ec;return kc(b[a])}
function D(a){$wnd.clearTimeout(a)}
function X(a){if(!a){throw new Nc}}
function Y(a){if(!a){throw new cd}}
function mb(a){if(a!=null){throw new Lc}return null}
function Cd(a){Bd();this.a=new bd(new Xc(a))}
function Tc(){this.a=db(Ib,Sd,1,0,3,1)}
function Gd(a,b){this.a=new Tc;this.b=a;this.c=b}
function Gc(a,b){var c;c=new Cc;c.c=b;c.b=1;return c}
function Ec(a,b,c){var d;d=new Cc;Kc(c,d);return d}
function Fc(a,b,c){var d;d=new Cc;Kc(b,d);d.b=c?8:0;return d}
function L(a,b){!a&&(a=[]);a[a.length]=b;return a}
function Wc(a,b){Z(b,a.a.length);return a.a[b]}
function Rc(a){Y(a.a<a.b.o());return a.b.p(a.a++)}
function Hc(a,b){var c=a.a=a.a||[];return c[b]||(c[b]=a.j(b))}
function A(a,b,c){var d;d=v();try{return u(a,b,c)}finally{B(d)}}
function w(b){return function(){return A(b,this,arguments);var a}}
function ic(a){return a instanceof Array?a[0]:null}
function U(){U=hc;Error.stackTraceLimit=64}
function C(a){$wnd.setTimeout(function(){throw a},0)}
function B(a){a&&J((H(),G));--r;if(a){if(t!=-1){D(t);t=-1}}}
function ib(a,b){if(a!=null&&!hb(a,b)){throw new Lc}return a}
function kc(a){function b(){}
;b.prototype=a||{};return new b}
function Ic(a){if(a.k()){return null}var b=a.c;var c=ec[b];return c}
function q(){if(Date.now){return Date.now()}return (new Date).getTime()}
function Ad(){yd();return eb(cb(Zb,1),Sd,5,0,[ud,xd,wd,td,sd,vd])}
function lb(a){return ~~Math.max(Math.min(a,2147483647),-2147483648)}
function hb(a,b){return typeof a==='string'&&!!gb[b]||a.cM&&!!a.cM[b]}
function bc(b,c){if(b&&typeof b==Md){try{b.__gwt$exception=c}catch(a){}}}
function Z(a,b){if(a<0||a>=b){throw new Oc('Index: '+a+', Size: '+b)}}
function db(a,b,c,d,e,f){var g;g=fb(e,d);eb(cb(a,f),b,c,e,g);return g}
function Kd(a,b,c,d,e){this.b=a;this.d=b;this.c=c;this.e=d;this.f=e;this.a=0}
function mc(a){var b,c,d;b=a&Rd;c=a>>22&Rd;d=a<0?1048575:0;return nc(b,c,d)}
function J(a){var b,c;if(a.b){c=null;do{b=a.b;a.b=null;c=M(b,c)}while(a.b);a.b=c}}
function I(a){var b,c;if(a.a){c=null;do{b=a.a;a.a=null;c=M(b,c)}while(a.a);a.a=c}}
function Kc(a,b){var c;if(!a){return}b.c=a;var d=Ic(b);if(!d){ec[a]=[b];return}d.cZ=b}
function dc(a){var b;if(jb(a,4)){return a}b=a&&a.__gwt$exception;if(!b){b=new o(a);Q(b,a);bc(a,b)}return b}
function cc(a){var b;if(jb(a,10)){b=ib(a,10);if(kb(b.a)!==kb((n(),m))){return kb(b.a)===kb(m)?null:b.a}}return a}
function R(a){var b=/function(?:\s+([\w$]+))?\s*\(/;var c=b.exec(a);return c&&c[1]||N}
function tc(){tc=hc;qc=nc(Rd,Rd,524287);rc=nc(0,0,524288);pc(1);pc(2);sc=pc(0)}
function vc(){wc();var a=uc;for(var b=0;b<arguments.length;b++){a.push(arguments[b])}}
function zc(a,b){typeof window===Md&&typeof window['$gwt']===Md&&(window['$gwt'][a]=b)}
function P(){P=hc;var a,b;b=!(!!Error.stackTraceLimit||'stack' in new Error);a=new W;O=b?new S:a}
function eb(a,b,c,d,e){e.cZ=a;e.cM=b;e.tM=lc;e.__elementTypeId$=c;e.__elementTypeCategory$=d;return e}
function kd(){gd();var a,b,c;c=fd+++q();a=lb(Math.floor(c*Vd))&16777215;b=lb(c-a*Wd);this.a=a^1502;this.b=b^Ud}
function v(){var a;if(r!=0){a=q();if(a-s>2000){s=a;t=$wnd.setTimeout(F,10)}}if(r++==0){I((H(),G));return true}return false}
function pc(a){var b,c;if(a>-129&&a<128){b=a+128;oc==null&&(oc=db(Ab,Sd,76,256,0,1));c=oc[b];!c&&(c=oc[b]=mc(a));return c}return mc(a)}
function Id(a){var b,c,d,e,f;f=db(Zb,Sd,5,6,0,1);b=0;d=new kd;while(b<6){e=hd(d,a.length);c=a[e];if(c){f[b]=c;a[e]=null;++b}}return f}
function jc(){!Array.isArray&&(Array.isArray=function(a){return Object.prototype.toString.call(a)==='[object Array]'})}
function Jd(a,b){Kd.call(this,a,b,new Cd(eb(cb(Zb,1),Sd,5,0,[])),new Cd(eb(cb(Zb,1),Sd,5,0,[])),new Cd(eb(cb(Zb,1),Sd,5,0,[])))}
function Bd(){Bd=hc;new Cd(eb(cb(Zb,1),Sd,5,0,[(yd(),ud),ud,xd,xd,wd,wd,td,td,sd,sd,vd,vd,vd,vd,vd,vd]));new Cd(eb(cb(Zb,1),Sd,5,0,[]))}
function hd(a,b){var c,d;X(b>0);if((b&-b)==b){return lb(b*jd(a)*4.6566128730773926E-10)}do{c=jd(a);d=c%b}while(c-d+(b-1)<0);return lb(d)}
function yd(){yd=hc;ud=new zd('ONE',0,1);xd=new zd('TWO',1,2);wd=new zd('THREE',2,3);td=new zd('FOUR',3,4);sd=new zd('FIVE',4,5);vd=new zd('SIX',5,6)}
function xc(b,c,d,e){wc();var f=uc;$moduleName=c;$moduleBase=d;ac=e;function g(){for(var a=0;a<f.length;a++){f[a]()}}
if(b){try{Ld(g)()}catch(a){b(c,a)}}else{Ld(g)()}}
function gd(){gd=hc;var a,b,c,d;dd=db(nb,Sd,0,25,7,1);ed=db(nb,Sd,0,33,7,1);d=1.52587890625E-5;for(b=32;b>=0;b--){ed[b]=d;d*=0.5}c=1;for(a=24;a>=0;a--){dd[a]=c;c*=0.5}}
function fb(a,b){var c=new Array(b);var d;switch(a){case ab:d={l:0,m:0,h:0};break;case bb:d=0;break;case $:d=false;break;default:return c;}for(var e=0;e<b;++e){c[e]=d}return c}
function jd(a){var b,c,d,e,f,g;e=a.a*Ud+a.b*1502;g=a.b*Ud+11;b=Math.floor(g*Vd);e+=b;g-=b*Wd;e%=Wd;a.a=e;a.b=g;d=a.a*128;f=Pc(a.b*ed[31]);c=d+f;c>=2147483648&&(c-=4294967296);return c}
function M(b,c){var d,e,f,g;for(e=0,f=b.length;e<f;e++){g=b[e];try{g[1]?g[0].w()&&(c=L(c,g)):g[0].w()}catch(a){a=dc(a);if(jb(a,4)){d=a;C(jb(d,10)?ib(d,10).g():d)}else throw cc(a)}}return c}
function gc(a,b,c){var d=ec;var e=fc;var f=ic;var g=d[a];var h=f(g);if(g&&!h){_=g}else{_=d[a]=!b?{}:e(b);_.cM=c;_.constructor=_;!b&&(_.tM=lc)}for(var i=3;i<arguments.length;++i){arguments[i].prototype=_}h&&(_.cZ=h)}
function ld(h,e){var f=h;var g=e.n();$wnd.cmereShared={test:'omg so shared right now!!!!',deal:function(){var a=(b=eb(cb(Zb,1),Sd,5,0,[(yd(),ud),ud,xd,xd,wd,wd,td,td,sd,sd,vd,vd,vd,vd,vd,vd]),c=Id(b),d=Id(b),new Gd(new Cd(c),new Cd(d))),b,c,d;return f.s(a)}};typeof $wnd.cmereSharedLoaded==='function'&&$wnd.cmereSharedLoaded()}
var Md='object',Nd='java.lang',Od='com.google.gwt.core.client',Pd={3:1,4:1},Qd='com.google.gwt.core.client.impl',Rd=4194303,Sd={3:1},Td='java.util',Ud=15525485,Vd=5.9604644775390625E-8,Wd=16777216,Xd='us.larkoli.cmere.shared',Yd='com.google.gwt.lang';var _,uc,ec={},ac=-1;gc(1,null,{},k);gb={3:1,74:1,55:1,2:1};jc();var gb;gc(21,1,{},Cc);_.j=function Dc(a){var b;b=new Cc;b.b=4;a>1?Hc(this,a-1):this;return b};_.k=function Jc(){return (this.b&1)!=0};_.b=0;var Bc=1;var Ib=Ec(Nd,'Object',1),qb=Ec(Od,'JavaScriptObject$',0),Db=Ec(Nd,'Class',21);gc(4,1,Pd);var Lb=Ec(Nd,'Throwable',4);gc(17,4,Pd);var Fb=Ec(Nd,'Exception',17);gc(7,17,Pd);var Jb=Ec(Nd,'RuntimeException',7);gc(31,7,Pd);var sb=Ec(Qd,'JavaScriptExceptionBase',31);gc(10,31,{10:1,3:1,4:1},o);_.g=function p(){return kb(this.a)===kb(m)?null:this.a};var m;var pb=Ec(Od,'JavaScriptException',10);gc(56,1,{});var rb=Ec(Od,'Scheduler',56);var r=0,s=0,t=-1;gc(49,56,{},K);var G;var tb=Ec(Qd,'SchedulerImpl',49);var N='anonymous',O;gc(67,1,{});var xb=Ec(Qd,'StackTraceCreator/Collector',67);gc(32,67,{},S);_.i=function T(a,b){var c={},j;a.fnStack=[];var d=arguments.callee.caller;while(d){var e=(P(),d.name||(d.name=R(d.toString())));a.fnStack.push(e);var f=':'+e;var g=c[f];if(g){var h,i;for(h=0,i=g.length;h<i;h++){if(g[h]===d){return}}}(g||(c[f]=[])).push(d);d=d.caller}};var ub=Ec(Qd,'StackTraceCreator/CollectorLegacy',32);gc(68,67,{});_.i=function V(c,d){function e(b){if(!('stack' in b)){try{throw b}catch(a){}}return b}
var f;typeof d=='string'?(f=e(new Error(d))):d instanceof Object&&'stack' in d?(f=d):(f=e(new Error));c.__gwt$backingJsError=f};var wb=Ec(Qd,'StackTraceCreator/CollectorModern',68);gc(33,68,{},W);var vb=Ec(Qd,'StackTraceCreator/CollectorModernNoSourceMap',33);var $=8,ab=6,bb=7;var oc;var qc,rc,sc;gc(11,7,Pd,Lc);var Cb=Ec(Nd,'ClassCastException',11);gc(29,1,{3:1,55:1});_.n=function Mc(){return this.b!=null?this.b:''+this.c};_.c=0;var Eb=Ec(Nd,'Enum',29);gc(25,7,Pd,Nc);var Gb=Ec(Nd,'IllegalArgumentException',25);gc(53,7,Pd,Oc);var Hb=Ec(Nd,'IndexOutOfBoundsException',53);var Kb=Ec(Nd,'String',2);gc(70,1,{});var Mb=Ec(Td,'AbstractCollection',70);gc(72,70,{14:1});var Ob=Ec(Td,'AbstractList',72);gc(13,1,{},Sc);_.a=0;var Nb=Ec(Td,'AbstractList/IteratorImpl',13);gc(45,72,{3:1,14:1},Tc);_.p=function Uc(a){return Z(a,this.a.length),this.a[a]};_.o=function Vc(){return this.a.length};var Pb=Ec(Td,'ArrayList',45);gc(51,72,{3:1,14:1},Xc);_.p=function Yc(a){return Wc(this,a)};_.o=function Zc(){return this.a.length};var Qb=Ec(Td,'Arrays/ArrayList',51);gc(38,1,{});_.o=function $c(){return this.b.a.length};var Sb=Ec(Td,'Collections/UnmodifiableCollection',38);gc(26,1,{},_c);var Rb=Ec(Td,'Collections/UnmodifiableCollectionIterator',26);gc(39,38,{14:1});var Tb=Ec(Td,'Collections/UnmodifiableList',39);gc(40,39,{14:1},bd);var Ub=Ec(Td,'Collections/UnmodifiableRandomAccessList',40);gc(54,7,Pd,cd);var Vb=Ec(Td,'NoSuchElementException',54);gc(50,1,{},kd);_.a=0;_.b=0;var dd,ed,fd=0;var Wb=Ec(Td,'Random',50);gc(30,1,{},rd);_.q=function nd(a){return {cards:this.r(a),cardSum:a.u()}};_.r=function od(a){var b,c;b=db(ob,Sd,0,a.a.o(),7,1);for(c=0;c<a.a.o();c++){b[c]=ad(a.a,c).a}return b};_.s=function pd(b){var c=this;return {getCurrentGameState:function(){var a=b.v();return c.t(a)}}};_.t=function qd(a){var b=this;var c=a.b;var d=a.d;var e=a.c;var f=a.e;var g=a.f;var h=a.a;return {player1Hand:b.q(c),player2Hand:b.q(d),player1StuckCards:b.q(e),player2StuckCards:b.q(f),stack:b.q(g),numSixesDiscarded:h}};var Xb=Ec('us.larkoli.cmere.client','sharedJsBridge',30);gc(5,29,{3:1,55:1,5:1},zd);_.a=0;var sd,td,ud,vd,wd,xd;var Zb=Fc('Card',5,Ad);gc(9,72,{14:1,9:1},Cd);_.p=function Dd(a){return ad(this.a,a)};_.u=function Ed(){var a,b,c;c=0;for(b=new _c(new Sc(this.a.b));Qc(b.a);){a=ib(Rc(b.a),5);c+=a.a}return c};_.o=function Fd(){return this.a.o()};var Yb=Ec(Xd,'CardCollection',9);gc(46,1,{},Gd);_.v=function Hd(){var a,b;b=new Jd(this.b,this.c);for(a=new Sc(this.a);a.a<a.b.o();){Y(a.a<a.b.o());mb(a.b.p(a.a++));b=null.w()}return b};var $b=Ec(Xd,'Game',46);gc(27,1,{},Jd);_.a=0;var _b=Ec('us.larkoli.cmere.shared.gamestate','GameState',27);var ob=Gc('int','I'),yb=Ec(Yd,'CollapsedPropertyHolder',58),zb=Ec(Yd,'JavaClassHierarchySetupUtil',60),Ab=Ec(Yd,'LongLibBase/LongEmul',null),Bb=Ec(Yd,'ModuleUtils',63),nb=Gc('double','D');var Ld=yc();var gwtOnLoad=gwtOnLoad=xc;vc(Ac);zc('permProps',[[]]);if (sharedjsbridge) sharedjsbridge.onScriptLoad(gwtOnLoad);})();
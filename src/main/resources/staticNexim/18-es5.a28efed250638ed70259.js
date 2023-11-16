!function(){function t(t,n){if(!(t instanceof n))throw new TypeError("Cannot call a class as a function")}function n(t,n){for(var e=0;e<n.length;e++){var i=n[e];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(t,i.key,i)}}function e(t,e,i){return e&&n(t.prototype,e),i&&n(t,i),t}(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{"/2RN":function(n,i,o){"use strict";o.r(i),o.d(i,"DashboardModule",(function(){return O}));var r,a,c,s,u=o("3Pt+"),l=o("ofXK"),d=o("tyNb"),p=o("iXZC"),b=o("lJxs"),f=o("fXoL"),h=o("a8X4"),g=((r=function(){function n(e,i,o){t(this,n),this.router=e,this.reportService=i,this.location=o}return e(n,[{key:"canActivate",value:function(t,n){var e=this;return this.reportService.selectedDate.pipe(Object(b.a)((function(t){var n,i=null===(n=e.location.getState())||void 0===n?void 0:n.navigationId;return null!==t&&t.length>0||((null==i||i<=1)&&e.router.navigate(["/"]),!1)})))}},{key:"canActivateChild",value:function(t,n){return this.canActivate(t,n)}},{key:"canLoad",value:function(t,n){return this.reportService.selectedDate.pipe(Object(b.a)((function(t){return null!==t||t.length>0})))}}]),n}()).\u0275fac=function(t){return new(t||r)(f.Wb(d.b),f.Wb(h.a),f.Wb(l.i))},r.\u0275prov=f.Ib({token:r,factory:r.\u0275fac,providedIn:"root"}),r),v=o("KwcT"),y=o("Z70I"),m=o("Tj54"),x=function(){return{exact:!0}},C=[{path:"",component:(a=function(){function n(e,i,o){t(this,n),this.authService=e,this.reportService=i,this.reportHistory=o,this.selectedDate=null}return e(n,[{key:"ngOnInit",value:function(){var t=this;this.$dateSubscription=this.reportService.selectedDate.subscribe((function(n){t.selectedDate=n}))}},{key:"ngAfterViewInit",value:function(){}},{key:"logout",value:function(){this.authService.logout()}},{key:"ngOnDestroy",value:function(){this.$dateSubscription&&this.$dateSubscription.unsubscribe()}}]),n}(),a.\u0275fac=function(t){return new(t||a)(f.Mb(v.a),f.Mb(h.a),f.Mb(y.a))},a.\u0275cmp=f.Gb({type:a,selectors:[["app-dashboard"]],decls:26,vars:4,consts:[["id","myTopnav",1,"topnav"],["routerLink","/dashboard",1,"navbar-brand"],["src","../../../assets/img/efass-dashboard-logo.png"],[1,"navbar-brand"],[1,"h4","text-white"],[1,"logout",3,"click"],[1,"sidebar"],["routerLinkActive","active","routerLink","/dashboard",3,"routerLinkActiveOptions"],["routerLinkActive","active","routerLink","generate_report/data/assets"],["routerLinkActive","active","routerLink","user_settings"],[1,"main"]],template:function(t,n){1&t&&(f.Sb(0,"div",0),f.Sb(1,"a",1),f.Nb(2,"img",2),f.Rb(),f.Sb(3,"div",3),f.Sb(4,"span",4),f.Ac(5,"Electronic Financial Analysis and Surveillance System (Efass)"),f.Rb(),f.Rb(),f.Sb(6,"b"),f.Sb(7,"a",5),f.Zb("click",(function(){return n.logout()})),f.Ac(8,"LOGOUT"),f.Rb(),f.Rb(),f.Rb(),f.Sb(9,"div",6),f.Nb(10,"br"),f.Nb(11,"br"),f.Sb(12,"a",7),f.Sb(13,"mat-icon"),f.Ac(14,"home"),f.Rb(),f.Ac(15," Dashboard"),f.Rb(),f.Sb(16,"a",8),f.Sb(17,"mat-icon"),f.Ac(18,"folder"),f.Rb(),f.Ac(19," Generate Report"),f.Rb(),f.Sb(20,"a",9),f.Sb(21,"mat-icon"),f.Ac(22,"settings"),f.Rb(),f.Ac(23," Settings"),f.Rb(),f.Rb(),f.Sb(24,"div",10),f.Nb(25,"router-outlet"),f.Rb()),2&t&&(f.Bb(12),f.kc("routerLinkActiveOptions",f.lc(3,x)),f.Bb(4),f.Eb("disabled",null===n.selectedDate||0===n.selectedDate.length))},directives:[d.d,d.c,m.a,d.f],styles:[".sidebar[_ngcontent-%COMP%]{margin:0;width:220px;background-color:var(--primary-color);border:.5px solid var(--primary-color);position:fixed;height:100%;overflow:auto;z-index:1;padding:35px 0 0}.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{display:block;color:#f1f1f1;font-size:15px;padding:16px;text-decoration:none}.sidebar[_ngcontent-%COMP%]   a.active[_ngcontent-%COMP%]{background-color:#fff;color:var(--primary-color)}div.main[_ngcontent-%COMP%]{margin-left:240px;padding:48px 16px 1px}@media screen and (max-width:700px){.sidebar[_ngcontent-%COMP%]{width:100%;height:auto;position:relative}.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{float:left}div.main[_ngcontent-%COMP%]{margin-left:0;padding-top:0}}@media screen and (max-width:400px){.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{text-align:center;float:none}}.topnav[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{display:block;text-align:center;text-decoration:none;font-size:18px;padding:14px 10px 12px;margin-left:0;font-family:Raleway,sans-serif;min-width:210px;color:#f1f1f1}.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]{color:#fff;font-size:16px;cursor:pointer;transition:.06s ease-in}.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]:hover{transform:scale(.8)}.topnav[_ngcontent-%COMP%]{background-color:var(--primary-color);display:flex;justify-content:space-between;align-items:center;border-bottom:1px solid #d9d9d9;height:auto;z-index:99;left:0;right:0}.sticky[_ngcontent-%COMP%], .topnav[_ngcontent-%COMP%]{overflow:hidden;position:fixed}.sticky[_ngcontent-%COMP%]{top:0;z-index:10}.disabled[_ngcontent-%COMP%]{color:currentColor;cursor:not-allowed;opacity:.5;text-decoration:none}.row[_ngcontent-%COMP%]{display:flex;flex-direction:row;justify-content:center;align-items:center}a[_ngcontent-%COMP%]{vertical-align:middle}a[_ngcontent-%COMP%] > mat-icon[_ngcontent-%COMP%]{vertical-align:middle}img[_ngcontent-%COMP%]{width:140px;margin-top:-12px}"]}),a),canActivate:[p.a],canActivateChild:[p.a],children:[{path:"user_settings",loadChildren:function(){return o.e(25).then(o.bind(null,"XAcJ")).then((function(t){return t.UserSettingsModule}))}},{path:"generate_report",loadChildren:function(){return Promise.all([o.e(2),o.e(21)]).then(o.bind(null,"8VTR")).then((function(t){return t.GenerateReportModule}))},canActivate:[g],canActivateChild:[g]},{path:"doc/:id",loadChildren:function(){return Promise.all([o.e(2),o.e(1),o.e(26)]).then(o.bind(null,"oPuF")).then((function(t){return t.XmlViewerModule}))}},{path:"",loadChildren:function(){return Promise.all([o.e(0),o.e(2),o.e(12),o.e(1),o.e(17)]).then(o.bind(null,"82nU")).then((function(t){return t.MainModule}))},pathMatch:"full"}]}],M=((s=function n(){t(this,n)}).\u0275mod=f.Kb({type:s}),s.\u0275inj=f.Jb({factory:function(t){return new(t||s)},imports:[[d.e.forChild(C)],d.e]}),s),O=((c=function n(){t(this,n)}).\u0275mod=f.Kb({type:c}),c.\u0275inj=f.Jb({factory:function(t){return new(t||c)},imports:[[l.c,M,u.h,m.b]]}),c)},Z70I:function(n,i,o){"use strict";o.d(i,"a",(function(){return s}));var r=o("AytR"),a=o("fXoL"),c=o("tk/3"),s=function(){var n=function(){function n(e){t(this,n),this.http=e}return e(n,[{key:"getReportHistory",value:function(){return this.http.get(r.a.baseApi+"/activities")}},{key:"postReportDate",value:function(t){return this.http.post(r.a.baseApi+"/date",t,{responseType:"text"})}},{key:"postCbnDate",value:function(t){return this.http.post(r.a.baseApi+"/cbnDate",t,{responseType:"text"})}},{key:"deleteReportHistory",value:function(t){return this.http.delete(r.a.baseApi+"/activity/"+t)}}]),n}();return n.\u0275fac=function(t){return new(t||n)(a.Wb(c.c))},n.\u0275prov=a.Ib({token:n,factory:n.\u0275fac,providedIn:"root"}),n}()}}])}();
(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{"/2RN":function(t,e,n){"use strict";n.r(e),n.d(e,"DashboardModule",(function(){return v}));var o=n("3Pt+"),i=n("ofXK"),r=n("tyNb"),a=n("iXZC"),c=n("lJxs"),s=n("fXoL"),l=n("a8X4");let d=(()=>{class t{constructor(t,e,n){this.router=t,this.reportService=e,this.location=n}canActivate(t,e){return this.reportService.selectedDate.pipe(Object(c.a)(t=>{var e;const n=null===(e=this.location.getState())||void 0===e?void 0:e.navigationId;return null!==t&&t.length>0||((null==n||n<=1)&&this.router.navigate(["/"]),!1)}))}canActivateChild(t,e){return this.canActivate(t,e)}canLoad(t,e){return this.reportService.selectedDate.pipe(Object(c.a)(t=>null!==t||t.length>0))}}return t.\u0275fac=function(e){return new(e||t)(s.Wb(r.b),s.Wb(l.a),s.Wb(i.i))},t.\u0275prov=s.Ib({token:t,factory:t.\u0275fac,providedIn:"root"}),t})();var p=n("KwcT"),b=n("Z70I"),u=n("Tj54");const h=function(){return{exact:!0}},g=[{path:"",component:(()=>{class t{constructor(t,e,n){this.authService=t,this.reportService=e,this.reportHistory=n,this.selectedDate=null}ngOnInit(){this.$dateSubscription=this.reportService.selectedDate.subscribe(t=>{this.selectedDate=t})}ngAfterViewInit(){}logout(){this.authService.logout()}ngOnDestroy(){this.$dateSubscription&&this.$dateSubscription.unsubscribe()}}return t.\u0275fac=function(e){return new(e||t)(s.Mb(p.a),s.Mb(l.a),s.Mb(b.a))},t.\u0275cmp=s.Gb({type:t,selectors:[["app-dashboard"]],decls:26,vars:4,consts:[["id","myTopnav",1,"topnav"],["routerLink","/dashboard",1,"navbar-brand"],["src","../../../assets/img/efass-dashboard-logo.png"],[1,"navbar-brand"],[1,"h4","text-white"],[1,"logout",3,"click"],[1,"sidebar"],["routerLinkActive","active","routerLink","/dashboard",3,"routerLinkActiveOptions"],["routerLinkActive","active","routerLink","generate_report/data/assets"],["routerLinkActive","active","routerLink","user_settings"],[1,"main"]],template:function(t,e){1&t&&(s.Sb(0,"div",0),s.Sb(1,"a",1),s.Nb(2,"img",2),s.Rb(),s.Sb(3,"div",3),s.Sb(4,"span",4),s.Ac(5,"Electronic Financial Analysis and Surveillance System (Efass)"),s.Rb(),s.Rb(),s.Sb(6,"b"),s.Sb(7,"a",5),s.Zb("click",(function(){return e.logout()})),s.Ac(8,"LOGOUT"),s.Rb(),s.Rb(),s.Rb(),s.Sb(9,"div",6),s.Nb(10,"br"),s.Nb(11,"br"),s.Sb(12,"a",7),s.Sb(13,"mat-icon"),s.Ac(14,"home"),s.Rb(),s.Ac(15," Dashboard"),s.Rb(),s.Sb(16,"a",8),s.Sb(17,"mat-icon"),s.Ac(18,"folder"),s.Rb(),s.Ac(19," Generate Report"),s.Rb(),s.Sb(20,"a",9),s.Sb(21,"mat-icon"),s.Ac(22,"settings"),s.Rb(),s.Ac(23," Settings"),s.Rb(),s.Rb(),s.Sb(24,"div",10),s.Nb(25,"router-outlet"),s.Rb()),2&t&&(s.Bb(12),s.kc("routerLinkActiveOptions",s.lc(3,h)),s.Bb(4),s.Eb("disabled",null===e.selectedDate||0===e.selectedDate.length))},directives:[r.d,r.c,u.a,r.f],styles:[".sidebar[_ngcontent-%COMP%]{margin:0;width:220px;background-color:var(--primary-color);border:.5px solid var(--primary-color);position:fixed;height:100%;overflow:auto;z-index:1;padding:35px 0 0}.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{display:block;color:#f1f1f1;font-size:15px;padding:16px;text-decoration:none}.sidebar[_ngcontent-%COMP%]   a.active[_ngcontent-%COMP%]{background-color:#fff;color:var(--primary-color)}div.main[_ngcontent-%COMP%]{margin-left:240px;padding:48px 16px 1px}@media screen and (max-width:700px){.sidebar[_ngcontent-%COMP%]{width:100%;height:auto;position:relative}.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{float:left}div.main[_ngcontent-%COMP%]{margin-left:0;padding-top:0}}@media screen and (max-width:400px){.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{text-align:center;float:none}}.topnav[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{display:block;text-align:center;text-decoration:none;font-size:18px;padding:14px 10px 12px;margin-left:0;font-family:Raleway,sans-serif;min-width:210px;color:#f1f1f1}.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]{color:#fff;font-size:16px;cursor:pointer;transition:.06s ease-in}.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]:hover{transform:scale(.8)}.topnav[_ngcontent-%COMP%]{background-color:var(--primary-color);display:flex;justify-content:space-between;align-items:center;border-bottom:1px solid #d9d9d9;height:auto;z-index:99;left:0;right:0}.sticky[_ngcontent-%COMP%], .topnav[_ngcontent-%COMP%]{overflow:hidden;position:fixed}.sticky[_ngcontent-%COMP%]{top:0;z-index:10}.disabled[_ngcontent-%COMP%]{color:currentColor;cursor:not-allowed;opacity:.5;text-decoration:none}.row[_ngcontent-%COMP%]{display:flex;flex-direction:row;justify-content:center;align-items:center}a[_ngcontent-%COMP%]{vertical-align:middle}a[_ngcontent-%COMP%] > mat-icon[_ngcontent-%COMP%]{vertical-align:middle}img[_ngcontent-%COMP%]{width:140px;margin-top:-12px}"]}),t})(),canActivate:[a.a],canActivateChild:[a.a],children:[{path:"user_settings",loadChildren:()=>n.e(25).then(n.bind(null,"XAcJ")).then(t=>t.UserSettingsModule)},{path:"generate_report",loadChildren:()=>Promise.all([n.e(2),n.e(21)]).then(n.bind(null,"8VTR")).then(t=>t.GenerateReportModule),canActivate:[d],canActivateChild:[d]},{path:"doc/:id",loadChildren:()=>Promise.all([n.e(2),n.e(1),n.e(26)]).then(n.bind(null,"oPuF")).then(t=>t.XmlViewerModule)},{path:"",loadChildren:()=>Promise.all([n.e(0),n.e(2),n.e(12),n.e(1),n.e(17)]).then(n.bind(null,"82nU")).then(t=>t.MainModule),pathMatch:"full"}]}];let f=(()=>{class t{}return t.\u0275mod=s.Kb({type:t}),t.\u0275inj=s.Jb({factory:function(e){return new(e||t)},imports:[[r.e.forChild(g)],r.e]}),t})(),v=(()=>{class t{}return t.\u0275mod=s.Kb({type:t}),t.\u0275inj=s.Jb({factory:function(e){return new(e||t)},imports:[[i.c,f,o.h,u.b]]}),t})()},Z70I:function(t,e,n){"use strict";n.d(e,"a",(function(){return a}));var o=n("AytR"),i=n("fXoL"),r=n("tk/3");let a=(()=>{class t{constructor(t){this.http=t}getReportHistory(){return this.http.get(o.a.baseApi+"/activities")}postReportDate(t){return this.http.post(o.a.baseApi+"/date",t,{responseType:"text"})}postCbnDate(t){return this.http.post(o.a.baseApi+"/cbnDate",t,{responseType:"text"})}deleteReportHistory(t){return this.http.delete(o.a.baseApi+"/activity/"+t)}}return t.\u0275fac=function(e){return new(e||t)(i.Wb(r.c))},t.\u0275prov=i.Ib({token:t,factory:t.\u0275fac,providedIn:"root"}),t})()}}]);
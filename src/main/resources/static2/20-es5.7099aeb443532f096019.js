!function(){function e(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function t(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}(window.webpackJsonp=window.webpackJsonp||[]).push([[20],{GE1z:function(n,r,i){"use strict";i.r(r),i.d(r,"GenerateReportDataModule",(function(){return Q}));var o=i("ofXK"),a=i("tyNb"),c=i("OaSA"),l=i("M9IT"),u=i("AytR"),s=i("fXoL"),b=i("a8X4"),h=i("KwcT"),d=i("3Pt+"),f=i("tk/3"),p=i("kmnG"),m=i("e6WT");function g(e,t){1&e&&(s.Sb(0,"th",24),s.Sb(1,"b"),s.Ac(2," S/N "),s.Rb(),s.Rb())}function S(e,t){if(1&e&&(s.Sb(0,"td",25),s.Ac(1),s.Rb()),2&e){var n=t.$implicit;s.Bb(1),s.Cc(" ",n.serial_number," ")}}function R(e,t){1&e&&(s.Sb(0,"th",24),s.Sb(1,"b"),s.Ac(2," Report Code "),s.Rb(),s.Rb())}function v(e,t){if(1&e&&(s.Sb(0,"td",25),s.Ac(1),s.Rb()),2&e){var n=t.$implicit;s.Bb(1),s.Cc(" ",n.return_code," ")}}function D(e,t){1&e&&(s.Sb(0,"th",24),s.Sb(1,"b"),s.Ac(2,"Report Description "),s.Rb(),s.Rb())}function C(e,t){if(1&e&&(s.Sb(0,"td",25),s.Ac(1),s.Rb()),2&e){var n=t.$implicit;s.Bb(1),s.Cc(" ",n.return_name," ")}}function w(e,t){1&e&&(s.Sb(0,"th",24),s.Sb(1,"b"),s.Ac(2,"Action"),s.Rb(),s.Rb())}function M(e,t){if(1&e){var n=s.Tb();s.Sb(0,"td",25),s.Sb(1,"button",26),s.Zb("click",(function(){s.pc(n);var e=t.$implicit;return s.dc().edit(e.sheet_number)})),s.Ac(2,"View"),s.Rb(),s.Rb()}}function y(e,t){1&e&&s.Nb(0,"tr",27)}function k(e,t){1&e&&s.Nb(0,"tr",28)}function P(e,t){if(1&e&&(s.Sb(0,"tr",29),s.Sb(1,"td",30),s.Ac(2),s.Rb(),s.Rb()),2&e){s.dc();var n=s.nc(28);s.Bb(2),s.Cc('No data matching the filter "',n.value,'"')}}function N(e,t){1&e&&(s.Sb(0,"tr"),s.Sb(1,"td",31),s.Ac(2,"LOADING..."),s.Rb(),s.Rb())}function _(e,t){if(1&e){var n=s.Tb();s.Sb(0,"tr"),s.Sb(1,"td",31),s.Sb(2,"p"),s.Ac(3),s.Rb(),s.Sb(4,"button",32),s.Zb("click",(function(){return s.pc(n),s.dc().loadData()})),s.Ac(5,"Retry"),s.Rb(),s.Rb(),s.Rb()}if(2&e){var r=s.dc();s.Bb(3),s.Bc(r.errorMessage)}}var I,A,O,E=function(){return[5,10,25,100]},z=[{path:"",component:(I=function(){function n(t,r,i,o,a,c,l){e(this,n),this.router=t,this.route=r,this.reportService=i,this.authService=o,this.location=a,this.fb=c,this.http=l,this.tableData=[],this.displayedColumns=["serialNumber","sheetNumber","returnCode","returnName"],this.SPECIAL_SHEETS=["100","qdfir100","250","300","302","423","453","533","600","700","800","1000","1200","mstdr2"],this.isLoading=!0,this.isError=!1,this.reportName=null,this.byGroupIsLoading=!0,this.byGroupIsError=!1,this.byGroupReportName=null,this.first=0,this.rows=10,this.errorMessage="An Error occurred",console.log("Inside report data"+this.reportData)}var r,i,o;return r=n,(i=[{key:"ngAfterViewInit",value:function(){this.dataSource.paginator=this.paginator}},{key:"ngOnInit",value:function(){var e=this;this.reportSubscription=this.reportService.reportData.subscribe((function(t){e.reportData=t})),this.route.paramMap.subscribe((function(t){t.has("report")&&(e.reportName=t.get("report"),e.loadData())})),this.timeIntervalId=setInterval((function(){e.nowDate=new Date}),1e3),this.$user=this.authService.user.subscribe((function(t){e.username=t.username})),this.$selectedDate=this.reportService.selectedDate.subscribe((function(t){e.reportSelectedDate=t}))}},{key:"edit",value:function(e){var t=e.match(/\d/g).join(""),n=["edit"];this.SPECIAL_SHEETS.includes(e)?(n.push(e=t),console.log(e)):n.push(e),this.router.navigate(n,{relativeTo:this.route})}},{key:"goBack",value:function(){this.location.back()}},{key:"loadData",value:function(){var e=this;this.isError=!1,this.isLoading=!0,this.reportRequestSubscription=this.reportService.getReports(this.reportName).subscribe((function(){e.isLoading=!1,e.tableData=e.reportService.tableData,e.tableData[0].serial_number=0;for(var t=0;t<e.tableData.length;t++)e.tableData[t].serial_number=1+t;console.log(e.tableData),e.dataSource=new c.l(e.reportData)}),(function(t){e.isLoading=!1,e.isError=!0,e.errorMessage=404===t.status?"No record found":"An Error occurred"}))}},{key:"ngOnDestroy",value:function(){clearInterval(this.timeIntervalId),this.$selectedDate&&this.$selectedDate.unsubscribe(),this.$user&&this.$user.unsubscribe(),this.reportRequestSubscription&&this.reportRequestSubscription.unsubscribe(),this.reportSubscription&&this.reportSubscription.unsubscribe()}},{key:"applyFilter",value:function(e){this.dataSource.filter=e.target.value.trim().toLowerCase()}},{key:"next",value:function(){this.first=this.first+this.rows}},{key:"prev",value:function(){this.first=this.first-this.rows}},{key:"reset",value:function(){this.first=0}},{key:"isLastPage",value:function(){return!this.tableData||this.first===this.tableData.length-this.rows}},{key:"isFirstPage",value:function(){return!this.tableData||0===this.first}},{key:"downloadXmlReports",value:function(){var e=this,t=[];this.tableData.forEach((function(e){t.push(e.return_code)}));var n=u.a.baseUrl+"/download/";t.filter((function(e){return!e.startsWith("QDFIR400")})).filter((function(e){return!e.startsWith("QDFIR450")})).filter((function(e){return!e.startsWith("MDFIR450")})).filter((function(e){return!e.startsWith("MDFIR400")})).forEach((function(e){console.log(e),n+=e,n+=","})),console.log(n),"Q"===this.reportService.getReportGroup()&&(n+="QDFIR400",n+=", QDFIR450"),"M"===this.reportService.getReportGroup()&&(n+="MDFIR400",n+=",MDFIR450"),console.log(n),this.download(n).subscribe((function(t){var n=document.createElement("a"),r=URL.createObjectURL(t);n.href=r,n.download="Reports downloaded for "+e.reportSelectedDate+".zip",n.click(),URL.revokeObjectURL(r)}))}},{key:"download",value:function(e){return this.http.get(e,{responseType:"blob"})}}])&&t(r.prototype,i),o&&t(r,o),n}(),I.\u0275fac=function(e){return new(e||I)(s.Mb(a.b),s.Mb(a.a),s.Mb(b.a),s.Mb(h.a),s.Mb(o.i),s.Mb(d.c),s.Mb(f.c))},I.\u0275cmp=s.Gb({type:I,selectors:[["app-assets-and-liability-data"]],viewQuery:function(e,t){var n;1&e&&s.Dc(l.a,!0),2&e&&s.mc(n=s.ac())&&(t.paginator=n.first)},decls:49,vars:16,consts:[[1,"page-header"],[1,"row"],[1,"user"],[1,"input-icon"],[2,"color","var(--primary-color)"],[1,""],[1,"nav","justify-content-end"],[1,"nav-item","me-2"],["mat-flat-button","",1,"btn_common",3,"click"],["matInput","","placeholder","Enter MDFIR300 OR QDFIR300",3,"keyup"],["input",""],["mat-table","",1,"table",3,"dataSource"],["matColumnDef","serialNumber"],["mat-header-cell","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["matColumnDef","sheetNumber"],["matColumnDef","returnCode"],["matColumnDef","returnName"],["mat-header-row","",4,"matHeaderRowDef"],["mat-row","",4,"matRowDef","matRowDefColumns"],["class","mat-row",4,"matNoDataRow"],[4,"ngIf"],[3,"length","pageSize","pageSizeOptions"],["myPaginator",""],["mat-header-cell",""],["mat-cell",""],[1,"edits",3,"click"],["mat-header-row",""],["mat-row",""],[1,"mat-row"],["colspan","4",1,"mat-cell"],["colspan","4",2,"text-align","center"],[1,"btn_common","view",3,"click"]],template:function(e,t){1&e&&(s.Nb(0,"br"),s.Sb(1,"div",0),s.Sb(2,"h1"),s.Ac(3," Generate Report "),s.Sb(4,"small"),s.Ac(5,"list & edit "),s.Rb(),s.Rb(),s.Sb(6,"div",1),s.Sb(7,"div",2),s.Sb(8,"span",3),s.Sb(9,"label",4),s.Ac(10,"Current Date: "),s.Rb(),s.Ac(11),s.ec(12,"date"),s.Rb(),s.Rb(),s.Rb(),s.Sb(13,"div",2),s.Sb(14,"span",3),s.Sb(15,"label",4),s.Ac(16,"User: "),s.Rb(),s.Ac(17),s.ec(18,"titlecase"),s.Rb(),s.Rb(),s.Rb(),s.Sb(19,"div",5),s.Sb(20,"ul",6),s.Sb(21,"li",7),s.Sb(22,"button",8),s.Zb("click",(function(){return t.downloadXmlReports()})),s.Ac(23,"Download"),s.Rb(),s.Rb(),s.Rb(),s.Rb(),s.Sb(24,"mat-form-field"),s.Sb(25,"mat-label"),s.Ac(26,"Filter"),s.Rb(),s.Sb(27,"input",9,10),s.Zb("keyup",(function(e){return t.applyFilter(e)})),s.Rb(),s.Rb(),s.Sb(29,"table",11),s.Qb(30,12),s.zc(31,g,3,0,"th",13),s.zc(32,S,2,1,"td",14),s.Pb(),s.Qb(33,15),s.zc(34,R,3,0,"th",13),s.zc(35,v,2,1,"td",14),s.Pb(),s.Qb(36,16),s.zc(37,D,3,0,"th",13),s.zc(38,C,2,1,"td",14),s.Pb(),s.Qb(39,17),s.zc(40,w,3,0,"th",13),s.zc(41,M,3,0,"td",14),s.Pb(),s.zc(42,y,1,0,"tr",18),s.zc(43,k,1,0,"tr",19),s.zc(44,P,3,1,"tr",20),s.Rb(),s.zc(45,N,3,0,"tr",21),s.zc(46,_,6,1,"tr",21),s.Nb(47,"mat-paginator",22,23)),2&e&&(s.Bb(11),s.Cc(" \xa0 ",s.gc(12,10,t.nowDate,"medium")," "),s.Bb(6),s.Cc(" \xa0 ",s.fc(18,13,t.username)," "),s.Bb(12),s.kc("dataSource",t.dataSource),s.Bb(13),s.kc("matHeaderRowDef",t.displayedColumns),s.Bb(1),s.kc("matRowDefColumns",t.displayedColumns),s.Bb(2),s.kc("ngIf",t.isLoading),s.Bb(1),s.kc("ngIf",t.isError),s.Bb(1),s.kc("length",t.reportData.length)("pageSize",5)("pageSizeOptions",s.lc(15,E)))},directives:[p.b,p.e,m.b,c.k,c.c,c.e,c.b,c.g,c.j,c.h,o.m,l.a,c.d,c.a,c.f,c.i],pipes:[o.f,o.s],styles:[".table[_ngcontent-%COMP%]{margin-top:13px}.page-header[_ngcontent-%COMP%]{display:flex;justify-content:space-between;margin-top:0;margin-bottom:10px}.table_action_btn[_ngcontent-%COMP%]{display:flex;align-items:center}.table_action_btn[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]{border:none;margin:0 5px;padding:5px;height:unset;color:#ececec;font-weight:700;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:14px}.table_action_btn[_ngcontent-%COMP%]   button.download[_ngcontent-%COMP%]{background-color:#d2d904}.table_action_btn[_ngcontent-%COMP%]   button.view[_ngcontent-%COMP%]{background-color:#4fbfa7}.username-col[_ngcontent-%COMP%]{text-align:right;display:flex}.username[_ngcontent-%COMP%]{font-size:16px;font-weight:700;color:#333}.edits[_ngcontent-%COMP%]{display:flex;justify-content:center;align-items:center;width:54px;height:32px;background-color:#fff;border:1px solid var(--primary-color);border-radius:5px}.edits[_ngcontent-%COMP%]:hover{background-color:var(--primary-color);color:#fff}back[_ngcontent-%COMP%]{background-color:#fff}.mat-column-x[_ngcontent-%COMP%]{padding:0!important;width:35px!important}"]}),I),pathMatch:"full"},{path:"edit/100/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"CNfu")).then((function(e){return e.Sheet100Module}))}},{path:"edit/250/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"lEgX")).then((function(e){return e.Sheet250Module}))}},{path:"edit/300/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"SlVR")).then((function(e){return e.Sheet300Module}))}},{path:"edit/302/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"fvLe")).then((function(e){return e.Sheet302Module}))}},{path:"edit/423/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"EDDw")).then((function(e){return e.Sheet423Module}))}},{path:"edit/453/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"DKN4")).then((function(e){return e.Sheet453Module}))}},{path:"edit/533/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(7)]).then(i.bind(null,"4VIA")).then((function(e){return e.Sheet533Module}))}},{path:"edit/600/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(8)]).then(i.bind(null,"5uIM")).then((function(e){return e.Sheet600Module}))}},{path:"edit/700/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(9)]).then(i.bind(null,"XDCG")).then((function(e){return e.Sheet700Module}))}},{path:"edit/700/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(5)]).then(i.bind(null,"+i7u")).then((function(e){return e.Qdfir700Module}))}},{path:"edit/800/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(10)]).then(i.bind(null,"0MnM")).then((function(e){return e.Sheet800Module}))}},{path:"edit/1000/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(1)]).then(i.bind(null,"W7T7")).then((function(e){return e.Sheet1000Module}))}},{path:"edit/1200/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(6)]).then(i.bind(null,"IK9+")).then((function(e){return e.Sheet1200Module}))}},{path:"edit/321/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(4)]).then(i.bind(null,"l5XD")).then((function(e){return e.Sheet321Module}))}},{path:"edit/mstdr2/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(11)]).then(i.bind(null,"PQ1j")).then((function(e){return e.Sheetmstdr2Module}))}},{path:"edit/:sheetName",loadChildren:function(){return Promise.all([i.e(0),i.e(11),i.e(4),i.e(8),i.e(10),i.e(6),i.e(7),i.e(5),i.e(9),i.e(1),i.e(19)]).then(i.bind(null,"CPkj")).then((function(e){return e.GenerateReportEditModule}))}}],x=((A=function t(){e(this,t)}).\u0275mod=s.Kb({type:A}),A.\u0275inj=s.Jb({factory:function(e){return new(e||A)},imports:[[a.e.forChild(z)],a.e]}),A),L=i("d3UM"),B=i("Qu3c"),F=i("q7Ft"),Q=((O=function t(){e(this,t)}).\u0275mod=s.Kb({type:O}),O.\u0275inj=s.Jb({factory:function(e){return new(e||O)},imports:[[o.c,x,l.b,L.b,c.m,B.b,F.a,p.d,m.c,d.h,d.r]]}),O)}}])}();
(window.webpackJsonp=window.webpackJsonp||[]).push([[20],{GE1z:function(e,t,r){"use strict";r.r(t),r.d(t,"GenerateReportDataModule",(function(){return E}));var i=r("ofXK"),n=r("tyNb"),a=r("OaSA"),o=r("M9IT"),s=r("AytR"),l=r("fXoL"),c=r("a8X4"),b=r("KwcT"),h=r("3Pt+"),d=r("tk/3"),u=r("kmnG"),p=r("e6WT");function m(e,t){1&e&&(l.Sb(0,"th",24),l.Sb(1,"b"),l.Ac(2," S/N "),l.Rb(),l.Rb())}function f(e,t){if(1&e&&(l.Sb(0,"td",25),l.Ac(1),l.Rb()),2&e){const e=t.$implicit;l.Bb(1),l.Cc(" ",e.serial_number," ")}}function S(e,t){1&e&&(l.Sb(0,"th",24),l.Sb(1,"b"),l.Ac(2," Report Code "),l.Rb(),l.Rb())}function g(e,t){if(1&e&&(l.Sb(0,"td",25),l.Ac(1),l.Rb()),2&e){const e=t.$implicit;l.Bb(1),l.Cc(" ",e.return_code," ")}}function R(e,t){1&e&&(l.Sb(0,"th",24),l.Sb(1,"b"),l.Ac(2,"Report Description "),l.Rb(),l.Rb())}function D(e,t){if(1&e&&(l.Sb(0,"td",25),l.Ac(1),l.Rb()),2&e){const e=t.$implicit;l.Bb(1),l.Cc(" ",e.return_name," ")}}function C(e,t){1&e&&(l.Sb(0,"th",24),l.Sb(1,"b"),l.Ac(2,"Action"),l.Rb(),l.Rb())}function M(e,t){if(1&e){const e=l.Tb();l.Sb(0,"td",25),l.Sb(1,"button",26),l.Zb("click",(function(){l.pc(e);const r=t.$implicit;return l.dc().edit(r.sheet_number)})),l.Ac(2,"View"),l.Rb(),l.Rb()}}function w(e,t){1&e&&l.Nb(0,"tr",27)}function P(e,t){1&e&&l.Nb(0,"tr",28)}function v(e,t){if(1&e&&(l.Sb(0,"tr",29),l.Sb(1,"td",30),l.Ac(2),l.Rb(),l.Rb()),2&e){l.dc();const e=l.nc(28);l.Bb(2),l.Cc('No data matching the filter "',e.value,'"')}}function N(e,t){1&e&&(l.Sb(0,"tr"),l.Sb(1,"td",31),l.Ac(2,"LOADING..."),l.Rb(),l.Rb())}function y(e,t){if(1&e){const e=l.Tb();l.Sb(0,"tr"),l.Sb(1,"td",31),l.Sb(2,"p"),l.Ac(3),l.Rb(),l.Sb(4,"button",32),l.Zb("click",(function(){return l.pc(e),l.dc().loadData()})),l.Ac(5,"Retry"),l.Rb(),l.Rb(),l.Rb()}if(2&e){const e=l.dc();l.Bb(3),l.Bc(e.errorMessage)}}const _=function(){return[5,10,25,100]},I=[{path:"",component:(()=>{class e{constructor(e,t,r,i,n,a,o){this.router=e,this.route=t,this.reportService=r,this.authService=i,this.location=n,this.fb=a,this.http=o,this.tableData=[],this.displayedColumns=["serialNumber","sheetNumber","returnCode","returnName"],this.SPECIAL_SHEETS=["100","qdfir100","250","300","302","423","453","533","600","700","800","1000","1200","mstdr2"],this.isLoading=!0,this.isError=!1,this.reportName=null,this.byGroupIsLoading=!0,this.byGroupIsError=!1,this.byGroupReportName=null,this.first=0,this.rows=10,this.errorMessage="An Error occurred",console.log("Inside report data"+this.reportData)}ngAfterViewInit(){this.dataSource.paginator=this.paginator}ngOnInit(){this.reportSubscription=this.reportService.reportData.subscribe(e=>{this.reportData=e}),this.route.paramMap.subscribe(e=>{e.has("report")&&(this.reportName=e.get("report"),this.loadData())}),this.timeIntervalId=setInterval(()=>{this.nowDate=new Date},1e3),this.$user=this.authService.user.subscribe(e=>{this.username=e.username}),this.$selectedDate=this.reportService.selectedDate.subscribe(e=>{this.reportSelectedDate=e})}edit(e){const t=e.match(/\d/g).join(""),r=["edit"];this.SPECIAL_SHEETS.includes(e)?(r.push(e=t),console.log(e)):r.push(e),this.router.navigate(r,{relativeTo:this.route})}goBack(){this.location.back()}loadData(){this.isError=!1,this.isLoading=!0,this.reportRequestSubscription=this.reportService.getReports(this.reportName).subscribe(()=>{this.isLoading=!1,this.tableData=this.reportService.tableData,this.tableData[0].serial_number=0;for(let e=0;e<this.tableData.length;e++)this.tableData[e].serial_number=1+e;console.log(this.tableData),this.dataSource=new a.l(this.reportData)},e=>{this.isLoading=!1,this.isError=!0,this.errorMessage=404===e.status?"No record found":"An Error occurred"})}ngOnDestroy(){clearInterval(this.timeIntervalId),this.$selectedDate&&this.$selectedDate.unsubscribe(),this.$user&&this.$user.unsubscribe(),this.reportRequestSubscription&&this.reportRequestSubscription.unsubscribe(),this.reportSubscription&&this.reportSubscription.unsubscribe()}applyFilter(e){this.dataSource.filter=e.target.value.trim().toLowerCase()}next(){this.first=this.first+this.rows}prev(){this.first=this.first-this.rows}reset(){this.first=0}isLastPage(){return!this.tableData||this.first===this.tableData.length-this.rows}isFirstPage(){return!this.tableData||0===this.first}downloadXmlReports(){let e=[];this.tableData.forEach(t=>{e.push(t.return_code)});let t=s.a.baseUrl+"/download/";e.filter(e=>!e.startsWith("QDFIR400")).filter(e=>!e.startsWith("QDFIR450")).filter(e=>!e.startsWith("MDFIR450")).filter(e=>!e.startsWith("MDFIR400")).forEach(e=>{console.log(e),t+=e,t+=","}),console.log(t),"Q"===this.reportService.getReportGroup()&&(t+="QDFIR400",t+=", QDFIR450"),"M"===this.reportService.getReportGroup()&&(t+="MDFIR400",t+=",MDFIR450"),console.log(t),this.download(t).subscribe(e=>{const t=document.createElement("a"),r=URL.createObjectURL(e);t.href=r,t.download="Reports downloaded for "+this.reportSelectedDate+".zip",t.click(),URL.revokeObjectURL(r)})}download(e){return this.http.get(e,{responseType:"blob"})}}return e.\u0275fac=function(t){return new(t||e)(l.Mb(n.b),l.Mb(n.a),l.Mb(c.a),l.Mb(b.a),l.Mb(i.i),l.Mb(h.c),l.Mb(d.c))},e.\u0275cmp=l.Gb({type:e,selectors:[["app-assets-and-liability-data"]],viewQuery:function(e,t){var r;1&e&&l.Dc(o.a,!0),2&e&&l.mc(r=l.ac())&&(t.paginator=r.first)},decls:49,vars:16,consts:[[1,"page-header"],[1,"row"],[1,"user"],[1,"input-icon"],[2,"color","var(--primary-color)"],[1,""],[1,"nav","justify-content-end"],[1,"nav-item","me-2"],["mat-flat-button","",1,"btn_common",3,"click"],["matInput","","placeholder","Enter MDFIR300 OR QDFIR300",3,"keyup"],["input",""],["mat-table","",1,"table",3,"dataSource"],["matColumnDef","serialNumber"],["mat-header-cell","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["matColumnDef","sheetNumber"],["matColumnDef","returnCode"],["matColumnDef","returnName"],["mat-header-row","",4,"matHeaderRowDef"],["mat-row","",4,"matRowDef","matRowDefColumns"],["class","mat-row",4,"matNoDataRow"],[4,"ngIf"],[3,"length","pageSize","pageSizeOptions"],["myPaginator",""],["mat-header-cell",""],["mat-cell",""],[1,"edits",3,"click"],["mat-header-row",""],["mat-row",""],[1,"mat-row"],["colspan","4",1,"mat-cell"],["colspan","4",2,"text-align","center"],[1,"btn_common","view",3,"click"]],template:function(e,t){1&e&&(l.Nb(0,"br"),l.Sb(1,"div",0),l.Sb(2,"h1"),l.Ac(3," Generate Report "),l.Sb(4,"small"),l.Ac(5,"list & edit "),l.Rb(),l.Rb(),l.Sb(6,"div",1),l.Sb(7,"div",2),l.Sb(8,"span",3),l.Sb(9,"label",4),l.Ac(10,"Current Date: "),l.Rb(),l.Ac(11),l.ec(12,"date"),l.Rb(),l.Rb(),l.Rb(),l.Sb(13,"div",2),l.Sb(14,"span",3),l.Sb(15,"label",4),l.Ac(16,"User: "),l.Rb(),l.Ac(17),l.ec(18,"titlecase"),l.Rb(),l.Rb(),l.Rb(),l.Sb(19,"div",5),l.Sb(20,"ul",6),l.Sb(21,"li",7),l.Sb(22,"button",8),l.Zb("click",(function(){return t.downloadXmlReports()})),l.Ac(23,"Download"),l.Rb(),l.Rb(),l.Rb(),l.Rb(),l.Sb(24,"mat-form-field"),l.Sb(25,"mat-label"),l.Ac(26,"Filter"),l.Rb(),l.Sb(27,"input",9,10),l.Zb("keyup",(function(e){return t.applyFilter(e)})),l.Rb(),l.Rb(),l.Sb(29,"table",11),l.Qb(30,12),l.zc(31,m,3,0,"th",13),l.zc(32,f,2,1,"td",14),l.Pb(),l.Qb(33,15),l.zc(34,S,3,0,"th",13),l.zc(35,g,2,1,"td",14),l.Pb(),l.Qb(36,16),l.zc(37,R,3,0,"th",13),l.zc(38,D,2,1,"td",14),l.Pb(),l.Qb(39,17),l.zc(40,C,3,0,"th",13),l.zc(41,M,3,0,"td",14),l.Pb(),l.zc(42,w,1,0,"tr",18),l.zc(43,P,1,0,"tr",19),l.zc(44,v,3,1,"tr",20),l.Rb(),l.zc(45,N,3,0,"tr",21),l.zc(46,y,6,1,"tr",21),l.Nb(47,"mat-paginator",22,23)),2&e&&(l.Bb(11),l.Cc(" \xa0 ",l.gc(12,10,t.nowDate,"medium")," "),l.Bb(6),l.Cc(" \xa0 ",l.fc(18,13,t.username)," "),l.Bb(12),l.kc("dataSource",t.dataSource),l.Bb(13),l.kc("matHeaderRowDef",t.displayedColumns),l.Bb(1),l.kc("matRowDefColumns",t.displayedColumns),l.Bb(2),l.kc("ngIf",t.isLoading),l.Bb(1),l.kc("ngIf",t.isError),l.Bb(1),l.kc("length",t.reportData.length)("pageSize",5)("pageSizeOptions",l.lc(15,_)))},directives:[u.b,u.e,p.b,a.k,a.c,a.e,a.b,a.g,a.j,a.h,i.m,o.a,a.d,a.a,a.f,a.i],pipes:[i.f,i.s],styles:[".table[_ngcontent-%COMP%]{margin-top:13px}.page-header[_ngcontent-%COMP%]{display:flex;justify-content:space-between;margin-top:0;margin-bottom:10px}.table_action_btn[_ngcontent-%COMP%]{display:flex;align-items:center}.table_action_btn[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]{border:none;margin:0 5px;padding:5px;height:unset;color:#ececec;font-weight:700;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:14px}.table_action_btn[_ngcontent-%COMP%]   button.download[_ngcontent-%COMP%]{background-color:#d2d904}.table_action_btn[_ngcontent-%COMP%]   button.view[_ngcontent-%COMP%]{background-color:#4fbfa7}.username-col[_ngcontent-%COMP%]{text-align:right;display:flex}.username[_ngcontent-%COMP%]{font-size:16px;font-weight:700;color:#333}.edits[_ngcontent-%COMP%]{display:flex;justify-content:center;align-items:center;width:54px;height:32px;background-color:#fff;border:1px solid var(--primary-color);border-radius:5px}.edits[_ngcontent-%COMP%]:hover{background-color:var(--primary-color);color:#fff}back[_ngcontent-%COMP%]{background-color:#fff}.mat-column-x[_ngcontent-%COMP%]{padding:0!important;width:35px!important}"]}),e})(),pathMatch:"full"},{path:"edit/100/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"CNfu")).then(e=>e.Sheet100Module)},{path:"edit/250/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"lEgX")).then(e=>e.Sheet250Module)},{path:"edit/300/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"SlVR")).then(e=>e.Sheet300Module)},{path:"edit/302/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"fvLe")).then(e=>e.Sheet302Module)},{path:"edit/423/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"EDDw")).then(e=>e.Sheet423Module)},{path:"edit/453/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"DKN4")).then(e=>e.Sheet453Module)},{path:"edit/533/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(7)]).then(r.bind(null,"4VIA")).then(e=>e.Sheet533Module)},{path:"edit/600/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(8)]).then(r.bind(null,"5uIM")).then(e=>e.Sheet600Module)},{path:"edit/700/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(9)]).then(r.bind(null,"XDCG")).then(e=>e.Sheet700Module)},{path:"edit/700/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(5)]).then(r.bind(null,"+i7u")).then(e=>e.Qdfir700Module)},{path:"edit/800/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(10)]).then(r.bind(null,"0MnM")).then(e=>e.Sheet800Module)},{path:"edit/1000/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(1)]).then(r.bind(null,"W7T7")).then(e=>e.Sheet1000Module)},{path:"edit/1200/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(6)]).then(r.bind(null,"IK9+")).then(e=>e.Sheet1200Module)},{path:"edit/321/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(4)]).then(r.bind(null,"l5XD")).then(e=>e.Sheet321Module)},{path:"edit/mstdr2/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(11)]).then(r.bind(null,"PQ1j")).then(e=>e.Sheetmstdr2Module)},{path:"edit/:sheetName",loadChildren:()=>Promise.all([r.e(0),r.e(11),r.e(4),r.e(8),r.e(10),r.e(6),r.e(7),r.e(5),r.e(9),r.e(1),r.e(19)]).then(r.bind(null,"CPkj")).then(e=>e.GenerateReportEditModule)}];let A=(()=>{class e{}return e.\u0275mod=l.Kb({type:e}),e.\u0275inj=l.Jb({factory:function(t){return new(t||e)},imports:[[n.e.forChild(I)],n.e]}),e})();var k=r("d3UM"),O=r("Qu3c"),z=r("q7Ft");let E=(()=>{class e{}return e.\u0275mod=l.Kb({type:e}),e.\u0275inj=l.Jb({factory:function(t){return new(t||e)},imports:[[i.c,A,o.b,k.b,a.m,O.b,z.a,u.d,p.c,h.h,h.r]]}),e})()}}]);
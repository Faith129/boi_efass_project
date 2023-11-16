(window.webpackJsonp=window.webpackJsonp||[]).push([[4],{TNCL:function(t,e,a){"use strict";a.d(e,"a",(function(){return Y}));var i=a("3Pt+"),o=a("iELJ"),r=a("fXoL"),c=a("AytR"),n=a("tk/3"),s=a("a8X4");let b=(()=>{class t{constructor(t,e){this.http=t,this.reportService=e,this.sheetName="mdfir321/",this.reportService.selectedDate.subscribe(t=>{this.reportSelectedDate=t})}postMDFIR321Data(t){return this.http.post(c.a.baseApi+"/"+this.sheetName+this.reportSelectedDate,t)}getMDFIR321Data(){return this.http.get(c.a.baseApi+"/"+this.sheetName+this.reportSelectedDate)}putMDFIR321Data(t,e){return console.log(t),this.http.put(c.a.baseApi+"/"+this.sheetName+this.reportSelectedDate+"/"+t,e)}deleteMDFIR321Data(t){return this.http.delete(c.a.baseApi+"/"+this.sheetName+this.reportSelectedDate+"/"+t)}}return t.\u0275fac=function(e){return new(e||t)(r.Wb(n.c),r.Wb(s.a))},t.\u0275prov=r.Ib({token:t,factory:t.\u0275fac,providedIn:"root"}),t})();var l=a("k9XE"),m=a("kmnG"),u=a("e6WT"),d=a("TN/R"),f=a("bTqV");let p=(()=>{class t{constructor(t,e,a,i,o){this.formBuilder=t,this.sheet321Service=e,this.notifierService=a,this.editData=i,this.MatDialogRef=o,this.actionsBtn="Save"}ngOnInit(){this.mdfir321Form=this.formBuilder.group({bankName:["",i.u.required],bankCode:["",i.u.required],typeOfPlacements:["",i.u.required],accountNumber:["",i.u.required],amount:["",i.u.required],amount2:["",i.u.required],effectiveDate:["",i.u.required],maturityDate:["",i.u.required],interestRate:["",i.u.required],upfrontInterestReceived:["",i.u.required],accruedInterestReceivable:["",i.u.required],remarks:["",i.u.required]}),this.editData&&(this.actionsBtn="Update",this.mdfir321Form.controls.bankName.setValue(this.editData.bankName),this.mdfir321Form.controls.bankCode.setValue(this.editData.bankCode),this.mdfir321Form.controls.typeOfPlacements.setValue(this.editData.typeOfPlacements),this.mdfir321Form.controls.accountNumber.setValue(this.editData.accountNumber),this.mdfir321Form.controls.amount.setValue(this.editData.amount),this.mdfir321Form.controls.amount2.setValue(this.editData.amount2),this.mdfir321Form.controls.effectiveDate.setValue(this.editData.effectiveDate),this.mdfir321Form.controls.maturityDate.setValue(this.editData.maturityDate),this.mdfir321Form.controls.interestRate.setValue(this.editData.interestRate),this.mdfir321Form.controls.upfrontInterestReceived.setValue(this.editData.upfrontInterestReceived),this.mdfir321Form.controls.accruedInterestReceivable.setValue(this.editData.accruedInterestReceivable),this.mdfir321Form.controls.remarks.setValue(this.editData.remarks))}ngOnDestroy(){}addDetails(){this.editData?this.putDetails():this.mdfir321Form.valid&&this.sheet321Service.postMDFIR321Data(this.mdfir321Form.value).subscribe({next:t=>{alert("Mdfir321 added"),this.mdfir321Form.reset(),this.MatDialogRef.close("save")},error:()=>{alert("MDFIRprobws")}}),console.log(this.mdfir321Form.value)}putDetails(){this.sheet321Service.putMDFIR321Data(this.editData.id,this.mdfir321Form.value).subscribe({next:t=>{this.notifierService.showNotification("MDFIR321 updated successfully","ok","success"),this.mdfir321Form.reset(),this.MatDialogRef.close("update")},error:()=>{this.notifierService.showNotification("Error updating Row","OK","error")}})}}return t.\u0275fac=function(e){return new(e||t)(r.Mb(i.c),r.Mb(b),r.Mb(l.a),r.Mb(o.a),r.Mb(o.g))},t.\u0275cmp=r.Gb({type:t,selectors:[["app-dialog"]],decls:63,vars:7,consts:[["mat-dialog-title",""],["mat-dialog-content",""],[3,"formGroup"],["appearance","outline"],["matInput","","type","text","formControlName","bankName"],["matInput","","type","text","formControlName","bankCode"],["matInput","","type","text","formControlName","typeOfPlacements"],["matInput","","type","text","formControlName","accountNumber"],["matInput","","type","number","formControlName","amount"],["matInput","","type","number","formControlName","amount2"],["matInput","","formControlName","effectiveDate",3,"matDatepicker"],["matSuffix","",3,"for"],["picker1",""],["matInput","","formControlName","maturityDate",3,"matDatepicker"],["picker2",""],["matInput","","type","number","formControlName","interestRate"],["matInput","","type","number","formControlName","upfrontInterestReceived"],["matInput","","type","number","formControlName","accruedInterestReceivable"],["matInput","","type","test","formControlName","remarks"],["mat-dialog-actions",""],["mat-raised-button","","color","warn","mat-dialog-close",""],["mat-raised-button","","cdkFocusInitial","",1,"save_btn",3,"disabled","click"]],template:function(t,e){if(1&t&&(r.Sb(0,"h1",0),r.Ac(1,"Report MDFIR321 Form"),r.Rb(),r.Sb(2,"div",1),r.Sb(3,"form",2),r.Sb(4,"mat-form-field",3),r.Sb(5,"mat-label"),r.Ac(6,"Bank Name"),r.Rb(),r.Nb(7,"input",4),r.Rb(),r.Sb(8,"mat-form-field",3),r.Sb(9,"mat-label"),r.Ac(10,"Bank Code"),r.Rb(),r.Nb(11,"input",5),r.Rb(),r.Sb(12,"mat-form-field",3),r.Sb(13,"mat-label"),r.Ac(14,"Type of Placement"),r.Rb(),r.Nb(15,"input",6),r.Rb(),r.Sb(16,"mat-form-field",3),r.Sb(17,"mat-label"),r.Ac(18,"Account Number"),r.Rb(),r.Nb(19,"input",7),r.Rb(),r.Sb(20,"mat-form-field",3),r.Sb(21,"mat-label"),r.Ac(22,"Amount"),r.Rb(),r.Nb(23,"input",8),r.Rb(),r.Sb(24,"mat-form-field",3),r.Sb(25,"mat-label"),r.Ac(26,"Amount 2"),r.Rb(),r.Nb(27,"input",9),r.Rb(),r.Sb(28,"mat-form-field",3),r.Sb(29,"mat-label"),r.Ac(30,"Effective Date"),r.Rb(),r.Nb(31,"input",10),r.Nb(32,"mat-datepicker-toggle",11),r.Nb(33,"mat-datepicker",null,12),r.Rb(),r.Sb(35,"mat-form-field",3),r.Sb(36,"mat-label"),r.Ac(37,"Maturity Date"),r.Rb(),r.Nb(38,"input",13),r.Nb(39,"mat-datepicker-toggle",11),r.Nb(40,"mat-datepicker",null,14),r.Rb(),r.Sb(42,"mat-form-field",3),r.Sb(43,"mat-label"),r.Ac(44,"Interest Rate"),r.Rb(),r.Nb(45,"input",15),r.Rb(),r.Sb(46,"mat-form-field",3),r.Sb(47,"mat-label"),r.Ac(48,"Upfront Interest Received"),r.Rb(),r.Nb(49,"input",16),r.Rb(),r.Sb(50,"mat-form-field",3),r.Sb(51,"mat-label"),r.Ac(52,"Accrued Interest Receivable"),r.Rb(),r.Nb(53,"input",17),r.Rb(),r.Sb(54,"mat-form-field",3),r.Sb(55,"mat-label"),r.Ac(56,"Remarks"),r.Rb(),r.Nb(57,"input",18),r.Rb(),r.Rb(),r.Rb(),r.Sb(58,"div",19),r.Sb(59,"button",20),r.Ac(60,"Close"),r.Rb(),r.Sb(61,"button",21),r.Zb("click",(function(){return e.addDetails()})),r.Ac(62),r.Rb(),r.Rb()),2&t){const t=r.nc(34),a=r.nc(41);r.Bb(3),r.kc("formGroup",e.mdfir321Form),r.Bb(28),r.kc("matDatepicker",t),r.Bb(1),r.kc("for",t),r.Bb(6),r.kc("matDatepicker",a),r.Bb(1),r.kc("for",a),r.Bb(22),r.kc("disabled",!e.mdfir321Form.valid),r.Bb(1),r.Bc(e.actionsBtn)}},directives:[o.h,o.e,i.w,i.m,i.g,m.b,m.e,u.b,i.b,i.l,i.e,i.q,d.b,d.d,m.f,d.a,o.c,f.a,o.d],styles:[".example-form-field[_ngcontent-%COMP%]{width:200px}"]}),t})();var h=a("M9IT"),R=a("LUZP"),S=a("OaSA");let D=(()=>{class t{constructor(t,e){this.data=t,this.dialogRef=e}ngOnInit(){}deleteConfirmed(){this.dialogRef.close("delete")}}return t.\u0275fac=function(e){return new(e||t)(r.Mb(o.a),r.Mb(o.g))},t.\u0275cmp=r.Gb({type:t,selectors:[["app-confirmation-dialog"]],decls:8,vars:0,consts:[["mat-dialog-content",""],["mat-dialog-actions",""],["mat-button","","mat-raised-button","","mat-dialog-close","","cdkFocusInitial","",1,"row_btn"],["mat-button","","mat-raised-button","","color","warn",3,"mat-dialog-close","click"]],template:function(t,e){1&t&&(r.Sb(0,"div",0),r.Sb(1,"h2"),r.Ac(2,"Are you sure you want to delete?"),r.Rb(),r.Rb(),r.Sb(3,"div",1),r.Sb(4,"button",2),r.Ac(5,"No"),r.Rb(),r.Sb(6,"button",3),r.Zb("click",(function(){return e.deleteConfirmed()})),r.Ac(7,"Yes"),r.Rb(),r.Rb())},directives:[o.e,o.c,f.a,o.d],styles:[""]}),t})();var C=a("ofXK");function g(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," S/N "),r.Rb())}function N(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.index;r.dc();const a=r.nc(54);r.Bb(1),r.Cc(" ",t+1+a.pageIndex*a.pageSize,"")}}function A(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," BANK NAME "),r.Rb())}function v(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.bankName," ")}}function I(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," BANK CODE "),r.Rb())}function k(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.bankCode," ")}}function w(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," TYPE OF PLACEMENTS "),r.Rb())}function M(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.typeOfPlacements," ")}}function y(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," ACCOUNT NUMBER "),r.Rb())}function F(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.accountNumber," ")}}function P(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," AMOUNT "),r.Rb())}function z(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.ec(2,"currency"),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",r.hc(2,1,t.amount,"NGN","symbol")," ")}}function B(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," AMOUNT 2 "),r.Rb())}function O(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.ec(2,"currency"),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",r.hc(2,1,t.amount2,"NGN","symbol")," ")}}function E(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," TENOR "),r.Rb())}function T(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.tenor," ")}}function x(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," EFFECTIVE DATE "),r.Rb())}function V(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.ec(2,"date"),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",r.fc(2,1,t.effectiveDate)," ")}}function q(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," MATURITY DATE "),r.Rb())}function Q(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.ec(2,"date"),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",r.fc(2,1,t.maturityDate)," ")}}function U(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," INTEREST RATE "),r.Rb())}function $(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.interestRate," ")}}function _(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," UPFRONT INTEREST RECEIVED "),r.Rb())}function L(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.upfrontInterestReceived," ")}}function K(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," ACCRUED INTEREST RECEIVABLE "),r.Rb())}function G(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.Bb(1),r.Cc(" ",t.accruedInterestReceivable," ")}}function X(t,e){1&t&&(r.Sb(0,"th",27),r.Ac(1," REMARKS "),r.Rb())}function J(t,e){if(1&t&&(r.Sb(0,"td",28),r.Ac(1),r.Rb()),2&t){const t=e.$implicit;r.wc("color",t.color),r.Bb(1),r.Cc(" ",t.remarks," ")}}function Z(t,e){1&t&&r.Nb(0,"tr",29)}function W(t,e){1&t&&r.Nb(0,"tr",30)}function j(t,e){if(1&t&&(r.Sb(0,"tr",31),r.Sb(1,"td",32),r.Ac(2),r.Rb(),r.Rb()),2&t){r.dc();const t=r.nc(5);r.Bb(2),r.Cc('No data matching the filter "',t.value,'"')}}const H=function(){return[5,10,25,100]};let Y=(()=>{class t{constructor(t,e,a){this.dialog=t,this.sheet321Service=e,this.notifierService=a,this.displayedColumns=["id","bankName","bankCode","typeOfPlacements","accountNumber","amount","amount2","tenor","effectiveDate","maturityDate","interestRate","upfrontInterestReceived","accruedInterestReceivable","remarks"]}ngOnInit(){this.getAllMDFIR321Data()}openDialog(){this.dialog.open(p,{width:"30%"}).afterClosed().subscribe(t=>{"save"===t&&this.getAllMDFIR321Data()})}getAllMDFIR321Data(){this.sheet321Service.getMDFIR321Data().subscribe({next:t=>{console.log(t.sheet321),this.dataSource=new S.l(t.sheet321),this.dataSource.paginator=this.paginator,this.dataSource.sort=this.sort},error:()=>{console.log("Error while fetching data")}})}applyFilter(t){this.dataSource.filter=t.target.value.trim().toLowerCase(),this.dataSource.paginator&&this.dataSource.paginator.firstPage()}editReportRow(t){this.dialog.open(p,{width:"30%",data:t}).afterClosed().subscribe(t=>{"update"===t&&this.getAllMDFIR321Data()})}deleteReportRow(t){this.sheet321Service.deleteMDFIR321Data(t).subscribe({next:t=>{this.notifierService.showNotification("Deleted successfully","OK","success"),this.getAllMDFIR321Data()},error:t=>{this.notifierService.showNotification("Unable to delete","OK","error")}})}openConfirmationDialog(t){this.dialog.open(D,{width:"17%",data:!0}).afterClosed().subscribe(e=>{"delete"===e&&(this.deleteReportRow(t),this.getAllMDFIR321Data())})}}return t.\u0275fac=function(e){return new(e||t)(r.Mb(o.b),r.Mb(b),r.Mb(l.a))},t.\u0275cmp=r.Gb({type:t,selectors:[["app-sheet321"]],viewQuery:function(t,e){var a;1&t&&(r.Dc(h.a,!0),r.Dc(R.a,!0)),2&t&&(r.mc(a=r.ac())&&(e.paginator=a.first),r.mc(a=r.ac())&&(e.sort=a.first))},decls:55,vars:7,consts:[[1,"container"],["matInput","","placeholder","Ex. Mia",3,"keyup"],["input",""],[1,"overflow"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","id"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["matColumnDef","bankName"],["matColumnDef","bankCode"],["matColumnDef","typeOfPlacements"],["matColumnDef","accountNumber"],["matColumnDef","amount"],["matColumnDef","amount2"],["matColumnDef","tenor"],["matColumnDef","effectiveDate"],["matColumnDef","maturityDate"],["matColumnDef","interestRate"],["matColumnDef","upfrontInterestReceived"],["matColumnDef","accruedInterestReceivable"],["matColumnDef","remarks"],["mat-cell","",3,"color",4,"matCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["mat-row","",4,"matRowDef","matRowDefColumns"],["class","mat-row",4,"matNoDataRow"],[3,"length","pageSize","pageSizeOptions"],["myPaginator",""],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-row",""],["mat-row",""],[1,"mat-row"],["colspan","4",1,"mat-cell"]],template:function(t,e){1&t&&(r.Sb(0,"div",0),r.Sb(1,"mat-form-field"),r.Sb(2,"mat-label"),r.Ac(3,"Filter"),r.Rb(),r.Sb(4,"input",1,2),r.Zb("keyup",(function(t){return e.applyFilter(t)})),r.Rb(),r.Rb(),r.Sb(6,"div",3),r.Sb(7,"table",4),r.Qb(8,5),r.zc(9,g,2,0,"th",6),r.zc(10,N,2,1,"td",7),r.Pb(),r.Qb(11,8),r.zc(12,A,2,0,"th",6),r.zc(13,v,2,1,"td",7),r.Pb(),r.Qb(14,9),r.zc(15,I,2,0,"th",6),r.zc(16,k,2,1,"td",7),r.Pb(),r.Qb(17,10),r.zc(18,w,2,0,"th",6),r.zc(19,M,2,1,"td",7),r.Pb(),r.Qb(20,11),r.zc(21,y,2,0,"th",6),r.zc(22,F,2,1,"td",7),r.Pb(),r.Qb(23,12),r.zc(24,P,2,0,"th",6),r.zc(25,z,3,5,"td",7),r.Pb(),r.Qb(26,13),r.zc(27,B,2,0,"th",6),r.zc(28,O,3,5,"td",7),r.Pb(),r.Qb(29,14),r.zc(30,E,2,0,"th",6),r.zc(31,T,2,1,"td",7),r.Pb(),r.Qb(32,15),r.zc(33,x,2,0,"th",6),r.zc(34,V,3,3,"td",7),r.Pb(),r.Qb(35,16),r.zc(36,q,2,0,"th",6),r.zc(37,Q,3,3,"td",7),r.Pb(),r.Qb(38,17),r.zc(39,U,2,0,"th",6),r.zc(40,$,2,1,"td",7),r.Pb(),r.Qb(41,18),r.zc(42,_,2,0,"th",6),r.zc(43,L,2,1,"td",7),r.Pb(),r.Qb(44,19),r.zc(45,K,2,0,"th",6),r.zc(46,G,2,1,"td",7),r.Pb(),r.Qb(47,20),r.zc(48,X,2,0,"th",6),r.zc(49,J,2,3,"td",21),r.Pb(),r.zc(50,Z,1,0,"tr",22),r.zc(51,W,1,0,"tr",23),r.zc(52,j,3,1,"tr",24),r.Rb(),r.Rb(),r.Nb(53,"mat-paginator",25,26),r.Rb()),2&t&&(r.Bb(7),r.kc("dataSource",e.dataSource),r.Bb(43),r.kc("matHeaderRowDef",e.displayedColumns),r.Bb(1),r.kc("matRowDefColumns",e.displayedColumns),r.Bb(2),r.kc("length",25)("pageSize",5)("pageSizeOptions",r.lc(6,H)))},directives:[m.b,m.e,u.b,S.k,R.a,S.c,S.e,S.b,S.g,S.j,S.h,h.a,S.d,R.b,S.a,S.f,S.i],pipes:[C.d,C.f],styles:["table[_ngcontent-%COMP%]{width:100%;border:1px solid #ddd}.mat-form-field[_ngcontent-%COMP%]{font-size:14px;width:100%}td[_ngcontent-%COMP%], th[_ngcontent-%COMP%]{text-align:left;padding:0 28px}th[_ngcontent-%COMP%]{border-bottom:1px solid #000}tr[_ngcontent-%COMP%]:nth-child(odd){background-color:#f2f2f2}.mat-header-cell[_ngcontent-%COMP%]{font-weight:700;color:#000;font-size:15px}.container[_ngcontent-%COMP%]{max-width:3000px;margin:0 auto;z-index:-1}.overflow[_ngcontent-%COMP%]{overflow-x:auto;white-space:nowrap}.mat-column-id[_ngcontent-%COMP%]{padding:0;width:10px}"]}),t})()},l5XD:function(t,e,a){"use strict";a.r(e),a.d(e,"Sheet321Module",(function(){return A}));var i=a("ofXK"),o=a("TNCL"),r=a("d3UM"),c=a("OaSA"),n=a("M9IT"),s=a("Qu3c"),b=a("q7Ft"),l=a("iELJ"),m=a("bTqV"),u=a("tyNb"),d=a("maxO"),f=a("Tj54"),p=a("e6WT"),h=a("TN/R"),R=a("FKr1"),S=a("3Pt+"),D=a("tk/3"),C=a("LUZP"),g=a("fXoL");const N=[{path:"",component:o.a,pathMatch:"full"}];let A=(()=>{class t{}return t.\u0275mod=g.Kb({type:t}),t.\u0275inj=g.Jb({factory:function(e){return new(e||t)},imports:[[i.c,u.e.forChild(N),d.a,r.b,c.m,n.b,s.b,b.a,l.f,m.b,f.b,p.c,p.c,h.c,R.k,S.h,S.r,D.d,C.c]]}),t})()}}]);
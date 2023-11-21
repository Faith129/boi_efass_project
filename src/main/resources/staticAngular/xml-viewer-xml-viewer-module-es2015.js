(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["xml-viewer-xml-viewer-module"],{

/***/ "d4hY":
/*!**********************************************************!*\
  !*** ./src/app/pages/xml-viewer/xml-viewer.component.ts ***!
  \**********************************************************/
/*! exports provided: XmlViewerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "XmlViewerComponent", function() { return XmlViewerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/environments/environment */ "AytR");
/* harmony import */ var _xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./xml-viewer.service */ "DRSI");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ngx-doc-viewer */ "w4ga");







function XmlViewerComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "ngx-doc-viewer", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("url", ctx_r0.selectedDoc)("viewerUrl", ctx_r0.selectedViewer.viewerUrl)("viewer", ctx_r0.selectedViewer.name);
} }
const getbaseUrl = () => {
    const pathArray = window.location.href.split('/');
    const protocol = pathArray[0];
    const host = pathArray[2];
    return protocol + '//' + host;
};
class XmlViewerComponent {
    constructor(xmlService, route, location) {
        this.xmlService = xmlService;
        this.route = route;
        this.location = location;
        this.viewer = {
            name: 'office',
            // 'https://file-examples-com.github.io/uploads/2017/02/file_example_XLSX_50.xlsx'
            doc: '',
            custom: true,
            acceptedUploadTypes: null,
        };
        this.selectedViewer = null;
        this.selectedDoc = null;
    }
    ngOnInit() {
        this.route.paramMap.subscribe((param) => {
            if (param.has('id')) {
                const id = +param.get('id');
                this.xmlService.documentList.subscribe(lists => {
                    const data = lists.find((doc) => doc.id === id);
                    if (data) {
                        this.viewer.doc = src_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi + '/' + data.file_path;
                        this.viewer.doc = src_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi + `/download/excel/${id}`;
                        this.selectedViewer = this.viewer;
                        this.selectedDoc = this.selectedViewer.doc;
                    }
                    else {
                        this.location.back();
                    }
                });
            }
            else {
                // this.location.back();
            }
        });
    }
}
XmlViewerComponent.ɵfac = function XmlViewerComponent_Factory(t) { return new (t || XmlViewerComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__["XmlViewerService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"])); };
XmlViewerComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: XmlViewerComponent, selectors: [["app-xml-viewer"]], decls: 1, vars: 1, consts: [["style", "text-align:center", 4, "ngIf"], [2, "text-align", "center"], ["queryParams", "hl=Nl", 2, "width", "100%", "height", "80vh", 3, "url", "viewerUrl", "viewer"]], template: function XmlViewerComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, XmlViewerComponent_div_0_Template, 2, 3, "div", 0);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.selectedViewer && ctx.selectedDoc);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_5__["NgxDocViewerComponent"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhZ2VzL3htbC12aWV3ZXIveG1sLXZpZXdlci5jb21wb25lbnQuY3NzIn0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-xml-viewer',
                templateUrl: './xml-viewer.component.html',
                styleUrls: ['./xml-viewer.component.css'],
            }]
    }], function () { return [{ type: _xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__["XmlViewerService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"] }, { type: _angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"] }]; }, null); })();


/***/ }),

/***/ "oPuF":
/*!*******************************************************!*\
  !*** ./src/app/pages/xml-viewer/xml-viewer.module.ts ***!
  \*******************************************************/
/*! exports provided: XmlViewerModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "XmlViewerModule", function() { return XmlViewerModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-doc-viewer */ "w4ga");
/* harmony import */ var _xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./xml-viewer.component */ "d4hY");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "tyNb");







const routes = [
    {
        path: '', component: _xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]
    }
];
class XmlViewerModule {
}
XmlViewerModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: XmlViewerModule });
XmlViewerModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function XmlViewerModule_Factory(t) { return new (t || XmlViewerModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"].forChild(routes)
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](XmlViewerModule, { declarations: [_xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"],
                    _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"].forChild(routes)
                ]
            }]
    }], null, null); })();


/***/ })

}]);
//# sourceMappingURL=xml-viewer-xml-viewer-module-es2015.js.map
(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["xml-viewer-xml-viewer-module"], {
    /***/
    "d4hY":
    /*!**********************************************************!*\
      !*** ./src/app/pages/xml-viewer/xml-viewer.component.ts ***!
      \**********************************************************/

    /*! exports provided: XmlViewerComponent */

    /***/
    function d4hY(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "XmlViewerComponent", function () {
        return XmlViewerComponent;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var src_environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! src/environments/environment */
      "AytR");
      /* harmony import */


      var _xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./xml-viewer.service */
      "DRSI");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");
      /* harmony import */


      var ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! ngx-doc-viewer */
      "w4ga");

      function XmlViewerComponent_div_0_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "ngx-doc-viewer", 2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("url", ctx_r0.selectedDoc)("viewerUrl", ctx_r0.selectedViewer.viewerUrl)("viewer", ctx_r0.selectedViewer.name);
        }
      }

      var getbaseUrl = function getbaseUrl() {
        var pathArray = window.location.href.split('/');
        var protocol = pathArray[0];
        var host = pathArray[2];
        return protocol + '//' + host;
      };

      var XmlViewerComponent = /*#__PURE__*/function () {
        function XmlViewerComponent(xmlService, route, location) {
          _classCallCheck(this, XmlViewerComponent);

          this.xmlService = xmlService;
          this.route = route;
          this.location = location;
          this.viewer = {
            name: 'office',
            // 'https://file-examples-com.github.io/uploads/2017/02/file_example_XLSX_50.xlsx'
            doc: '',
            custom: true,
            acceptedUploadTypes: null
          };
          this.selectedViewer = null;
          this.selectedDoc = null;
        }

        _createClass(XmlViewerComponent, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            var _this = this;

            this.route.paramMap.subscribe(function (param) {
              if (param.has('id')) {
                var id = +param.get('id');

                _this.xmlService.documentList.subscribe(function (lists) {
                  var data = lists.find(function (doc) {
                    return doc.id === id;
                  });

                  if (data) {
                    _this.viewer.doc = src_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi + '/' + data.file_path;
                    _this.viewer.doc = src_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi + "/download/excel/".concat(id);
                    _this.selectedViewer = _this.viewer;
                    _this.selectedDoc = _this.selectedViewer.doc;
                  } else {
                    _this.location.back();
                  }
                });
              } else {// this.location.back();
              }
            });
          }
        }]);

        return XmlViewerComponent;
      }();

      XmlViewerComponent.ɵfac = function XmlViewerComponent_Factory(t) {
        return new (t || XmlViewerComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__["XmlViewerService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"]));
      };

      XmlViewerComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: XmlViewerComponent,
        selectors: [["app-xml-viewer"]],
        decls: 1,
        vars: 1,
        consts: [["style", "text-align:center", 4, "ngIf"], [2, "text-align", "center"], ["queryParams", "hl=Nl", 2, "width", "100%", "height", "80vh", 3, "url", "viewerUrl", "viewer"]],
        template: function XmlViewerComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, XmlViewerComponent_div_0_Template, 2, 3, "div", 0);
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.selectedViewer && ctx.selectedDoc);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_5__["NgxDocViewerComponent"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhZ2VzL3htbC12aWV3ZXIveG1sLXZpZXdlci5jb21wb25lbnQuY3NzIn0= */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-xml-viewer',
            templateUrl: './xml-viewer.component.html',
            styleUrls: ['./xml-viewer.component.css']
          }]
        }], function () {
          return [{
            type: _xml_viewer_service__WEBPACK_IMPORTED_MODULE_2__["XmlViewerService"]
          }, {
            type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]
          }, {
            type: _angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "oPuF":
    /*!*******************************************************!*\
      !*** ./src/app/pages/xml-viewer/xml-viewer.module.ts ***!
      \*******************************************************/

    /*! exports provided: XmlViewerModule */

    /***/
    function oPuF(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "XmlViewerModule", function () {
        return XmlViewerModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");
      /* harmony import */


      var ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ngx-doc-viewer */
      "w4ga");
      /* harmony import */


      var _xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./xml-viewer.component */
      "d4hY");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");

      var routes = [{
        path: '',
        component: _xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]
      }];

      var XmlViewerModule = function XmlViewerModule() {
        _classCallCheck(this, XmlViewerModule);
      };

      XmlViewerModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: XmlViewerModule
      });
      XmlViewerModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function XmlViewerModule_Factory(t) {
          return new (t || XmlViewerModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"].forChild(routes)]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](XmlViewerModule, {
          declarations: [_xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_xml_viewer_component__WEBPACK_IMPORTED_MODULE_3__["XmlViewerComponent"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_2__["NgxDocViewerModule"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"].forChild(routes)]
          }]
        }], null, null);
      })();
      /***/

    }
  }]);
})();
//# sourceMappingURL=xml-viewer-xml-viewer-module-es5.js.map
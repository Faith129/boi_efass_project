(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["generate-report-generate-report-module"], {
    /***/
    "8VTR":
    /*!*****************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report.module.ts ***!
      \*****************************************************************/

    /*! exports provided: GenerateReportModule */

    /***/
    function VTR(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportModule", function () {
        return GenerateReportModule;
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


      var _generate_report_page__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./generate-report.page */
      "Phwn");
      /* harmony import */


      var _generate_report_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./generate-report-routing.module */
      "Zgfl");

      var GenerateReportModule = function GenerateReportModule() {
        _classCallCheck(this, GenerateReportModule);
      };

      GenerateReportModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: GenerateReportModule
      });
      GenerateReportModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function GenerateReportModule_Factory(t) {
          return new (t || GenerateReportModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportRoutingModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](GenerateReportModule, {
          declarations: [_generate_report_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportPage"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportRoutingModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_generate_report_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportPage"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportRoutingModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "Phwn":
    /*!***************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report.page.ts ***!
      \***************************************************************/

    /*! exports provided: GenerateReportPage */

    /***/
    function Phwn(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportPage", function () {
        return GenerateReportPage;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var sweetalert__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! sweetalert */
      "GUC0");
      /* harmony import */


      var sweetalert__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(sweetalert__WEBPACK_IMPORTED_MODULE_1__);
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _report_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./report.service */
      "a8X4");
      /* harmony import */


      var src_app_general_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! src/app/general.service */
      "j8bs"); // tslint:disable-next-line: component-class-suffix


      var GenerateReportPage = /*#__PURE__*/function () {
        function GenerateReportPage(router, route, reportService, generalService) {
          _classCallCheck(this, GenerateReportPage);

          this.router = router;
          this.route = route;
          this.reportService = reportService;
          this.generalService = generalService;
        }

        _createClass(GenerateReportPage, [{
          key: "ngOnInit",
          value: function ngOnInit() {} // tslint:disable-next-line: typedef

        }, {
          key: "navigateToData",
          value: function navigateToData(pathParam) {
            this.router.navigate(['data', pathParam], {
              relativeTo: this.route
            });
          }
        }, {
          key: "generateReport",
          value: function generateReport() {
            var _this = this;

            this.generalService.updateBlockedUI(true);
            this.reportService.generateReport().subscribe(function () {
              _this.generalService.updateBlockedUI(false);

              sweetalert__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'Report generated',
                icon: 'success'
              });
            }, function (err) {
              _this.generalService.updateBlockedUI(false);

              sweetalert__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'Failed to generate Report',
                icon: 'error'
              });
            });
          }
        }]);

        return GenerateReportPage;
      }();

      GenerateReportPage.ɵfac = function GenerateReportPage_Factory(t) {
        return new (t || GenerateReportPage)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_report_service__WEBPACK_IMPORTED_MODULE_3__["ReportService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](src_app_general_service__WEBPACK_IMPORTED_MODULE_4__["GeneralService"]));
      };

      GenerateReportPage.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: GenerateReportPage,
        selectors: [["app-generate-report"]],
        decls: 44,
        vars: 0,
        consts: [[1, "page-header"], [1, "table"], [1, "table_action_btn"], [1, "btn_common", "view", 3, "click"], ["colspan", "3", 1, "table_action_btn", "generate_btn_col"]],
        template: function GenerateReportPage_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 0);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "h1");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, " Generate Report ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "small");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "data & reports ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "table", 1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "tr");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "th");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "S/N");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "th");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Primary Reports");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "th");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, "Action");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "tr");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "1");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "Assets & Liability");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "td", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "button", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportPage_Template_button_click_20_listener() {
              return ctx.navigateToData("assets");
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, "Breakdown");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "tr");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](24, "2");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "Profit & Loss");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "td", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "button", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportPage_Template_button_click_28_listener() {
              return ctx.navigateToData("pl");
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29, "Breakdown");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "tr");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](32, "3");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](34, "Memorandum");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "td", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "button", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportPage_Template_button_click_36_listener() {
              return ctx.navigateToData("mm");
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37, "Breakdown");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "tr");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](39, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](40, "td");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "td", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](42, "button", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportPage_Template_button_click_42_listener() {
              return ctx.generateReport();
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](43, "Generate");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        },
        styles: [".card[_ngcontent-%COMP%] {\r\n  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\r\n  max-width: 800px;\r\n  margin: auto;\r\n  position: relative;\r\n  top: 5vh;\r\n  font-family: arial;\r\n  padding-bottom: 10px;\r\n  }\r\n  .report-card[_ngcontent-%COMP%]{\r\n  text-align: center;\r\n  }\r\n  h2[_ngcontent-%COMP%]{\r\n  margin: 5px;\r\n  }\r\n  .table_action_btn[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-items: center;\r\n  }\r\n  .table_action_btn[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n  border: none;\r\n  margin: 0 5px;\r\n  padding: 5px;\r\n  height: unset;\r\n  color: #333333;\r\n  font-weight: 700;\r\n  font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\r\n  font-size: 14px;\r\n  }\r\n  .table_action_btn[_ngcontent-%COMP%]   button.download[_ngcontent-%COMP%] {\r\n  background-color: #D2D904;\r\n  }\r\n  .table_action_btn[_ngcontent-%COMP%]   button.view[_ngcontent-%COMP%] {\r\n  background-color: #4FBFA7;\r\n  }\r\n  .generate_btn_col[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  justify-content: flex-end;\r\n  }\r\n  .generate_btn_col[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n  background-color: var(--primary-color)!important;\r\n  color: white;\r\n  font-size: 16px;\r\n  padding: 5px 10px;\r\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvZ2VuZXJhdGUtcmVwb3J0L2dlbmVyYXRlLXJlcG9ydC5wYWdlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDBDQUEwQztFQUMxQyxnQkFBZ0I7RUFDaEIsWUFBWTtFQUNaLGtCQUFrQjtFQUNsQixRQUFRO0VBQ1Isa0JBQWtCO0VBQ2xCLG9CQUFvQjtFQUNwQjtFQUNBO0VBQ0Esa0JBQWtCO0VBQ2xCO0VBQ0E7RUFDQSxXQUFXO0VBQ1g7RUFFQTtFQUNBLGFBQWE7RUFDYixtQkFBbUI7RUFDbkI7RUFFQTtFQUNBLFlBQVk7RUFDWixhQUFhO0VBQ2IsWUFBWTtFQUNaLGFBQWE7RUFDYixjQUFjO0VBQ2QsZ0JBQWdCO0VBQ2hCLHdEQUF3RDtFQUN4RCxlQUFlO0VBQ2Y7RUFDQTtFQUNBLHlCQUF5QjtFQUN6QjtFQUNBO0VBQ0EseUJBQXlCO0VBQ3pCO0VBRUE7RUFDQSxhQUFhO0VBQ2IseUJBQXlCO0VBQ3pCO0VBRUE7RUFDQSxnREFBZ0Q7RUFDaEQsWUFBWTtFQUNaLGVBQWU7RUFDZixpQkFBaUI7RUFDakIiLCJmaWxlIjoic3JjL2FwcC9wYWdlcy9nZW5lcmF0ZS1yZXBvcnQvZ2VuZXJhdGUtcmVwb3J0LnBhZ2UuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmNhcmQge1xyXG4gIGJveC1zaGFkb3c6IDAgNHB4IDhweCAwIHJnYmEoMCwgMCwgMCwgMC4yKTtcclxuICBtYXgtd2lkdGg6IDgwMHB4O1xyXG4gIG1hcmdpbjogYXV0bztcclxuICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgdG9wOiA1dmg7XHJcbiAgZm9udC1mYW1pbHk6IGFyaWFsO1xyXG4gIHBhZGRpbmctYm90dG9tOiAxMHB4O1xyXG4gIH1cclxuICAucmVwb3J0LWNhcmR7XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gIH1cclxuICBoMntcclxuICBtYXJnaW46IDVweDtcclxuICB9XHJcblxyXG4gIC50YWJsZV9hY3Rpb25fYnRuIHtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbiAgfVxyXG5cclxuICAudGFibGVfYWN0aW9uX2J0biBidXR0b24ge1xyXG4gIGJvcmRlcjogbm9uZTtcclxuICBtYXJnaW46IDAgNXB4O1xyXG4gIHBhZGRpbmc6IDVweDtcclxuICBoZWlnaHQ6IHVuc2V0O1xyXG4gIGNvbG9yOiAjMzMzMzMzO1xyXG4gIGZvbnQtd2VpZ2h0OiA3MDA7XHJcbiAgZm9udC1mYW1pbHk6IFwiSGVsdmV0aWNhIE5ldWVcIixIZWx2ZXRpY2EsQXJpYWwsc2Fucy1zZXJpZjtcclxuICBmb250LXNpemU6IDE0cHg7XHJcbiAgfVxyXG4gIC50YWJsZV9hY3Rpb25fYnRuIGJ1dHRvbi5kb3dubG9hZCB7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI0QyRDkwNDtcclxuICB9XHJcbiAgLnRhYmxlX2FjdGlvbl9idG4gYnV0dG9uLnZpZXcge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM0RkJGQTc7XHJcbiAgfVxyXG5cclxuICAuZ2VuZXJhdGVfYnRuX2NvbCB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtZW5kO1xyXG4gIH1cclxuXHJcbiAgLmdlbmVyYXRlX2J0bl9jb2wgYnV0dG9uIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKSFpbXBvcnRhbnQ7XHJcbiAgY29sb3I6IHdoaXRlO1xyXG4gIGZvbnQtc2l6ZTogMTZweDtcclxuICBwYWRkaW5nOiA1cHggMTBweDtcclxuICB9XHJcbiJdfQ== */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportPage, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-generate-report',
            templateUrl: './generate-report.page.html',
            styleUrls: ['./generate-report.page.css']
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
          }, {
            type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]
          }, {
            type: _report_service__WEBPACK_IMPORTED_MODULE_3__["ReportService"]
          }, {
            type: src_app_general_service__WEBPACK_IMPORTED_MODULE_4__["GeneralService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "Zgfl":
    /*!*************************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report-routing.module.ts ***!
      \*************************************************************************/

    /*! exports provided: GenerateReportRoutingModule */

    /***/
    function Zgfl(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportRoutingModule", function () {
        return GenerateReportRoutingModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _generate_report_page__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./generate-report.page */
      "Phwn");

      var routes = [{
        path: '',
        component: _generate_report_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportPage"],
        pathMatch: 'full'
      }, {
        path: 'data/:report',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-data-generate-report-data-module */
          [__webpack_require__.e("default~generate-report-data-generate-report-data-module~main-main-module"), __webpack_require__.e("generate-report-data-generate-report-data-module")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-data/generate-report-data.module */
          "GE1z")).then(function (m) {
            return m.GenerateReportDataModule;
          });
        }
      }];

      var GenerateReportRoutingModule = function GenerateReportRoutingModule() {
        _classCallCheck(this, GenerateReportRoutingModule);
      };

      GenerateReportRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: GenerateReportRoutingModule
      });
      GenerateReportRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function GenerateReportRoutingModule_Factory(t) {
          return new (t || GenerateReportRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](GenerateReportRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();
      /***/

    }
  }]);
})();
//# sourceMappingURL=generate-report-generate-report-module-es5.js.map
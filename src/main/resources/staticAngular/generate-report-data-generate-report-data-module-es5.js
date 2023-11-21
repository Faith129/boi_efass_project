(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["generate-report-data-generate-report-data-module"], {
    /***/
    "/gA8":
    /*!*****************************************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report-data/generate-report-data.page.ts ***!
      \*****************************************************************************************/

    /*! exports provided: GenerateReportDataPage */

    /***/
    function gA8(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportDataPage", function () {
        return GenerateReportDataPage;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_material_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/material/table */
      "OaSA");
      /* harmony import */


      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/material/paginator */
      "M9IT");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../../../../environments/environment */
      "AytR");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _report_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! ../report.service */
      "a8X4");
      /* harmony import */


      var src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! src/app/common/auth.service */
      "KwcT");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");
      /* harmony import */


      var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! @angular/forms */
      "3Pt+");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! @angular/material/form-field */
      "kmnG");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/material/input */
      "e6WT");

      function GenerateReportDataPage_th_31_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 24);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "b");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " S/N ");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_td_32_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 25);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var element_r15 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r15.serial_number, " ");
        }
      }

      function GenerateReportDataPage_th_34_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 24);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "b");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, " Report Code ");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_td_35_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 25);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var element_r16 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r16.return_code, " ");
        }
      }

      function GenerateReportDataPage_th_37_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 24);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "b");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Report Description ");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_td_38_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 25);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var element_r17 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r17.return_name, " ");
        }
      }

      function GenerateReportDataPage_th_40_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 24);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "b");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Action");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_td_41_Template(rf, ctx) {
        if (rf & 1) {
          var _r20 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 25);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 26);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportDataPage_td_41_Template_button_click_1_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r20);

            var element_r18 = ctx.$implicit;

            var ctx_r19 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

            return ctx_r19.edit(element_r18.sheet_number);
          });

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "View");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_tr_42_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 27);
        }
      }

      function GenerateReportDataPage_tr_43_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 28);
        }
      }

      function GenerateReportDataPage_tr_44_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr", 29);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td", 30);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

          var _r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](28);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("No data matching the filter \"", _r0.value, "\"");
        }
      }

      function GenerateReportDataPage_tr_45_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td", 31);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "LOADING...");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function GenerateReportDataPage_tr_46_Template(rf, ctx) {
        if (rf & 1) {
          var _r23 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td", 31);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "p");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "button", 32);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportDataPage_tr_46_Template_button_click_4_listener() {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r23);

            var ctx_r22 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

            return ctx_r22.loadData();
          });

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Retry");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var ctx_r13 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r13.errorMessage);
        }
      }

      var _c0 = function _c0() {
        return [5, 10, 25, 100];
      };

      var GenerateReportDataPage = /*#__PURE__*/function () {
        function GenerateReportDataPage(router, route, reportService, authService, location, fb, http) {
          _classCallCheck(this, GenerateReportDataPage);

          this.router = router;
          this.route = route;
          this.reportService = reportService;
          this.authService = authService;
          this.location = location;
          this.fb = fb;
          this.http = http;
          this.tableData = [];
          this.displayedColumns = ['serialNumber', 'sheetNumber', 'returnCode', 'returnName'];
          this.SPECIAL_SHEETS = ['100', 'qdfir100', '250', '300', '302', '423', '453', '533', '600', '700', '800', '1000', '1200', 'mstdr2'];
          this.isLoading = true;
          this.isError = false;
          this.reportName = null;
          this.byGroupIsLoading = true;
          this.byGroupIsError = false;
          this.byGroupReportName = null;
          this.first = 0;
          this.rows = 10;
          this.errorMessage = 'An Error occurred';
          console.log("Inside report data" + this.reportData);
        }

        _createClass(GenerateReportDataPage, [{
          key: "ngAfterViewInit",
          value: function ngAfterViewInit() {
            this.dataSource.paginator = this.paginator;
          }
        }, {
          key: "ngOnInit",
          value: function ngOnInit() {
            var _this = this;

            this.reportSubscription = this.reportService.reportData.subscribe(function (_reportData) {
              _this.reportData = _reportData;
            });
            this.route.paramMap.subscribe(function (params) {
              if (params.has('report')) {
                _this.reportName = params.get('report');

                _this.loadData();
              }
            });
            this.timeIntervalId = setInterval(function () {
              _this.nowDate = new Date();
            }, 1000);
            this.$user = this.authService.user.subscribe(function (user) {
              _this.username = user.username;
            });
            this.$selectedDate = this.reportService.selectedDate.subscribe(function (date) {
              _this.reportSelectedDate = date;
            });
          }
        }, {
          key: "edit",
          value: function edit(sheetName) {
            var sheetNumber = sheetName.match(/\d/g).join(''); // let realSheetName = '';

            var routeArray = ['edit'];

            if (this.SPECIAL_SHEETS.includes(sheetName)) {
              // realSheetName = sheetName;
              sheetName = sheetNumber;
              routeArray.push(sheetName); // routeArray.push(realSheetName);

              console.log(sheetName);
            } else {
              routeArray.push(sheetName);
            } // realSheetName


            this.router.navigate(routeArray, {
              relativeTo: this.route
            });
          }
        }, {
          key: "goBack",
          value: function goBack() {
            this.location.back();
          }
        }, {
          key: "loadData",
          value: function loadData() {
            var _this2 = this;

            console.log(this.reportName);
            this.isError = false;
            this.isLoading = true;
            this.reportRequestSubscription = this.reportService.getReports(this.reportName).subscribe(function () {
              _this2.isLoading = false;
              _this2.tableData = _this2.reportService.tableData;
              console.log();
              _this2.tableData[0].serial_number = 0;

              for (var i = 0; i < _this2.tableData.length; i++) {
                _this2.tableData[i].serial_number = 1 + i;
              }

              console.log(_this2.tableData);
              _this2.dataSource = new _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](_this2.reportData);
            }, function (err) {
              _this2.isLoading = false;
              _this2.isError = true;

              if (err.status === 404) {
                _this2.errorMessage = 'No record found';
              } else {
                _this2.errorMessage = 'An Error occurred';
              }
            });
          } // loadDataByGroup() {
          //   this.isError = false;
          //   this.isLoading = true;
          //   this.reportRequestSubscription = this.reportService.getReports(this.reportName).subscribe(() => {
          //     this.isLoading = false;
          //     this.tableData  = this.reportService.tableData;
          //     this.tableData[0].serial_number = 0;
          //     for (let i = 0; i < this.tableData.length; i++){
          //       this.tableData[i].serial_number = 1 + i;
          //     }
          //     console.log("TABLE DATA")
          //     console.log(this.tableData)
          //           this.dataSource = new MatTableDataSource<ReportData>(this.reportData);
          //   }, err => {
          //     this.isLoading = false;
          //     this.isError = true;
          //     if (err.status === 404) {
          //       this.errorMessage = 'No record found';
          //     } else {
          //       this.errorMessage = 'An Error occurred';
          //     }
          //   })
          // }

        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            clearInterval(this.timeIntervalId);

            if (this.$selectedDate) {
              this.$selectedDate.unsubscribe();
            }

            if (this.$user) {
              this.$user.unsubscribe();
            }

            this.reportRequestSubscription && this.reportRequestSubscription.unsubscribe();
            this.reportSubscription && this.reportSubscription.unsubscribe();
          }
        }, {
          key: "applyFilter",
          value: function applyFilter(event) {
            var filterValue = event.target.value;
            this.dataSource.filter = filterValue.trim().toLowerCase();
          }
        }, {
          key: "next",
          value: function next() {
            this.first = this.first + this.rows;
          }
        }, {
          key: "prev",
          value: function prev() {
            this.first = this.first - this.rows;
          }
        }, {
          key: "reset",
          value: function reset() {
            this.first = 0;
          }
        }, {
          key: "isLastPage",
          value: function isLastPage() {
            return this.tableData ? this.first === this.tableData.length - this.rows : true;
          }
        }, {
          key: "isFirstPage",
          value: function isFirstPage() {
            return this.tableData ? this.first === 0 : true;
          }
        }, {
          key: "downloadXmlReports",
          value: function downloadXmlReports() {
            var _this3 = this;

            var selectedReport = [];
            this.tableData.forEach(function (e) {
              selectedReport.push(e.return_code);
            }); //let endpoint = `${environment.baseUrl}/download/MDFIR1200`;

            var endpoint = "".concat(_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseUrl, "/download/");
            selectedReport.filter(function (item) {
              return !item.startsWith("QDFIR400");
            }).filter(function (item) {
              return !item.startsWith("QDFIR450");
            }).filter(function (item) {
              return !item.startsWith("MDFIR450");
            }).filter(function (item) {
              return !item.startsWith("MDFIR400");
            }).forEach(function (item) {
              // console.log(item);
              endpoint += item;
              endpoint += ',';
            });
            console.log(endpoint);

            if (this.reportService.getReportGroup() === "Q") {
              endpoint += "QDFIR400";
              endpoint += ", QDFIR450";
            }

            if (this.reportService.getReportGroup() === "M") {
              endpoint += "MDFIR400";
              endpoint += ",MDFIR450";
            }

            console.log(endpoint);
            this.download(endpoint).subscribe(function (blob) {
              var a = document.createElement('a');
              console.log(blob);
              var objectUrl = URL.createObjectURL(blob);
              a.href = objectUrl;
              a.download = 'Reports downloaded for ' + _this3.reportSelectedDate + '.zip';
              a.click();
              URL.revokeObjectURL(objectUrl);
            });
          }
        }, {
          key: "download",
          value: function download(url) {
            return this.http.get(url, {
              responseType: 'blob'
            });
          }
        }]);

        return GenerateReportDataPage;
      }();

      GenerateReportDataPage.ɵfac = function GenerateReportDataPage_Factory(t) {
        return new (t || GenerateReportDataPage)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_report_service__WEBPACK_IMPORTED_MODULE_5__["ReportService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_6__["AuthService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_7__["Location"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClient"]));
      };

      GenerateReportDataPage.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: GenerateReportDataPage,
        selectors: [["app-assets-and-liability-data"]],
        viewQuery: function GenerateReportDataPage_Query(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵviewQuery"](_angular_material_paginator__WEBPACK_IMPORTED_MODULE_2__["MatPaginator"], true);
          }

          if (rf & 2) {
            var _t;

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.paginator = _t.first);
          }
        },
        decls: 49,
        vars: 16,
        consts: [[1, "page-header"], [1, "row"], [1, "user"], [1, "input-icon"], [2, "color", "#000000"], [1, ""], [1, "nav", "justify-content-end"], [1, "nav-item", "me-2"], ["mat-flat-button", "", 1, "btn_common", 3, "click"], ["matInput", "", "placeholder", "Enter MDFIR300 OR QDFIR300", 3, "keyup"], ["input", ""], ["mat-table", "", 1, "table", 3, "dataSource"], ["matColumnDef", "serialNumber"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "sheetNumber"], ["matColumnDef", "returnCode"], ["matColumnDef", "returnName"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["class", "mat-row", 4, "matNoDataRow"], [4, "ngIf"], [3, "length", "pageSize", "pageSizeOptions"], ["myPaginator", ""], ["mat-header-cell", ""], ["mat-cell", ""], [1, "edits", 3, "click"], ["mat-header-row", ""], ["mat-row", ""], [1, "mat-row"], ["colspan", "4", 1, "mat-cell"], ["colspan", "4", 2, "text-align", "center"], [1, "btn_common", "view", 3, "click"]],
        template: function GenerateReportDataPage_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 0);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "h1");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, " Generate Report ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "small");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "list & edit ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "span", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "label", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "Current Date: ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](12, "date");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "span", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "label", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "User: ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](18, "titlecase");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "ul", 6);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "li", 7);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "button", 8);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function GenerateReportDataPage_Template_button_click_22_listener() {
              return ctx.downloadXmlReports();
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "Download");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "mat-form-field");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "mat-label");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "Filter");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "input", 9, 10);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("keyup", function GenerateReportDataPage_Template_input_keyup_27_listener($event) {
              return ctx.applyFilter($event);
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "table", 11);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](30, 12);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](31, GenerateReportDataPage_th_31_Template, 3, 0, "th", 13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](32, GenerateReportDataPage_td_32_Template, 2, 1, "td", 14);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](33, 15);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](34, GenerateReportDataPage_th_34_Template, 3, 0, "th", 13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](35, GenerateReportDataPage_td_35_Template, 2, 1, "td", 14);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](36, 16);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](37, GenerateReportDataPage_th_37_Template, 3, 0, "th", 13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](38, GenerateReportDataPage_td_38_Template, 2, 1, "td", 14);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](39, 17);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](40, GenerateReportDataPage_th_40_Template, 3, 0, "th", 13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](41, GenerateReportDataPage_td_41_Template, 3, 0, "td", 14);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](42, GenerateReportDataPage_tr_42_Template, 1, 0, "tr", 18);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](43, GenerateReportDataPage_tr_43_Template, 1, 0, "tr", 19);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](44, GenerateReportDataPage_tr_44_Template, 3, 1, "tr", 20);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](45, GenerateReportDataPage_tr_45_Template, 3, 0, "tr", 21);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](46, GenerateReportDataPage_tr_46_Template, 6, 1, "tr", 21);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](47, "mat-paginator", 22, 23);
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](11);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" \xA0 ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind2"](12, 10, ctx.nowDate, "medium"), " ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" \xA0 ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](18, 13, ctx.username), " ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](12);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isLoading);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isError);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("length", ctx.reportData.length)("pageSize", 5)("pageSizeOptions", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](15, _c0));
          }
        },
        directives: [_angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_11__["MatInput"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatNoDataRow"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["NgIf"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_2__["MatPaginator"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_1__["MatRow"]],
        pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_7__["DatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["TitleCasePipe"]],
        styles: [".table[_ngcontent-%COMP%] {\r\n  margin-top: 13px;\r\n}\r\n\r\n.page-header[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  justify-content: space-between;\r\n  margin-top: 0px;\r\n  margin-bottom: 10px;\r\n}\r\n\r\n\r\n\r\n.table_action_btn[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-items: center;\r\n}\r\n\r\n\r\n\r\n.table_action_btn[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n  border: none;\r\n  margin: 0 5px;\r\n  padding: 5px;\r\n  height: unset;\r\n  \r\n  font-weight: 700;\r\n  font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n  font-size: 14px;\r\n}\r\n\r\n.table_action_btn[_ngcontent-%COMP%]   button.download[_ngcontent-%COMP%] {\r\n  background-color: #D2D904;\r\n}\r\n\r\n.table_action_btn[_ngcontent-%COMP%]   button.view[_ngcontent-%COMP%] {\r\n  background-color: #4FBFA7;\r\n}\r\n\r\n.username-col[_ngcontent-%COMP%] {\r\n  text-align: right;\r\n  display: flex;\r\n}\r\n\r\n.username[_ngcontent-%COMP%] {\r\n  font-size: 16px;\r\n  font-weight: 700;\r\n  color: #333333;\r\n}\r\n\r\n.edits[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  justify-content: center;\r\n  align-items: center;\r\n  width: 54px;\r\n  height: 32px;\r\n  \r\n  border: 1px solid var(--primary-color);\r\n  border-radius: 5px;\r\n}\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n.edits[_ngcontent-%COMP%]:hover {\r\n  background-color: #d9e8dc;\r\n  color: #0000 !important;\r\n}\r\n\r\n*/[_ngcontent-%COMP%]   back[_ngcontent-%COMP%] {\r\n  background-color: #fff;\r\n}\r\n\r\n\r\n\r\n.mat-column-x[_ngcontent-%COMP%] {\r\n  padding: 0px !important;\r\n  width: 35px !important;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvZ2VuZXJhdGUtcmVwb3J0L2dlbmVyYXRlLXJlcG9ydC1kYXRhL2dlbmVyYXRlLXJlcG9ydC1kYXRhLnBhZ2UuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsZ0JBQWdCO0FBQ2xCOztBQUVBO0VBQ0UsYUFBYTtFQUNiLDhCQUE4QjtFQUM5QixlQUFlO0VBQ2YsbUJBQW1CO0FBQ3JCOztBQUVBOzs7R0FHRzs7QUFFSDtFQUNFLGFBQWE7RUFDYixtQkFBbUI7QUFDckI7O0FBRUE7OztHQUdHOztBQUVIO0VBQ0UsWUFBWTtFQUNaLGFBQWE7RUFDYixZQUFZO0VBQ1osYUFBYTtFQUNiLG9CQUFvQjtFQUNwQixnQkFBZ0I7RUFDaEIsMkRBQTJEO0VBQzNELGVBQWU7QUFDakI7O0FBRUE7RUFDRSx5QkFBeUI7QUFDM0I7O0FBRUE7RUFDRSx5QkFBeUI7QUFDM0I7O0FBRUE7RUFDRSxpQkFBaUI7RUFDakIsYUFBYTtBQUNmOztBQUVBO0VBQ0UsZUFBZTtFQUNmLGdCQUFnQjtFQUNoQixjQUFjO0FBQ2hCOztBQUVBO0VBQ0UsYUFBYTtFQUNiLHVCQUF1QjtFQUN2QixtQkFBbUI7RUFDbkIsV0FBVztFQUNYLFlBQVk7RUFDWiw0QkFBNEI7RUFDNUIsc0NBQXNDO0VBQ3RDLGtCQUFrQjtBQUNwQjs7QUFFQSxVQUFVOztBQUNWOzs7R0FHRzs7QUFHSCxVQUFVOztBQUNWO0VBQ0UseUJBQXlCO0VBQ3pCLHVCQUF1QjtBQUN6Qjs7QUFFQTtFQUNFLHNCQUFzQjtBQUN4Qjs7QUFFQTs7Ozs7R0FLRzs7QUFFSDtFQUNFLHVCQUF1QjtFQUN2QixzQkFBc0I7QUFDeEI7O0FBRUE7O0dBRUciLCJmaWxlIjoic3JjL2FwcC9wYWdlcy9nZW5lcmF0ZS1yZXBvcnQvZ2VuZXJhdGUtcmVwb3J0LWRhdGEvZ2VuZXJhdGUtcmVwb3J0LWRhdGEucGFnZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudGFibGUge1xyXG4gIG1hcmdpbi10b3A6IDEzcHg7XHJcbn1cclxuXHJcbi5wYWdlLWhlYWRlciB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWJldHdlZW47XHJcbiAgbWFyZ2luLXRvcDogMHB4O1xyXG4gIG1hcmdpbi1ib3R0b206IDEwcHg7XHJcbn1cclxuXHJcbi8qIC51c2VyIHtcclxuICBmbG9hdDogcmlnaHQ7XHJcbiAgbWFyZ2luLWxlZnQ6IC00MHB4O1xyXG59ICovXHJcblxyXG4udGFibGVfYWN0aW9uX2J0biB7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBhbGlnbi1pdGVtczogY2VudGVyO1xyXG59XHJcblxyXG4vKiAuam9obntcclxuICBtYXJnaW4tdG9wOiAtNTBweDtcclxuXHJcbn0gKi9cclxuXHJcbi50YWJsZV9hY3Rpb25fYnRuIGJ1dHRvbiB7XHJcbiAgYm9yZGVyOiBub25lO1xyXG4gIG1hcmdpbjogMCA1cHg7XHJcbiAgcGFkZGluZzogNXB4O1xyXG4gIGhlaWdodDogdW5zZXQ7XHJcbiAgLyogY29sb3I6ICMwZjBmMGY7ICovXHJcbiAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICBmb250LWZhbWlseTogXCJIZWx2ZXRpY2EgTmV1ZVwiLCBIZWx2ZXRpY2EsIEFyaWFsLCBzYW5zLXNlcmlmO1xyXG4gIGZvbnQtc2l6ZTogMTRweDtcclxufVxyXG5cclxuLnRhYmxlX2FjdGlvbl9idG4gYnV0dG9uLmRvd25sb2FkIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjRDJEOTA0O1xyXG59XHJcblxyXG4udGFibGVfYWN0aW9uX2J0biBidXR0b24udmlldyB7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogIzRGQkZBNztcclxufVxyXG5cclxuLnVzZXJuYW1lLWNvbCB7XHJcbiAgdGV4dC1hbGlnbjogcmlnaHQ7XHJcbiAgZGlzcGxheTogZmxleDtcclxufVxyXG5cclxuLnVzZXJuYW1lIHtcclxuICBmb250LXNpemU6IDE2cHg7XHJcbiAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICBjb2xvcjogIzMzMzMzMztcclxufVxyXG5cclxuLmVkaXRzIHtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGp1c3RpZnktY29udGVudDogY2VudGVyO1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbiAgd2lkdGg6IDU0cHg7XHJcbiAgaGVpZ2h0OiAzMnB4O1xyXG4gIC8qIGJhY2tncm91bmQtY29sb3I6ICMwMDA7ICovXHJcbiAgYm9yZGVyOiAxcHggc29saWQgdmFyKC0tcHJpbWFyeS1jb2xvcik7XHJcbiAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG59XHJcblxyXG4vKiBuZXhpbSAqL1xyXG4vKiAuZWRpdHM6aG92ZXJ7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogdmFyKC0tcHJpbWFyeS1jb2xvcik7XHJcbiAgY29sb3I6ICNmZmY7XHJcbn0gKi9cclxuXHJcblxyXG4vKiAvL2JvaSAqL1xyXG4uZWRpdHM6aG92ZXIge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICNkOWU4ZGM7XHJcbiAgY29sb3I6ICMwMDAwICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbiovIGJhY2sge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICNmZmY7XHJcbn1cclxuXHJcbi8qIC5zZWNvbmRhcnl7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI2ZmZjtcclxuICBib3JkZXI6IDFweCBzb2xpZCB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICBjb2xvcjogdmFyKC0tcHJpbWFyeS1jb2xvcikhaW1wb3J0YW50O1xyXG4gIG1hcmdpbi1sZWZ0OiAxNnB4O1xyXG59ICovXHJcblxyXG4ubWF0LWNvbHVtbi14IHtcclxuICBwYWRkaW5nOiAwcHggIWltcG9ydGFudDtcclxuICB3aWR0aDogMzVweCAhaW1wb3J0YW50O1xyXG59XHJcblxyXG4vKiBpbnB1dC5jaGVjayB7XHJcbiAgaGVpZ2h0OiAxOHB4O1xyXG59ICovXHJcbiJdfQ== */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportDataPage, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-assets-and-liability-data',
            templateUrl: './generate-report-data.page.html',
            styleUrls: ['./generate-report-data.page.css']
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]
          }, {
            type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"]
          }, {
            type: _report_service__WEBPACK_IMPORTED_MODULE_5__["ReportService"]
          }, {
            type: src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_6__["AuthService"]
          }, {
            type: _angular_common__WEBPACK_IMPORTED_MODULE_7__["Location"]
          }, {
            type: _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormBuilder"]
          }, {
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClient"]
          }];
        }, {
          paginator: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: [_angular_material_paginator__WEBPACK_IMPORTED_MODULE_2__["MatPaginator"]]
          }]
        });
      })();
      /***/

    },

    /***/
    "8KOg":
    /*!***************************************************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report-data/generate-report-data-routing.module.ts ***!
      \***************************************************************************************************/

    /*! exports provided: GenerateReportDataRoutingModule */

    /***/
    function KOg(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportDataRoutingModule", function () {
        return GenerateReportDataRoutingModule;
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


      var _generate_report_data_page__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./generate-report-data.page */
      "/gA8");

      var routes = [{
        path: '',
        component: _generate_report_data_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportDataPage"],
        pathMatch: 'full'
      }, {
        path: 'edit/100/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet100-sheet100-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~4188d894")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet100/sheet100.module */
          "CNfu")).then(function (m) {
            return m.Sheet100Module;
          });
        }
      }, {
        path: 'edit/250/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet250-sheet250-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~9777b335")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet250/sheet250.module */
          "lEgX")).then(function (m) {
            return m.Sheet250Module;
          });
        }
      }, {
        path: 'edit/300/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet300-sheet300-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~fb5a68a9")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet300/sheet300.module */
          "SlVR")).then(function (m) {
            return m.Sheet300Module;
          });
        }
      }, {
        path: 'edit/302/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet302-sheet302-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~71e92c78")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet302/sheet302.module */
          "fvLe")).then(function (m) {
            return m.Sheet302Module;
          });
        }
      }, {
        path: 'edit/423/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet423-sheet423-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~8e94e9a6")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet423/sheet423.module */
          "EDDw")).then(function (m) {
            return m.Sheet423Module;
          });
        }
      }, {
        path: 'edit/453/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet453-sheet453-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~49044bf4")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet453/sheet453.module */
          "DKN4")).then(function (m) {
            return m.Sheet453Module;
          });
        }
      }, {
        path: 'edit/533/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet533-sheet533-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~7fe32a4c")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet533/sheet533.module */
          "4VIA")).then(function (m) {
            return m.Sheet533Module;
          });
        }
      }, {
        path: 'edit/600/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet600-sheet600-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~76577e2c")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet600/sheet600.module */
          "5uIM")).then(function (m) {
            return m.Sheet600Module;
          });
        }
      }, {
        path: 'edit/700/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet700-sheet700-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~7749169d")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet700/sheet700.module */
          "XDCG")).then(function (m) {
            return m.Sheet700Module;
          });
        }
      }, {
        path: 'edit/700/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-quarterly-special-reports-qdfir700-qdfir700-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-quarterly-special-repo~0ef1fe1b")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/quarterly-special-reports/qdfir700/qdfir700.module */
          "+i7u")).then(function (m) {
            return m.Qdfir700Module;
          });
        }
      }, {
        path: 'edit/800/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet800-sheet800-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~1ac2bac2")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet800/sheet800.module */
          "0MnM")).then(function (m) {
            return m.Sheet800Module;
          });
        }
      }, {
        path: 'edit/1000/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet1000-sheet1000-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~037ce3e2")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet1000/sheet1000.module */
          "W7T7")).then(function (m) {
            return m.Sheet1000Module;
          });
        }
      }, {
        path: 'edit/1200/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheet1200-sheet1200-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~53957afc")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheet1200/sheet1200.module */
          "IK9+")).then(function (m) {
            return m.Sheet1200Module;
          });
        }
      }, {
        path: 'edit/321/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-normal-reports-sheet321-sheet321-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~0a4628ff")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/normal-reports/sheet321/sheet321.module */
          "l5XD")).then(function (m) {
            return m.Sheet321Module;
          });
        }
      }, {
        path: 'edit/mstdr2/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-special-report-edit-sheetmstdr2-sheetmstdr2-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~a62bb9d4")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/special-report-edit/sheetmstdr2/sheetmstdr2.module */
          "PQ1j")).then(function (m) {
            return m.Sheetmstdr2Module;
          });
        }
      }, {
        path: 'edit/:sheetName',
        loadChildren: function loadChildren() {
          return Promise.all(
          /*! import() | generate-report-edit-generate-report-edit-module */
          [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~a62bb9d4"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~0a4628ff"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~76577e2c"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~1ac2bac2"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~53957afc"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~7fe32a4c"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-quarterly-special-repo~0ef1fe1b"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~7749169d"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~4188d894"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~49044bf4"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~037ce3e2"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~71e92c78"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~8e94e9a6"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~9777b335"), __webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-special-report-edit-sh~fb5a68a9"), __webpack_require__.e("generate-report-edit-generate-report-edit-module")]).then(__webpack_require__.bind(null,
          /*! ./generate-report-edit/generate-report-edit.module */
          "CPkj")).then(function (m) {
            return m.GenerateReportEditModule;
          });
        }
      }];

      var GenerateReportDataRoutingModule = function GenerateReportDataRoutingModule() {
        _classCallCheck(this, GenerateReportDataRoutingModule);
      };

      GenerateReportDataRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: GenerateReportDataRoutingModule
      });
      GenerateReportDataRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function GenerateReportDataRoutingModule_Factory(t) {
          return new (t || GenerateReportDataRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](GenerateReportDataRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportDataRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "GE1z":
    /*!*******************************************************************************************!*\
      !*** ./src/app/pages/generate-report/generate-report-data/generate-report-data.module.ts ***!
      \*******************************************************************************************/

    /*! exports provided: GenerateReportDataModule */

    /***/
    function GE1z(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportDataModule", function () {
        return GenerateReportDataModule;
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


      var _generate_report_data_page__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./generate-report-data.page */
      "/gA8");
      /* harmony import */


      var _generate_report_data_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./generate-report-data-routing.module */
      "8KOg");
      /* harmony import */


      var _angular_material_select__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/material/select */
      "d3UM");
      /* harmony import */


      var _angular_material_table__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/table */
      "OaSA");
      /* harmony import */


      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! @angular/material/paginator */
      "M9IT");
      /* harmony import */


      var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @angular/material/tooltip */
      "Qu3c");
      /* harmony import */


      var _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! @angular/material/sidenav */
      "q7Ft");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! @angular/material/input */
      "e6WT");
      /* harmony import */


      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! @angular/material/form-field */
      "kmnG");
      /* harmony import */


      var _angular_forms__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/forms */
      "3Pt+");

      var GenerateReportDataModule = function GenerateReportDataModule() {
        _classCallCheck(this, GenerateReportDataModule);
      };

      GenerateReportDataModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: GenerateReportDataModule
      });
      GenerateReportDataModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function GenerateReportDataModule_Factory(t) {
          return new (t || GenerateReportDataModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_data_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportDataRoutingModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_6__["MatPaginatorModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_4__["MatSelectModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__["MatTooltipModule"], _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_8__["MatSidenavModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_9__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormsModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["ReactiveFormsModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](GenerateReportDataModule, {
          declarations: [_generate_report_data_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportDataPage"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_data_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportDataRoutingModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_6__["MatPaginatorModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_4__["MatSelectModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__["MatTooltipModule"], _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_8__["MatSidenavModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_9__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormsModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["ReactiveFormsModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportDataModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_generate_report_data_page__WEBPACK_IMPORTED_MODULE_2__["GenerateReportDataPage"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _generate_report_data_routing_module__WEBPACK_IMPORTED_MODULE_3__["GenerateReportDataRoutingModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_6__["MatPaginatorModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_4__["MatSelectModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_5__["MatTableModule"], _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_7__["MatTooltipModule"], _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_8__["MatSidenavModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_10__["MatFormFieldModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_9__["MatInputModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormsModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["ReactiveFormsModule"]]
          }]
        }], null, null);
      })();
      /***/

    }
  }]);
})();
//# sourceMappingURL=generate-report-data-generate-report-data-module-es5.js.map
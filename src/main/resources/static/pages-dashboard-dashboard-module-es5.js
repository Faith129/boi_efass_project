(function () {
  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["pages-dashboard-dashboard-module"], {
    /***/
    "/2RN":
    /*!*****************************************************!*\
      !*** ./src/app/pages/dashboard/dashboard.module.ts ***!
      \*****************************************************/

    /*! exports provided: DashboardModule */

    /***/
    function RN(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "DashboardModule", function () {
        return DashboardModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/forms */
      "3Pt+");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");
      /* harmony import */


      var _dashboard_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./dashboard-routing.module */
      "ea/W");
      /* harmony import */


      var _dashboard_page__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ./dashboard.page */
      "6ckw");
      /* harmony import */


      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/icon */
      "Tj54");

      var DashboardModule = function DashboardModule() {
        _classCallCheck(this, DashboardModule);
      };

      DashboardModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: DashboardModule
      });
      DashboardModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function DashboardModule_Factory(t) {
          return new (t || DashboardModule)();
        },
        imports: [[_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _dashboard_routing_module__WEBPACK_IMPORTED_MODULE_3__["DashboardRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormsModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](DashboardModule, {
          declarations: [_dashboard_page__WEBPACK_IMPORTED_MODULE_4__["DashboardPage"]],
          imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _dashboard_routing_module__WEBPACK_IMPORTED_MODULE_3__["DashboardRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormsModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DashboardModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            declarations: [_dashboard_page__WEBPACK_IMPORTED_MODULE_4__["DashboardPage"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _dashboard_routing_module__WEBPACK_IMPORTED_MODULE_3__["DashboardRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormsModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIconModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "6ckw":
    /*!***************************************************!*\
      !*** ./src/app/pages/dashboard/dashboard.page.ts ***!
      \***************************************************/

    /*! exports provided: DashboardPage */

    /***/
    function ckw(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "DashboardPage", function () {
        return DashboardPage;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! src/app/common/auth.service */
      "KwcT");
      /* harmony import */


      var _generate_report_report_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ../generate-report/report.service */
      "a8X4");
      /* harmony import */


      var _main_report_history_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../main/report-history.service */
      "Z70I");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/icon */
      "Tj54");

      var _c0 = function _c0() {
        return {
          exact: true
        };
      };

      var DashboardPage = /*#__PURE__*/function () {
        function DashboardPage(authService, reportService, reportHistory) {
          _classCallCheck(this, DashboardPage);

          this.authService = authService;
          this.reportService = reportService;
          this.reportHistory = reportHistory;
          this.selectedDate = null;
        }

        _createClass(DashboardPage, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            var _this = this;

            this.$dateSubscription = this.reportService.selectedDate.subscribe(function (date) {
              _this.selectedDate = date;
            });
          }
        }, {
          key: "ngAfterViewInit",
          value: function ngAfterViewInit() {}
        }, {
          key: "logout",
          value: function logout() {
            this.authService.logout();
          } // storeDate() {
          //   if(this.selectedDate !== null && this.selectedDate.length !== 0) {
          //     console.log(this.selectedDate)
          //     // this.reportService.saveReportDate().subscribe(_ => {}, err => {
          //         // swa({
          //         //   title: 'Couldn\'t set date',
          //         //   text: `An error occurred while setting date`,
          //         //   icon: 'error',
          //         // });
          //     this.reportHistory.postReportDate(this.selectedDate);
          //   }
          // }

        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this.$dateSubscription) {
              this.$dateSubscription.unsubscribe();
            }
          }
        }]);

        return DashboardPage;
      }();

      DashboardPage.ɵfac = function DashboardPage_Factory(t) {
        return new (t || DashboardPage)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_generate_report_report_service__WEBPACK_IMPORTED_MODULE_2__["ReportService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_main_report_history_service__WEBPACK_IMPORTED_MODULE_3__["ReportHistoryService"]));
      };

      DashboardPage.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: DashboardPage,
        selectors: [["app-dashboard"]],
        decls: 27,
        vars: 4,
        consts: [["id", "myTopnav", 1, "topnav"], [1, "logo_containerr"], ["routerLink", "/dashboard", 1, ""], ["src", "../../../assets/img/fullBoiLogo.png", 1, "BOI", "logo"], [1, "navbar-brand"], [1, "h4"], [1, "logout", 3, "click"], [1, "sidebar"], ["routerLinkActive", "active", "routerLink", "/dashboard", 3, "routerLinkActiveOptions"], ["routerLinkActive", "active", "routerLink", "generate_report/data/assets"], ["routerLinkActive", "active", "routerLink", "user_settings"], [1, "main"]],
        template: function DashboardPage_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "a", 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "img", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "span", 5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "Electronic Financial Analysis and Surveillance System (Efass)");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "b");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "a", 6);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function DashboardPage_Template_a_click_8_listener() {
              return ctx.logout();
            });

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "LOGOUT");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "a", 8);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-icon");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "home");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, " Dashboard");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "a", 9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "mat-icon");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "folder");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, " Generate Report");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "a", 10);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "mat-icon");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "settings");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](24, " Settings");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 11);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](26, "router-outlet");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLinkActiveOptions", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](3, _c0));

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("disabled", ctx.selectedDate === null || ctx.selectedDate.length === 0);
          }
        },
        directives: [_angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLinkWithHref"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLinkActive"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_5__["MatIcon"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterOutlet"]],
<<<<<<< HEAD
        styles: [".sidebar[_ngcontent-%COMP%] {\r\n  margin: 0;\r\n  padding: 0;\r\n  width: 220px;\r\n  background-color: var(--primary-color);\r\n  border: 0.5px solid var(--primary-color);\r\n  position: fixed;\r\n  height: 100%;\r\n  overflow: auto;\r\n  \r\n  z-index: 1;\r\n  padding-top: 35px;\r\n}\r\n.logo_containerr[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-items: center;\r\n  color: #000;\r\n  font-weight: 600;\r\n  \r\n  \r\n  font-size: 2rem;\r\n}\r\n.boi_logo[_ngcontent-%COMP%] {\r\n  object-fit: contain;\r\n  height: 5rem;\r\n  width: -webkit-fit-content;\r\n  width: -moz-fit-content;\r\n  width: fit-content;\r\n  \r\n}\r\n\r\n.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n  display: block;\r\n  \r\n  \r\n  color: #000;\r\n  font-weight: 600;\r\n  font-size: 15px;\r\n  \r\n  padding: 16px;\r\n  text-decoration: none;\r\n}\r\n\r\n.sidebar[_ngcontent-%COMP%]   a.active[_ngcontent-%COMP%] {\r\n  color: #000;\r\n  font-weight: 600;\r\n  background-color: #d9e8dc;\r\n  \r\n}\r\n\r\n\r\n\r\ndiv.main[_ngcontent-%COMP%] {\r\n  margin-left: 240px;\r\n  padding: 1px 16px;\r\n  padding-top: 48px;\r\n  \r\n}\r\n\r\n@media screen and (max-width: 700px) {\r\n  .sidebar[_ngcontent-%COMP%] {\r\n    width: 100%;\r\n    height: auto;\r\n    position: relative;\r\n  }\r\n\r\n  .sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n    float: left;\r\n  }\r\n\r\n  div.main[_ngcontent-%COMP%] {\r\n    margin-left: 0;\r\n    padding-top: initial;\r\n  }\r\n}\r\n\r\n@media screen and (max-width: 400px) {\r\n  .sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n    text-align: center;\r\n    float: none;\r\n  }\r\n}\r\n.topnav[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n  display: block;\r\n  text-align: center;\r\n  text-decoration: none;\r\n  font-size: 18px;\r\n  padding: 14px 10px 12px;\r\n  margin-left: 0px;\r\n  font-family: Raleway, sans-serif;\r\n  min-width: 210px;\r\n  color: #f1f1f1;\r\n}\r\n.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%] {\r\n  \r\n  color: #000;\r\n  font-size: 16px;\r\n  cursor: pointer;\r\n  transition: 0.06s ease-in;\r\n}\r\n.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]:hover {\r\n  transform: scale(0.8);\r\n}\r\n.topnav[_ngcontent-%COMP%] {\r\n  background-color: var(--primary-color);\r\n  overflow: hidden;\r\n  display: flex;\r\n  justify-content: space-between;\r\n  align-items: center;\r\n  border-bottom: 1px solid #d9d9d9;\r\n  ;\r\n  \r\n  \r\n  height: auto;\r\n  z-index: 99;\r\n  position: fixed;\r\n  left: 0;\r\n  right: 0;\r\n}\r\n.sticky[_ngcontent-%COMP%] {\r\n  position: fixed;\r\n  top: 0;\r\n  overflow: hidden;\r\n  z-index: 10;\r\n}\r\n.disabled[_ngcontent-%COMP%] {\r\n  color: currentColor;\r\n  cursor: not-allowed;\r\n  opacity: 0.5;\r\n  text-decoration: none;\r\n}\r\n.row[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  flex-direction: row;\r\n  justify-content: center;\r\n  align-items: center;\r\n}\r\na[_ngcontent-%COMP%] {\r\n  vertical-align: middle;\r\n}\r\na[_ngcontent-%COMP%] > mat-icon[_ngcontent-%COMP%] {\r\n  vertical-align: middle;\r\n}\r\nimg[_ngcontent-%COMP%] {\r\n  width: 140px;\r\n  margin-top: -12px;\r\n\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvZGFzaGJvYXJkL2Rhc2hib2FyZC5wYWdlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSw2QkFBNkI7QUFDN0I7RUFDRSxTQUFTO0VBQ1QsVUFBVTtFQUNWLFlBQVk7RUFDWixzQ0FBc0M7RUFDdEMsd0NBQXdDO0VBQ3hDLGVBQWU7RUFDZixZQUFZO0VBQ1osY0FBYztFQUNkLFlBQVk7RUFDWixVQUFVO0VBQ1YsaUJBQWlCO0FBQ25CO0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLFdBQVc7RUFDWCxnQkFBZ0I7RUFDaEIsMkJBQTJCO0VBQzNCLGVBQWU7RUFDZixlQUFlO0FBQ2pCO0FBRUE7RUFDRSxtQkFBbUI7RUFDbkIsWUFBWTtFQUNaLDBCQUFrQjtFQUFsQix1QkFBa0I7RUFBbEIsa0JBQWtCO0VBQ2xCLDJCQUEyQjtBQUM3QjtBQUVBLGtCQUFrQjtBQUNsQjtFQUNFLGNBQWM7RUFDZCwwQkFBMEI7RUFDMUIsUUFBUTtFQUNSLFdBQVc7RUFDWCxnQkFBZ0I7RUFDaEIsZUFBZTtFQUNmLDhCQUE4QjtFQUM5QixhQUFhO0VBQ2IscUJBQXFCO0FBQ3ZCO0FBRUEsd0JBQXdCO0FBQ3hCO0VBQ0UsV0FBVztFQUNYLGdCQUFnQjtFQUNoQix5QkFBeUI7RUFDekIsc0NBQXNDO0FBQ3hDO0FBRUEsd0JBQXdCO0FBQ3hCOzs7R0FHRztBQUVILCtHQUErRztBQUMvRztFQUNFLGtCQUFrQjtFQUNsQixpQkFBaUI7RUFDakIsaUJBQWlCO0VBQ2pCLG9CQUFvQjtBQUN0QjtBQUVBLDZFQUE2RTtBQUM3RTtFQUNFO0lBQ0UsV0FBVztJQUNYLFlBQVk7SUFDWixrQkFBa0I7RUFDcEI7O0VBRUE7SUFDRSxXQUFXO0VBQ2I7O0VBRUE7SUFDRSxjQUFjO0lBQ2Qsb0JBQW9CO0VBQ3RCO0FBQ0Y7QUFFQSw2RkFBNkY7QUFDN0Y7RUFDRTtJQUNFLGtCQUFrQjtJQUNsQixXQUFXO0VBQ2I7QUFDRjtBQUlBO0VBQ0UsY0FBYztFQUNkLGtCQUFrQjtFQUNsQixxQkFBcUI7RUFDckIsZUFBZTtFQUNmLHVCQUF1QjtFQUN2QixnQkFBZ0I7RUFDaEIsZ0NBQWdDO0VBQ2hDLGdCQUFnQjtFQUNoQixjQUFjO0FBQ2hCO0FBRUE7RUFDRSxpQkFBaUI7RUFDakIsV0FBVztFQUNYLGVBQWU7RUFDZixlQUFlO0VBQ2YseUJBQXlCO0FBQzNCO0FBRUE7RUFDRSxxQkFBcUI7QUFDdkI7QUFFQTtFQUNFLHNDQUFzQztFQUN0QyxnQkFBZ0I7RUFDaEIsYUFBYTtFQUNiLDhCQUE4QjtFQUM5QixtQkFBbUI7RUFDbkIsZ0NBQWdDOztFQUVoQywwQkFBMEI7RUFDMUIsV0FBVztFQUNYLFlBQVk7RUFDWixXQUFXO0VBQ1gsZUFBZTtFQUNmLE9BQU87RUFDUCxRQUFRO0FBQ1Y7QUFFQTtFQUNFLGVBQWU7RUFDZixNQUFNO0VBQ04sZ0JBQWdCO0VBQ2hCLFdBQVc7QUFDYjtBQUVBO0VBQ0UsbUJBQW1CO0VBQ25CLG1CQUFtQjtFQUNuQixZQUFZO0VBQ1oscUJBQXFCO0FBQ3ZCO0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLHVCQUF1QjtFQUN2QixtQkFBbUI7QUFDckI7QUFFQTtFQUNFLHNCQUFzQjtBQUN4QjtBQUVBO0VBQ0Usc0JBQXNCO0FBQ3hCO0FBRUE7RUFDRSxZQUFZO0VBQ1osaUJBQWlCOztBQUVuQiIsImZpbGUiOiJzcmMvYXBwL3BhZ2VzL2Rhc2hib2FyZC9kYXNoYm9hcmQucGFnZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBUaGUgc2lkZSBuYXZpZ2F0aW9uIG1lbnUgKi9cclxuLnNpZGViYXIge1xyXG4gIG1hcmdpbjogMDtcclxuICBwYWRkaW5nOiAwO1xyXG4gIHdpZHRoOiAyMjBweDtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICBib3JkZXI6IDAuNXB4IHNvbGlkIHZhcigtLXByaW1hcnktY29sb3IpO1xyXG4gIHBvc2l0aW9uOiBmaXhlZDtcclxuICBoZWlnaHQ6IDEwMCU7XHJcbiAgb3ZlcmZsb3c6IGF1dG87XHJcbiAgLyogdG9wOiAwOyAqL1xyXG4gIHotaW5kZXg6IDE7XHJcbiAgcGFkZGluZy10b3A6IDM1cHg7XHJcbn1cclxuXHJcbi5sb2dvX2NvbnRhaW5lcnIge1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxuICBjb2xvcjogIzAwMDtcclxuICBmb250LXdlaWdodDogNjAwO1xyXG4gIC8qIGJvcmRlcjogMXB4IHNvbGlkIHJlZDsgKi9cclxuICAvKiBnYXA6IDFyZW07ICovXHJcbiAgZm9udC1zaXplOiAycmVtO1xyXG59XHJcblxyXG4uYm9pX2xvZ28ge1xyXG4gIG9iamVjdC1maXQ6IGNvbnRhaW47XHJcbiAgaGVpZ2h0OiA1cmVtO1xyXG4gIHdpZHRoOiBmaXQtY29udGVudDtcclxuICAvKiBib3JkZXI6IDFweCBzb2xpZCByZWQ7ICovXHJcbn1cclxuXHJcbi8qIFNpZGViYXIgbGlua3MgKi9cclxuLnNpZGViYXIgYSB7XHJcbiAgZGlzcGxheTogYmxvY2s7XHJcbiAgLyogY29sb3I6ICNmMWYxZjE7IG5leGltICovXHJcbiAgLyogYm9pICovXHJcbiAgY29sb3I6ICMwMDA7XHJcbiAgZm9udC13ZWlnaHQ6IDYwMDtcclxuICBmb250LXNpemU6IDE1cHg7XHJcbiAgLyogbWFyZ2luOiAyMHB4IDBweCAyMHggMHB4OyAqL1xyXG4gIHBhZGRpbmc6IDE2cHg7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4vKiBBY3RpdmUvY3VycmVudCBsaW5rICovXHJcbi5zaWRlYmFyIGEuYWN0aXZlIHtcclxuICBjb2xvcjogIzAwMDtcclxuICBmb250LXdlaWdodDogNjAwO1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICNkOWU4ZGM7XHJcbiAgLyogY29sb3I6dmFyKC0tcHJpbWFyeS1jb2xvcik7IG5leGltICovXHJcbn1cclxuXHJcbi8qIExpbmtzIG9uIG1vdXNlLW92ZXIgKi9cclxuLyogLnNpZGViYXIgYTpob3Zlcjpub3QoLmFjdGl2ZSkge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM1NTU7XHJcbiAgY29sb3I6IHdoaXRlO1xyXG59ICovXHJcblxyXG4vKiBQYWdlIGNvbnRlbnQuIFRoZSB2YWx1ZSBvZiB0aGUgbWFyZ2luLWxlZnQgcHJvcGVydHkgc2hvdWxkIG1hdGNoIHRoZSB2YWx1ZSBvZiB0aGUgc2lkZWJhcidzIHdpZHRoIHByb3BlcnR5ICovXHJcbmRpdi5tYWluIHtcclxuICBtYXJnaW4tbGVmdDogMjQwcHg7XHJcbiAgcGFkZGluZzogMXB4IDE2cHg7XHJcbiAgcGFkZGluZy10b3A6IDQ4cHg7XHJcbiAgLyogaGVpZ2h0OiAxMDAwcHg7ICovXHJcbn1cclxuXHJcbi8qIE9uIHNjcmVlbnMgdGhhdCBhcmUgbGVzcyB0aGFuIDcwMHB4IHdpZGUsIG1ha2UgdGhlIHNpZGViYXIgaW50byBhIHRvcGJhciAqL1xyXG5AbWVkaWEgc2NyZWVuIGFuZCAobWF4LXdpZHRoOiA3MDBweCkge1xyXG4gIC5zaWRlYmFyIHtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiBhdXRvO1xyXG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIH1cclxuXHJcbiAgLnNpZGViYXIgYSB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICB9XHJcblxyXG4gIGRpdi5tYWluIHtcclxuICAgIG1hcmdpbi1sZWZ0OiAwO1xyXG4gICAgcGFkZGluZy10b3A6IGluaXRpYWw7XHJcbiAgfVxyXG59XHJcblxyXG4vKiBPbiBzY3JlZW5zIHRoYXQgYXJlIGxlc3MgdGhhbiA0MDBweCwgZGlzcGxheSB0aGUgYmFyIHZlcnRpY2FsbHksIGluc3RlYWQgb2YgaG9yaXpvbnRhbGx5ICovXHJcbkBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6IDQwMHB4KSB7XHJcbiAgLnNpZGViYXIgYSB7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBmbG9hdDogbm9uZTtcclxuICB9XHJcbn1cclxuXHJcblxyXG5cclxuLnRvcG5hdiBhIHtcclxuICBkaXNwbGF5OiBibG9jaztcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG4gIGZvbnQtc2l6ZTogMThweDtcclxuICBwYWRkaW5nOiAxNHB4IDEwcHggMTJweDtcclxuICBtYXJnaW4tbGVmdDogMHB4O1xyXG4gIGZvbnQtZmFtaWx5OiBSYWxld2F5LCBzYW5zLXNlcmlmO1xyXG4gIG1pbi13aWR0aDogMjEwcHg7XHJcbiAgY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbi50b3BuYXYgYS5sb2dvdXQge1xyXG4gIC8qIGNvbG9yOiAjZmZmOyAqL1xyXG4gIGNvbG9yOiAjMDAwO1xyXG4gIGZvbnQtc2l6ZTogMTZweDtcclxuICBjdXJzb3I6IHBvaW50ZXI7XHJcbiAgdHJhbnNpdGlvbjogMC4wNnMgZWFzZS1pbjtcclxufVxyXG5cclxuLnRvcG5hdiBhLmxvZ291dDpob3ZlciB7XHJcbiAgdHJhbnNmb3JtOiBzY2FsZSgwLjgpO1xyXG59XHJcblxyXG4udG9wbmF2IHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNkOWQ5ZDk7XHJcbiAgO1xyXG4gIC8qIHBhZGRpbmctYm90dG9tOiAyNXB4OyAqL1xyXG4gIC8qIHRvcDogMDsqL1xyXG4gIGhlaWdodDogYXV0bztcclxuICB6LWluZGV4OiA5OTtcclxuICBwb3NpdGlvbjogZml4ZWQ7XHJcbiAgbGVmdDogMDtcclxuICByaWdodDogMDtcclxufVxyXG5cclxuLnN0aWNreSB7XHJcbiAgcG9zaXRpb246IGZpeGVkO1xyXG4gIHRvcDogMDtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIHotaW5kZXg6IDEwO1xyXG59XHJcblxyXG4uZGlzYWJsZWQge1xyXG4gIGNvbG9yOiBjdXJyZW50Q29sb3I7XHJcbiAgY3Vyc29yOiBub3QtYWxsb3dlZDtcclxuICBvcGFjaXR5OiAwLjU7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4ucm93IHtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGZsZXgtZGlyZWN0aW9uOiByb3c7XHJcbiAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxufVxyXG5cclxuYSB7XHJcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxufVxyXG5cclxuYT5tYXQtaWNvbiB7XHJcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxufVxyXG5cclxuaW1nIHtcclxuICB3aWR0aDogMTQwcHg7XHJcbiAgbWFyZ2luLXRvcDogLTEycHg7XHJcblxyXG59XHJcbiJdfQ== */"]
=======
        styles: [".sidebar[_ngcontent-%COMP%] {\r\n  margin: 0;\r\n  padding: 0;\r\n  width: 220px;\r\n  background-color: var(--primary-color);\r\n  border: 0.5px solid var(--primary-color);\r\n  position: fixed;\r\n  height: 100%;\r\n  overflow: auto;\r\n  \r\n  z-index: 1;\r\n  padding-top: 35px;\r\n}\r\n.logo_containerr[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  align-items: center;\r\n  color: #000;\r\n  font-weight: 600;\r\n  \r\n  \r\n  font-size: 2rem;\r\n}\r\n.boi_logo[_ngcontent-%COMP%] {\r\n  object-fit: contain;\r\n  height: 5rem;\r\n  width: -webkit-fit-content;\r\n  width: -moz-fit-content;\r\n  width: fit-content;\r\n  \r\n}\r\n\r\n.sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n  display: block;\r\n  \r\n  \r\n  color: #000;\r\n  \r\n  font-size: 15px;\r\n  \r\n  padding: 16px;\r\n  text-decoration: none;\r\n}\r\n\r\n.sidebar[_ngcontent-%COMP%]   a.active[_ngcontent-%COMP%] {\r\n  color: #000;\r\n  \r\n  background-color: #d9e8dc;\r\n  \r\n}\r\n\r\n\r\n\r\ndiv.main[_ngcontent-%COMP%] {\r\n  margin-left: 240px;\r\n  padding: 1px 16px;\r\n  padding-top: 48px;\r\n  \r\n}\r\n\r\n@media screen and (max-width: 700px) {\r\n  .sidebar[_ngcontent-%COMP%] {\r\n    width: 100%;\r\n    height: auto;\r\n    position: relative;\r\n  }\r\n\r\n  .sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n    float: left;\r\n  }\r\n\r\n  div.main[_ngcontent-%COMP%] {\r\n    margin-left: 0;\r\n    padding-top: initial;\r\n  }\r\n}\r\n\r\n@media screen and (max-width: 400px) {\r\n  .sidebar[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n    text-align: center;\r\n    float: none;\r\n  }\r\n}\r\n.topnav[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n  display: block;\r\n  text-align: center;\r\n  text-decoration: none;\r\n  font-size: 18px;\r\n  padding: 14px 10px 12px;\r\n  margin-left: 0px;\r\n  font-family: Raleway, sans-serif;\r\n  min-width: 210px;\r\n  color: #f1f1f1;\r\n}\r\n.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%] {\r\n  \r\n  color: #000;\r\n  font-size: 16px;\r\n  cursor: pointer;\r\n  transition: 0.06s ease-in;\r\n}\r\n.topnav[_ngcontent-%COMP%]   a.logout[_ngcontent-%COMP%]:hover {\r\n  transform: scale(0.8);\r\n}\r\n.topnav[_ngcontent-%COMP%] {\r\n  background-color: var(--primary-color);\r\n  overflow: hidden;\r\n  display: flex;\r\n  justify-content: space-between;\r\n  align-items: center;\r\n  border-bottom: 1px solid #d9d9d9;\r\n  ;\r\n  \r\n  \r\n  height: auto;\r\n  z-index: 99;\r\n  position: fixed;\r\n  left: 0;\r\n  right: 0;\r\n}\r\n.sticky[_ngcontent-%COMP%] {\r\n  position: fixed;\r\n  top: 0;\r\n  overflow: hidden;\r\n  z-index: 10;\r\n}\r\n.disabled[_ngcontent-%COMP%] {\r\n  color: currentColor;\r\n  cursor: not-allowed;\r\n  opacity: 0.5;\r\n  text-decoration: none;\r\n}\r\n.row[_ngcontent-%COMP%] {\r\n  display: flex;\r\n  flex-direction: row;\r\n  justify-content: center;\r\n  align-items: center;\r\n}\r\na[_ngcontent-%COMP%] {\r\n  vertical-align: middle;\r\n}\r\na[_ngcontent-%COMP%] > mat-icon[_ngcontent-%COMP%] {\r\n  vertical-align: middle;\r\n}\r\nimg[_ngcontent-%COMP%] {\r\n  width: 140px;\r\n  margin-top: -12px;\r\n\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvZGFzaGJvYXJkL2Rhc2hib2FyZC5wYWdlLmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSw2QkFBNkI7QUFDN0I7RUFDRSxTQUFTO0VBQ1QsVUFBVTtFQUNWLFlBQVk7RUFDWixzQ0FBc0M7RUFDdEMsd0NBQXdDO0VBQ3hDLGVBQWU7RUFDZixZQUFZO0VBQ1osY0FBYztFQUNkLFlBQVk7RUFDWixVQUFVO0VBQ1YsaUJBQWlCO0FBQ25CO0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLFdBQVc7RUFDWCxnQkFBZ0I7RUFDaEIsMkJBQTJCO0VBQzNCLGVBQWU7RUFDZixlQUFlO0FBQ2pCO0FBRUE7RUFDRSxtQkFBbUI7RUFDbkIsWUFBWTtFQUNaLDBCQUFrQjtFQUFsQix1QkFBa0I7RUFBbEIsa0JBQWtCO0VBQ2xCLDJCQUEyQjtBQUM3QjtBQUVBLGtCQUFrQjtBQUNsQjtFQUNFLGNBQWM7RUFDZCwwQkFBMEI7RUFDMUIsUUFBUTtFQUNSLFdBQVc7RUFDWCxzQkFBc0I7RUFDdEIsZUFBZTtFQUNmLDhCQUE4QjtFQUM5QixhQUFhO0VBQ2IscUJBQXFCO0FBQ3ZCO0FBRUEsd0JBQXdCO0FBQ3hCO0VBQ0UsV0FBVztFQUNYLHNCQUFzQjtFQUN0Qix5QkFBeUI7RUFDekIsc0NBQXNDO0FBQ3hDO0FBRUEsd0JBQXdCO0FBQ3hCOzs7R0FHRztBQUVILCtHQUErRztBQUMvRztFQUNFLGtCQUFrQjtFQUNsQixpQkFBaUI7RUFDakIsaUJBQWlCO0VBQ2pCLG9CQUFvQjtBQUN0QjtBQUVBLDZFQUE2RTtBQUM3RTtFQUNFO0lBQ0UsV0FBVztJQUNYLFlBQVk7SUFDWixrQkFBa0I7RUFDcEI7O0VBRUE7SUFDRSxXQUFXO0VBQ2I7O0VBRUE7SUFDRSxjQUFjO0lBQ2Qsb0JBQW9CO0VBQ3RCO0FBQ0Y7QUFFQSw2RkFBNkY7QUFDN0Y7RUFDRTtJQUNFLGtCQUFrQjtJQUNsQixXQUFXO0VBQ2I7QUFDRjtBQUlBO0VBQ0UsY0FBYztFQUNkLGtCQUFrQjtFQUNsQixxQkFBcUI7RUFDckIsZUFBZTtFQUNmLHVCQUF1QjtFQUN2QixnQkFBZ0I7RUFDaEIsZ0NBQWdDO0VBQ2hDLGdCQUFnQjtFQUNoQixjQUFjO0FBQ2hCO0FBRUE7RUFDRSxpQkFBaUI7RUFDakIsV0FBVztFQUNYLGVBQWU7RUFDZixlQUFlO0VBQ2YseUJBQXlCO0FBQzNCO0FBRUE7RUFDRSxxQkFBcUI7QUFDdkI7QUFFQTtFQUNFLHNDQUFzQztFQUN0QyxnQkFBZ0I7RUFDaEIsYUFBYTtFQUNiLDhCQUE4QjtFQUM5QixtQkFBbUI7RUFDbkIsZ0NBQWdDOztFQUVoQywwQkFBMEI7RUFDMUIsV0FBVztFQUNYLFlBQVk7RUFDWixXQUFXO0VBQ1gsZUFBZTtFQUNmLE9BQU87RUFDUCxRQUFRO0FBQ1Y7QUFFQTtFQUNFLGVBQWU7RUFDZixNQUFNO0VBQ04sZ0JBQWdCO0VBQ2hCLFdBQVc7QUFDYjtBQUVBO0VBQ0UsbUJBQW1CO0VBQ25CLG1CQUFtQjtFQUNuQixZQUFZO0VBQ1oscUJBQXFCO0FBQ3ZCO0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLHVCQUF1QjtFQUN2QixtQkFBbUI7QUFDckI7QUFFQTtFQUNFLHNCQUFzQjtBQUN4QjtBQUVBO0VBQ0Usc0JBQXNCO0FBQ3hCO0FBRUE7RUFDRSxZQUFZO0VBQ1osaUJBQWlCOztBQUVuQiIsImZpbGUiOiJzcmMvYXBwL3BhZ2VzL2Rhc2hib2FyZC9kYXNoYm9hcmQucGFnZS5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBUaGUgc2lkZSBuYXZpZ2F0aW9uIG1lbnUgKi9cclxuLnNpZGViYXIge1xyXG4gIG1hcmdpbjogMDtcclxuICBwYWRkaW5nOiAwO1xyXG4gIHdpZHRoOiAyMjBweDtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICBib3JkZXI6IDAuNXB4IHNvbGlkIHZhcigtLXByaW1hcnktY29sb3IpO1xyXG4gIHBvc2l0aW9uOiBmaXhlZDtcclxuICBoZWlnaHQ6IDEwMCU7XHJcbiAgb3ZlcmZsb3c6IGF1dG87XHJcbiAgLyogdG9wOiAwOyAqL1xyXG4gIHotaW5kZXg6IDE7XHJcbiAgcGFkZGluZy10b3A6IDM1cHg7XHJcbn1cclxuXHJcbi5sb2dvX2NvbnRhaW5lcnIge1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxuICBjb2xvcjogIzAwMDtcclxuICBmb250LXdlaWdodDogNjAwO1xyXG4gIC8qIGJvcmRlcjogMXB4IHNvbGlkIHJlZDsgKi9cclxuICAvKiBnYXA6IDFyZW07ICovXHJcbiAgZm9udC1zaXplOiAycmVtO1xyXG59XHJcblxyXG4uYm9pX2xvZ28ge1xyXG4gIG9iamVjdC1maXQ6IGNvbnRhaW47XHJcbiAgaGVpZ2h0OiA1cmVtO1xyXG4gIHdpZHRoOiBmaXQtY29udGVudDtcclxuICAvKiBib3JkZXI6IDFweCBzb2xpZCByZWQ7ICovXHJcbn1cclxuXHJcbi8qIFNpZGViYXIgbGlua3MgKi9cclxuLnNpZGViYXIgYSB7XHJcbiAgZGlzcGxheTogYmxvY2s7XHJcbiAgLyogY29sb3I6ICNmMWYxZjE7IG5leGltICovXHJcbiAgLyogYm9pICovXHJcbiAgY29sb3I6ICMwMDA7XHJcbiAgLyogZm9udC13ZWlnaHQ6IDYwMDsgKi9cclxuICBmb250LXNpemU6IDE1cHg7XHJcbiAgLyogbWFyZ2luOiAyMHB4IDBweCAyMHggMHB4OyAqL1xyXG4gIHBhZGRpbmc6IDE2cHg7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4vKiBBY3RpdmUvY3VycmVudCBsaW5rICovXHJcbi5zaWRlYmFyIGEuYWN0aXZlIHtcclxuICBjb2xvcjogIzAwMDtcclxuICAvKiBmb250LXdlaWdodDogNjAwOyAqL1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICNkOWU4ZGM7XHJcbiAgLyogY29sb3I6dmFyKC0tcHJpbWFyeS1jb2xvcik7IG5leGltICovXHJcbn1cclxuXHJcbi8qIExpbmtzIG9uIG1vdXNlLW92ZXIgKi9cclxuLyogLnNpZGViYXIgYTpob3Zlcjpub3QoLmFjdGl2ZSkge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM1NTU7XHJcbiAgY29sb3I6IHdoaXRlO1xyXG59ICovXHJcblxyXG4vKiBQYWdlIGNvbnRlbnQuIFRoZSB2YWx1ZSBvZiB0aGUgbWFyZ2luLWxlZnQgcHJvcGVydHkgc2hvdWxkIG1hdGNoIHRoZSB2YWx1ZSBvZiB0aGUgc2lkZWJhcidzIHdpZHRoIHByb3BlcnR5ICovXHJcbmRpdi5tYWluIHtcclxuICBtYXJnaW4tbGVmdDogMjQwcHg7XHJcbiAgcGFkZGluZzogMXB4IDE2cHg7XHJcbiAgcGFkZGluZy10b3A6IDQ4cHg7XHJcbiAgLyogaGVpZ2h0OiAxMDAwcHg7ICovXHJcbn1cclxuXHJcbi8qIE9uIHNjcmVlbnMgdGhhdCBhcmUgbGVzcyB0aGFuIDcwMHB4IHdpZGUsIG1ha2UgdGhlIHNpZGViYXIgaW50byBhIHRvcGJhciAqL1xyXG5AbWVkaWEgc2NyZWVuIGFuZCAobWF4LXdpZHRoOiA3MDBweCkge1xyXG4gIC5zaWRlYmFyIHtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiBhdXRvO1xyXG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIH1cclxuXHJcbiAgLnNpZGViYXIgYSB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICB9XHJcblxyXG4gIGRpdi5tYWluIHtcclxuICAgIG1hcmdpbi1sZWZ0OiAwO1xyXG4gICAgcGFkZGluZy10b3A6IGluaXRpYWw7XHJcbiAgfVxyXG59XHJcblxyXG4vKiBPbiBzY3JlZW5zIHRoYXQgYXJlIGxlc3MgdGhhbiA0MDBweCwgZGlzcGxheSB0aGUgYmFyIHZlcnRpY2FsbHksIGluc3RlYWQgb2YgaG9yaXpvbnRhbGx5ICovXHJcbkBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6IDQwMHB4KSB7XHJcbiAgLnNpZGViYXIgYSB7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBmbG9hdDogbm9uZTtcclxuICB9XHJcbn1cclxuXHJcblxyXG5cclxuLnRvcG5hdiBhIHtcclxuICBkaXNwbGF5OiBibG9jaztcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG4gIGZvbnQtc2l6ZTogMThweDtcclxuICBwYWRkaW5nOiAxNHB4IDEwcHggMTJweDtcclxuICBtYXJnaW4tbGVmdDogMHB4O1xyXG4gIGZvbnQtZmFtaWx5OiBSYWxld2F5LCBzYW5zLXNlcmlmO1xyXG4gIG1pbi13aWR0aDogMjEwcHg7XHJcbiAgY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbi50b3BuYXYgYS5sb2dvdXQge1xyXG4gIC8qIGNvbG9yOiAjZmZmOyAqL1xyXG4gIGNvbG9yOiAjMDAwO1xyXG4gIGZvbnQtc2l6ZTogMTZweDtcclxuICBjdXJzb3I6IHBvaW50ZXI7XHJcbiAgdHJhbnNpdGlvbjogMC4wNnMgZWFzZS1pbjtcclxufVxyXG5cclxuLnRvcG5hdiBhLmxvZ291dDpob3ZlciB7XHJcbiAgdHJhbnNmb3JtOiBzY2FsZSgwLjgpO1xyXG59XHJcblxyXG4udG9wbmF2IHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xyXG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XHJcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNkOWQ5ZDk7XHJcbiAgO1xyXG4gIC8qIHBhZGRpbmctYm90dG9tOiAyNXB4OyAqL1xyXG4gIC8qIHRvcDogMDsqL1xyXG4gIGhlaWdodDogYXV0bztcclxuICB6LWluZGV4OiA5OTtcclxuICBwb3NpdGlvbjogZml4ZWQ7XHJcbiAgbGVmdDogMDtcclxuICByaWdodDogMDtcclxufVxyXG5cclxuLnN0aWNreSB7XHJcbiAgcG9zaXRpb246IGZpeGVkO1xyXG4gIHRvcDogMDtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIHotaW5kZXg6IDEwO1xyXG59XHJcblxyXG4uZGlzYWJsZWQge1xyXG4gIGNvbG9yOiBjdXJyZW50Q29sb3I7XHJcbiAgY3Vyc29yOiBub3QtYWxsb3dlZDtcclxuICBvcGFjaXR5OiAwLjU7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4ucm93IHtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGZsZXgtZGlyZWN0aW9uOiByb3c7XHJcbiAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxufVxyXG5cclxuYSB7XHJcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxufVxyXG5cclxuYT5tYXQtaWNvbiB7XHJcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxufVxyXG5cclxuaW1nIHtcclxuICB3aWR0aDogMTQwcHg7XHJcbiAgbWFyZ2luLXRvcDogLTEycHg7XHJcblxyXG59XHJcbiJdfQ== */"]
>>>>>>> upstream/main
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DashboardPage, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-dashboard',
            templateUrl: './dashboard.page.html',
            styleUrls: ['./dashboard.page.css']
          }]
        }], function () {
          return [{
            type: src_app_common_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"]
          }, {
            type: _generate_report_report_service__WEBPACK_IMPORTED_MODULE_2__["ReportService"]
          }, {
            type: _main_report_history_service__WEBPACK_IMPORTED_MODULE_3__["ReportHistoryService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "Z70I":
    /*!******************************************************!*\
      !*** ./src/app/pages/main/report-history.service.ts ***!
      \******************************************************/

    /*! exports provided: ReportHistoryService */

    /***/
    function Z70I(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "ReportHistoryService", function () {
        return ReportHistoryService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ../../../environments/environment */
      "AytR");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var ReportHistoryService = /*#__PURE__*/function () {
        function ReportHistoryService(http) {
          _classCallCheck(this, ReportHistoryService);

          this.http = http;
        }

        _createClass(ReportHistoryService, [{
          key: "getReportHistory",
          value: function getReportHistory() {
            return this.http.get("".concat(_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi, "/") + 'activities');
          }
        }, {
          key: "postReportDate",
          value: function postReportDate(date) {
            return this.http.post("".concat(_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi, "/") + 'date', date, {
              responseType: 'text'
            });
          }
        }, {
          key: "postCbnDate",
          value: function postCbnDate(date) {
            return this.http.post("".concat(_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi, "/") + 'cbnDate', date, {
              responseType: 'text'
            });
          } // tslint:disable-next-line:typedef

        }, {
          key: "deleteReportHistory",
          value: function deleteReportHistory(id) {
            return this.http["delete"]("".concat(_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseApi, "/") + 'activity/' + id);
          }
        }]);

        return ReportHistoryService;
      }();

      ReportHistoryService.ɵfac = function ReportHistoryService_Factory(t) {
        return new (t || ReportHistoryService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]));
      };

      ReportHistoryService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: ReportHistoryService,
        factory: ReportHistoryService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ReportHistoryService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "ea/W":
    /*!*************************************************************!*\
      !*** ./src/app/pages/dashboard/dashboard-routing.module.ts ***!
      \*************************************************************/

    /*! exports provided: DashboardRoutingModule */

    /***/
    function eaW(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "DashboardRoutingModule", function () {
        return DashboardRoutingModule;
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


      var src_app_common_authenticated_guard__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! src/app/common/authenticated.guard */
      "iXZC");
      /* harmony import */


      var src_app_common_generate_report_guard__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! src/app/common/generate-report.guard */
      "kN9r");
      /* harmony import */


      var _dashboard_page__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ./dashboard.page */
      "6ckw");

      var routes = [{
        path: '',
        component: _dashboard_page__WEBPACK_IMPORTED_MODULE_4__["DashboardPage"],
        canActivate: [src_app_common_authenticated_guard__WEBPACK_IMPORTED_MODULE_2__["AuthenticatedGuard"]],
        canActivateChild: [src_app_common_authenticated_guard__WEBPACK_IMPORTED_MODULE_2__["AuthenticatedGuard"]],
        children: [{
          path: 'user_settings',
          loadChildren: function loadChildren() {
            return __webpack_require__.e(
            /*! import() | user-settings-user-settings-module */
            "user-settings-user-settings-module").then(__webpack_require__.bind(null,
            /*! ../user-settings/user-settings.module */
            "XAcJ")).then(function (m) {
              return m.UserSettingsModule;
            });
          }
        }, {
          path: 'generate_report',
          loadChildren: function loadChildren() {
            return Promise.all(
            /*! import() | generate-report-generate-report-module */
            [__webpack_require__.e("default~create-user-create-user-module~generate-report-generate-report-module~main-main-module~updat~0b1b9fd2"), __webpack_require__.e("generate-report-generate-report-module")]).then(__webpack_require__.bind(null,
            /*! ../generate-report/generate-report.module */
            "8VTR")).then(function (m) {
              return m.GenerateReportModule;
            });
          },
          canActivate: [src_app_common_generate_report_guard__WEBPACK_IMPORTED_MODULE_3__["GenerateReportGuard"]],
          canActivateChild: [src_app_common_generate_report_guard__WEBPACK_IMPORTED_MODULE_3__["GenerateReportGuard"]]
        }, {
          path: 'doc/:id',
          loadChildren: function loadChildren() {
            return Promise.all(
            /*! import() | xml-viewer-xml-viewer-module */
            [__webpack_require__.e("default~create-user-create-user-module~generate-report-generate-report-module~main-main-module~updat~0b1b9fd2"), __webpack_require__.e("common"), __webpack_require__.e("xml-viewer-xml-viewer-module")]).then(__webpack_require__.bind(null,
            /*! ../xml-viewer/xml-viewer.module */
            "oPuF")).then(function (m) {
              return m.XmlViewerModule;
            });
          }
        }, {
          path: '',
          loadChildren: function loadChildren() {
            return Promise.all(
            /*! import() | main-main-module */
            [__webpack_require__.e("default~generate-report-edit-generate-report-edit-module~generate-report-edit-normal-reports-sheet32~a6d57d43"), __webpack_require__.e("default~create-user-create-user-module~generate-report-generate-report-module~main-main-module~updat~0b1b9fd2"), __webpack_require__.e("default~generate-report-data-generate-report-data-module~main-main-module"), __webpack_require__.e("common"), __webpack_require__.e("main-main-module")]).then(__webpack_require__.bind(null,
            /*! ../main/main.module */
            "82nU")).then(function (m) {
              return m.MainModule;
            });
          },
          pathMatch: 'full'
        }]
      }];

      var DashboardRoutingModule = function DashboardRoutingModule() {
        _classCallCheck(this, DashboardRoutingModule);
      };

      DashboardRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: DashboardRoutingModule
      });
      DashboardRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function DashboardRoutingModule_Factory(t) {
          return new (t || DashboardRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](DashboardRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DashboardRoutingModule, [{
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
    "kN9r":
    /*!*************************************************!*\
      !*** ./src/app/common/generate-report.guard.ts ***!
      \*************************************************/

    /*! exports provided: GenerateReportGuard */

    /***/
    function kN9r(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GenerateReportGuard", function () {
        return GenerateReportGuard;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! rxjs/operators */
      "kU1M");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");
      /* harmony import */


      var _pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../pages/generate-report/report.service */
      "a8X4");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");
      /**
       * this guard route that shouldn't be accessed date is not selected
       */


      var GenerateReportGuard = /*#__PURE__*/function () {
        function GenerateReportGuard(router, reportService, location) {
          _classCallCheck(this, GenerateReportGuard);

          this.router = router;
          this.reportService = reportService;
          this.location = location;
        }

        _createClass(GenerateReportGuard, [{
          key: "canActivate",
          value: function canActivate(next, state) {
            var _this2 = this;

            return this.reportService.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (date) {
              var _a; // const navigationId


              var navigationId = (_a = _this2.location.getState()) === null || _a === void 0 ? void 0 : _a.navigationId;

              if (date !== null && date.length > 0) {
                return true;
              } else if (navigationId === null || navigationId === undefined || navigationId <= 1) {
                _this2.router.navigate(['/']);
              }

              return false;
            }));
          }
        }, {
          key: "canActivateChild",
          value: function canActivateChild(next, state) {
            return this.canActivate(next, state);
          }
        }, {
          key: "canLoad",
          value: function canLoad(route, segments) {
            return this.reportService.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (date) {
              if (date !== null || date.length > 0) {
                return true;
              }

              return false;
            }));
          }
        }]);

        return GenerateReportGuard;
      }();

      GenerateReportGuard.ɵfac = function GenerateReportGuard_Factory(t) {
        return new (t || GenerateReportGuard)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_3__["ReportService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"]));
      };

      GenerateReportGuard.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: GenerateReportGuard,
        factory: GenerateReportGuard.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GenerateReportGuard, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
          }, {
            type: _pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_3__["ReportService"]
          }, {
            type: _angular_common__WEBPACK_IMPORTED_MODULE_4__["Location"]
          }];
        }, null);
      })();
      /***/

    }
  }]);
})();
//# sourceMappingURL=pages-dashboard-dashboard-module-es5.js.map
(function () {
  function _createForOfIteratorHelper(o, allowArrayLike) { var it; if (typeof Symbol === "undefined" || o[Symbol.iterator] == null) { if (Array.isArray(o) || (it = _unsupportedIterableToArray(o)) || allowArrayLike && o && typeof o.length === "number") { if (it) o = it; var i = 0; var F = function F() {}; return { s: F, n: function n() { if (i >= o.length) return { done: true }; return { done: false, value: o[i++] }; }, e: function e(_e) { throw _e; }, f: F }; } throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."); } var normalCompletion = true, didErr = false, err; return { s: function s() { it = o[Symbol.iterator](); }, n: function n() { var step = it.next(); normalCompletion = step.done; return step; }, e: function e(_e2) { didErr = true; err = _e2; }, f: function f() { try { if (!normalCompletion && it["return"] != null) it["return"](); } finally { if (didErr) throw err; } } }; }

  function _unsupportedIterableToArray(o, minLen) { if (!o) return; if (typeof o === "string") return _arrayLikeToArray(o, minLen); var n = Object.prototype.toString.call(o).slice(8, -1); if (n === "Object" && o.constructor) n = o.constructor.name; if (n === "Map" || n === "Set") return Array.from(o); if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return _arrayLikeToArray(o, minLen); }

  function _arrayLikeToArray(arr, len) { if (len == null || len > arr.length) len = arr.length; for (var i = 0, arr2 = new Array(len); i < len; i++) { arr2[i] = arr[i]; } return arr2; }

  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {
    /***/
    0:
    /*!***************************!*\
      !*** multi ./src/main.ts ***!
      \***************************/

    /*! no static exports found */

    /***/
    function _(module, exports, __webpack_require__) {
      module.exports = __webpack_require__(
      /*! C:\Users\Neptune\Documents\New-Efass\src\main.ts */
      "zUnb");
      /***/
    },

    /***/
    "8ILd":
    /*!*************************************************!*\
      !*** ./src/app/common/unauthenticated.guard.ts ***!
      \*************************************************/

    /*! exports provided: UnauthenticatedGuard */

    /***/
    function ILd(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "UnauthenticatedGuard", function () {
        return UnauthenticatedGuard;
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


      var _auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./auth.service */
      "KwcT");
      /**
       * this guard route that shouldn't be accessed when user is authenticated
       */


      var UnauthenticatedGuard = /*#__PURE__*/function () {
        function UnauthenticatedGuard(router, auth) {
          _classCallCheck(this, UnauthenticatedGuard);

          this.router = router;
          this.auth = auth;
        }

        _createClass(UnauthenticatedGuard, [{
          key: "canActivate",
          value: function canActivate(next, state) {
            var _this = this;

            return this.auth.isAuthenticated.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (isAuthenticated) {
              if (isAuthenticated) {
                _this.router.navigateByUrl('/dashboard');
              }

              return !isAuthenticated;
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
            var _this2 = this;

            return this.auth.isAuthenticated.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (isAuthenticated) {
              if (isAuthenticated) {
                _this2.router.navigateByUrl('/dashboard');
              }

              return !isAuthenticated;
            }));
          }
        }]);

        return UnauthenticatedGuard;
      }();

      UnauthenticatedGuard.ɵfac = function UnauthenticatedGuard_Factory(t) {
        return new (t || UnauthenticatedGuard)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]));
      };

      UnauthenticatedGuard.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: UnauthenticatedGuard,
        factory: UnauthenticatedGuard.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UnauthenticatedGuard, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
          }, {
            type: _auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "AytR":
    /*!*****************************************!*\
      !*** ./src/environments/environment.ts ***!
      \*****************************************/

    /*! exports provided: environment */

    /***/
    function AytR(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "environment", function () {
        return environment;
      }); // This file can be replaced during build by using the `fileReplacements` array.
      // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
      // The list of file replacements can be found in `angular.json`.


      var environment = {
        production: false,
        // // // LOCAL
        //  baseUrl: 'http://10.152.2.106:9006',
        //  baseApi: 'http://10.152.2.106:9006/api/v1',
        // FAITH IP 
        // baseUrl: 'http://10.152.2.134:9006',
        // baseApi: 'http://10.152.2.134:9006/api/v1',
        // NEXIM IP You fit check stack, this thing is like a second or 2 slower. anydesk?
        baseUrl: 'http://172.16.1.57:9006',
        baseApi: 'http://172.16.1.57:9006/api/v1'
      };
      /*
       * For easier debugging in development mode, you can import the following file
       * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
       *
       * This import should be commented out in production mode because it will have a negative impact
       * on performance if an error is thrown.
       */
      // import 'zone.js/dist/zone-error';  // Included with Angular CLI.

      /***/
    },

    /***/
    "J3gp":
    /*!********************************!*\
      !*** ./src/app/test/report.ts ***!
      \********************************/

    /*! exports provided: Report */

    /***/
    function J3gp(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Report", function () {
        return Report;
      });

      var Report = function Report(header, body) {
        _classCallCheck(this, Report);

        this.header = header;
        this.body = body;
      };
      /***/

    },

    /***/
    "KwcT":
    /*!****************************************!*\
      !*** ./src/app/common/auth.service.ts ***!
      \****************************************/

    /*! exports provided: AuthService */

    /***/
    function KwcT(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AuthService", function () {
        return AuthService;
      });
      /* harmony import */


      var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! tslib */
      "mrSG");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! rxjs */
      "qCKp");
      /* harmony import */


      var src_environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! src/environments/environment */
      "AytR");
      /* harmony import */


      var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! rxjs/operators */
      "kU1M");
      /* harmony import */


      var _ng_idle_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! @ng-idle/core */
      "+lv+");
      /* harmony import */


      var _pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! ../pages/generate-report/report.service */
      "a8X4");

      var AuthService = /*#__PURE__*/function () {
        function AuthService(httpClient, httpBackend, idle, ngZone, reportService) {
          _classCallCheck(this, AuthService);

          this.httpClient = httpClient;
          this.httpBackend = httpBackend;
          this.idle = idle;
          this.ngZone = ngZone;
          this.reportService = reportService;
          this.$user = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
          this.$isAuthenticated = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](false);
          this.$token = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
          this.USER_AUTH_KEY = '@USER_AUTH_KEY';
          this.httpWithoutInterceptor = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"](httpBackend);
        }

        _createClass(AuthService, [{
          key: "login",
          value: function login(loginData) {
            var _this3 = this;

            return this.httpWithoutInterceptor.post("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl, "/authenticate"), loginData).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["map"])(function (response) {
              _this3.$user.next(response.user);

              _this3.$isAuthenticated.next(true);

              _this3.$token.next(response.token);

              var userAuthData = {
                user: response.user,
                token: response.token
              };
              var userAuthStringData = JSON.stringify(userAuthData);
              localStorage.setItem(_this3.USER_AUTH_KEY, userAuthStringData);

              _this3.autoLogout();

              return true;
            }, function (err) {
              return Object(tslib__WEBPACK_IMPORTED_MODULE_0__["__awaiter"])(_this3, void 0, void 0, /*#__PURE__*/regeneratorRuntime.mark(function _callee() {
                return regeneratorRuntime.wrap(function _callee$(_context) {
                  while (1) {
                    switch (_context.prev = _context.next) {
                      case 0:
                        this.$user.next(null);
                        this.$isAuthenticated.next(false);
                        this.$token.next(null);
                        return _context.abrupt("return", false);

                      case 4:
                      case "end":
                        return _context.stop();
                    }
                  }
                }, _callee, this);
              }));
            }));
          }
        }, {
          key: "autoLogin",
          value: function autoLogin() {
            var userData = JSON.parse(localStorage.getItem(this.USER_AUTH_KEY));

            if ((userData === null || userData === void 0 ? void 0 : userData.token) && (userData === null || userData === void 0 ? void 0 : userData.user)) {
              this.$user.next(userData.user);
              this.$token.next(userData.token);
              this.$isAuthenticated.next(true);
              this.autoLogout();
            } else {
              this.$user.next(null);
              this.$token.next(null);
              this.$isAuthenticated.next(false);
            }
          }
        }, {
          key: "logout",
          value: function logout() {
            this.reportService.clearReportDate();
            localStorage.removeItem(this.USER_AUTH_KEY);
            this.$user.next(null);
            this.$token.next(null);
            this.$isAuthenticated.next(false);
          }
        }, {
          key: "autoLogout",
          value: function autoLogout() {
            var _this4 = this;

            this.idle.onTimeout.subscribe(function () {
              _this4.ngZone.run(function () {
                _this4.logout();
              });
            });
            this.idle.setTimeout(60);
            this.idle.setInterrupts(_ng_idle_core__WEBPACK_IMPORTED_MODULE_6__["DEFAULT_INTERRUPTSOURCES"]);
            this.idle.watch();
          }
        }, {
          key: "user",
          get: function get() {
            return this.$user.asObservable();
          }
        }, {
          key: "isAuthenticated",
          get: function get() {
            return this.$isAuthenticated.asObservable();
          }
        }, {
          key: "token",
          get: function get() {
            return this.$token.asObservable();
          }
        }]);

        return AuthService;
      }();

      AuthService.ɵfac = function AuthService_Factory(t) {
        return new (t || AuthService)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpBackend"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_ng_idle_core__WEBPACK_IMPORTED_MODULE_6__["Idle"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgZone"]), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_7__["ReportService"]));
      };

      AuthService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjectable"]({
        token: AuthService,
        factory: AuthService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](AuthService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]
          }, {
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpBackend"]
          }, {
            type: _ng_idle_core__WEBPACK_IMPORTED_MODULE_6__["Idle"]
          }, {
            type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["NgZone"]
          }, {
            type: _pages_generate_report_report_service__WEBPACK_IMPORTED_MODULE_7__["ReportService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "Sy1n":
    /*!**********************************!*\
      !*** ./src/app/app.component.ts ***!
      \**********************************/

    /*! exports provided: AppComponent */

    /***/
    function Sy1n(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
        return AppComponent;
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


      var _common_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./common/auth.service */
      "KwcT");
      /* harmony import */


      var _general_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./general.service */
      "j8bs");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");

      function AppComponent_div_1_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "div", 2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      var AppComponent = /*#__PURE__*/function () {
        function AppComponent(router, authService, generalService) {
          _classCallCheck(this, AppComponent);

          this.router = router;
          this.authService = authService;
          this.generalService = generalService;
          this.title = 'efass-frontend';
          this.showOverLaySpinner = false;
        }

        _createClass(AppComponent, [{
          key: "ngOnInit",
          value: function ngOnInit() {
            var _this5 = this;

            this.authService.autoLogin();
            this.authService.isAuthenticated.subscribe(function (isAuthenticated) {
              if (!isAuthenticated) {
                _this5.router.navigate(['/']);
              } else {
                _this5.blockUISub$ = _this5.generalService.blockUI.subscribe(function (value) {
                  _this5.showOverLaySpinner = value;
                });
              }
            });
          }
        }, {
          key: "ngOnDestroy",
          value: function ngOnDestroy() {
            if (this.blockUISub$) {
              this.blockUISub$.unsubscribe();
            }
          }
        }]);

        return AppComponent;
      }();

      AppComponent.ɵfac = function AppComponent_Factory(t) {
        return new (t || AppComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_common_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_general_service__WEBPACK_IMPORTED_MODULE_3__["GeneralService"]));
      };

      AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: AppComponent,
        selectors: [["app-root"]],
        decls: 2,
        vars: 1,
        consts: [["class", "ui-overlay", 4, "ngIf"], [1, "ui-overlay"], [1, "loadingSpinner"]],
        template: function AppComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "router-outlet");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, AppComponent_div_1_Template, 2, 0, "div", 0);
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showOverLaySpinner);
          }
        },
        directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"]],
        styles: ["div.ui-overlay[_ngcontent-%COMP%] {\r\n    position: absolute;\r\n    background-color: rgba(0, 0, 0, 0.3);\r\n    top: 0;\r\n    bottom: 0;\r\n    right: 0;\r\n    left: 0;\r\n    display: flex;\r\n    justify-content: center;\r\n    align-items: center;\r\n}\r\n\r\n.loadingSpinner[_ngcontent-%COMP%] {\r\n    width: 80px;\r\n    height: 80px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxrQkFBa0I7SUFDbEIsb0NBQW9DO0lBQ3BDLE1BQU07SUFDTixTQUFTO0lBQ1QsUUFBUTtJQUNSLE9BQU87SUFDUCxhQUFhO0lBQ2IsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtBQUN2Qjs7QUFFQTtJQUNJLFdBQVc7SUFDWCxZQUFZO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJkaXYudWktb3ZlcmxheSB7XHJcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiByZ2JhKDAsIDAsIDAsIDAuMyk7XHJcbiAgICB0b3A6IDA7XHJcbiAgICBib3R0b206IDA7XHJcbiAgICByaWdodDogMDtcclxuICAgIGxlZnQ6IDA7XHJcbiAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xyXG59XHJcblxyXG4ubG9hZGluZ1NwaW5uZXIge1xyXG4gICAgd2lkdGg6IDgwcHg7XHJcbiAgICBoZWlnaHQ6IDgwcHg7XHJcbn0iXX0= */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-root',
            templateUrl: './app.component.html',
            styleUrls: ['./app.component.css']
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]
          }, {
            type: _common_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"]
          }, {
            type: _general_service__WEBPACK_IMPORTED_MODULE_3__["GeneralService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "V+oM":
    /*!********************************!*\
      !*** ./src/app/test/header.ts ***!
      \********************************/

    /*! exports provided: Header */

    /***/
    function VOM(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Header", function () {
        return Header;
      });

      var Header = function Header(bankCode, bankName, returnCode, returnName, periodFrom, periodEnd, ver, signed, lng) {
        _classCallCheck(this, Header);

        this.bankCode = bankCode;
        this.bankName = bankName;
        this.returnCode = returnCode;
        this.returnName = returnName;
        this.periodFrom = periodFrom;
        this.periodEnd = periodEnd;
        this.ver = ver;
        this.signed = signed;
        this.lng = lng;
      };
      /***/

    },

    /***/
    "ZAI4":
    /*!*******************************!*\
      !*** ./src/app/app.module.ts ***!
      \*******************************/

    /*! exports provided: AppModule */

    /***/
    function ZAI4(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppModule", function () {
        return AppModule;
      });
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app-routing.module */
      "vY5A");
      /* harmony import */


      var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./app.component */
      "Sy1n");
      /* harmony import */


      var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/forms */
      "3Pt+");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _common_token_interceptor_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! ./common/token-interceptor.service */
      "xDej");
      /* harmony import */


      var _ng_idle_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @ng-idle/core */
      "+lv+");
      /* harmony import */


      var ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! ngx-doc-viewer */
      "w4ga");
      /* harmony import */


      var _angular_material_icon__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! @angular/material/icon */
      "Tj54");
      /* harmony import */


      var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! @angular/material/paginator */
      "M9IT");
      /* harmony import */


      var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/platform-browser/animations */
      "omvX");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(
      /*! @angular/material/input */
      "e6WT");
      /* harmony import */


      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(
      /*! @angular/material/form-field */
      "kmnG");
      /* harmony import */


      var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(
      /*! @angular/material/datepicker */
      "TN/R");
      /* harmony import */


      var _angular_material_core__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(
      /*! @angular/material/core */
      "FKr1");
      /* harmony import */


      var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(
      /*! @angular/material/snack-bar */
      "zHaW");

      var AppModule = function AppModule() {
        _classCallCheck(this, AppModule);
      };

      AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({
        type: AppModule,
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
      });
      AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({
        factory: function AppModule_Factory(t) {
          return new (t || AppModule)();
        },
        providers: [{
          provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"],
          useClass: _common_token_interceptor_service__WEBPACK_IMPORTED_MODULE_6__["RefreshTokenInterceptor"],
          multi: true
        }],
        imports: [[_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"], _ng_idle_core__WEBPACK_IMPORTED_MODULE_7__["NgIdleModule"].forRoot(), ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_8__["NgxDocViewerModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_9__["MatIconModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_10__["MatPaginatorModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_12__["MatInputModule"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_14__["MatDatepickerModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_15__["MatNativeDateModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_16__["MatSnackBarModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](AppModule, {
          declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
          imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"], _ng_idle_core__WEBPACK_IMPORTED_MODULE_7__["NgIdleModule"], ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_8__["NgxDocViewerModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_9__["MatIconModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_10__["MatPaginatorModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_12__["MatInputModule"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_14__["MatDatepickerModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_15__["MatNativeDateModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_16__["MatSnackBarModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](AppModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
          args: [{
            declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"], _ng_idle_core__WEBPACK_IMPORTED_MODULE_7__["NgIdleModule"].forRoot(), ngx_doc_viewer__WEBPACK_IMPORTED_MODULE_8__["NgxDocViewerModule"], _angular_material_icon__WEBPACK_IMPORTED_MODULE_9__["MatIconModule"], _angular_material_paginator__WEBPACK_IMPORTED_MODULE_10__["MatPaginatorModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_12__["MatInputModule"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_14__["MatDatepickerModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_15__["MatNativeDateModule"], _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_16__["MatSnackBarModule"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"]],
            providers: [{
              provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"],
              useClass: _common_token_interceptor_service__WEBPACK_IMPORTED_MODULE_6__["RefreshTokenInterceptor"],
              multi: true
            }],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "a8X4":
    /*!*********************************************************!*\
      !*** ./src/app/pages/generate-report/report.service.ts ***!
      \*********************************************************/

    /*! exports provided: ReportService */

    /***/
    function a8X4(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "ReportService", function () {
        return ReportService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! rxjs */
      "qCKp");
      /* harmony import */


      var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! rxjs/operators */
      "kU1M");
      /* harmony import */


      var src_environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! src/environments/environment */
      "AytR");
      /* harmony import */


      var src_app_test_item__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! src/app/test/item */
      "lAJI");
      /* harmony import */


      var src_app_test_body__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! src/app/test/body */
      "hVyH");
      /* harmony import */


      var src_app_test_header__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! src/app/test/header */
      "V+oM");
      /* harmony import */


      var src_app_test_report__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! src/app/test/report */
      "J3gp");
      /* harmony import */


      var jstoxml__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! jstoxml */
      "/VK+");
      /* harmony import */


      var jstoxml__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(jstoxml__WEBPACK_IMPORTED_MODULE_8__);
      /* harmony import */


      var jszip__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! jszip */
      "xOOu");
      /* harmony import */


      var jszip__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(jszip__WEBPACK_IMPORTED_MODULE_9__);
      /* harmony import */


      var file_saver__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! file-saver */
      "Iab2");
      /* harmony import */


      var file_saver__WEBPACK_IMPORTED_MODULE_10___default = /*#__PURE__*/__webpack_require__.n(file_saver__WEBPACK_IMPORTED_MODULE_10__);
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var ReportService = /*#__PURE__*/function () {
        function ReportService(http) {
          _classCallCheck(this, ReportService);

          this.http = http;
          this.tableData = null;
          this.$reportData = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
          this.$reportSelectedDate = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
          this.$fileId = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
          this.sheetData = null;
          this._filedId = '';
          this.item1 = new src_app_test_item__WEBPACK_IMPORTED_MODULE_4__["Item"]('2001', 'Test Code 1', 45000);
          this.item2 = new src_app_test_item__WEBPACK_IMPORTED_MODULE_4__["Item"]('2002', 'Test Code 2', 75000);
          this.item3 = new src_app_test_item__WEBPACK_IMPORTED_MODULE_4__["Item"]('2003', 'Test Code 3', 56000);
          this.item4 = new src_app_test_item__WEBPACK_IMPORTED_MODULE_4__["Item"]('2004', 'Test Code 4', 50000);
          this.item5 = new src_app_test_item__WEBPACK_IMPORTED_MODULE_4__["Item"]('2005', 'Test Code 5', 15000);
          this.items = [this.item1, this.item2, this.item3, this.item4, this.item5];
          this.header1 = new src_app_test_header__WEBPACK_IMPORTED_MODULE_6__["Header"]('00405', 'NIGERIAN EXPORT IMPORT BANK (NEXIM)', 'MDFIR300', 'SCHEDULE OF QUOTED EQUITY INVESTMENTS', '01/04/2021', '30/06/2021', 'ORIG', '', 'en_US');
          this.body1 = new src_app_test_body__WEBPACK_IMPORTED_MODULE_5__["Body"]('MDFIR300', 'Monthly Statement of Assets and Liabilities', this.items);
          this.header2 = new src_app_test_header__WEBPACK_IMPORTED_MODULE_6__["Header"]('00405', 'NIGERIAN EXPORT IMPORT BANK (NEXIM)', 'MDFIR1000', 'SCHEDULE OF QUOTED EQUITY INVESTMENTS', '01/04/2021', '30/06/2021', 'ORIG', '', 'en_US');
          this.body2 = new src_app_test_body__WEBPACK_IMPORTED_MODULE_5__["Body"]('MDFIR1000', 'Monthly Statement of Assets and Liabilities', this.items);
          this.header3 = new src_app_test_header__WEBPACK_IMPORTED_MODULE_6__["Header"]('00405', 'NIGERIAN EXPORT IMPORT BANK (NEXIM)', 'MDFIR1200', 'SCHEDULE OF QUOTED EQUITY INVESTMENTS', '01/04/2021', '30/06/2021', 'ORIG', '', 'en_US');
          this.body3 = new src_app_test_body__WEBPACK_IMPORTED_MODULE_5__["Body"]('MDFIR1200', 'Monthly Statement of Assets and Liabilities', this.items);
          this.reports = [new src_app_test_report__WEBPACK_IMPORTED_MODULE_7__["Report"](this.header1, this.body1), new src_app_test_report__WEBPACK_IMPORTED_MODULE_7__["Report"](this.header2, this.body2), new src_app_test_report__WEBPACK_IMPORTED_MODULE_7__["Report"](this.header3, this.body3), new src_app_test_report__WEBPACK_IMPORTED_MODULE_7__["Report"](this.header1, this.body1), new src_app_test_report__WEBPACK_IMPORTED_MODULE_7__["Report"](this.header2, this.body2)];
        }

        _createClass(ReportService, [{
          key: "getSheetData",
          value: function getSheetData(sheetName) {
            var _this6 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this6.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/").concat(sheetName.toLowerCase(), "/").concat(date));
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              var sheetData = null;
              var columns = response.columnNames; // const editable = response.editable;

              for (var key in response) {
                if (Object.prototype.hasOwnProperty.call(response, key)) {
                  if (key !== 'responseCode' && key !== 'responseMessage' && key.toLowerCase().includes('sheet')) {
                    sheetData = response[key];
                  }
                }
              } // editable


              return {
                sheetData: sheetData,
                columns: columns
              };
            }));
          }
        }, {
          key: "setReportGroup",
          value: function setReportGroup(group) {
            this.reportGroup = group;
            return this.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/tableList/").concat(this.reportGroup));
          }
        }, {
          key: "getReportGroup",
          value: function getReportGroup() {
            return this.reportGroup;
          }
        }, {
          key: "getReports",
          value: function getReports(reportType) {
            var _this7 = this;

            this.$reportData.next(null);
            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this7.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/tableList/") + _this7.reportGroup);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              _this7.$reportData.next(response.data);

              _this7.tableData = response.data;
              console.log("Inside Service: ", response.data);
              return response.data;
            }));
          } // new get reports

        }, {
          key: "getReportByGroup",
          value: function getReportByGroup(reportType) {
            var _this8 = this;

            this.$reportData.next(null);
            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this8.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/tableList/").concat(reportType, "/").concat(_this8.reportGroup));
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              _this8.$reportData.next(response.data);

              _this8.tableData = response.data;
              console.log(response.data);
              return response.data;
            }));
          }
        }, {
          key: "updateSheet",
          value: function updateSheet(data, sheetType) {
            var _this9 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this9.http.put("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/").concat(sheetType.toLowerCase(), "/").concat(date, "/").concat(data.id), data);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              for (var key in response) {
                if (Object.prototype.hasOwnProperty.call(response, key)) {
                  if (key !== 'responseCode' && key !== 'responseMessage' && key.toLowerCase().includes('data')) {
                    return response[key];
                  }
                }
              }
            }));
          }
        }, {
          key: "updateSpecialSheet",
          value: function updateSpecialSheet(id, body, sheetType, length, code) {
            var _this10 = this;

            console.log(id, body, sheetType, code);
            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this10.http.put("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/").concat(sheetType.toLowerCase(), "/").concat(date, "/").concat(id), Object.assign(Object.assign({}, body), {
                code: code
              }));
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              for (var key in response) {
                if (Object.prototype.hasOwnProperty.call(response, key)) {
                  if (key !== 'responseCode' && key !== 'responseMessage' && key.toLowerCase().includes('data')) {
                    return response[key];
                  }
                }
              }
            }));
          }
        }, {
          key: "getTableData",
          value: function getTableData() {
            return this.tableData;
          }
        }, {
          key: "createData",
          value: function createData(data, sheetType) {
            var _this11 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this11.http.post("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/").concat(sheetType.toLowerCase(), "/").concat(date), data);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              for (var key in response) {
                if (key !== 'responseCode' && key !== 'responseMessage' && key.toLowerCase().includes('data')) {
                  return response[key];
                }
              }
            }));
          }
        }, {
          key: "deleteData",
          value: function deleteData(data, sheetType) {
            var _this12 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this12.http["delete"]("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/").concat(sheetType.toLowerCase(), "/").concat(date, "/").concat(data.id));
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (responseMessage) {
              return responseMessage;
            }));
          }
        }, {
          key: "setReportDate",
          value: function setReportDate(date) {
            this.$reportSelectedDate.next(date);
          }
        }, {
          key: "saveReportDate",
          value: function saveReportDate() {
            var _this13 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              return _this13.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/report/date/").concat(date)).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (res) {
                // this.$fileId.next(res.fileId);
                // this._filedId = res.fileId;
                return res;
              }));
            }));
          }
        }, {
          key: "clearReportDate",
          value: function clearReportDate() {
            this.$reportSelectedDate.next('');
          }
        }, {
          key: "generateReport",
          value: function generateReport() {
            var _this14 = this;

            return this.selectedDate.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (date) {
              if (date) {
                return _this14.http.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/generate/").concat(date, "/").concat(_this14._filedId));
              }

              throw new Error('Date not selected');
            }));
          }
        }, {
          key: "testGenerateReport",
          value: function testGenerateReport() {
            var zip = new jszip__WEBPACK_IMPORTED_MODULE_9__();
            var options = {
              header: true,
              indent: ' '
            };

            var _iterator = _createForOfIteratorHelper(this.reports),
                _step;

            try {
              for (_iterator.s(); !(_step = _iterator.n()).done;) {
                var report = _step.value;
                var rep = Object(jstoxml__WEBPACK_IMPORTED_MODULE_8__["toXML"])(report, options);
                var blob = new Blob([rep], {
                  type: "application/xml;charset=utf-8"
                });
                zip.file(report.header.returnCode + ".xml", blob);
              }
            } catch (err) {
              _iterator.e(err);
            } finally {
              _iterator.f();
            }

            var date = new Date().toLocaleDateString();
            zip.generateAsync({
              type: "blob"
            }).then(function (content) {
              // jstoxml, jszip, file-saver
              Object(file_saver__WEBPACK_IMPORTED_MODULE_10__["saveAs"])(content, "Reports Generated on " + date + ".zip");
            });
          }
        }, {
          key: "testGenerateReportsSpecific",
          value: function testGenerateReportsSpecific(reports) {
            var zip = new jszip__WEBPACK_IMPORTED_MODULE_9__();
            var options = {
              header: true,
              indent: ' '
            };

            if (reports.length <= 0) {
              reports = this.reports;
            }

            var _iterator2 = _createForOfIteratorHelper(reports),
                _step2;

            try {
              for (_iterator2.s(); !(_step2 = _iterator2.n()).done;) {
                var report = _step2.value;
                var rep = Object(jstoxml__WEBPACK_IMPORTED_MODULE_8__["toXML"])(report, options);
                var blob = new Blob([rep], {
                  type: "application/xml;charset=utf-8"
                });
                zip.file(report.header.returnCode + ".xml", blob);
              }
            } catch (err) {
              _iterator2.e(err);
            } finally {
              _iterator2.f();
            }

            var date = new Date().toLocaleDateString();
            zip.generateAsync({
              type: "blob"
            }).then(function (content) {
              // jstoxml, jszip, file-saver
              Object(file_saver__WEBPACK_IMPORTED_MODULE_10__["saveAs"])(content, "Reports Generated on " + date + ".zip");
            });
          }
        }, {
          key: "testGenerateSingleReport",
          value: function testGenerateSingleReport(report) {
            var zip = new jszip__WEBPACK_IMPORTED_MODULE_9__();
            var options = {
              header: true,
              indent: ' '
            };
            var rep = Object(jstoxml__WEBPACK_IMPORTED_MODULE_8__["toXML"])(report, options);
            var blob = new Blob([rep], {
              type: "application/xml;charset=utf-8"
            });
            zip.file(report.header.returnCode + ".xml", blob);
            var date = new Date().toLocaleDateString();
            zip.generateAsync({
              type: "blob"
            }).then(function (content) {
              // jstoxml, jszip, file-saver
              Object(file_saver__WEBPACK_IMPORTED_MODULE_10__["saveAs"])(content, "Reports Generated on " + date + ".zip");
            });
          }
        }, {
          key: "testGenerateReportsCheck",
          value: function testGenerateReportsCheck(reports) {
            var _this15 = this;

            this.reportData.subscribe(function (_reportData) {
              _this15.reportsHolder = _reportData;
            });
            var zip = new jszip__WEBPACK_IMPORTED_MODULE_9__();
            var options = {
              header: true,
              indent: ' '
            };

            if (reports.length <= 0) {
              reports = this.reportsHolder;
            }

            var _iterator3 = _createForOfIteratorHelper(reports),
                _step3;

            try {
              for (_iterator3.s(); !(_step3 = _iterator3.n()).done;) {
                var report = _step3.value;
                var rep = Object(jstoxml__WEBPACK_IMPORTED_MODULE_8__["toXML"])(report, options);
                var blob = new Blob([rep], {
                  type: "application/xml;charset=utf-8"
                });
                zip.file(report.sheetNumber + ".xml", blob);
              }
            } catch (err) {
              _iterator3.e(err);
            } finally {
              _iterator3.f();
            }

            var date = new Date().toLocaleDateString();
            zip.generateAsync({
              type: "blob"
            }).then(function (content) {
              // jstoxml, jszip, file-saver
              Object(file_saver__WEBPACK_IMPORTED_MODULE_10__["saveAs"])(content, "Reports Generated on " + date + ".zip");
            });
          }
        }, {
          key: "reportData",
          get: function get() {
            return this.$reportData.asObservable();
          }
        }, {
          key: "selectedDate",
          get: function get() {
            return this.$reportSelectedDate.asObservable();
          }
        }, {
          key: "fileId",
          get: function get() {
            return this.$fileId.asObservable();
          }
        }]);

        return ReportService;
      }();

      ReportService.ɵfac = function ReportService_Factory(t) {
        return new (t || ReportService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"]));
      };

      ReportService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: ReportService,
        factory: ReportService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ReportService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "hVyH":
    /*!******************************!*\
      !*** ./src/app/test/body.ts ***!
      \******************************/

    /*! exports provided: Body */

    /***/
    function hVyH(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Body", function () {
        return Body;
      });

      var Body = function Body(reportCode, description, item) {
        _classCallCheck(this, Body);

        this.reportCode = reportCode;
        this.description = description;
        this.item = item;
      };
      /***/

    },

    /***/
    "iXZC":
    /*!***********************************************!*\
      !*** ./src/app/common/authenticated.guard.ts ***!
      \***********************************************/

    /*! exports provided: AuthenticatedGuard */

    /***/
    function iXZC(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AuthenticatedGuard", function () {
        return AuthenticatedGuard;
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


      var _auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./auth.service */
      "KwcT");
      /**
       * This guard route that shouldn't be accessed when user is not authenticated
       */


      var AuthenticatedGuard = /*#__PURE__*/function () {
        function AuthenticatedGuard(router, auth) {
          _classCallCheck(this, AuthenticatedGuard);

          this.router = router;
          this.auth = auth;
        }

        _createClass(AuthenticatedGuard, [{
          key: "canActivate",
          value: function canActivate(next, state) {
            var _this16 = this;

            return this.auth.isAuthenticated.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (isAuthenticated) {
              if (!isAuthenticated) {
                _this16.router.navigateByUrl('/');
              }

              return isAuthenticated;
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
            var _this17 = this;

            return this.auth.isAuthenticated.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (isAuthenticated) {
              if (!isAuthenticated) {
                _this17.router.navigateByUrl('/');
              }

              return isAuthenticated;
            }));
          }
        }]);

        return AuthenticatedGuard;
      }();

      AuthenticatedGuard.ɵfac = function AuthenticatedGuard_Factory(t) {
        return new (t || AuthenticatedGuard)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]));
      };

      AuthenticatedGuard.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: AuthenticatedGuard,
        factory: AuthenticatedGuard.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AuthenticatedGuard, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
          }, {
            type: _auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "j8bs":
    /*!************************************!*\
      !*** ./src/app/general.service.ts ***!
      \************************************/

    /*! exports provided: GeneralService */

    /***/
    function j8bs(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "GeneralService", function () {
        return GeneralService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! rxjs */
      "qCKp");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var GeneralService = /*#__PURE__*/function () {
        function GeneralService(http) {
          _classCallCheck(this, GeneralService);

          this.http = http;
          this.blockUI$ = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](false);
        }

        _createClass(GeneralService, [{
          key: "updateBlockedUI",
          value: function updateBlockedUI(block) {
            this.blockUI$.next(block);
          }
        }, {
          key: "blockUI",
          get: function get() {
            return this.blockUI$.asObservable();
          }
        }]);

        return GeneralService;
      }();

      GeneralService.ɵfac = function GeneralService_Factory(t) {
        return new (t || GeneralService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]));
      };

      GeneralService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: GeneralService,
        factory: GeneralService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GeneralService, [{
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
    "lAJI":
    /*!******************************!*\
      !*** ./src/app/test/item.ts ***!
      \******************************/

    /*! exports provided: Item */

    /***/
    function lAJI(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Item", function () {
        return Item;
      });

      var Item = function Item(code, description, amount) {
        _classCallCheck(this, Item);

        this.code = code;
        this.description = description;
        this.amount = amount;
      };
      /***/

    },

    /***/
    "vY5A":
    /*!***************************************!*\
      !*** ./src/app/app-routing.module.ts ***!
      \***************************************/

    /*! exports provided: AppRoutingModule */

    /***/
    function vY5A(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
        return AppRoutingModule;
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


      var _common_authenticated_guard__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./common/authenticated.guard */
      "iXZC");
      /* harmony import */


      var _common_unauthenticated_guard__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./common/unauthenticated.guard */
      "8ILd");

      var routes = [{
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
      }, {
        path: 'login',
        loadChildren: function loadChildren() {
          return __webpack_require__.e(
          /*! import() | pages-login-login-module */
          "pages-login-login-module").then(__webpack_require__.bind(null,
          /*! ./pages/login/login.module */
          "F4UR")).then(function (m) {
            return m.LoginModule;
          });
        },
        canActivate: [_common_unauthenticated_guard__WEBPACK_IMPORTED_MODULE_3__["UnauthenticatedGuard"]]
      }, // tslint:disable-next-line: max-line-length
      {
        path: 'dashboard',
        canLoad: [_common_authenticated_guard__WEBPACK_IMPORTED_MODULE_2__["AuthenticatedGuard"]],
        loadChildren: function loadChildren() {
          return __webpack_require__.e(
          /*! import() | pages-dashboard-dashboard-module */
          "pages-dashboard-dashboard-module").then(__webpack_require__.bind(null,
          /*! ./pages/dashboard/dashboard.module */
          "/2RN")).then(function (m) {
            return m.DashboardModule;
          });
        }
      }];

      var AppRoutingModule = function AppRoutingModule() {
        _classCallCheck(this, AppRoutingModule);
      };

      AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: AppRoutingModule
      });
      AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function AppRoutingModule_Factory(t) {
          return new (t || AppRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "xDej":
    /*!*****************************************************!*\
      !*** ./src/app/common/token-interceptor.service.ts ***!
      \*****************************************************/

    /*! exports provided: RefreshTokenInterceptor */

    /***/
    function xDej(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "RefreshTokenInterceptor", function () {
        return RefreshTokenInterceptor;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! rxjs */
      "qCKp");
      /* harmony import */


      var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! rxjs/operators */
      "kU1M");
      /* harmony import */


      var _auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./auth.service */
      "KwcT");

      var RefreshTokenInterceptor = /*#__PURE__*/function () {
        function RefreshTokenInterceptor(auth) {
          _classCallCheck(this, RefreshTokenInterceptor);

          this.auth = auth;
          this.refreshTokenInProgress = false;
          this.refreshTokenSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
        }

        _createClass(RefreshTokenInterceptor, [{
          key: "intercept",
          value: function intercept(request, next) {
            var _this18 = this;

            return this.auth.token.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (token) {
              request = _this18.addToken(request, token);
              return next.handle(request).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
                if (error.status !== 401) {
                  return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error);
                }

                _this18.auth.logout();

                return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); // return this.handle401Error(request, next);
              }));
            }));
          }
        }, {
          key: "addToken",
          value: function addToken(request, token) {
            return request.clone({
              setHeaders: {
                Authorization: 'Bearer ' + token
              }
            });
          }
        }]);

        return RefreshTokenInterceptor;
      }();

      RefreshTokenInterceptor.ɵfac = function RefreshTokenInterceptor_Factory(t) {
        return new (t || RefreshTokenInterceptor)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]));
      };

      RefreshTokenInterceptor.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: RefreshTokenInterceptor,
        factory: RefreshTokenInterceptor.ɵfac
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](RefreshTokenInterceptor, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"]
        }], function () {
          return [{
            type: _auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "zUnb":
    /*!*********************!*\
      !*** ./src/main.ts ***!
      \*********************/

    /*! no exports provided */

    /***/
    function zUnb(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./environments/environment */
      "AytR");
      /* harmony import */


      var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app/app.module */
      "ZAI4");
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");

      if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
      }

      _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])["catch"](function (err) {
        return console.error(err);
      });
      /***/

    },

    /***/
    "zn8P":
    /*!******************************************************!*\
      !*** ./$$_lazy_route_resource lazy namespace object ***!
      \******************************************************/

    /*! no static exports found */

    /***/
    function zn8P(module, exports) {
      function webpackEmptyAsyncContext(req) {
        // Here Promise.resolve().then() is used instead of new Promise() to prevent
        // uncaught exception popping up in devtools
        return Promise.resolve().then(function () {
          var e = new Error("Cannot find module '" + req + "'");
          e.code = 'MODULE_NOT_FOUND';
          throw e;
        });
      }

      webpackEmptyAsyncContext.keys = function () {
        return [];
      };

      webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
      module.exports = webpackEmptyAsyncContext;
      webpackEmptyAsyncContext.id = "zn8P";
      /***/
    }
  }, [[0, "runtime", "vendor"]]]);
})();
//# sourceMappingURL=main-es5.js.map
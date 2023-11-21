(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["common"], {
    /***/
    "DRSI":
    /*!********************************************************!*\
      !*** ./src/app/pages/xml-viewer/xml-viewer.service.ts ***!
      \********************************************************/

    /*! exports provided: XmlViewerService */

    /***/
    function DRSI(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "XmlViewerService", function () {
        return XmlViewerService;
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


      var sweetalert__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! sweetalert */
      "GUC0");
      /* harmony import */


      var sweetalert__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(sweetalert__WEBPACK_IMPORTED_MODULE_4__);
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var XmlViewerService = /*#__PURE__*/function () {
        function XmlViewerService(httpClient) {
          _classCallCheck(this, XmlViewerService);

          this.httpClient = httpClient;
          this.$documentList = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"]([]);
        }

        _createClass(XmlViewerService, [{
          key: "getDocuments",
          value: function getDocuments() {
            var _this = this;

            return this.httpClient.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/files")).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (response) {
              _this.$documentList.next(response.reportData);
            }));
          }
        }, {
          key: "saveDocument",
          value: function saveDocument(id) {
            var _this2 = this;

            var filename = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'myfile';
            this.documentList.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1)).subscribe(function (docList) {
              var doc = docList.find(function (_doc) {
                return _doc.id === id;
              });

              _this2.httpClient.get("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/download/excel/").concat(id), {
                responseType: 'blob',
                observe: 'response'
              }).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1)).subscribe(function (response) {
                var dataType = response.type;
                var binaryData = [];
                binaryData.push(response.body);
                var downloadLink = document.createElement('a');
                downloadLink.href = window.URL.createObjectURL(new Blob(binaryData, {
                  type: 'blob'
                }));
                downloadLink.setAttribute('download', "".concat(doc.file_name, ".xlsx"));
                document.body.appendChild(downloadLink);
                downloadLink.click();
                downloadLink.parentNode.removeChild(downloadLink);
              }, function (err) {
                var errorMessage = 'An unknown Error occurred';

                if (err.status === 0) {
                  errorMessage = 'An unknown Error occurred';
                } else if (err.status === 400) {
                  var serverMessage = err.error;
                  errorMessage = "".concat(serverMessage.message, "\n").concat(serverMessage === null || serverMessage === void 0 ? void 0 : serverMessage.details);
                } else {
                  var _serverMessage = err.error;

                  if ((_serverMessage === null || _serverMessage === void 0 ? void 0 : _serverMessage.message) instanceof Array) {
                    errorMessage = _serverMessage.message.join('<br>');
                  } else {
                    errorMessage = (_serverMessage === null || _serverMessage === void 0 ? void 0 : _serverMessage.message) || errorMessage;
                  }
                }

                sweetalert__WEBPACK_IMPORTED_MODULE_4___default()({
                  title: 'Error',
                  text: errorMessage,
                  icon: 'error'
                });
              });
            });
          }
        }, {
          key: "deleteDocument",
          value: function deleteDocument(id) {
            var _this3 = this;

            return this.httpClient["delete"]("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi, "/deletefile/").concat(id)).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])(function (dataList) {
              return _this3.documentList;
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (docList) {
              var listIndex = docList.findIndex(function (doc) {
                return doc.id === id;
              });
              docList.splice(listIndex, 1);

              _this3.$documentList.next(docList);
            }));
          }
        }, {
          key: "documentList",
          get: function get() {
            return this.$documentList.asObservable();
          }
        }]);

        return XmlViewerService;
      }();

      XmlViewerService.ɵfac = function XmlViewerService_Factory(t) {
        return new (t || XmlViewerService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"]));
      };

      XmlViewerService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: XmlViewerService,
        factory: XmlViewerService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "vfVh":
    /*!**************************************************************!*\
      !*** ./src/app/pages/user-settings/user-settings.service.ts ***!
      \**************************************************************/

    /*! exports provided: UserSettingsService */

    /***/
    function vfVh(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "UserSettingsService", function () {
        return UserSettingsService;
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


      var src_environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! src/environments/environment */
      "AytR");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var UserSettingsService = /*#__PURE__*/function () {
        function UserSettingsService(httpClient) {
          _classCallCheck(this, UserSettingsService);

          this.httpClient = httpClient;
        }

        _createClass(UserSettingsService, [{
          key: "updatePassword",
          value: function updatePassword(body) {
            return this.httpClient.put("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseApi, "/user"), body).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (response) {}));
          }
        }, {
          key: "createUser",
          value: function createUser(body) {
            return this.httpClient.post("".concat(src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseApi, "/users"), body).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (response) {}));
          }
        }]);

        return UserSettingsService;
      }();

      UserSettingsService.ɵfac = function UserSettingsService_Factory(t) {
        return new (t || UserSettingsService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]));
      };

      UserSettingsService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: UserSettingsService,
        factory: UserSettingsService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserSettingsService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]
          }];
        }, null);
      })();
      /***/

    }
  }]);
})();
//# sourceMappingURL=common-es5.js.map
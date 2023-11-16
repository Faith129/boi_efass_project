(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["common"],{

/***/ "DRSI":
/*!********************************************************!*\
  !*** ./src/app/pages/xml-viewer/xml-viewer.service.ts ***!
  \********************************************************/
/*! exports provided: XmlViewerService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "XmlViewerService", function() { return XmlViewerService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "qCKp");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "kU1M");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/environments/environment */ "AytR");
/* harmony import */ var sweetalert__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! sweetalert */ "GUC0");
/* harmony import */ var sweetalert__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(sweetalert__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "tk/3");







class XmlViewerService {
    constructor(httpClient) {
        this.httpClient = httpClient;
        this.$documentList = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"]([]);
    }
    getDocuments() {
        return this.httpClient.get(`${src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi}/files`).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])((response) => {
            this.$documentList.next(response.reportData);
        }));
    }
    saveDocument(id, filename = 'myfile') {
        this.documentList.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1)).subscribe((docList) => {
            const doc = docList.find((_doc) => _doc.id === id);
            this.httpClient.get(`${src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi}/download/excel/${id}`, { responseType: 'blob', observe: 'response' })
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1)).subscribe((response) => {
                let dataType = response.type;
                let binaryData = [];
                binaryData.push(response.body);
                let downloadLink = document.createElement('a');
                downloadLink.href = window.URL.createObjectURL(new Blob(binaryData, { type: 'blob' }));
                downloadLink.setAttribute('download', `${doc.file_name}.xlsx`);
                document.body.appendChild(downloadLink);
                downloadLink.click();
                downloadLink.parentNode.removeChild(downloadLink);
            }, err => {
                let errorMessage = 'An unknown Error occurred';
                if (err.status === 0) {
                    errorMessage = 'An unknown Error occurred';
                }
                else if (err.status === 400) {
                    const serverMessage = err.error;
                    errorMessage = `${serverMessage.message}\n${serverMessage === null || serverMessage === void 0 ? void 0 : serverMessage.details}`;
                }
                else {
                    const serverMessage = err.error;
                    if ((serverMessage === null || serverMessage === void 0 ? void 0 : serverMessage.message) instanceof Array) {
                        errorMessage = serverMessage.message.join('<br>');
                    }
                    else {
                        errorMessage = (serverMessage === null || serverMessage === void 0 ? void 0 : serverMessage.message) || errorMessage;
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
    deleteDocument(id) {
        return this.httpClient.delete(`${src_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].baseApi}/deletefile/${id}`).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])((dataList => {
            return this.documentList;
        })), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["take"])(1), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(docList => {
            const listIndex = docList.findIndex(doc => doc.id === id);
            docList.splice(listIndex, 1);
            this.$documentList.next(docList);
        }));
    }
    get documentList() {
        return this.$documentList.asObservable();
    }
}
XmlViewerService.ɵfac = function XmlViewerService_Factory(t) { return new (t || XmlViewerService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"])); };
XmlViewerService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: XmlViewerService, factory: XmlViewerService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](XmlViewerService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "vfVh":
/*!**************************************************************!*\
  !*** ./src/app/pages/user-settings/user-settings.service.ts ***!
  \**************************************************************/
/*! exports provided: UserSettingsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserSettingsService", function() { return UserSettingsService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "kU1M");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/environments/environment */ "AytR");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "tk/3");





class UserSettingsService {
    constructor(httpClient) {
        this.httpClient = httpClient;
    }
    updatePassword(body) {
        return this.httpClient.put(`${src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseApi}/user`, body).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])((response) => {
        }));
    }
    createUser(body) {
        return this.httpClient.post(`${src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].baseApi}/users`, body).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])((response) => {
        }));
    }
}
UserSettingsService.ɵfac = function UserSettingsService_Factory(t) { return new (t || UserSettingsService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"])); };
UserSettingsService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: UserSettingsService, factory: UserSettingsService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserSettingsService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] }]; }, null); })();


/***/ })

}]);
//# sourceMappingURL=common-es2015.js.map
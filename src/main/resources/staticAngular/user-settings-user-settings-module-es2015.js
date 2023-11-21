(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["user-settings-user-settings-module"],{

/***/ "XAcJ":
/*!*************************************************************!*\
  !*** ./src/app/pages/user-settings/user-settings.module.ts ***!
  \*************************************************************/
/*! exports provided: UserSettingsModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserSettingsModule", function() { return UserSettingsModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _user_settings_page__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./user-settings.page */ "zDyl");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "tyNb");






const routes = [
    { path: '', component: _user_settings_page__WEBPACK_IMPORTED_MODULE_2__["UserSettingsPage"],
        children: [
            { path: 'create-user', loadChildren: () => Promise.all(/*! import() | create-user-create-user-module */[__webpack_require__.e("default~create-user-create-user-module~generate-report-generate-report-module~main-main-module~updat~0b1b9fd2"), __webpack_require__.e("common"), __webpack_require__.e("create-user-create-user-module")]).then(__webpack_require__.bind(null, /*! ./create-user/create-user.module */ "WTqH")).then(m => m.CreateUserModule) },
            { path: 'update-password', loadChildren: () => Promise.all(/*! import() | update-password-update-password-module */[__webpack_require__.e("default~create-user-create-user-module~generate-report-generate-report-module~main-main-module~updat~0b1b9fd2"), __webpack_require__.e("common"), __webpack_require__.e("update-password-update-password-module")]).then(__webpack_require__.bind(null, /*! ./update-password/update-password.module */ "fV8Y")).then(m => m.UpdatePasswordModule) },
            { path: '', pathMatch: 'full', redirectTo: 'update-password' }
        ]
    },
];
class UserSettingsModule {
}
UserSettingsModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: UserSettingsModule });
UserSettingsModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function UserSettingsModule_Factory(t) { return new (t || UserSettingsModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](UserSettingsModule, { declarations: [_user_settings_page__WEBPACK_IMPORTED_MODULE_2__["UserSettingsPage"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserSettingsModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_user_settings_page__WEBPACK_IMPORTED_MODULE_2__["UserSettingsPage"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "zDyl":
/*!***********************************************************!*\
  !*** ./src/app/pages/user-settings/user-settings.page.ts ***!
  \***********************************************************/
/*! exports provided: UserSettingsPage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserSettingsPage", function() { return UserSettingsPage; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");



class UserSettingsPage {
    constructor() { }
    ngOnInit() {
    }
}
UserSettingsPage.ɵfac = function UserSettingsPage_Factory(t) { return new (t || UserSettingsPage)(); };
UserSettingsPage.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: UserSettingsPage, selectors: [["app-user-settings"]], decls: 8, vars: 0, consts: [["routerLink", "update-password", "routerLinkActive", "active"], ["routerLink", "create-user", "routerLinkActive", "active"]], template: function UserSettingsPage_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "nav");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "a", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "Update Password");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "Create User");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "router-outlet");
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkActive"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"]], styles: ["nav[_ngcontent-%COMP%] {\r\n    display: flex;\r\n    flex-wrap: wrap;\r\n    justify-content: space-evenly;\r\n    width: 100%;\r\n    margin: 30px ;\r\n}\r\nnav[_ngcontent-%COMP%]   div[_ngcontent-%COMP%] {\r\n    flex: 1;\r\n    text-align: center;\r\n}\r\nnav[_ngcontent-%COMP%]   a[_ngcontent-%COMP%] {\r\n    \r\n    color: black;\r\n    padding: 16px;\r\n    text-decoration: none;\r\n    border: 1px solid var(--primary-color);\r\n}\r\nnav[_ngcontent-%COMP%]   a.active[_ngcontent-%COMP%] {\r\n    background-color: var(--primary-color);\r\n    color: white;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGFnZXMvdXNlci1zZXR0aW5ncy91c2VyLXNldHRpbmdzLnBhZ2UuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksYUFBYTtJQUNiLGVBQWU7SUFDZiw2QkFBNkI7SUFDN0IsV0FBVztJQUNYLGFBQWE7QUFDakI7QUFDQTtJQUNJLE9BQU87SUFDUCxrQkFBa0I7QUFDdEI7QUFDQTtJQUNJLG9CQUFvQjtJQUNwQixZQUFZO0lBQ1osYUFBYTtJQUNiLHFCQUFxQjtJQUNyQixzQ0FBc0M7QUFDMUM7QUFFQTtJQUNJLHNDQUFzQztJQUN0QyxZQUFZO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvcGFnZXMvdXNlci1zZXR0aW5ncy91c2VyLXNldHRpbmdzLnBhZ2UuY3NzIiwic291cmNlc0NvbnRlbnQiOlsibmF2IHtcclxuICAgIGRpc3BsYXk6IGZsZXg7XHJcbiAgICBmbGV4LXdyYXA6IHdyYXA7XHJcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWV2ZW5seTtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWFyZ2luOiAzMHB4IDtcclxufVxyXG5uYXYgZGl2IHtcclxuICAgIGZsZXg6IDE7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbn1cclxubmF2IGEge1xyXG4gICAgLyogZGlzcGxheTogYmxvY2s7ICovXHJcbiAgICBjb2xvcjogYmxhY2s7XHJcbiAgICBwYWRkaW5nOiAxNnB4O1xyXG4gICAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgdmFyKC0tcHJpbWFyeS1jb2xvcik7XHJcbn1cclxuXHJcbm5hdiBhLmFjdGl2ZSB7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5LWNvbG9yKTtcclxuICAgIGNvbG9yOiB3aGl0ZTtcclxufSJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserSettingsPage, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-user-settings',
                templateUrl: './user-settings.page.html',
                styleUrls: ['./user-settings.page.css']
            }]
    }], function () { return []; }, null); })();


/***/ })

}]);
//# sourceMappingURL=user-settings-user-settings-module-es2015.js.map
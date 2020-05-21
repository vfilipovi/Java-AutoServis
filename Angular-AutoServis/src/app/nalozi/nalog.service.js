"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var rxjs_1 = require("rxjs");
var operators_1 = require("rxjs/operators");
var app_constants_1 = require("../constants/app.constants");
var NalogService = /** @class */ (function () {
    function NalogService(http) {
        this.http = http;
        this.naloziUrl = app_constants_1.SERVER_API_URL + "/nalozi";
    }
    NalogService.prototype.getNalozi = function () {
        return this.http.get(this.naloziUrl)
            .pipe(operators_1.tap(function (_) { return console.log('fetched nalozi'); }), operators_1.catchError(this.handleError('getNalozi', [])));
    };
    NalogService.prototype.getNalog = function (id) {
        var url = this.naloziUrl + "/" + id;
        return this.http.get(url)
            .pipe(operators_1.tap(function (_) { return console.log("fetched nalog id=" + id); }), operators_1.catchError(this.handleError("getNalog id=" + id)));
    };
    NalogService.prototype.updateNalog = function (nalog) {
        var url = this.naloziUrl + "/" + nalog.id;
        return this.http.put(url, nalog).pipe(operators_1.tap(function (_) { return console.log("updated nalog id=" + nalog.id); }), operators_1.catchError(this.handleError('updateNalog')));
    };
    NalogService.prototype.addNalog = function (nalog) {
        return this.http.post(this.naloziUrl, nalog).pipe(operators_1.tap(function (newNalog) { return console.log("added nalog id=" + newNalog.id); }), operators_1.catchError(this.handleError('addNalog')));
    };
    NalogService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(operation);
            console.error(error);
            return rxjs_1.of(result);
        };
    };
    NalogService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], NalogService);
    return NalogService;
}());
exports.NalogService = NalogService;

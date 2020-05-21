"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var app_constants_1 = require("../constants/app.constants");
var authority_constants_1 = require("../constants/authority.constants");
var UserService = /** @class */ (function () {
    function UserService(http) {
        this.http = http;
        this.usersUrl = app_constants_1.SERVER_API_URL + "/api/user";
    }
    UserService.prototype.getCurrentUser = function () {
        return this.http.get(this.usersUrl + "/current-user");
    };
    UserService.prototype.isRoleAdmin = function () {
        if (this.currentUser) {
            return this.currentUser.authorities.some(function (authority) { return authority === authority_constants_1.Authority.ADMIN; });
        }
        else {
            return false;
        }
    };
    UserService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], UserService);
    return UserService;
}());
exports.UserService = UserService;

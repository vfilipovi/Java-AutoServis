"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var NaloziComponent = /** @class */ (function () {
    function NaloziComponent(nalogService, router, toastrService) {
        this.nalogService = nalogService;
        this.router = router;
        this.toastrService = toastrService;
    }
    NaloziComponent.prototype.ngOnInit = function () {
        this.getNalozi();
    };
    NaloziComponent.prototype.getNalozi = function () {
        var _this = this;
        this.nalogService.getNalozi()
            .subscribe(function (nalozi) { return _this.nalozi = nalozi; });
    };
    NaloziComponent.prototype.navigateToEdit = function (nalog) {
        this.router.navigate(["/nalog/edit/" + nalog.id]);
    };
    NaloziComponent.prototype.navigateToDetails = function (nalog) {
        this.router.navigate(["/nalog/detail/" + nalog.id]);
    };
    NaloziComponent = __decorate([
        core_1.Component({
            selector: 'app-nalozi',
            templateUrl: './nalozi.component.html'
        })
    ], NaloziComponent);
    return NaloziComponent;
}());
exports.NaloziComponent = NaloziComponent;

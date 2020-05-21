"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var klijent_model_1 = require("../klijenti/klijent.model");
var radnik_model_1 = require("../radnici/radnik.model");
var kvar_model_1 = require("../kvarovi/kvar.model");
var Nalog = /** @class */ (function () {
    function Nalog() {
        this.radnik = new radnik_model_1.Radnik();
        this.klijent = new klijent_model_1.Klijent();
        this.kvar = new kvar_model_1.Kvar();
    }
    return Nalog;
}());
exports.Nalog = Nalog;

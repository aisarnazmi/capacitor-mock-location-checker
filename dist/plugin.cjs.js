'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const CapacitorMockLocationChecker = core.registerPlugin('CapacitorMockLocationChecker', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.CapacitorMockLocationCheckerWeb()),
});

class CapacitorMockLocationCheckerWeb extends core.WebPlugin {
    async isLocationFromMockProvider() {
        throw new Error('Method not implemented.');
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    CapacitorMockLocationCheckerWeb: CapacitorMockLocationCheckerWeb
});

exports.CapacitorMockLocationChecker = CapacitorMockLocationChecker;
//# sourceMappingURL=plugin.cjs.js.map

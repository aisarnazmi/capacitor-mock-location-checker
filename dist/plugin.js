var capacitorCapacitorMockLocationChecker = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map

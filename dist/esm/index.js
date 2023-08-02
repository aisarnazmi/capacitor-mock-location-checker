import { registerPlugin } from '@capacitor/core';
const CapacitorMockLocationChecker = registerPlugin('CapacitorMockLocationChecker', {
    web: () => import('./web').then(m => new m.CapacitorMockLocationCheckerWeb()),
});
export * from './definitions';
export { CapacitorMockLocationChecker };
//# sourceMappingURL=index.js.map
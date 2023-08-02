import { registerPlugin } from '@capacitor/core';

import type { CapacitorMockLocationCheckerPlugin } from './definitions';

const CapacitorMockLocationChecker = registerPlugin<CapacitorMockLocationCheckerPlugin>('CapacitorMockLocationChecker', {
  web: () => import('./web').then(m => new m.CapacitorMockLocationCheckerWeb()),
});

export * from './definitions';
export { CapacitorMockLocationChecker };

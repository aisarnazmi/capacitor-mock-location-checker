import { WebPlugin } from '@capacitor/core';

import type { CapacitorMockLocationCheckerPlugin, CheckMockResult } from './definitions';

export class CapacitorMockLocationCheckerWeb extends WebPlugin implements CapacitorMockLocationCheckerPlugin {
  async isLocationFromMockProvider(): Promise<CheckMockResult> {
    throw new Error('Method not implemented.');
  }
}

import { WebPlugin } from '@capacitor/core';

import type { CapacitorMockLocationCheckerPlugin } from './definitions';

export class CapacitorMockLocationCheckerWeb extends WebPlugin implements CapacitorMockLocationCheckerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

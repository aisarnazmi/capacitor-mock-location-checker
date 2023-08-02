import { WebPlugin } from '@capacitor/core';
import type { CapacitorMockLocationCheckerPlugin, CheckMockResult } from './definitions';
export declare class CapacitorMockLocationCheckerWeb extends WebPlugin implements CapacitorMockLocationCheckerPlugin {
    isLocationFromMockProvider(): Promise<CheckMockResult>;
}

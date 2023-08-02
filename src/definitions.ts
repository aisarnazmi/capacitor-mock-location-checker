export interface CapacitorMockLocationCheckerPlugin {
  isLocationFromMockProvider(): Promise<CheckMockResult>;
}

export interface CheckMockResult {
  isMock: boolean;
}

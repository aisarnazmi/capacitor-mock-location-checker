export interface CapacitorMockLocationCheckerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

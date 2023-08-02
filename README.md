# capacitor-mock-location-checker

Mock location checker for ionic capacitor

## Install

```bash
npm install github:aisarnazmi/capacitor-mock-location-checker
npx cap sync
```

## Example

```typescript
import { Injectable } from '@angular/core';
import { Capacitor } from '@capacitor/core';
import { CapacitorMockLocationChecker } from 'capacitor-mock-location-checker';

@Injectable({
  providedIn: 'root',
})
export class MockCheckerService {
  constructor() {}

  async checkMock(): Promise<boolean> {
    if (Capacitor.getPlatform() === 'android') {
      const result = await CapacitorMockLocationChecker.isLocationFromMockProvider();

      return result.isMock;
    }
    return false;
  }
}
```

## API

<docgen-index>

* [`isLocationFromMockProvider()`](#islocationfrommockprovider)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### isLocationFromMockProvider()

```typescript
isLocationFromMockProvider() => Promise<CheckMockResult>
```

**Returns:** <code>Promise&lt;<a href="#checkmockresult">CheckMockResult</a>&gt;</code>

--------------------


### Interfaces


#### CheckMockResult

| Prop         | Type                 |
| ------------ | -------------------- |
| **`isMock`** | <code>boolean</code> |

</docgen-api>

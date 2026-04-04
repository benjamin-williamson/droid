# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Run a single unit test class
./gradlew test --tests "net.decusatis.mybicycleshopflaming.ExampleUnitTest"

# Clean build
./gradlew clean
```

## Architecture

This is a WGU D308 Vacation Scheduler Android app (Java, minSdk 26, targetSdk 33) using the Room persistence library. Package: `net.decusatis.mybicycleshopflaming`.

**Domain:** Vacations (title, hotel, startDate, endDate) contain Excursions (title, excursionDate). All dates stored as `MM/dd/yy` Strings.

**Layered structure:**

- **Entities** (`Entities/`) — `Product` maps to the `vacations` table (vacationID, title, hotel, startDate, endDate). `Part` maps to the `excursions` table (excursionID, title, excursionDate, vacationID foreign key). Class names are kept from the original Bicycle Shop template but represent vacation domain objects.
- **DAO** (`DAO/`) — `ProductDAO.getAllVacations()`, `PartDAO.getAllExcursions()` plus insert/update/delete for each.
- **Database** (`Database/`) — `BicycleDatabaseBuilder` (singleton `RoomDatabase`, version 2, `fallbackToDestructiveMigration`). `Repository` is the single UI-facing data access class; uses a 4-thread `ExecutorService` + `Thread.sleep(1000)` to synchronize async DB calls.
- **Activities** (`Activities/`) — UI layer:
  - `MainActivity` — home screen with Enter button
  - `ProductList` — RecyclerView of all vacations; FAB navigates to `ProductDetails`
  - `ProductDetails` — create/edit/delete a vacation; validates date format (MM/dd/yy), end ≥ start, blocks delete if excursions exist; menu: Save, Delete, Share (concatenated string via `ACTION_SEND`), Set Start Alert, Set End Alert
  - `PartDetails` — create/edit/delete an excursion; validates date format and that date falls within parent vacation's range; menu: Save, Delete, Set Alert (fires notification with excursion title)
  - `ProductAdapter` / `PartAdapter` — RecyclerView adapters; `PartAdapter` receives vacation start/end dates at construction to forward to `PartDetails`
  - `MyReceiver` — `BroadcastReceiver` that shows a Toast and a notification channel notification when `AlarmManager` fires

**Navigation flow:** `MainActivity` → `ProductList` → `ProductDetails` → `PartDetails`

**Alert pattern:** `AlarmManager.set(RTC_WAKEUP, date.getTime(), PendingIntent)` targeting `MyReceiver` with the message in `Intent.putExtra("key", message)`. Uses `MainActivity.numAlert` as a static counter for unique request codes.

**Intent extras flow:**
- `ProductList → ProductDetails`: `id` (vacationID), `name` (title), `hotel`, `startDate`, `endDate`
- `ProductDetails FAB → PartDetails`: `vacationID`, `vacationStartDate`, `vacationEndDate`
- `PartAdapter click → PartDetails`: above plus `id` (excursionID), `name` (excursion title), `excursionDate`

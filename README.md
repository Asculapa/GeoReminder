# GeoReminder

An Android app for creating reminders tied to a location (and time). The app is
in early development: the UI shell is in place, but reminders aren't saved or
triggered yet.

## Current state

- Main screen with **Current** and **Done** tabs (`ViewPager` + `TabLayout`)
- Floating action button that opens an animated **New Record** form
- Location picker with two options:
  - **List of locations**: a dialog (`ListOfLocation`), not yet populated
  - **Select location**: an OpenStreetMap view (osmdroid) with zoom and multi-touch

Still to do: saving reminders, location tracking and geofencing, time selection,
notifications, and filling the task lists.

## Tech stack

- Java, Android Support Library 28 (appcompat, design, constraint-layout)
- [osmdroid](https://github.com/osmdroid/osmdroid) 6.0.3 for maps (MAPNIK tiles)
- Gradle 4.6, Android Gradle Plugin 3.2.1
- `minSdkVersion` 21, `targetSdkVersion` / `compileSdkVersion` 28

## Project structure

```
app/src/main/java/com/shakal/georeminder/
├── MainActivity.java          # Tabs and the "add reminder" button
├── adapters/TabAdapter.java   # Pager adapter for Current / Done tabs
├── dialogFragments/
│   └── ListOfLocation.java    # Saved-locations dialog
└── fragments/
    ├── CurrentTasks.java
    ├── DoneTasks.java
    ├── NewRecord.java         # New reminder form
    └── Map.java               # osmdroid map for picking a location
```

## Building

Open the project in Android Studio, or build from the command line:

```bash
./gradlew assembleDebug     # build the debug APK
./gradlew installDebug      # install on a connected device or emulator
```

The build uses an old toolchain (Gradle 4.6, the `jcenter()` repository), so you
may need an older JDK (8) and an Android Studio release that matches it.

## Permissions

The app requests `ACCESS_FINE_LOCATION`, `INTERNET`, `ACCESS_NETWORK_STATE` and
`WRITE_EXTERNAL_STORAGE`. The last three are used by osmdroid to download and
cache map tiles.

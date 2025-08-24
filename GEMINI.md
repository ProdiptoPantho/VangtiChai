# Project Overview

This is an Android application named "VangtiChai," which translates to "I want change." It functions as a change calculator for Bangladeshi Taka (BDT). Users can input a monetary amount via a simple keypad, and the app calculates the minimum number of banknotes required for that sum.

The application is written in **Kotlin** and uses the **traditional Android View system** with `ConstraintLayout`. It does not use Jetpack Compose, despite the presence of the dependency in the build file. The core logic for both the UI interaction and the calculation is contained within `MainActivity.kt`.

## Detailed File Structure

Here are the key files and directories in the project:

*   `app/src/main/java/com/example/vangtichai/MainActivity.kt`: The single activity in the app. It handles all user input, state management, and the core calculation logic.
*   `app/src/main/res/layout/activity_main.xml`: The primary layout file for the user interface, defining the keypad and the display for the note breakdown.
*   `app/src/main/res/layout-land/`, `app/src/main/res/layout-sw600dp/`, `app/src/main/res/layout-sw600dp-land/`: These directories contain alternative layouts to ensure the UI is responsive on different screen sizes (phones vs. tablets) and orientations (portrait vs. landscape).
*   `app/build.gradle.kts`: The app-level Gradle build script. It defines dependencies, SDK versions, and other build configurations.
*   `README.md`: The original project README with a high-level overview and setup instructions.

## Core Logic Explained

The application's logic is straightforward and revolves around two main functions:

1.  **Input Handling:** A single `View.OnClickListener` is attached to all the number buttons (0-9). When a button is pressed:
    *   The digit is appended to the current `amount` variable (a `Long`).
    *   Input is limited to 15 digits to prevent overflow.
    *   The `updateUI()` function is called.

2.  **Change Calculation (`calculateChange` function):**
    *   This function takes the `amount` as input.
    *   It iterates through a predefined list of banknote denominations (`[500, 100, 50, 20, 10, 5, 2, 1]`).
    *   For each denomination, it uses integer division (`/`) to find out how many notes of that value fit into the `remaining` amount.
    *   It then uses the modulo operator (`%`) to calculate the new `remaining` amount to be passed to the next smaller denomination.
    *   The result for each denomination is immediately displayed in its corresponding `TextView`.

## Building and Running

To build and run this project:

1.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select `File` > `Open` and navigate to the project directory.
2.  **Sync Gradle:**
    *   Allow Android Studio to sync the project with the Gradle files.
3.  **Run the app:**
    *   Select an emulator or connect a physical Android device.
    *   Click the 'Run' button (▶) in Android Studio.

Alternatively, you can build from the command line using Gradle:

```bash
# On Windows
./gradlew assembleDebug

# On macOS/Linux
./gradlew assembleDebug
```

## Potential Improvements

*   **Remove Unused Dependencies:** The Jetpack Compose dependencies are included in `app/build.gradle.kts` but are not used. They could be removed to slightly reduce the project's size and complexity.
*   **UI Migration:** As a learning exercise, the project could be migrated from the traditional View system to Jetpack Compose.
*   **ViewModel:** The UI logic and state could be moved from `MainActivity.kt` into an `AndroidViewModel` to better separate concerns and follow modern Android architecture patterns.
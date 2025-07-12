# VangtiChai
[![Ask DeepWiki](https://devin.ai/assets/askdeepwiki.png)](https://deepwiki.com/ProdiptoPantho/VangtiChai)

"VangtiChai" (ভাংতি চাই), which translates to "I want change," is a simple yet practical Android application designed to function as a change calculator for Bangladeshi Taka (BDT). Users can input any monetary amount, and the app will instantly calculate and display the minimum number of banknotes required for that sum.

## Features

*   **Instant Change Calculation**: Enter an amount and see the breakdown into different banknote denominations (৳500, ৳100, ৳50, ৳20, ৳10, ৳5, ৳2, ৳1).
*   **Simple Keypad Interface**: A clean and straightforward keypad for easy amount entry.
*   **Responsive UI**: The layout adapts seamlessly to various screen sizes and orientations, supporting both phones and tablets in portrait and landscape modes.
*   **Dark Theme**: A visually comfortable dark theme for the user interface.
*   **Reset Functionality**: A clear button to quickly reset the entered amount to zero.
*   **State Preservation**: The app retains the entered amount even after screen rotation.

## How It Works

The core logic resides in `MainActivity.kt`.

1.  **Input Handling**: The app listens for clicks on the number buttons. Each press appends the digit to the current `amount` variable. The input is limited to 15 digits to prevent overflow.
2.  **Calculation**: The `calculateChange(value: Long)` function is called whenever the amount changes. It iteratively calculates the number of notes for each denomination using integer division and the modulo operator. It starts with the largest note (৳500) and works its way down to the smallest (৳1).
3.  **UI Update**: After calculation, `updateUI()` is called to refresh the `TextViews` on the screen, displaying the total entered amount and the count for each banknote.
4.  **Layout Management**: The application utilizes Android's resource qualifier system to provide different layouts for various configurations:
    *   `layout`: Default portrait layout for phones.
    *   `layout-land`: Landscape layout for phones.
    *   `layout-sw600dp`: Portrait layout for tablets.
    *   `layout-sw600dp-land`: Landscape layout for tablets.

## How to Build

To build and run this project yourself, follow these steps:

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/ProdiptoPantho/VangtiChai.git
    ```
2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select `File` > `Open` and navigate to the cloned repository directory.
3.  **Sync Gradle:**
    *   Allow Android Studio to sync the project with the Gradle files.
4.  **Run the app:**
    *   Select an emulator or connect a physical Android device.
    *   Click the 'Run' button (▶) in Android Studio.

<!-- Copyright (C) 2017 Raphael Levy -->

# Swing FullScreen macOS

A small Java library for making AWT/Swing applications natively full screen on macOS.

## Usage

First of all, import `FullScreenMacOS`:

    import com.raphaellevy.fullscreen.FullScreenMacOS;
    
Once you've created a `JFrame` or other `Window`, you can enable full screen for it:

    FullScreenMacOS.setFullScreenEnabled(window, true);
    
This will add a full screen button in normal Mac fashion. *After you have made the frame visible*,
you can tell it to enter full screen:

    FullScreenMacOS.toggleFullScreen(fr);
    
If you want to check whether full screen is available (e.g. you're running macOS/OS X 10.7+),
use `FullScreenMacOS.fullScreenAvailable()`.

## Building

This project uses Apache Maven 2. To build, make sure you have Maven installed and `cd` to
the project directory. Run the command `mvn install` and find the newly-created jar in the
target directory.
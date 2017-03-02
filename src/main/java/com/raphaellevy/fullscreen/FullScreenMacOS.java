//Copyright (C) 2017 Raphael Levy
package com.raphaellevy.fullscreen;

import java.awt.Window;
import java.lang.reflect.InvocationTargetException;

/**
 *	Utility methods for adding native mac full screen support to AWT/Swing applications.
 */
public class FullScreenMacOS 
{
	/**
	 * Set whether this window can be made full screen.
	 * @param frame
	 * @throws FullScreenException
	 */
	public static void setFullScreenEnabled(Window frame, boolean b) throws FullScreenException {
		try {
			Class<? extends Object> fsu = Class.forName("com.apple.eawt.FullScreenUtilities");
			fsu.getMethod("setWindowCanFullScreen", Window.class, Boolean.TYPE).invoke(null, frame, b);
		} catch (ClassNotFoundException e) {
			throw new FullScreenException(FullScreenException.CLASS_DOES_NOT_EXIST);
		} catch (Exception e) {
			throw new FullScreenException(FullScreenException.REFLECTION_ERROR);
		}
	}
	
	/**
	 * Toggles whether this window is full screen. Full screen must be enabled with setFullScreenEnabled() first, and the window must be visible.
	 * @param frame
	 * @throws FullScreenException
	 */
    public static void toggleFullScreen(Window frame) throws FullScreenException {
    	try {
			Class<? extends Object> app = Class.forName("com.apple.eawt.Application");
			Object geta = app.getMethod("getApplication").invoke(null);
			geta.getClass().getMethod("requestToggleFullScreen", Window.class).invoke(geta, frame);
		} catch (ClassNotFoundException e) {
			throw new FullScreenException(FullScreenException.CLASS_DOES_NOT_EXIST);
		} catch (Exception e) {
			throw new FullScreenException(FullScreenException.REFLECTION_ERROR);
		}
    }
    
    /**
     * Gets whether full screen is available on this computer.
     */
    public static boolean fullScreenAvailable() {
    	try {
    		Class.forName("com.apple.eawt.FullScreenUtilities");
        	Class.forName("com.apple.eawt.Application");
    	} catch (ClassNotFoundException e) {
    		return false;
    	}
    	return true;
    	
    }
}

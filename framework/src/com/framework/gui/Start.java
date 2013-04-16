package com.framework.gui;

public class Start {
	/**
	 * Instantiates a new start.
	 */
	private Start() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// create a game window
		DisplayWindow game = DisplayWindow.getInstance();

		// and make it visible
		game.setVisible(true);

	}
}

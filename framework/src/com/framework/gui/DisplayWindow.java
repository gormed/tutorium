package com.framework.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.text.Position;

import com.framework.controller.KeyInputListener;
import com.framework.controller.DisplayWindowListener;
import com.framework.data.LevelData;
import com.framework.logic.Entity;
import com.framework.logic.Level;

/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:25
 */
public class DisplayWindow extends JFrame {
	// =========================================================
	// Singleton
	// =========================================================
	private static DisplayWindow instance;

	public static DisplayWindow getInstance() {
		if (instance != null)
			return instance;
		else
			return instance = new DisplayWindow();
	}

	// =========================================================
	// Fields
	// =========================================================
	private static final long serialVersionUID = -5097177280076223641L;

	private Level level;

	private KeyInputListener keyInputListener;

	private Runnable updater;

	private Thread updateThread;

	private DisplayWindowListener windowListener;

	private Canvas canvas;

	private GraphicsDevice device;

	private boolean active = false;

	private double UPS = 0;
	private double ups = 0;
	private double FPS = 0;
	private double fps = 0;
	private double second = 0;
	private double gap = 0;
	private double time = System.currentTimeMillis();
	private double updateTime = time;
	private double drawTime = time;

	// =========================================================
	// Methods
	// =========================================================

	/**
	 * Instantiates a new game window.
	 */
	private DisplayWindow() {
		// Frame setup
		super("ReactPlane");
		device = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		setSize(Level.LEVEL_WIDTH, Level.LEVEL_HEIGHT);
		setResizable(false);
		setLocationByPlatform(true);
		// drawing logic
		add(canvas = new Canvas(this));
		canvas.setSize(Level.LEVEL_WIDTH, Level.LEVEL_HEIGHT);
		// add the listeners for user input and exit handling
		addKeyListener(keyInputListener = new KeyInputListener());
		addWindowListener(windowListener = new DisplayWindowListener(this));
		// create level from data
		level = Level.getInstance();
		level.initialize(new LevelData());
		loadLevel();
		// update loop
		updater = new Runnable() {

			@Override
			public void run() {
				// init time
				time = System.currentTimeMillis();
				updateTime = time;
				drawTime = time;
				// sync the key input with thread
				synchronized (keyInputListener) {
					// loop endless until exit request
					while (!keyInputListener.isExit()) {
						if (!active)
							updateTime = System.currentTimeMillis();
						if (second >= 1000) {
							UPS = ups;
							FPS = fps;
							second = 0;
							ups = 0;
							fps = 0;
						}

						// get current time
						time = System.currentTimeMillis();
						gap = (double) time - (double) updateTime;
						second += gap;
						ups++;
						// update level elements
						level.update((float) (((double) gap) * 0.001));
						if ((time - drawTime) >= 16) {
							// draw synchronized all 16 ms
							canvas.repaint();
							drawTime = time;
							fps++;
						}
						updateTime = time;
					}
				}
				// level.destory();
				System.exit(0);
			}
		};
		// update thread
		updateThread = new Thread(updater);
		updateThread.start();
	}

	/**
	 * Load level.
	 */
	private void loadLevel() {

		// add text for lives
		addElement(null , null);

	}

	public void addElement(VisualElement element, Entity entity) {
		// add the observer
		if (entity != null) {
			entity.addObserver(element);
			// add entity to list
			level.getEntityList().put(entity.getId(), entity);
		}
		// add the according gui element to draw list
		canvas.addElement(element);
	}


	public KeyInputListener getGameInputListener() {
		return keyInputListener;
	}

	public DisplayWindowListener getWindowListener() {
		return windowListener;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public GraphicsDevice getDevice() {
		return device;
	}

	public Level getLevel() {
		return level;
	}

}// end GameWindow
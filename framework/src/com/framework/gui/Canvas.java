package com.framework.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.JComponent;


/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:24
 */
public class Canvas extends JComponent {

	private static final long serialVersionUID = 6284068760970498634L;

	private DisplayWindow mainWindow;

	private Hashtable<Long, VisualElement> visualElements = new Hashtable<Long, VisualElement>();
	private ArrayList<VisualElement> addElements = new ArrayList<VisualElement>();
	private ArrayList<Long> removeElements = new ArrayList<Long>();

	public Canvas(DisplayWindow window) {
		mainWindow = window;
	}

	public void setSize(int w, int h) {
		super.setSize(w, h);
		width = w;
		height = h;
		scale = height / width;
	}

	public void update(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		if (mainWindow.getGameInputListener().isDebug())
			drawDebug(g2);

		g2.setColor(Color.black);
		drawGUIElements(g2);
	}

	private void drawGUIElements(Graphics2D g2) {
		for (VisualElement element : addElements) {
			visualElements.put(element.getId(), element);
		}
		for (Long id : removeElements) {
			visualElements.remove(id);
		}
		for (Map.Entry<Long, VisualElement> entry : visualElements.entrySet()) {

			entry.getValue().draw(g2, width, height);
		}
		addElements.clear();
		removeElements.clear();
	}

	public void paint(Graphics g) {
		update(g);
	}
	
	public void addElement(VisualElement element) {
		addElements.add(element);
	}
	
	public void removeElement(long id) {
		removeElements.add(id);
	}
 
	// DEBUG

	public int width;
	public int height;
	private float scale = 1.0f;

	private void drawDebug(Graphics2D g2) {

	}
}
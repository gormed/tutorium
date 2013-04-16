package com.framework.gui;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Observer;

/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:25
 */
public abstract class VisualElement implements Observer {

	public Canvas canvas;
	
	/** The unique element id. */
	private static long uniqueElementID = 0;

	/**
	 * Gets the id internally.
	 * 
	 * @return the id
	 */
	private static long getID() {
		return uniqueElementID++;
	}

	protected String name = "element";

	protected Point2D.Float position = new Point2D.Float();
	
	protected float width;
	protected float height;

	protected float angle;	
	
	protected Shape visual;
	protected Shape worldVisual;

	protected boolean isVisible;

	private long id = getID();

	public VisualElement(String name) {
		this.name = name;
	}

	public VisualElement() {
		name = name + "_" + id;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Point2D.Float getPosition() {
		return position;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public abstract void draw(Graphics2D g2, int width, int height);
}// end VisualElement
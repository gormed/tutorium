package com.framework.logic;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Observable;

/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:25
 */
public abstract class Entity extends Observable implements Updateable {
	
	/** The unique element id. */
	private static long uniqueEntityID = 0;

	/**
	 * Gets the id internally.
	 * 
	 * @return the id
	 */
	private static long getID() {
		return uniqueEntityID++;
	}

	/** The id. */
	private long id = getID();
	
	Point2D.Float position = new Point2D.Float();

	float width = 0;

	float height = 0;

	float angle = 0;

	Shape collision;

	public Entity() {
		super();
	}

	public abstract void createCollision(Shape shape);

	@Override
	public abstract void update(float gap);

	@Override
	public void updateObservers(float gap) {
		update(gap);
		notifyObservers(gap);
	}

	public Shape getCollision() {
		return collision;
	}

	public float getAngle() {
		return angle;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

	public Point2D.Float getPosition() {
		return position;
	}
	
	public long getId() {
		return id;
	}
}// end Entity
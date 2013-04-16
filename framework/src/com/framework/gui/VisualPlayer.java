package com.framework.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Observable;

import com.framework.logic.Player;

/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:25
 */
public class VisualPlayer extends VisualElement {

	public VisualPlayer(){
		
	}


	@Override
	public void update(Observable o, Object obj) {
		if (o instanceof Player) {
			Player p = (Player) o;
			this.position.x = p.getPosition().x;
			this.position.y = p.getPosition().y;
			this.angle = p.getAngle();
		} 
	}

	@Override
	public void draw(Graphics2D g2, int width, int height) {
		float Xpos = position.x * width;
		float Ypos = position.y * height;
		float scale = 1;

		AffineTransform trans = new AffineTransform();
		trans.translate(-position.x, -position.y);
		trans.translate(Xpos, Ypos);
		trans.scale(scale, scale);
		AffineTransform rot = AffineTransform.getRotateInstance(angle, position.x, position.y);
		worldVisual = rot.createTransformedShape(visual);
		worldVisual = trans.createTransformedShape(worldVisual);

		g2.setPaint(Color.black);
		g2.draw(worldVisual);
		if (DisplayWindow.getInstance().getGameInputListener().isDebug()) {
			g2.setPaint(Color.red);
			g2.drawString(getName() + "", Xpos - 10, Ypos);
		}
	}
}//end VisualPlane
package com.jmenu.paneles.menu3d;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

class Menu3dItem {

	private Color colorShadowLeftSelected;

	private Color backgroundSelected;

	private Color colorShadowTopSelected;

	private MenuAnimator animator;

	private double x;

	private double y;

	private double height;

	private double shadowSize;

	private String text;

	private double space = 0;

	private double width;

	private Color background = getDefaultBackground();

	private Color colorShadowTop = getDefaultColorShadowTop();

	private Color colorShadowLeft = getDefaultColorShadowLeft();

	private Color fondo;

	private Color arriba;

	private Color izquierda;

	private Font fuente;

	public void setFuente(Font fuente) {

		this.fuente = fuente;

	}

	public void setColorShadowTopSelected(Color colorShadowTopSelected) {

		this.colorShadowTopSelected = colorShadowTopSelected;

	}

	public void setBackgroundSelected(Color backgroundSelected) {

		this.backgroundSelected = backgroundSelected;

	}

	public void setColorShadowLeftSelected(Color colorShadowLeftSelected) {

		this.colorShadowLeftSelected = colorShadowLeftSelected;

	}

	public MenuAnimator getAnimator() {

		return animator;

	}

	public void setAnimator(MenuAnimator animator) {

		this.animator = animator;

	}

	public double getX() {

		return x;

	}

	public void setX(double x) {

		this.x = x;

	}

	public double getY() {

		return y;

	}

	public void setY(double y) {

		this.y = y;

	}

	public double getHeight() {

		return height;

	}

	public void setHeight(double height) {

		this.height = height;

	}

	public double getShadowSize() {

		return shadowSize;

	}

	public void setShadowSize(double shadowSize) {

		this.shadowSize = shadowSize;

	}

	public String getText() {

		return text;

	}

	public void setText(String text) {

		this.text = text;

	}

	public double getSpace() {

		return space;

	}

	public void setSpace(double space) {

		this.space = space;

	}

	public double getWidth() {

		return width;

	}

	public void setWidth(double width) {

		this.width = width;

	}

	public void setBackground(Color background) {

		this.background = background;

	}

	public Color getColorShadowTop() {

		return colorShadowTop;

	}

	public void setColorShadowTop(Color colorShadowTop) {

		this.colorShadowTop = colorShadowTop;

	}

	public Color getColorShadowLeft() {

		return colorShadowLeft;

	}

	public void setColorShadowLeft(Color colorShadowLeft) {

		this.colorShadowLeft = colorShadowLeft;

	}

	public Menu3dItem(Component com, double x, double y, double height, double shadowSize, String text,
			Color background, Color left, Color top) {

		this.fuente = new Font("Dialog", Font.PLAIN, 30);

		fondo = background;

		arriba = top;

		izquierda = left;

		this.x = x;

		this.y = y;

		this.height = height;

		this.shadowSize = shadowSize;

		this.text = text;

		animator = new MenuAnimator(com, this);

		colorShadowLeftSelected = new Color(35, 97, 198);

		backgroundSelected = new Color(46, 127, 255);

		colorShadowTopSelected = new Color(40, 113, 229);

		colorShadowLeftSelected = new Color(46, 46, 50);

	}

	public Menu3dItem() {

	}

	public void render(Graphics2D g2, float angle, int left, Component com) {

		width = com.getWidth() - left;

		AffineTransform tran = g2.getTransform();

		float textAngle = getAngleOfLocation(new Point(0, 0), new Point((int) width, (int) (-height))) + 180;

		double tx = x + Math.cos(Math.toRadians(textAngle)) * space;

		double ty = y + Math.sin(Math.toRadians(textAngle)) * space;

		g2.translate(tx, ty);

		Path2D p = new Path2D.Double();

		p.moveTo(0, 0);

		p.lineTo(width, -height);

		p.lineTo(width, 0);

		p.lineTo(0, height);

		double cosX = Math.cos(Math.toRadians(angle));

		double sinY = Math.sin(Math.toRadians(angle));

		Path2D shadowLeft = new Path2D.Double();

		shadowLeft.moveTo(0, 0);

		shadowLeft.lineTo(cosX * shadowSize, sinY * shadowSize);

		shadowLeft.lineTo(cosX * shadowSize, sinY * shadowSize + height);

		shadowLeft.lineTo(0, height);

		Path2D shadowTop = new Path2D.Double();

		shadowTop.moveTo(0, 0);

		shadowTop.lineTo(width, -height);

		shadowTop.lineTo(cosX * shadowSize + width, sinY * shadowSize - height);

		shadowTop.lineTo(cosX * shadowSize, sinY * shadowSize);

		Area area = new Area();

		area.add(new Area(p));

		area.add(new Area(shadowLeft));

		area.add(new Area(shadowTop));

		g2.setColor(background);

		g2.fill(area);

		g2.setColor(colorShadowLeft);

		g2.fill(shadowLeft);

		g2.setColor(colorShadowTop);

		g2.fill(shadowTop);

		g2.setFont(fuente);

		drawText(text, g2, textAngle, com.getForeground());

		g2.setTransform(tran);

	}

	private void drawText(String text, Graphics2D g2, float angle, Color foreground) {

		angle = angle - 360 - 180;

		g2.setColor(foreground);

		AffineTransform tran = g2.getTransform();

		tran.shear(0, Math.toRadians(angle));

		g2.setTransform(tran);

		float yy = getLocationFont(text, g2);

		g2.drawString(text, 10f, yy);

	}

	private float getLocationFont(String text, Graphics2D g2) {

		FontMetrics fm = g2.getFontMetrics();

		Rectangle2D r2 = fm.getStringBounds(text, g2);

		double yy = (height - r2.getHeight()) / 2;

		yy += fm.getAscent() + r2.getHeight() / 5;

		return (float) yy;

	}

	private float getAngleOfLocation(Point start, Point end) {

		double centerX = start.x;

		double centerY = start.y;

		double py = end.y - centerY;

		double px = end.x - centerX;

		double ang = Math.atan2(py, px);

		ang = ang * (180 / Math.PI);

		if (ang < 0) {

			ang = 360 - (-ang);

		}

		return (float) ang;

	}

	public boolean isMouseOver(Point mouse) {

		Path2D p = new Path2D.Double();

		p.moveTo(x, y);

		p.lineTo(x + width, y - height);

		p.lineTo(x + width, y);

		p.lineTo(x, y + height);

		return p.contains(mouse);

	}

	public void animate(float animate) {

		space = 40 * animate;

	}

	public Color getDefaultColorShadowTop() {

		return arriba;

	}

	public Color getDefaultColorShadowLeft() {

		return izquierda;

	}

	public Color getDefaultBackground() {

		return fondo;

	}

	public Color getBackground() {

		return background;

	}

	public Color getDefaultColorShadowTopSelected() {

		return colorShadowTopSelected;

	}

	public Color getDefaultColorShadowLeftSelected() {

		return colorShadowLeftSelected;

	}

	public Color getDefaultBackgroundSelected() {

		return backgroundSelected;

	}

}

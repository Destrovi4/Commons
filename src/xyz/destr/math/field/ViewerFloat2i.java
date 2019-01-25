package xyz.destr.math.field;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.JFrame;

import xyz.destr.math.FloatMath;

public class ViewerFloat2i extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3210362474915834017L;
	private Float2i float2i = null;
	private BufferedImage image = null;
	private boolean repaint = true;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public void setSource(Float2i source) {
		this.float2i = source;
		this.repaint = true;
	}
	
	public void setSourceRegion(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.repaint = true;
	}
	
	@Override
	public void paint(Graphics g) {
		if(float2i != null && repaint) {
			repaint = false;
			if(image == null || image.getWidth() != width || image.getHeight() != height) {
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			}
			final int[] colorBuffer = new int[3];
			final WritableRaster raster = image.getRaster();
			float minValue = Float.POSITIVE_INFINITY;
			float maxValue = Float.NEGATIVE_INFINITY;
			for(int lx = 0; lx < width; lx++) {
				for(int ly = 0; ly < height; ly++) {
					final float value = float2i.getFloat2i(x + lx, y + ly);
					minValue = FloatMath.min(minValue, value);
					maxValue = FloatMath.max(maxValue, value);
				}
			}
			final float valueDeltaByOne = 1.0f / (maxValue - minValue);
			for(int gx = 0; gx < width; gx++) {
				for(int gy = 0; gy < height; gy++) {
					final float value = float2i.getFloat2i(x + gx, y + gy);
					final int gray = (int)(255 * (value - minValue) * valueDeltaByOne);
					colorBuffer[0] = colorBuffer[1] = colorBuffer[2] = gray;
					raster.setPixel(gx, gy, colorBuffer);
				}
			}
		}
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}
	
	public static ViewerFloat2i show(Float2i source, int x, int y, int width, int height) {
		final ViewerFloat2i viewer = new ViewerFloat2i();
		viewer.setSource(source);
		viewer.setSourceRegion(x, y, width, height);
		final Dimension dimension = new Dimension(width, height);
		viewer.setSize(dimension);
		viewer.setPreferredSize(dimension);
		viewer.setLocationRelativeTo(null);
		viewer.setVisible(true);
		viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return viewer;
	}
}

package xyz.destr.math.field;

import java.util.Random;

import xyz.destr.math.Interpolation;

public class ArrayFloat2x implements Float2x {

	private float[] data = null;
	private int sizeX;
	private int sizeY;
	
	public ArrayFloat2x() {}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public void setSize(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.data = new float[sizeX * sizeY];
	}	
	
	public void fillRandom(Random random, float min, float max) {
		final float delta = max - min;
		for(int i = 0, count = data.length; i < count; i++) {
			data[i] = min + random.nextFloat() * delta;
		}
	}
	
	public void set(Float2i source, int x, int y, int width, int height) {
		setSize(width, height);
		for(int yy = 0; yy < height; yy++) {
			final int offset = yy * width;
			for(int xx = 0; xx < width; xx++) {
				data[offset + xx] = source.getFloat2i(x + xx, y + yy);
			}
		}
	}
	
	@Override
	public float getFloat2i(int x, int y) {
		while(x < 0) x += sizeX;
		while(y < 0) y += sizeY;
		return data[x%sizeX + (y%sizeY) * sizeX];
	}
	
	@Override
	public Interpolation getInterpolation() {
		return Interpolation.HERP;
	}

}

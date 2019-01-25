package xyz.destr.math.field;

import xyz.destr.math.Interpolation;

public class ScaledFloat2x implements Float2x {

	public Float2x source;
	public float scaleX;
	public float scaleY;
	
	public ScaledFloat2x() {}
	
	public ScaledFloat2x(Float2x source) {
		this.source = source;
		this.scaleX = 1.0f;
		this.scaleY = 1.0f;
	}
	
	public ScaledFloat2x(Float2x source, float scaleX, float scaleY) {
		this.source = source;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	
	@Override
	public Interpolation getInterpolation() {
		return source.getInterpolation();
	}
	
	@Override
	public float getFloat2f(float x, float y) {
		return source.getFloat2f(x, y);
	}
	
	@Override
	public float getFloat2i(int x, int y) {
		return source.getFloat2f((float)x * scaleX, (float)y * scaleY);
	}

}

package xyz.destr.math.field;

import xyz.destr.math.Interpolation;

public abstract class ProcessedFloat2x implements Float2x {

	public Float2x source;
	
	abstract float processFloat(float value);
	
	@Override
	public Interpolation getInterpolation() {
		return source.getInterpolation();
	}
		
	@Override
	public float getFloat2i(int x, int y) {
		return processFloat(source.getFloat2i(x, y));
	}
	
	@Override
	public float getFloat2f(float x, float y) {
		return processFloat(source.getFloat2f(x, y));
	}

}

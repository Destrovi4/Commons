package xyz.destr.math.field;

import xyz.destr.math.FloatMath;
import xyz.destr.math.IntMath;
import xyz.destr.math.Interpolation;

public interface Float2x extends Float2i, Float2f {

	public float getFloat2i(int x, int y);
	
	default Interpolation getInterpolation() {
		return Interpolation.LERP;
	}
	
	@Override
	public default float getFloat2f(float x, float y) {
		final int left		= IntMath.floor(x);
		final int right		= IntMath.ceil(x);
		final int top		= IntMath.floor(y);
		final int bottom 	= IntMath.ceil(y);
		
		final float xInterpolation = x - FloatMath.floor(x);
		
		final Interpolation interpolation = getInterpolation();
		final float topInterpolation = interpolation.interpolate(getFloat2i(left, top), getFloat2i(right, top), xInterpolation);
		final float bottomInterpolation = interpolation.interpolate(getFloat2i(left, bottom), getFloat2i(right, bottom), xInterpolation);
		return interpolation.interpolate(topInterpolation, bottomInterpolation, y - FloatMath.floor(y));
	}
	
}

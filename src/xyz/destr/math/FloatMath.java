package xyz.destr.math;

public class FloatMath {
	
	public static final float TWO_PI = (float)(2.0 * Math.PI);
	public static final float PI = (float)Math.PI;
	
	public static final float abs(float value) {
		return Math.abs(value);
	}
	
	public static final float sqrt(float value) {
		return (float)Math.sqrt(value);
	}
	
	public static final float magnitude(float x, float y, float z) {
		return (float)Math.sqrt(x*x+y*y+z*z);
	}
	
	public static final float magnitude(float x, float y) {
		return (float)Math.sqrt(x*x+y*y);
	}
	
	public static final float cos(float rad) {
		return (float)Math.cos(rad);
	}
	
	public static final float sin(float rad) {
		return (float)Math.sin(rad);
	}
	
	public static final float lerp(float p, float a, float b) {
		return (1f-p) * a + p * b;
	}
}

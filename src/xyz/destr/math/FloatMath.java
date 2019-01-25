package xyz.destr.math;

public class FloatMath {
	
	public static final float TWO_PI = (float)(2.0 * Math.PI);
	public static final float PI = (float)Math.PI;
	
	public static final float floor(float value) {
		return (float)Math.floor(value);
	}
	
	public static final float ceil(float value) {
		return (float)Math.ceil(value);
	}
	
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

	public static float pow(float a, int b) {
		return (float)Math.pow(a, b);
	}

	public static float clamp(float value, float min, float max) {
		return Math.max(min, Math.min(value, max));
	}

	public static float min(float a, float b) {
		return Math.min(a, b);
	}

	public static float max(float a, float b) {
		return Math.max(a, b);
	}
}

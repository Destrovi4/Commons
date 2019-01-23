package xyz.destr.math;

public interface Interpolation {
	
	public static double lerp(double min, double max, double f) {
		return min - (min - max) * f;
	}
	
	public static float lerp(float min, float max, float f) {
		return min - (min - max) * f;
	}
	
	public static double herp(double min, double max, double f) {
		return min - (min - max) * (3.0d - 2.0d * f) * f * f;
	}
	
	public static float herp(float min, float max, float f) {
		return min - (min - max) * (3.0f - 2.0f * f) * f * f;
	}
	
	/**
	 * interpolates from min and to max
	 * @param min
	 * @param max
	 * @param factor from 0.0d to 1.0d
	 * @return value between min and max
	 */
	public double interpolate(double min, double max, double factor);
	
	/**
	 * interpolates from min and to max
	 * @param min
	 * @param max
	 * @param factor from 0.0f to 1.0f
	 * @return value between min and max
	 */
	public float interpolate(float min, float max, float factor);
	
	public static final Interpolation LERP = new Interpolation() {

		@Override
		public double interpolate(double min, double max, double factor) {			
			return lerp(min, max, factor);
		}

		@Override
		public float interpolate(float min, float max, float factor) {
			return lerp(min, max, factor);
		}
		
	};
	
	public static final Interpolation HERP = new Interpolation() {

		@Override
		public double interpolate(double min, double max, double factor) {
			return herp(min, max, factor);
		}
		
		@Override
		public float interpolate(float min, float max, float factor) {
			return herp(min, max, factor);
		}
		
	};
	
}

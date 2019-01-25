package xyz.destr.math.field;

public class MinMaxFloat2i {
	
	public int minX;
	public int minY;
	public float minValue;
	
	public int maxX;
	public int maxY;
	public float maxValue;
	
	public void find(Float2i source, int x, int y, int width, int height) {
		minX = maxX = x;
		minY = maxY = y;
		minValue = maxValue = source.getFloat2i(x, y);
		final int endX = x + width;
		for(int xx = x + 1; xx < endX; xx++) {
			final float value = source.getFloat2i(xx, y);
			if(value < minValue) {
				minValue = value;
				minX = xx;
			}
			if(value > maxValue) {
				maxValue = value;
				maxX = xx;
			}
		}
		final int endY = y + height;
		for(int yy = y + 1; yy < endY; yy++) {
			for(int xx = x; xx < endX; xx++) {
				final float value = source.getFloat2i(xx, yy);
				if(value < minValue) {
					minValue = value;
					minX = xx;
					minY = yy;
				}
				if(value > maxValue) {
					maxValue = value;
					maxX = xx;
					maxY = yy;
				}
			}
		}
	}
	
}

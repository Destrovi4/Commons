package xyz.destr.math.field;

public class ArraySummFloat2x<T extends Float2x> implements Float2x {

	public T[] source;
	
	@Override
	public float getFloat2f(float x, float y) {
		float summ = 0;
		for(Float2x surrentSource: source)
			summ += surrentSource.getFloat2f(x, y);
		return summ;
	}
	
	@Override
	public float getFloat2i(int x, int y) {
		float summ = 0;
		for(Float2x surrentSource: source)
			summ += surrentSource.getFloat2i(x, y);
		return summ;
	}

}

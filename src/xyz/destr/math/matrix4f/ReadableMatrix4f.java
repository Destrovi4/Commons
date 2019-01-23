package xyz.destr.math.matrix4f;

public interface ReadableMatrix4f {
	public float get00();
	public float get01();
	public float get02();
	public float get03();
	public float get10();
	public float get11();
	public float get12();
	public float get13();
	public float get20();
	public float get21();
	public float get22();
	public float get23();
	public float get30();
	public float get31();
	public float get32();
	public float get33();
	
	public float[] toArray(float[] store);
}

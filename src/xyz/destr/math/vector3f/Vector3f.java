package xyz.destr.math.vector3f;

public class Vector3f implements MutableVector3f {
	
	public float x;
	public float y;
	public float z;
	
	public Vector3f() {}
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float sqrMag() {
		return x*x + y*y + z*z;
	}
	
	public float mag() {
		return (float)Math.sqrt(sqrMag());
	}
	
	public void mult(float value) {
		x *= value;
		y *= value;
		z *= value;
	}
	
	public void normalize() {
		mult(1.0f/mag());
	}
	
	public Vector3f cross(Vector3f other, Vector3f store) {
		final float resX = y * other.z - z * other.y; 
		final float resY = z * other.x - x * other.z;
		final float resZ = x * other.y - y * other.x;
        store.setXYZ(resX, resY, resZ);	
		return store;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getZ() {
		return z;
	}

	@Override
	public void setXYZ(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public float sqrDistTo(ReadableVector3f point) {
		final float dx = point.getX() - x;
		final float dy = point.getY() - y;
		final float dz = point.getZ() - z;
		return dx*dx + dy*dy + dz*dz;
	}
}

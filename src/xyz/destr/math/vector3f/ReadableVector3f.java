package xyz.destr.math.vector3f;

public interface ReadableVector3f {

	float getX();
	float getY();
	float getZ();
	
	float sqrDistTo(ReadableVector3f point);

}

package xyz.destr.math.matrix4f;

import xyz.destr.math.FloatMath;
import xyz.destr.math.matrix3f.ReadableMatrix3f;
import xyz.destr.math.vector3f.MutableVector3f;
import xyz.destr.math.vector3f.ReadableVector3f;
import xyz.destr.math.vector3f.Vector3f;

public class Matrix4f extends FloatFildMatrix4f {
	
	@Override
	public void loadIdentity() {
        m01 = m02 = m03 = 0.0f;
        m10 = m12 = m13 = 0.0f;
        m20 = m21 = m23 = 0.0f;
        m30 = m31 = m32 = 0.0f;
        m00 = m11 = m22 = m33 = 1.0f;
    }
	
	public Matrix4f mult(Matrix4f in2, Matrix4f store) {
        float temp00, temp01, temp02, temp03;
        float temp10, temp11, temp12, temp13;
        float temp20, temp21, temp22, temp23;
        float temp30, temp31, temp32, temp33;

        temp00 = m00 * in2.m00
                + m01 * in2.m10
                + m02 * in2.m20
                + m03 * in2.m30;
        temp01 = m00 * in2.m01
                + m01 * in2.m11
                + m02 * in2.m21
                + m03 * in2.m31;
        temp02 = m00 * in2.m02
                + m01 * in2.m12
                + m02 * in2.m22
                + m03 * in2.m32;
        temp03 = m00 * in2.m03
                + m01 * in2.m13
                + m02 * in2.m23
                + m03 * in2.m33;

        temp10 = m10 * in2.m00
                + m11 * in2.m10
                + m12 * in2.m20
                + m13 * in2.m30;
        temp11 = m10 * in2.m01
                + m11 * in2.m11
                + m12 * in2.m21
                + m13 * in2.m31;
        temp12 = m10 * in2.m02
                + m11 * in2.m12
                + m12 * in2.m22
                + m13 * in2.m32;
        temp13 = m10 * in2.m03
                + m11 * in2.m13
                + m12 * in2.m23
                + m13 * in2.m33;

        temp20 = m20 * in2.m00
                + m21 * in2.m10
                + m22 * in2.m20
                + m23 * in2.m30;
        temp21 = m20 * in2.m01
                + m21 * in2.m11
                + m22 * in2.m21
                + m23 * in2.m31;
        temp22 = m20 * in2.m02
                + m21 * in2.m12
                + m22 * in2.m22
                + m23 * in2.m32;
        temp23 = m20 * in2.m03
                + m21 * in2.m13
                + m22 * in2.m23
                + m23 * in2.m33;

        temp30 = m30 * in2.m00
                + m31 * in2.m10
                + m32 * in2.m20
                + m33 * in2.m30;
        temp31 = m30 * in2.m01
                + m31 * in2.m11
                + m32 * in2.m21
                + m33 * in2.m31;
        temp32 = m30 * in2.m02
                + m31 * in2.m12
                + m32 * in2.m22
                + m33 * in2.m32;
        temp33 = m30 * in2.m03
                + m31 * in2.m13
                + m32 * in2.m23
                + m33 * in2.m33;

        store.m00 = temp00;
        store.m01 = temp01;
        store.m02 = temp02;
        store.m03 = temp03;
        store.m10 = temp10;
        store.m11 = temp11;
        store.m12 = temp12;
        store.m13 = temp13;
        store.m20 = temp20;
        store.m21 = temp21;
        store.m22 = temp22;
        store.m23 = temp23;
        store.m30 = temp30;
        store.m31 = temp31;
        store.m32 = temp32;
        store.m33 = temp33;

        return store;
    }
	
	public Matrix4f transpose() {
        float tmp = m01;
        m01 = m10;
        m10 = tmp;

        tmp = m02;
        m02 = m20;
        m20 = tmp;

        tmp = m03;
        m03 = m30;
        m30 = tmp;

        tmp = m12;
        m12 = m21;
        m21 = tmp;

        tmp = m13;
        m13 = m31;
        m31 = tmp;

        tmp = m23;
        m23 = m32;
        m32 = tmp;

        return this;
    }
	
	public void setTranslate(float x, float y, float z){
		m03 = x;
		m13 = y;
		m23 = z;
		      m01 = m02 = 0.0f;
        m10       = m12 = 0.0f;
        m20 = m21       = 0.0f;
        m30 = m31 = m32 = 0.0f;
        m00 = m11 = m22 = m33 = 1.0f;
	}
	
	public void setRotation(float radians, float x, float y, float z) {
		float cos = (float)Math.cos(radians);
		float sin = (float)Math.sin(radians);
		float iCos = 1.0f - cos;
		float x2 = x*x;
		float y2 = y*y;
		float z2 = z*z;
		
		m00 = cos+x2*iCos;		m01 = x*y*iCos-z*sin;	m02 = x*z*iCos+y*sin;	m03 = 0.0f;
		m10 = y*x*iCos+z*sin;	m11 = cos+y2*iCos;		m12 = y*z*iCos-x*sin;	m13 = 0.0f;
		m20 = z*x*iCos-y*sin;	m21 = z*y*iCos+x*sin;	m22 = cos+z2*iCos;		m23 = 0.0f;
		m30 = 0.0f;				m31 = 0.0f;				m32 = 0.0f;				m33 = 1.0f;
	}
	
	public void setPerspective(float width, float height, float near_plane, float far_plane, float radians) {
		float fieldOfView = radians;
		float aspectRatio = (float)width / (float)height;
		float y_scale = (float)(1.0f/Math.tan(fieldOfView / 2f));
		float x_scale = y_scale / aspectRatio;
		float frustum_length = far_plane - near_plane;
		
		m10 = m02 = m03 = m10 = m12 = m13 = m20 = m21 = m30 = m31 = 0.0f;
		m00 = x_scale;
		m11 = y_scale;
		m22 = -((far_plane + near_plane) / frustum_length);
		m32 = -1;
		m23 = -((2 * near_plane * far_plane) / frustum_length);
		m33 = 0;
	}
	
	@Override
    public Matrix4f clone() {
		return (Matrix4f) super.clone();
    }

	public void setTransform(ReadableVector3f position, ReadableVector3f scale, ReadableMatrix3f rotation) {
		m00 = scale.getX() * rotation.get00();
        m01 = scale.getY() * rotation.get01();
        m02 = scale.getZ() * rotation.get02();
        m03 = position.getX();
        m10 = scale.getX() * rotation.get10();
        m11 = scale.getY() * rotation.get11();
        m12 = scale.getZ() * rotation.get12();
        m13 = position.getY();
        m20 = scale.getX() * rotation.get20();
        m21 = scale.getY() * rotation.get21();
        m22 = scale.getZ() * rotation.get22();
        m23 = position.getZ();

        m30 = 0;
        m31 = 0;
        m32 = 0;
        m33 = 1;
	}
	
	public Vector3f mult(Vector3f vec, Vector3f store) {
        float vx = vec.x, vy = vec.y, vz = vec.z;
        store.x = m00 * vx + m01 * vy + m02 * vz + m03;
        store.y = m10 * vx + m11 * vy + m12 * vz + m13;
        store.z = m20 * vx + m21 * vy + m22 * vz + m23;

        return store;
    }
	
	public Vector3f mult(Vector3f vec) {
        return mult(vec, vec);
    }
	
	public MutableVector3f mult(ReadableVector3f vec, MutableVector3f store) {
        float vx = vec.getX(), vy = vec.getY(), vz = vec.getZ();
        store.setXYZ(
        	m00 * vx + m01 * vy + m02 * vz + m03,
        	m10 * vx + m11 * vy + m12 * vz + m13,
        	m20 * vx + m21 * vy + m22 * vz + m23
        );
        return store;
    }
	
	public MutableVector3f mult(MutableVector3f vec) {
        return mult(vec, vec);
    }
		
	public Matrix4f lookAt(
			float eyeX, float eyeY, float eyeZ, 
			float centerX, float centerY, float centerZ, 
            float upX, float upY, float upZ
    ) {
		
		final float fwdX = centerX - eyeX;
		final float fwdY = centerY - eyeY;
		final float fwdZ = centerZ - eyeZ;
		final float oneByDeltaMag = 1.0f / FloatMath.magnitude(fwdX, fwdY, fwdZ);
		
		final float nFwdX = fwdX * oneByDeltaMag;
		final float nFwdY = fwdY * oneByDeltaMag;
		final float nFwdZ = fwdZ * oneByDeltaMag;
		
		final float sideX = nFwdY * upZ - nFwdZ * upY;
		final float sideY = nFwdZ * upX - nFwdX * upZ;
		final float sideZ = nFwdX * upY - nFwdY * upX;
		final float oneBySideMag = 1.0f / FloatMath.magnitude(sideX, sideY, sideZ);
		
		final float nSideX = sideX * oneBySideMag;
		final float nSideY = sideY * oneBySideMag;
		final float nSideZ = sideZ * oneBySideMag;
		
		final float fixedUpX = nSideY * nFwdZ - nSideZ * nFwdY; 
		final float fixedUpY = nSideZ * nFwdX - nSideX * nFwdZ;
		final float fixedUpZ = nSideX * nFwdY - nSideY * nFwdX;
		final float oneByFixedUpMag = 1.0f / FloatMath.magnitude(fixedUpX, fixedUpY, fixedUpZ);
		
		final float nFixedUpX = fixedUpX * oneByFixedUpMag;
		final float nFixedUpY = fixedUpY * oneByFixedUpMag;
		final float nFixedUpZ = fixedUpZ * oneByFixedUpMag;
		
				
		setNormalizedBasis(
			nSideX, nSideY, nSideZ,
			nFixedUpX, nFixedUpY, nFixedUpZ,
			-nFwdX, -nFwdY, -nFwdZ
		);
		transpose();
		
		
		translate(-eyeX, -eyeY, -eyeZ);
		
		return this;
	}
	
	public Matrix4f setBasis(
		float xx, float xy, float xz,
		float yx, float yy, float yz,
		float zx, float zy, float zz
	) {
		final float oneByMagFwd = 1.0f / FloatMath.sqrt(xx*xx + xy*xy * xz*xz);
		final float oneByMagSide = 1.0f / FloatMath.sqrt(yx*yx + yy*yy * yz*yz);
		final float oneByMagUp = 1.0f / FloatMath.sqrt(zx*zx + zy*zy * zz*zz);
		return setNormalizedBasis(
			xx * oneByMagSide,	xy * oneByMagSide,	xz * oneByMagSide,
			yx * oneByMagUp,	yy * oneByMagUp,	yz * oneByMagUp,
			zx * oneByMagFwd,	zy * oneByMagFwd,	zz * oneByMagFwd
		);
	}

	
	public Matrix4f setNormalizedBasis(
		float xx, float xy, float xz,
		float yx, float yy, float yz,
		float zx, float zy, float zz
	) {
		m00 = xx;
	    m01 = xy;
	    m02 = xz;
	    m03 = 0;

	    m10 = yx;
	    m11 = yy;
	    m12 = yz;
	    m13 = 0;

	    m20 = zx;
	    m21 = zy;
	    m22 = zz;
	    m23 = 0;
	    
	    m30 = m31 = m32 = 0;
	    m33 = 1;
		return this;
	}
	
	public Matrix4f translate(Vector3f vec, Matrix4f dest) {
	    dest.m30 += m00 * vec.x + m10 * vec.y + m20 * vec.z;
	    dest.m31 += m01 * vec.x + m11 * vec.y + m21 * vec.z;
	    dest.m32 += m02 * vec.x + m12 * vec.y + m22 * vec.z;
	    dest.m33 += m03 * vec.x + m13 * vec.y + m23 * vec.z;
	    return this;
	}
	
	public Matrix4f translate(float x, float y, float z) {
		return translate(x, y, z, this);
	}
	
	public Matrix4f translate(float x, float y, float z, Matrix4f dest) {
	    dest.m30 += m00 * x + m10 * y + m20 * z;
	    dest.m31 += m01 * x + m11 * y + m21 * z;
	    dest.m32 += m02 * x + m12 * y + m22 * z;
	    dest.m33 += m03 * x + m13 * y + m23 * z;
	    return this;
	}
	
	public void perspective(final float near_plane, final float far_plane, final float width, final float height, final float fieldOfView) {
		final float aspectRatio = width / height;
		final float y_scale = (float)(1.0f/Math.tan(fieldOfView / 2f));
		final float x_scale = y_scale / aspectRatio;
		final float frustum_length = far_plane - near_plane;
		 
		m00 = x_scale;
		m01 = 0;
		m02 = 0;
		m03 = 0;
		
		m10 = 0;
		m11 = y_scale;
		m12 = 0;
		m13 = 0;
		
		m20 = 0;
		m21 = 0;
		m22 = -((far_plane + near_plane) / frustum_length);
		m23 = -1;
		
		m30 = 0;
		m31 = 0;
		m32 = -((2 * near_plane * far_plane) / frustum_length);
		m33 = 0;
	}

}

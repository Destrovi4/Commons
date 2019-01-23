package xyz.destr.math.matrix3f;

public class Matrix3f implements MutableMatrix3f {
	
	public float m00, m01, m02;
	public float m10, m11, m12;
	public float m20, m21, m22;
	
	@Override
	public float get00() {
		return m00;
	}
	@Override
	public float get01() {
		return m01;
	}
	@Override
	public float get02() {
		return m02;
	}
	@Override
	public float get10() {
		return m10;
	}
	@Override
	public float get11() {
		return m11;
	}
	@Override
	public float get12() {
		return m12;
	}
	@Override
	public float get20() {
		return m20;
	}
	@Override
	public float get21() {
		return m21;
	}
	@Override
	public float get22() {
		return m22;
	}
	
	public Matrix3f normalize(Matrix3f store) {
        if (store == null) {
            store = new Matrix3f();
        }

        float mag = 1.0f / (float)Math.sqrt(
                m00 * m00
                + m10 * m10
                + m20 * m20);

        store.m00 = m00 * mag;
        store.m10 = m10 * mag;
        store.m20 = m20 * mag;

        mag = 1.0f / (float)Math.sqrt(
                m01 * m01
                + m11 * m11
                + m21 * m21);

        store.m01 = m01 * mag;
        store.m11 = m11 * mag;
        store.m21 = m21 * mag;

        store.m02 = store.m10 * store.m21 - store.m11 * store.m20;
        store.m12 = store.m01 * store.m20 - store.m00 * store.m21;
        store.m22 = store.m00 * store.m11 - store.m01 * store.m10;
        return store;
    }
	
	public Matrix3f normalize() {
		return normalize(this);
	}
	
	public void fromAngleNormalAxis(float angle, float x, float y, float z) {
        float fCos = (float)Math.cos(angle);
        float fSin = (float)Math.sin(angle);
        float fOneMinusCos = ((float) 1.0) - fCos;
        float fX2 = x*x;
        float fY2 = y*y;
        float fZ2 = z*z;
        float fXYM = x * y * fOneMinusCos;
        float fXZM = x * z * fOneMinusCos;
        float fYZM = y * z * fOneMinusCos;
        float fXSin = x * fSin;
        float fYSin = y * fSin;
        float fZSin = z * fSin;

        m00 = fX2 * fOneMinusCos + fCos;
        m01 = fXYM - fZSin;
        m02 = fXZM + fYSin;
        m10 = fXYM + fZSin;
        m11 = fY2 * fOneMinusCos + fCos;
        m12 = fYZM - fXSin;
        m20 = fXZM - fYSin;
        m21 = fYZM + fXSin;
        m22 = fZ2 * fOneMinusCos + fCos;
    }
	
	public Matrix3f mult(Matrix3f mat, Matrix3f product) {

        float temp00, temp01, temp02;
        float temp10, temp11, temp12;
        float temp20, temp21, temp22;

        if (product == null) {
            product = new Matrix3f();
        }
        temp00 = m00 * mat.m00 + m01 * mat.m10 + m02 * mat.m20;
        temp01 = m00 * mat.m01 + m01 * mat.m11 + m02 * mat.m21;
        temp02 = m00 * mat.m02 + m01 * mat.m12 + m02 * mat.m22;
        temp10 = m10 * mat.m00 + m11 * mat.m10 + m12 * mat.m20;
        temp11 = m10 * mat.m01 + m11 * mat.m11 + m12 * mat.m21;
        temp12 = m10 * mat.m02 + m11 * mat.m12 + m12 * mat.m22;
        temp20 = m20 * mat.m00 + m21 * mat.m10 + m22 * mat.m20;
        temp21 = m20 * mat.m01 + m21 * mat.m11 + m22 * mat.m21;
        temp22 = m20 * mat.m02 + m21 * mat.m12 + m22 * mat.m22;

        product.m00 = temp00;
        product.m01 = temp01;
        product.m02 = temp02;
        product.m10 = temp10;
        product.m11 = temp11;
        product.m12 = temp12;
        product.m20 = temp20;
        product.m21 = temp21;
        product.m22 = temp22;

        return product;
    }
	
	public Matrix3f mult(Matrix3f mat) {
		return mult(mat, this);
	}
	
	public Matrix3f loadIdentity() {
        m01 = m02 = m10 = m12 = m20 = m21 = 0;
        m00 = m11 = m22 = 1;
        return this;
    }
	
}

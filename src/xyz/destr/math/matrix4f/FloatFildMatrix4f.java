package xyz.destr.math.matrix4f;

public abstract class FloatFildMatrix4f implements MutableMatrix4f, Cloneable {
	
	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;

	//WritableMatrix4f
	
	public void setMatrix4f(
		float m00, float m01, float m02, float m03,
		float m10, float m11, float m12, float m13,
		float m20, float m21, float m22, float m23,
		float m30, float m31, float m32, float m33
	) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}
	
	@Override
	public void setMatrix4f(ReadableMatrix4f matrix) {
		if(matrix instanceof FloatFildMatrix4f) {
			setMatrix4f((FloatFildMatrix4f)matrix);
		} else {
			this.m00 = matrix.get00();
			this.m01 = matrix.get01();
			this.m02 = matrix.get02();
			this.m03 = matrix.get03();
			this.m10 = matrix.get10();
			this.m11 = matrix.get11();
			this.m12 = matrix.get12();
			this.m13 = matrix.get13();
			this.m20 = matrix.get20();
			this.m21 = matrix.get21();
			this.m22 = matrix.get22();
			this.m23 = matrix.get23();
			this.m30 = matrix.get30();
			this.m31 = matrix.get31();
			this.m32 = matrix.get32();
			this.m33 = matrix.get33();
		}
	}
	
	public void setMatrix4f(FloatFildMatrix4f matrix) {
		this.m00 = matrix.m00;
		this.m01 = matrix.m01;
		this.m02 = matrix.m02;
		this.m03 = matrix.m03;
		this.m10 = matrix.m10;
		this.m11 = matrix.m11;
		this.m12 = matrix.m12;
		this.m13 = matrix.m13;
		this.m20 = matrix.m20;
		this.m21 = matrix.m21;
		this.m22 = matrix.m22;
		this.m23 = matrix.m23;
		this.m30 = matrix.m30;
		this.m31 = matrix.m31;
		this.m32 = matrix.m32;
		this.m33 = matrix.m33;
	}
	
	//ReadableMatrix4f
	
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
	public float get03() {
		return m03;
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
	public float get13() {
		return m13;
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
		return m33;
	}

	@Override
	public float get23() {
		return m23;
	}

	@Override
	public float get30() {
		return m30;
	}

	@Override
	public float get31() {
		return m31;
	}

	@Override
	public float get32() {
		return m32;
	}

	@Override
	public float get33() {
		return m33;
	}
	
	@Override
	public float[] toArray(float[] store) {
		store[ 0] = m00;
		store[ 1] = m01;
		store[ 2] = m02;
		store[ 3] = m03;
		store[ 4] = m10;
		store[ 5] = m11;
		store[ 6] = m12;
		store[ 7] = m13;
		store[ 8] = m20;
		store[ 9] = m21;
		store[10] = m22;
		store[11] = m23;
		store[12] = m30;
		store[13] = m31;
		store[14] = m32;
		store[15] = m33;
		return store;
	}
	
	//Object and other
	
	@Override
    public FloatFildMatrix4f clone() {
        try {
            return (FloatFildMatrix4f) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // can not happen
        }
    }
	
	@Override
    public int hashCode() {
        int hash = 37;
        hash = 37 * hash + Float.floatToIntBits(m00);
        hash = 37 * hash + Float.floatToIntBits(m01);
        hash = 37 * hash + Float.floatToIntBits(m02);
        hash = 37 * hash + Float.floatToIntBits(m03);

        hash = 37 * hash + Float.floatToIntBits(m10);
        hash = 37 * hash + Float.floatToIntBits(m11);
        hash = 37 * hash + Float.floatToIntBits(m12);
        hash = 37 * hash + Float.floatToIntBits(m13);

        hash = 37 * hash + Float.floatToIntBits(m20);
        hash = 37 * hash + Float.floatToIntBits(m21);
        hash = 37 * hash + Float.floatToIntBits(m22);
        hash = 37 * hash + Float.floatToIntBits(m23);

        hash = 37 * hash + Float.floatToIntBits(m30);
        hash = 37 * hash + Float.floatToIntBits(m31);
        hash = 37 * hash + Float.floatToIntBits(m32);
        hash = 37 * hash + Float.floatToIntBits(m33);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (this == object) {
            return true;
        } else if(object instanceof FloatFildMatrix4f) {
        	FloatFildMatrix4f comp = (FloatFildMatrix4f) object;
	        return !(
	        	Float.compare(m00, comp.m00) != 0 ||
	        	Float.compare(m01, comp.m01) != 0 ||
	        	Float.compare(m02, comp.m02) != 0 ||
	        	Float.compare(m03, comp.m03) != 0 ||
	        	Float.compare(m10, comp.m10) != 0 ||
	        	Float.compare(m11, comp.m11) != 0 ||
	        	Float.compare(m12, comp.m12) != 0 ||
	        	Float.compare(m13, comp.m13) != 0 ||
	        	Float.compare(m20, comp.m20) != 0 ||
	        	Float.compare(m21, comp.m21) != 0 ||
	        	Float.compare(m22, comp.m22) != 0 ||
	        	Float.compare(m23, comp.m23) != 0 ||
	        	Float.compare(m30, comp.m30) != 0 ||
	        	Float.compare(m31, comp.m31) != 0 ||
	        	Float.compare(m32, comp.m32) != 0 ||
	        	Float.compare(m33, comp.m33) != 0
	        );
        } else if(object instanceof ReadableMatrix4f) {
        	ReadableMatrix4f comp = (ReadableMatrix4f) object;
	        return !(
	        	Float.compare(m00, comp.get00()) != 0 ||
	        	Float.compare(m01, comp.get01()) != 0 ||
	        	Float.compare(m02, comp.get02()) != 0 ||
	        	Float.compare(m03, comp.get03()) != 0 ||
	        	Float.compare(m10, comp.get10()) != 0 ||
	        	Float.compare(m11, comp.get11()) != 0 ||
	        	Float.compare(m12, comp.get12()) != 0 ||
	        	Float.compare(m13, comp.get13()) != 0 ||
	        	Float.compare(m20, comp.get20()) != 0 ||
	        	Float.compare(m21, comp.get21()) != 0 ||
	        	Float.compare(m22, comp.get22()) != 0 ||
	        	Float.compare(m23, comp.get23()) != 0 ||
	        	Float.compare(m30, comp.get30()) != 0 ||
	        	Float.compare(m31, comp.get31()) != 0 ||
	        	Float.compare(m32, comp.get32()) != 0 ||
	        	Float.compare(m33, comp.get33()) != 0
	        );
        } else {
        	return false;
        }
    }
    
    @Override
    public String toString() {
		return "Matrix4f\n[\n"
			+ '\t' + m00 + '\t' + m01 + '\t' + m02 + '\t' + m03 + '\n'
			+ '\t' + m10 + '\t' + m11 + '\t' + m12 + '\t' + m13 + '\n'
			+ '\t' + m20 + '\t' + m21 + '\t' + m22 + '\t' + m23 + '\n'
			+ '\t' + m30 + '\t' + m31 + '\t' + m32 + '\t' + m33 + '\n'
			+ ']';
    }
	
}

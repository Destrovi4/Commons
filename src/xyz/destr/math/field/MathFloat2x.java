package xyz.destr.math.field;

public class MathFloat2x extends ProcessedFloat2x {

	public float add;
	public float mult;
	
	public MathFloat2x() {}
	
	public MathFloat2x(Float2x source) {
		this.source = source;
	}
	
	@Override
	float processFloat(float value) {
		return add + value * mult;
	}

}

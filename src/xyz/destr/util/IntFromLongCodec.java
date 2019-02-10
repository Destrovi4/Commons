package xyz.destr.util;

public interface IntFromLongCodec {
	
	public int decode(long data);
	
	public long encode(long data, int value);
	
	default long change(long data, int delta) {
		return encode(data, decode(data) + delta);
	}
	
	default boolean equal(long data, int value) {
		return decode(data) == value;
	}
	
	default boolean notEqual(long data, int value) {
		return decode(data) != value;
	}
	
	default boolean more(long data, int value) {
		return decode(data) > value;
	}
	
	default boolean moreOrEqual(long data, int value) {
		return decode(data) >= value;
	}
	
	default boolean less(long data, int value) {
		return decode(data) < value;
	}
	
	default boolean lessOrEqual(long data, int value) {
		return decode(data) <= value;
	}
	
	public static IntFromLongCodec make(int dataBits, int offsetBits) {
		return new Universal(dataBits, offsetBits);
	}
	
	static class Universal implements IntFromLongCodec {
		
		private final long dataMask;
		private final long otherDataMask;
		private final int offsetBits;
		
		public Universal(int dataBits, int offsetBits) {
			this.dataMask = ~(0xFFFFFFFFFFFFFFFFL<<dataBits)<<offsetBits;
			this.otherDataMask = ~dataMask;
			this.offsetBits = offsetBits;
		}

		@Override
		public int decode(long data) {
			return (int)((data&dataMask)>>offsetBits);
		}

		@Override
		public long encode(long data, int value) {
			return (data&otherDataMask)|((value<<offsetBits)&dataMask);
		}
		
	}
}

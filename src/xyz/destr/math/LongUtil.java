package xyz.destr.math;

public class LongUtil {
	
	public static final int decodeInt(long data, long mask, int offset) {
		return (int)((data&mask)>>offset);
	}
	
	public static final long encodeInt(long data, long mask, int offset, int value) {
		return (data&(~mask))|((value<<offset)&mask);
	}
	
}

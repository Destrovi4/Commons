package xyz.destr.math;

public class Hash {
	
	public static int ofCoupleInt(int a, int b) {
		return a * 31 + b;
	}
	
	public static int ofQuartetInt(int a, int b, int c, int d) {
		int hash = a;
		hash = hash * 31 + b;
		hash = hash * 31 + c;
		return hash * 31 + d;
	}
	
	public static int ofCharSequence(CharSequence cs) {
		int hash = 0;
		int factor = 1;
		for(int i = 0, count = cs.length(); i < count; i++) {
			hash += cs.charAt(count - i - 1) * factor;
			factor *= 31;
		}
		return hash;
	}
	
	public static int ofChar(char[] data) {
		int hash = 0;
		int factor = 1;
		for(int i = 0, count = data.length; i < count; i++) {
			hash += data[count - i - 1] * factor;
			factor *= 31;
		}
		return hash;
	}
	
}

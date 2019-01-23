package xyz.destr.math.matrix4f;

import java.io.IOException;
import java.util.StringTokenizer;

public interface MutableMatrix4f extends ReadableMatrix4f, WritableMatrix4f {
	
	public static <T extends WritableMatrix4f> T parceString(String source, T store) throws IOException {
		StringTokenizer st = new StringTokenizer(source);
		store.setMatrix4f(
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken()),
			Float.parseFloat(st.nextToken())
		);			
		return store;
	}
	
}

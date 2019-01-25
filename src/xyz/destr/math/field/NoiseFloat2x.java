package xyz.destr.math.field;

import java.util.Random;

import xyz.destr.math.FloatMath;
import xyz.destr.math.IntMath;

public class NoiseFloat2x implements Float2x {

	public static final int DEFAULT_OCTAVES_COUNT = 8;
	public static final float DEFAULT_PERSISTENCE = 0.4f;
	
	protected ArraySummFloat2x<Float2x> layers = new ArraySummFloat2x<>();
	
	public void generate(int width, int height) {
		generate(DEFAULT_OCTAVES_COUNT, DEFAULT_PERSISTENCE, width, height);
	}
	
	public void generate(int octavesCount, float persistence, int width, int height) {
		final Float2x[] noiseLayers = layers.source = new Float2x[octavesCount];
		final Random random = new Random();
		for(int i = 0; i < octavesCount; i++) {
			final float frequencie = 1 << i;
			final float amplitude = FloatMath.pow(persistence, noiseLayers.length - i); 
			final ArrayFloat2x layer = new ArrayFloat2x();
			final int layerWidth = IntMath.ceil(width / frequencie);
			final int layerHeight = IntMath.ceil(height / frequencie);
			noiseLayers[i] = new ScaledFloat2x(layer, (float)layerWidth/width, (float)layerHeight/height);
			layer.setSize(layerWidth, layerHeight);
			layer.fillRandom(random, -amplitude, amplitude);
		}		
	}
	
	@Override
	public float getFloat2i(int x, int y) {
		return layers.getFloat2i(x, y);
	}
	
	@Override
	public float getFloat2f(float x, float y) {
		return layers.getFloat2f(x, y);
	}
	
	public static void main(String[] args) {
		NoiseFloat2x noise = new NoiseFloat2x();
		final int width = 800;
		final int height = 600;
		noise.generate(width, height);
		ViewerFloat2i.show(noise, 0, 0, width, height);
	}
	

}

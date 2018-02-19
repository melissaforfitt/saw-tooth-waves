
abstract public class Synth {

	double frequency;
	double time;
	double sampleRate;

	public double get() {
		
		return frequency;
	}

	public void tick() {

		time += 1.0 / sampleRate;
		
	}

}

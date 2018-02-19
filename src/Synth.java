
abstract public class Synth {

	double frequency;
	double time;
	double sampleRate;
	double output;

	public double get() {
		
		return output;
	}

	public void tick() {

		time += 1.0 / sampleRate;
		
	}

}

abstract public class Synth {
	
	double frequency;
	double time;
	double sampleRate = 44100;
	double output;

	abstract public double get();

	public void tick() {

		time += 1.0 / sampleRate;

	}

}
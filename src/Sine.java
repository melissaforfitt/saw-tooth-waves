
public class Sine extends Synth {

	public Sine(double frequency) {

		this.frequency = frequency;

	}

	public double get() {

		output = Math.sin(2 * Math.PI * 450 * time);

		return output;

	}

}

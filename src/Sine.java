
public class Sine extends Synth {

	public Sine(int frequency) {

		this.frequency = frequency;

	}

	public double get() {

		frequency = Math.sin(2 * Math.PI * 450 * time);

		return frequency;

	}

}

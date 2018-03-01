
public class Sine extends Synth {

	public Sine(double frequency) {

		this.frequency = frequency;
		
	}

	public double get() {

		return Math.sin(2 * Math.PI * 450 * time);

	}

}

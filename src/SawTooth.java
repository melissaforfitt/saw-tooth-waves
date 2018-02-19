
public class SawTooth extends Synth {

	public SawTooth(double frequency) {

		this.frequency = frequency;

	}

	public double get() {
		
		output = 2 * ((time * frequency) - Math.floor(0.5 + time * frequency));

		return output;
	}

}

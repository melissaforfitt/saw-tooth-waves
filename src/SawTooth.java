
public class SawTooth extends Synth {

	public SawTooth(double time, double frequency) {

		this.time = time;
		this.frequency = frequency;

	}

	public double get(double time, double frequency) {
		
		frequency = 2 * ((time * frequency) - Math.floor(0.5 + time * frequency));

		return frequency;
	}

}

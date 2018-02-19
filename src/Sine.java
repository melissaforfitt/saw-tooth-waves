
public class Sine {

	int sampleRate;
	private double time;

	public Sine(int sampleRate) {

		this.sampleRate = sampleRate;

	}

	public double get() {

		return Math.sin(2 * Math.PI * 450 * time);

	}

	public void tick() {

		time += 1.0 / sampleRate;

	}

}

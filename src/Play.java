import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import java.util.*;

/** Class to play audio generated in real time */
public class Play {

	/** sample rate in Hz */
	private final int sampleRate = 44100;
	private SourceDataLine line;
	ArrayList<Sine> sine = new ArrayList<Sine>();
	sine.add(new Sine());

	private double get() {

		return sine.get();

	}

	private void tick() {

		sine.tick();

	}

	public Play() throws LineUnavailableException {
		/* Set up to play audio */
		AudioFormat format = new AudioFormat((float) sampleRate, 16, 1, true, false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		line = (SourceDataLine) AudioSystem.getLine(info);
		line.open(format, 1024 * 2);
	}

	/**
	 * Create audio for a given time.
	 * 
	 * @param seconds
	 *            Number of seconds to run for.
	 */
	public void run(int seconds) {
		byte[] buffer = new byte[1024 * 2];
		line.start();
		/* Run a loop to collect audio samples and give them to the audio interface */
		int b = 0;
		for (int i = 0; i < sampleRate * seconds; ++i) {
			short s = (short) (get() * 32768);
			buffer[b] = (byte) s;
			buffer[b + 1] = (byte) (s >> 8);
			b += 2;
			if (b >= buffer.length) {
				line.write(buffer, 0, buffer.length);
				b = 0;
			}
			tick();
		}
	}

	/** Tidy up */
	public void close() {
		line.drain();
		line.stop();
	}

	public static void main(String[] args) throws LineUnavailableException {
		Play p = new Play();
		p.run(5);
		p.close();
	}
}

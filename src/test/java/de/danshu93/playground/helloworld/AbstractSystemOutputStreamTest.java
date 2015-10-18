package de.danshu93.playground.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

/**
 * Abstract unit test which gives access to the contents of the {@link System}s
 * standard and error output streams.
 * 
 * @author Daniel
 *
 */
public abstract class AbstractSystemOutputStreamTest {

	/**
	 * The standard output stream.
	 */
	protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/**
	 * The error output stream.
	 */
	protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	/**
	 * Sets both streams.
	 */
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	/**
	 * Removes both streams.
	 */
	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

}

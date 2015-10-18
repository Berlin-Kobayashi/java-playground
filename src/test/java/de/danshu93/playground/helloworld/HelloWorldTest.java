package de.danshu93.playground.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the {@link HelloWorld} class.
 * 
 * @author Daniel
 *
 */
public class HelloWorldTest extends AbstractSystemOutputStreamTest {

	/**
	 * Tests if {@link HelloWorld} prints 'hello world' to the {@link System}s
	 * standard output stream.
	 */
	@Test
	public void helloWorldShouldReturnHelloWorld() {
		String expected = "hello world";
		HelloWorld.main(new String[] {});
		assertEquals(expected, outContent.toString());
	}

}

package StepDefinations;

import java.util.Arrays;

public class Interview {
	public static void main(String args[]) {
		String arr[] = { "Apple", "Orange", "Guava" };

		// Using Java 8 Streams to count elements
		long count = Arrays.stream(arr).count();

		System.out.println("Count of elements: " + count);
	}
}

/*
 * Copyright 2014, Robert Dyer,
 *                 and Bowling Green State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to generate datasets for use as input in Project 1.
 * Program is modified to be used for the project purposes
 * @author Nitin Chaurasia
 */
public class GenerateDataset {
	/** The maximum value to use when generating random numbers. */
	public static int MAX_VALUE = 1000000;

	private static List<Integer> values;

	/**
	 * Generates a list of random numbers.
	 *
	 * @param size the number of entries in the returned list
	 * @return a list with 'size' randomly generated integers in it
	 */
	public static void sortedData(int size) {
			Collections.sort(values);

		// display the data, one per line
		for (final int i : values)
			System.out.println(i);
	}
	
	public static void reverseSortedData(int size) {
		Collections.reverse(values);

	// display the data, one per line
	for (final int i : values)
		System.out.println(i);
}

	/**
	 * Generates a list of random numbers.
	 *
	 * @param size the number of entries in the returned list
	 * @return a list with 'size' randomly generated integers in it
	 */
	public static List<Integer> randomData(final int size) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add((int)(Math.random() * MAX_VALUE));

		return output;
	}

	/**
	 * Generates a list of numbers all the same value.
	 *
	 * @param size the number of entries in the returned list
	 * @param value the value to use when generating the list
	 * @return a list with 'size' copies of 'value' in it
	 */
	public static List<Integer> sameData(final int size, final int value) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add(value);

		return output;
	}
}
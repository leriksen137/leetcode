package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

import leetcode.helper.PrimitiveIntArrayWrapper;
import leetcode.template.LeetCode;

/**
 * Solution to <a href=
 * "https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove
 * Duplicates from Sorted Array</a>
 * 
 * @author leriksen137
 */
public class Problem26 implements LeetCode {

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int insertIndex = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				nums[insertIndex++] = nums[i];
			}
		}
		return insertIndex;
	}

	private HashMap<PrimitiveIntArrayWrapper, Integer> examples = new HashMap<>();

	private void addExamples() {
		examples.put(new PrimitiveIntArrayWrapper(new int[] { 1, 1, 2 }), 2);
		examples.put(new PrimitiveIntArrayWrapper(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }), 5);
	}

	@Override
	public void run() {
		// this method was built on an old version of a problem template.

		addExamples();

		for (Map.Entry<PrimitiveIntArrayWrapper, Integer> example : examples.entrySet()) {
			PrimitiveIntArrayWrapper exampleInput = example.getKey();
			Integer exampleOutput = example.getValue();

			Integer myOutput = removeDuplicates(exampleInput.getArray());

			try {
				if (myOutput.compareTo(exampleOutput) != 0) {
					System.out.println("Failed");
					System.out.println("\tInput:    " + exampleInput.toString());
					System.out.println("\tExpected: " + exampleOutput.toString());
					System.out.println("\tReturned: " + myOutput.toString());
					return;
				}
			} catch (NullPointerException e) {
				System.out.println("Failed");
				System.out.println("\tNullPointerException on calculating result for: " + exampleInput.toString());
				return;
			}
		}

	}

}
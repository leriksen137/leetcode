package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leetcode.helper.ListUtil;

/**
 * Solution to <a href= "https://leetcode.com/problems/4sum/">4Sum</a>
 * 
 * @author Laurent Eriksen
 */
public class Problem18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> solutionSet = new ArrayList<>();
		int length = nums.length;
		for (int i = 0; i < length - 3; i++) {
			for (int j = i + 1; j < length - 2; j++) {
				for (int k = j + 1; k < length - 1; k++) {
					for (int m = k + 1; m < length; m++) {
						if (nums[i] + nums[j] + nums[k] + nums[m] == 0) {
							// add solution. Automatically converts int to Integer (autoboxing)
							solutionSet.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k], nums[m])));

						}
					}
				}
			}
		}

		// sort all lists for easier comparison
		for (List<Integer> list : solutionSet) {
			Collections.sort(list);
		}

		// check for duplicates
//		boolean duplicateFound = false;
//		while (!duplicateFound) {
//			duplicateFound = false;
//			for (int i = 0; i < solutionSet.size() && !duplicateFound; i++) {
//				for (int j = i + 1; j < solutionSet.size() && !duplicateFound; j++) {
//					if (solutionSet.get(i).equals(solutionSet.get(j))) {
//						solutionSet.remove(j);
//						duplicateFound = true;
//					}
//				}
//			}
//		}

		return solutionSet;
	}

	public void run() {
		int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		List<List<Integer>> solutionSet = fourSum(nums, target);

		System.out.println(solutionSet.toString());

		assert solutionSet.size() == 3 : "Number of solutions wrong";

		// check that sum is zero
		for (List<Integer> list : solutionSet) {
			assert ListUtil.sum(list) == 0 : "ERROR: Sum not equal to zero";
		}

		// check for no duplicates
		for (List<Integer> list1 : solutionSet) {
			for (List<Integer> list2 : solutionSet) {
				if (list1 != list2) {
					assert !list1.equals(list2) : "ERROR: duplicate solution";
				}
			}
		}

	}
}
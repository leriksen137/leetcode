package com.leetcode.problems.problem17;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * leriksen137
 */
public class SolutionTest {

	@Test
	public void testLetterCombinations() {
		Solution s = new Solution();
		String input = "23";
		List<String> solution = s.letterCombinations(input);

		assertTrue(solution.size() == 9);
	}
}

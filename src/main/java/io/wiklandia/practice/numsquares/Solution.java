package io.wiklandia.practice.numsquares;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Breadth first
 * 
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int min = s.numSquares(192);
		System.out.println(min);
	}

	public int numSquares(int n) {
		int m = (int) Math.sqrt(n);
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i <= m; i++) {
			squares.add(i * i);
		}

		Set<Integer> toCheck = new HashSet<>();
		toCheck.add(n);
		int result = 1;
		while (true) {
			Set<Integer> newCheck = new HashSet<>();
			for (int sq : squares) {
				for (int check : toCheck) {
					int val = check - sq;
					if (val == 0) {
						return result;
					} else if (val > 0) {
						newCheck.add(val);
					}
				}
			}
			result++;
			toCheck = newCheck;
		}
	}

}

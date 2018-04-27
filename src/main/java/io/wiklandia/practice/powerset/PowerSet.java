package io.wiklandia.practice.powerset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		permutation("abc");
	}

	static <T> Set<Set<T>> powerSet(Set<T> set) {
		Set<Set<T>> result = new HashSet<>();
		result.add(new HashSet<>());
		for (T t : set) {
			Set<Set<T>> temp = new HashSet<>(result);
			for (Set<T> ss : temp) {
				Set<T> hmm = new HashSet<>(ss);
				hmm.add(t);
				result.add(hmm);
			}
		}
		return result;
	}

	public static void permutation(String str) {
		List<String> aa = new ArrayList<>();
		permutation("", str, aa);
		System.out.println(aa);
	}

	private static void permutation(String prefix, String str, List<String> r) {
		r.add(prefix);
		int n = str.length();
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), r);
			}
		}
	}

}

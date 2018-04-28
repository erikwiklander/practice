package io.wiklandia.practice.palindromes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sol {

	public static void main(String[] args) {

		Sol s = new Sol();
		List<String> palin = s.generatePalindromes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		System.out.println(palin);
	}

	public List<String> generatePalindromes(String s) {

		if (s.length() == 1) {
			return Collections.singletonList(s);
		}

		Map<Character, Integer> countByChar = new HashMap<>();
		for (char c : s.toCharArray()) {
			countByChar.put(c, countByChar.getOrDefault(c, 0) + 1);
		}

		char odd = ' ';
		boolean hasOdd = false;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : countByChar.entrySet()) {

			for (int i = 0; i < entry.getValue() / 2; i++) {
				sb.append(entry.getKey());
			}

			if (entry.getValue() % 2 == 1) {

				if (hasOdd) {
					return Collections.emptyList();
				}

				hasOdd = true;
				odd = entry.getKey();
			}

		}

		Set<String> perm = new HashSet<>();
		permutation("", sb.toString(), perm, new HashSet<>());

		List<String> result = new ArrayList<>();
		for (String p : perm) {
			StringBuilder sss = new StringBuilder(p);
			if (hasOdd) {
				sss.append(odd);
			}
			sss.append(new StringBuilder(p).reverse());
			result.add(sss.toString());
		}

		return result;
	}

	private void permutation(String prefix, String rest, Set<String> result, Set<String> dups) {

		String key = prefix + " " + rest;

		if (dups.contains(key)) {
			return;
		}

		for (int i = 0; i < rest.length(); i++) {
			String s = prefix + rest.charAt(i);
			if (rest.length() == 1) {
				result.add(s);
			} else {
				dups.add(key);
				permutation(s, rest.substring(0, i) + rest.substring(i + 1, rest.length()), result, dups);
			}

		}
	}

}

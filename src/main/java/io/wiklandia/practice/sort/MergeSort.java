package io.wiklandia.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String... args) {
		System.out.println(sort(Arrays.asList(1, 4, 3, 2)));
	}

	public static <T extends Comparable<T>> List<T> sort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		} else {
			return merge(sort(list.subList(0, list.size() / 2)), sort(list.subList(list.size() / 2, list.size())));
		}

	}

	private static <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {
		List<T> result = new ArrayList<>();
		while (!l1.isEmpty() || !l2.isEmpty()) {
			if (l1.isEmpty()) {
				result.addAll(l2);
				return result;
			} else if (l2.isEmpty()) {
				result.addAll(l1);
				return result;
			} else {
				T o1 = l1.get(0);
				T o2 = l2.get(0);
				if (o1.compareTo(o2) < 0) {
					result.add(o1);
					l1 = l1.subList(1, l1.size());
				} else {
					result.add(o2);
					l2 = l2.subList(1, l2.size());
				}
			}
		}
		return result;
	}

}

package io.wiklandia.practice.sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

	public static void main(String... args) {

		System.out.println(sort(Arrays.asList(1, 2, 3, 4, 0, 0)));

	}

	public static <T extends Comparable<T>> List<T> sort(List<T> list) {
		System.out.println(list);
		int swaps = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).compareTo(list.get(i + 1)) > 0) {
				T temp = list.get(i);
				list.set(i, list.get(i + 1));
				list.set(i + 1, temp);
				swaps++;
			}
		}

		if (swaps == 0) {
			return list;
		} else {
			return sort(list);
		}

	}

}

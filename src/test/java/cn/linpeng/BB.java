package cn.linpeng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BB {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		// list.forEach(i -> {
		// System.out.println(i);
		// });

		list.stream().filter(item -> item != 2)
				.sorted(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				}).forEach(i -> {
					System.out.println(i);
				});

	}

}

package tutorium.libs.lang;

import java.util.ArrayList;

public class WrapperSample {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		int i = -23;
		numbers.add(i);
		Integer c = new Integer(23);
		numbers.add(c);
	}

}

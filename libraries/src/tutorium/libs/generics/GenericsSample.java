package tutorium.libs.generics;

import java.util.*;

public class GenericsSample {

	public static void main(String[] args) {

		Cart<String> stringCart = new Cart("Some content...");
		Cart<ArrayList<String>> listCart = new Cart(new ArrayList<String>());

		listCart.getContent().add("New line in listCart");
		listCart.getContent().add("Another line in listCart");
	}
}

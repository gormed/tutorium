package tutorium.libs.lists;

import java.util.LinkedList;

public class LinkedListSample {

	public static void main(String[] args) {
		// erstelle Liste
		LinkedList<Integer> list = new LinkedList<Integer>();
		// Fuege Elemente vorne bzw. hinten ein
		list.addFirst(17);
		list.addLast(42);
		// vorne hinzufuegen
		list.push(111);
		// Fuege 12 an der Position 1 ein
		list.add(1, 12);
		// pruefe ob ein Element in der Liste ist
		if (list.contains(23)) list.add(4);
		// Ausgabe
		System.out.println("In die Liste gucken: " + list.peek());
		System.out.println("Den ersten Eintrag entfernen und ausgeben: " + list.pop());
		System.out.println("Ist die Liste leer?: " + list.isEmpty());
		System.out.println();
		for (Integer i : list) {
			System.out.println(i);
		}

	}

}

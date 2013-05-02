package tutorium.libs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionsSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList implementiert Collection<E>
		ArrayList<Integer> deck = new ArrayList<Integer>();
		
		// Liste befuellen
		for (int i = 0; i < 32; i++) {
			deck.add(i);
		}
		// Eine Collection mischen
		Collections.shuffle(deck, new Random(System.currentTimeMillis()));
		// neue Elemente hinzufuegen
		Collections.addAll(deck, 32, 33, 34, 35);
		// Ausgabe
		System.out.println(deck.toString());
		System.out.println();
		// Liste umkehren
		Collections.reverse(deck);
		// Ausgabe
		System.out.println(deck.toString());
		System.out.println();
		// Sortieren
		Collections.sort(deck);
		System.out.println(deck.toString());
		System.out.println();
		
	}

}

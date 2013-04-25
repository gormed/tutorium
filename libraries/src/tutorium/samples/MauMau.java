package tutorium.samples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class MauMau {

	static final Random rand = new Random(System.currentTimeMillis());
	static LinkedList<Integer> deck = new LinkedList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {

			deck.add(i);

		}

		Collections.shuffle(deck, rand);

		// for (int i = 0; i < 32; i++) {
		//
		// deck.add(getRandomNumber());
		//
		// }
		//
		for (Integer i : deck) {
			System.out.println(i);
		}
		
		
	}

	public static int getRandomNumber() {

		int random = rand.nextInt(32);

		while (deck.contains(random)) {

			random = rand.nextInt(32);
		}

		return random;
	}
	
	public static int drawCard() {
		return deck.pop();
	}

}

package tutorium.libs.lists;

import java.util.ArrayList;

public class ArrayListSample {

	public static void main(String[] args) {
		// Liste erstellen
		ArrayList<String> chatList = new ArrayList<String>();
		// hinzufuegen von Eintraegen
		chatList.add("Ich: Hi");
		chatList.add("Name: Hallo");
		chatList.add("...");
		// Ausgabe
		System.out.println("Groeße der Liste: " + chatList.size());
		System.out.println(chatList.toString());
		System.out.println("Eintrag 0: " + chatList.get(0));
		// Liste leeren
		chatList.clear();
		// neue Liste erstellen
		ArrayList<Double> randomNumbers = new ArrayList<Double>(20);
		// Liste befuellen
		for (int i = 0; i < 20; i++) {
			randomNumbers.add(Math.random());
		}
		// Ausgabe
		System.out.println();
		for (Double d : randomNumbers) {
			System.out.println(d);
		}

	}

}

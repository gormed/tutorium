package tutorium.libs.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapSample {

	public static void main(String[] args) {
		// erstelle HashMap
		HashMap<String, Person> personList = new HashMap<String, Person>();
		// fuege Schluessen und Werte hinzu
		Person peter = new Person();
		personList.put("Peter", peter);
		Person paul = new Person();
		personList.put("Paul", paul);
		// geht das?
		personList.put("Paul", peter);
		// Ausgabe
		System.out.println("Beinhaltet Schluessel 'Lisa'?: " + personList.containsKey("Lisa"));
		System.out.println("Beinhaltet Wert peter?: " + personList.containsValue(peter));
		System.out.println();
		for (Map.Entry<String, Person> entry : personList.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
	}

}

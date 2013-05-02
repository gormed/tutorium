package tutorium.libs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import tutorium.libs.util.Person;

public class AdvancedCollectionsSample {

	public static void main(String[] args) {
		// get a pseudo random generator
		Random r = new Random(System.currentTimeMillis());
		// create a list for persons
		ArrayList<Person> persons = new ArrayList<Person>();
		// generate random persons (without names...)
		for (int i = 0; i < 10; i++) {
			persons.add(new Person(r.nextInt(100), 120 + r.nextInt(80), 50 + r
					.nextInt(80), ""));
		}

		// Ausgabe
		System.out.println(persons.toString());
		System.out.println();
		
		// comperator 
		Comparator<Person> ageComp = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getAge() > o2.getAge()) {
					return 1;
				} else if (o1.getAge() < o2.getAge()) {
					return -1;
				}
				return 0;
			}
		};
		// sort a collection with a custom comparator for age
		Collections.sort(persons, ageComp);
		// Ausgabe
		System.out.println(persons.toString());
		System.out.println();
		// comparator
		Comparator<Person> heightComp = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getHeight() > o2.getHeight())
					return 1;
				else if (o1.getHeight() < o2.getHeight())
					return -1;
				return 0;
			}
		};
		// sort a collection with a custom comparator for height
		Collections.sort(persons, heightComp);
		Collections.reverse(persons);
		// Ausgabe
		System.out.println(persons.toString());
		System.out.println();
		
	}

}

package tutorium.libs.maps;

import java.util.HashSet;

public class HashSetSample {

	public static void main(String[] args) {
		// erstelle Menge
		HashSet<String> set = new HashSet<String>();
		// daten für die Menge
		String a = "Beispielstring";
		String b = "Noch ein String";
		String c = "Und noch einer";
		// einfuegen der Strings
		set.add(a);
		// doppelt einfuegen, klappt das?
		set.add(a);
		set.add(b);
		set.add(c);
		// pruefen ob ein Element in der Menge ist
		if (set.contains(a))
			System.out.println("Die Menge beinhaltet 'a'");
		System.out.println();
		// Ausgabe, ist 'a' doppelt?
		for (String s : set)
			System.out.println(s);

	}

}

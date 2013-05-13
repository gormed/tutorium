package tutorium.libs.lang;

public class StringSample {

	public static void main(String[] args) {

		char[] somechars = { ' ', 'A', 'D', 'D', ' ', 's', 't', 'h', ' ', 'h', 'e',
				'r', 'e', ' ' };
		String s1 = new String(somechars);
		String s2 = "Hello World!";

		s1 = s2 + s1;
		int length = s1.length();
		String s3 = s1.toLowerCase();
		s3.trim();
		String[] splitstrings = s3.split("[!]");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println();
		for (String s : splitstrings) {
			System.out.println(s);
		}

	}

}

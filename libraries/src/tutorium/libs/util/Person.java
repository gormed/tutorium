package tutorium.libs.util;

public class Person {
	private int age = 23;
	private int height = 188;
	private int weight = 80;
	private String name = "Max Mustermann";
	
	public Person() {
		
	}
	
	public Person(int age, int height, int weight, String name) {
		super();
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+name+", "+age+", "+height+", "+weight+")";
	}
}


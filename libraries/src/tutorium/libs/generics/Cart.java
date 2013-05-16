package tutorium.libs.generics;

public class Cart<T> {
	private T content;
	public Cart(T content) {
		this.content = content;
	}
	public T getContent() {
		return content;
	}
}
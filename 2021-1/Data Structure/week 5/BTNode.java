package week5;

public class BTNode<E> {

	protected BTNode<E> left, right;
	protected E data;
	
	public BTNode() {
		left = null;
		right = null;
		data = null;
	}
	
	public BTNode(E n) {
		left = null;
		right = null;
		this.data = n;
	}
	
	public E getData() {
		return data;
	}
	
	public BTNode<E> getRight() {
		return right;
	}
	
	public BTNode<E> getLeft() {
		return left;
	}
	
	public void setRight(BTNode<E> node) {
		right = node;
	}
	
	public void setLeft(BTNode<E> node) {
		left = node;
	}
	
}

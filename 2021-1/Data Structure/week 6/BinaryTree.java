package week6;

public class BinaryTree<E> {
	
	protected Node<E> root;
	
	public BinaryTree() {
		root = null;
	}

	protected BinaryTree(Node<E> root) {
		this.root = root;
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if(leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if(rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}
	
	public void insert(E data) {
		root = insert(root, data);
	}
	
	private Node<E> insert(Node<E> node, E data) {
		if(node == null) {
			node = new Node<E>(data);
		} else {
			if(node.getRight() == null) {
				node.right = insert(node.right, data);
			} else {
				node.left = insert(node.left, data);
			}
		}
		return node;
	}
	
	public E getData() {
		return root.getData();
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node<E> r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.println(r.getData() + " ");
			inorder(r.getRight());
		}
	}
	
	public void preorder() {
		preorder(root);
	}
	
	private void preorder(Node<E> r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}
	
	public void postorder() {
		postorder(root);
	}
	
	private void postorder(Node<E> r) {
		if(r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
	
	
	
	
}

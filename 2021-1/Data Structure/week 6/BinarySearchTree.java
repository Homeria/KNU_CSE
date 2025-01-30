package week6;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	protected boolean addReturn;
	protected E deleteReturn;
	protected Node<E> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Node<E> root) {
		this.root = root;
	}
	
	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
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
	
	
	public E find(E target) {
		return find(root, target);
	}
	
	private E find(Node<E> localRoot, E target) {
		if (localRoot == null) {
			return null;
		}
		
		int compResult = target.compareTo(localRoot.data);
		if(compResult == 0) {
			return localRoot.data;
		} else if (compResult < 0) {
			return find(localRoot.left, target);
		} else {
			return find(localRoot.right, target);
		}
	}
	
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}
	
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}
	
	private Node<E> delete(Node<E> localRoot, E item) {
		if (localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		
		int compResult = item.compareTo(localRoot.data);
		if (compResult < 0) {
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0) {
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			deleteReturn = localRoot.data;
			if (localRoot.left == null) {
				return localRoot.right;
			} else if (localRoot.right == null) {
				return localRoot.left;
			} else {
				if (localRoot.left.right == null) {
					localRoot.data = localRoot.left.data;
					localRoot.left = localRoot.left.left;
					return localRoot;
				} else {
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}
	
	public boolean remove(E target) {
		return delete(target) != null;
	}
	
	public boolean contains(E target) {
		return find(target) != null;
	}
	
	private E findLargestChild(Node<E> parent) {
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}
	
	
	public int maxDepth(BinarySearchTree<E> tree) {
		return maxDepth(tree.root);
	}
	
	private int maxDepth(Node<E> localRoot) {
		int left = 0;
		int right = 0;
		if (localRoot == null) {
			return 0;
		} else {
			left = maxDepth(localRoot.left);
			right = maxDepth(localRoot.right);
		}
		
		System.out.println("Node : " + localRoot.data + ", left = " + left + ", right = " + right);
		
		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}
	
	
	public int minDepth(BinarySearchTree<E> tree) {
		return minDepth(tree.root);
	}
	
	private int minDepth(Node<E> localRoot) {
		int left = 0;
		int right = 0;
		if (localRoot == null) {
			return 0;
		} else {
			left = minDepth(localRoot.left);
			right = minDepth(localRoot.right);
		}
		
		System.out.println("Node : " + localRoot.data + ", left = " + left + ", right = " + right);
		
		if ((left == 0) && (right != 0)) {
			return right + 1;
		} else if ((right == 0) && (left != 0)) {
			return left + 1;
		} else if (left > right) {
			return right + 1;
		} else {
			return left + 1;
		}
		
	}
}

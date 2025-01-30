package week5;

public class BinaryTree<E> {
	
	protected BTNode<E> root;
	
	public BinaryTree() {
		root = null;
	}
	
	protected BinaryTree(BTNode<E> root) {
		this.root = root;
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new BTNode<E>(data);
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
	
	
	/**
	 * 해당 바이너리 트리에 노드를 추가하는 메소드
	 * @param n 노드 추가 방식 구분
	 * @param node 노드1
	 * @param node2 노드2
	 * @return 추가에 성공했다면 true, 실패했다면 false
	 */
	public boolean add(int n, BTNode<E> node, BTNode<E> node2) {
		if (n == 2) {
			root = node;
			return true;
			
		} else if (n == 3) {
			BTNode<E> tmp = root;
			root = node;
			root.setLeft(tmp);
			return true;
			
		} else if (n == 4) {
			if (node.getLeft() == null) {
				node.setLeft(node2);
			} else if (node.getRight() == null) {
				node.setRight(node2);
			} else {
				BTNode<E> node3 = node.getLeft();
				node.setLeft(node2);
				node.getLeft().setLeft(node3);
			}
			return true;
			
		} else {
			System.out.println("[Error] parameter n is not correctly number.");
			return false;
		}
	}
	
	
	/**
	 * 파라미터로 주어진 이진 트리에 해당 데이터가 존재하는지 알아보기 위한 메소드
	 * @param binaryTree 검사할 이진 트리
	 * @param data 이진 트리에 존재하는지 알아보기 위한 데이터
	 * @return
	 */
	public boolean isExist(BinaryTree<E> binaryTree, E data) {
		if (searching(binaryTree, data) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * 파라미터로 주어진 이진 트리에 데이터를 담은 BTNode를 반환받기 위한 메소드
	 * @param binaryTree BTNode들이 들어있는 이진 트리
	 * @param data 찾고자 하는 BTNode의 기준이 되는 데이터
	 * @return data 값이 담긴 BTNode를 발견했다면 해당 BTNode, 발견하지 못했다면 null 반환
	 */
	public BTNode<E> searching(BinaryTree<E> binaryTree, E data) {
		if (binaryTree.isEmpty()) {
			return null;
		} else {
			return searching(binaryTree.root, data);
		}
	}
	
	
	/**
	 * 파라미터로 주어진 BTNode를 따라 재귀적으로 데이터가 담긴 BTNode를 찾아 반환하는 메소드
	 * @param node 기준이 되는 BTNode
	 * @param data 찾고자 하는 BTNode의 기준이 되는 데이터
	 * @return data 값이 담긴 BTNode를 발견했다면 해당 BTNode, 발견하지 못했다면 null 반환
	 */
	private BTNode<E> searching(BTNode<E> node, E data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else {
			BTNode<E> targetNode;
			targetNode = searching(node.getLeft(), data);
			if (targetNode == null) {
				targetNode = searching(node.getRight(), data);
			}
			return targetNode;
		}
	}
	
	/**
	 * 해당 데이터가 담긴 BTNode를 반환하는 메소드
	 * @param node 기준이 되는 BTNode
	 * @param data 찾고자 하는 BTNode의 기준이 되는 데이터
	 * @return data 값이 담긴 BTNode를 발견했다면 해당 BTNode, 발견하지 못했다면 null 반환
	 */
	public BTNode<E> getNode(BTNode<E> node, E data) {
		return searching(node, data);
	}
	

	/**
	 * 해당 이진 트리가 비었는지에 대한 여부를 반환하는 메소드
	 * @return root가 null이라면 true, 아니면 false 반환
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(BTNode<E> r) {
		if(r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	public void preorder() {
		preorder(root);
	}
	
	private void preorder(BTNode<E> r) {
		if(r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
		
	}
	
	public void postorder() {
		postorder(root);
	}
	
	private void postorder(BTNode<E> r) {
		if(r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
	
	
	public void setRoot(BTNode<E> node) {
		root = node;
	}
	
	public void setLeft(BTNode<E> node) {
		root.setLeft(node);
	}
	
	public void setRight(BTNode<E> node) {
		root.setRight(node);
	}

	public BTNode<E> getRoot() {
		return root;
	}
	
	public E getData() {
		return root.getData();
	}
	
	public BTNode<E> getLeft() {
		return root.getLeft();
	}
	
	public BTNode<E> getRight() {
		return root.getRight();
	}
}


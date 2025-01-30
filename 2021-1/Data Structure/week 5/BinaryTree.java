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
	 * �ش� ���̳ʸ� Ʈ���� ��带 �߰��ϴ� �޼ҵ�
	 * @param n ��� �߰� ��� ����
	 * @param node ���1
	 * @param node2 ���2
	 * @return �߰��� �����ߴٸ� true, �����ߴٸ� false
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
	 * �Ķ���ͷ� �־��� ���� Ʈ���� �ش� �����Ͱ� �����ϴ��� �˾ƺ��� ���� �޼ҵ�
	 * @param binaryTree �˻��� ���� Ʈ��
	 * @param data ���� Ʈ���� �����ϴ��� �˾ƺ��� ���� ������
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
	 * �Ķ���ͷ� �־��� ���� Ʈ���� �����͸� ���� BTNode�� ��ȯ�ޱ� ���� �޼ҵ�
	 * @param binaryTree BTNode���� ����ִ� ���� Ʈ��
	 * @param data ã���� �ϴ� BTNode�� ������ �Ǵ� ������
	 * @return data ���� ��� BTNode�� �߰��ߴٸ� �ش� BTNode, �߰����� ���ߴٸ� null ��ȯ
	 */
	public BTNode<E> searching(BinaryTree<E> binaryTree, E data) {
		if (binaryTree.isEmpty()) {
			return null;
		} else {
			return searching(binaryTree.root, data);
		}
	}
	
	
	/**
	 * �Ķ���ͷ� �־��� BTNode�� ���� ��������� �����Ͱ� ��� BTNode�� ã�� ��ȯ�ϴ� �޼ҵ�
	 * @param node ������ �Ǵ� BTNode
	 * @param data ã���� �ϴ� BTNode�� ������ �Ǵ� ������
	 * @return data ���� ��� BTNode�� �߰��ߴٸ� �ش� BTNode, �߰����� ���ߴٸ� null ��ȯ
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
	 * �ش� �����Ͱ� ��� BTNode�� ��ȯ�ϴ� �޼ҵ�
	 * @param node ������ �Ǵ� BTNode
	 * @param data ã���� �ϴ� BTNode�� ������ �Ǵ� ������
	 * @return data ���� ��� BTNode�� �߰��ߴٸ� �ش� BTNode, �߰����� ���ߴٸ� null ��ȯ
	 */
	public BTNode<E> getNode(BTNode<E> node, E data) {
		return searching(node, data);
	}
	

	/**
	 * �ش� ���� Ʈ���� ��������� ���� ���θ� ��ȯ�ϴ� �޼ҵ�
	 * @return root�� null�̶�� true, �ƴϸ� false ��ȯ
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


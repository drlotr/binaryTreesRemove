/*

 * This class defines a binary tree data structure along with utility methods

 * to make it useful.

 */

public class BinaryTree {
	public Node root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int newRecord) {
		root = subtreeInsert(root, newRecord);
	}

	private Node subtreeInsert(Node topNode, int newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord < topNode.record) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}

	public void inOrder() {
		inOrderSubtree(root);
	}

	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}

	public void preOrder() {
		preOrderSubtree(root);
	}

	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}

	public void postOrder() {
		postOrderSubtree(root);
	}

	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}

	public int size() {
		return subtreeSize(root);
	}

	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else if (topNode.left == null && topNode.right == null) {
			return 1;
		} else {
			return subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1;
		}
	}

	public int minDepth() {
		return subtreeMaxDepth(root);
	}

	private int subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else if (topNode.left == null && topNode.right == null) {
			return 1;
		} else {
			return 1;
		}
	}

	public int maxDepth() {
		return subtreeMinDepth(root);
	}

	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else if (topNode.left == null && topNode.right == null) {
			return 1;
		} else {
			return subtreeMaxDepth(topNode.left) + subtreeMaxDepth(topNode.right);
		}
	}

	public int countMatches(int key) {
		return subtreeCountMatches(root, key);
	}

	private int subtreeCountMatches(Node topNode, int key) {
		if (topNode == null) {
			return 0;
		} else if (topNode.left == null && topNode.right == null && topNode.record == key) {
			return 1;
		} else if (topNode.left != null && topNode.right != null && topNode.record == key) {
			return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key) + 1;
		} else {
			return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key);
		}
	}

	public int max() {
		return maxRecord(root);
	}

	private int maxRecord(Node topNode) {
		if (topNode == null) {
			return topNode.record;
		} else if (topNode.right == null) {
			return topNode.record;
		} else {
			return maxRecord(topNode.right);
		}
	}

	public int min() {
		return minRecord(root);
	}

	private int minRecord(Node topNode) {
		if (topNode == null) {
			return topNode.record;
		} else if (topNode.left == null) {
			return topNode.record;
		} else {
			return minRecord(topNode.left);
		}
	}

	public void removeNode(int key) {
		root = subtreeRemoveNode(root, key);
	}

	public Node subtreeRemoveNode(Node topNode, int key) {
		if (topNode == null)
			return topNode;
		if (key < topNode.record)
			topNode.left = subtreeRemoveNode(topNode.left, key);
		else if (key > topNode.record) {
			topNode.right = subtreeRemoveNode(topNode.right, key);
		} else {
			if (topNode.left == null) {
				return topNode.right;
			} else if (topNode.right == null) {
				return topNode.left;
			}
			topNode.record = minRecord(topNode.right);
			topNode.right = subtreeRemoveNode(topNode.right, topNode.record);
		}

		return topNode;
	}
}
/**
 * Binary Search Tree Assignment
 * 
 * 1. write contains (4pts)
 * 2. write traverseInorder (4pts)
 * 3. write randomizedSort (5pts)
 * 4. write delete (5pts)
 * 5. improve insert to self balance using AVL (4pts)
 * 6. improve delete to self balancing using AVL (3pts)
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BinarySearchTree {
	private static final List List = null;

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree('d');
		bst.insert('b');
		bst.insert('c');
		bst.insert('d');
		bst.insert('a');
		bst.insert('e');
		bst.insert('g');
		bst.insert('f');
		bst.insert('h');

		System.out.println(bst.contains('b'));
		System.out.println(bst.traverseInorder());

		bst.print();

		//test code for sort:
		List<Character> l = new LinkedList<Character>();
		l.add('A');
		l.add('A');
		l.add('A');
		l.add('Z');
		l.add('B');
		System.out.println(l);
		BinarySearchTree sort = new BinarySearchTree('A');
		List<Character> sorted = BinarySearchTree.randomizedSort(l);
		System.out.println(sorted);

		sort.print();

	}

	private Node root;

	public BinarySearchTree(char c) {
		root = new Node(c);
	}

	public void print() {
		root.print();
	}

	public void insert(char c) {
		insert(c, root);
	}

	/**
	 * insert for an unbalanced BST.
	 * @param c the letter to insert
	 * @param n the root node to insert from
	 * 
	 * PART 5:
	 * modify this function to balance on insert using AVL algorithm
	 * 
	 */
	private void insert(char c, Node n) {
		if(c==n.data) return;						//c already in tree
		else if(c<n.data) {							//c is less than n
			if(n.left==null) {
				n.left = new Node(c); 	//there is no child to the left, add c
				n.left.parent = n;
			}
			else insert(c, n.left);					//insert c in left subtree
		} else {									//c is greater than n
			if(n.right==null) {
				n.right = new Node(c);//there is no child to the right, add c
				n.right.parent = n;
			}
			else insert(c, n.right);				//insert c in right subtree
		}
	}

	/**
	 * STEP 1:
	 * determine whether c is in the tree
	 * @param c a letter to look for
	 * @return true if c is in the tree
	 * 
	 * Base case: c is initial node
	 * C > initial --> look right
	 * C < initial --> look left
	 * 
	 * 
	 * Recursive function:
	 * base case c is initial
	 * look left until node on the left side is null 
	 * 
	 */

	public boolean contains(char c) {
		return contains(c, root);
	}

	public boolean contains(char c, Node n){

		if(c==n.data){
			return true;
		}
		if(c<n.data){
			if(n.left == null){
				return false;
			}
			else{
				return contains(c, n.left);
			}
		}
		if(c>n.data){
			if(n.right == null){
				return false;
			}
			else{
				return contains(c, n.right);
			}
		}
		return false;
	}

	//	private boolean contains(char c, Node left) {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}

	/**
	 * STEP 2:
	 * do an in order traversal of the tree
	 * ex.
	 * 
	 *        d               
	 *       / \       
	 *		/   \      
	 *	   /     \     
	 *    /       \    
	 *    b       e       
	 *   / \       \   
	 *  /   \       \  
	 *  a   c       g   
	 *  		     \ 
	 *       		  h
	 *        
	 * should return ['a','b','c','d','e','g','h']
	 * 
	 * 
	 * want to add left half to list, initial to list, right half to list
	 * if the node is null, you've reached the end of the tree and should just print l
	 */
	public List<Character> traverseInorder(){
		return traverseInorder(root);
	}

	public List<Character> traverseInorder(Node n) {
		List<Character> q = new LinkedList <Character>();
		//base case if node is null
		if(n== null) return q;

		//if node isn't null, add left, node, right
		else{
			q.addAll(traverseInorder(n.left));
			q.add(n.data);
			q.addAll(traverseInorder(n.right));
		}
		if(n.right == null) return q;
		return q;
	}

	/**
	 * STEP 3:
	 * 
	 * Sort the given list by creating a bst from the list.  
	 * Make sure to insert the list in a randomized order, to help 
	 * promote a balanced tree
	 * @param unsorted a list of items
	 * @return a new sorted list
	 */

	public static List<Character> randomizedSort(List<Character> unsorted) {
		//add all items to a new BST
		//traverse them and print
		BinarySearchTree sort = new BinarySearchTree(unsorted.get(0)); 

		for (int i = 1; i < unsorted.size(); i++) {
			sort.insert(unsorted.get(i));
		}
		sort.print();
		return sort.traverseInorder();
	}

	/**
	 * STEP 4: complete this function
	 * STEP 6: improve to self balance with AVL
	 * delete the char c from the tree
	 * @param c the letter to delete
	 * @return true if successful, false if it does not exist
	 */

	//check right
	public boolean isRight(Node n){
		if(n.parent.right == n)
			return true;
		else 
			return false;
	}

	//check left
	public boolean isLeft(Node n){
		if(n.parent.left == n)
			return true;
		else 
			return false;
	}

	public Node replacement(Node n){
		Node replaceParent = n;
		Node replacementNode = n;
		Node q = n.right;

		while(q!=null){
			replaceParent = replacementNode;
			replacementNode = q;
			q = q.left;
		}

		if(replacementNode != n.right){
			replaceParent.left = replacementNode.right;
			replacementNode.right = n.right;
		}
		return replacementNode;
	}

	public Node node(char c){
		return node(c,root);
	}

	public Node node(char c, Node n){
		if(c == n.data)
			return n;
		if(c<n.data)
			return node(c, n.left);
		else
			return node(c, n.right);
	}

	public boolean delete(char c) {
		if(contains(c) == false)
			return false;
		Node n = node(c);
		//no children, delete a leaf
		if(n.right == null && n.left == null && isLeft(n) == true){
			n.parent.left =null; 
		}
		else if(n.right == null && n.left == null && isLeft(n) == false){
			n.parent.right= null;
		}
		else if (n== root && n.right ==null){
			n.left = null;
			n.left.parent = null;
		}
		else if(n==root && n.left == null){
			n.right = null;
			n.right.parent = null;
		}

		//1 child, need to change link
		else if(n.left==null && isLeft(n) == false)
			n.parent.right = n.right;
		else if(n.right==null && isLeft(n) == true)
			n.parent.right = n.left;
		else if(n.left==null && isLeft(n) == true)
			n.parent.right = n.left;
		else if(n.right==null && isLeft(n) == false)
			n.parent.right = n.left;

		//2 children, use replacement
		else{
			
			Node replacementNode = replacement(n);
			
			if(n == root){
				root = replacementNode;
				replacementNode = n.left;
			}
			
			else if(isLeft(n) == true){
				n.parent.left = replacementNode;
				replacementNode.left = n.left;
			}
			
			else if(isLeft(n) == false){
				n.parent.right = replacementNode;
				replacementNode.left = n.left;
			}
		}
		return true;
	}

}

class Node {
	char data;
	Node left;
	Node right;
	Node parent;

	public Node(char d) {
		data = d;
	}

	public void print() {
		BTreePrinter.printNode(this);
	}

}

/* from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram */
class BTreePrinter {

	public static void printNode(Node root) {
		int maxLevel = BTreePrinter.maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(Node node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}


}


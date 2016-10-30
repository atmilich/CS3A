public class LinkedList {
	/*
	 * Tester Code:
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add('a',0);
		l.set(0, '5');
		l.add('b',1);
		l.set(1, '3');
		l.add('c',2);
		l.set(2, '7');
		l.add('d',3);
		l.set(3, '1');
//		System.out.println(l.get(0));
//		System.out.println(l.get(2));
//		System.out.println(l.remove(0));
//		System.out.println(l.get(0));
//		l.set(1, 'X');
//		System.out.println(l.get(1));
//		l.print();
//		l.bubblesort();
//		l.selectionsort();
//		l.remove('3');
		l.print();
	}


	/*
	 * Linked List Code: 
	 */
	Node first;
	int size;

	public LinkedList() {
		first = null;
		size=0;
	}

	public void add(char c, int index) {
		Node n = new Node();
		n.value = c;
		
		if(index==0) {
			n.next = first;
			first = n;
		}
		else{
			Node p = get(index-1, first);
			n.prev = p;
			n.next = p.next;
			p.next = n;
			if(index < size-1){
				Node a = get(index+1, first);
				a.prev = n;
			}
		}
		size++;
	}

	public char remove(int index) {
		if(index==0) {
			Node r = first;
			first = r.next;
			return r.value;
		}

		Node p = get(index-1, first);
		if(index < size-1){
			Node q = get(index+1, first);
			q.prev = p;
		}
		Node r = p.next;
		p.next = r.next;
		size--;
		return r.value;
	}

	public void set(int index, char c) {
		get(index, first).value = c;
	}

	public char get(int index) {
		return get(index, first).value;
	}

	public Node get(int index, Node n) {
		//base case:
		if(n==null) {
			System.err.println("out of bounds, fool!");
			return null;
		}

		if(index==0) {
			return n;
		}

		return get(index-1, n.next);
	}

	public Node val(int index){
		return get(index, first);
	}

	/* 
	 * 1. print the list.
	 * ex. "a > b > c > d"
	 */
	void print() {
		print(first);
	}

	void print (Node n){
		//base case: node is null
		if (n == null){
				return;
		}
		//if node is not null
			System.out.print(n.value + " ");

		//check if the link to the next node is not null (which would mean it's not the last node)
		if(n.next != null){
			System.out.print(" > ");
		}
		print(n.next);
}
	/*
	 * 3. sort the list
	 uses 2 for loops and compares the value of the node at j to the val of the one before
	 if the node at j-1 is greater than the node at j, switch them
		 second for loop w i used so that it continues through the whole list
	 */
	void bubblesort() {
	Node temp = new Node();
	for(int i=size; i > 0; i--){
      for(int j=1; j<size; j++){
				 if(val(j-1).value > val(j).value){
            temp.value = val(j).value;
						val(j).value = val(j-1).value;
						val(j-1).value = temp.value;
					}
			}
		}
	}

/*
 * 2. modify the node to be doubly linked
 * (you will need to do some work above, too)
 */
class Node {
	char value;
	Node next;
	Node prev;
	}

/*
4. Selection sort
	Uses 2 pointers (p & q) to look through list. P marks the smallest val in the list while q continues to run through the list. If q is smaller than p, p moves to q and q keeps increasing by 1 and compares to the new val of p
	when q reaches the end it moves the value at p to the first spot
*/

	void selectionsort(){
		for(int run=0; run <size; run++){
			for(int q=0; q<size; q++){
				for(int p=0; p<size; p++){
					if(val(q).value > val(p).value){
						p=q;
						q++;
						val(p).value = val(0).value;
					}
				}
			}
		run++;
}


/*	for(int i=size; i>0; i--){
		for(int j=1; j<size; j++){
			
		}
		}
		*/

}

}

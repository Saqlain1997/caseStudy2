

class DLLNode<T>{
	T key;
	DLLNode<T> previous;
	DLLNode<T> next;
	
	public DLLNode(T key) {
		this.key = key;
	}
}

public class DoubleLinkedList<T> {
	DLLNode<T> head;
	DLLNode<T> tail;
	int size=0;

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.removeLastNode();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeFirstNode();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeFromIndex(1);
		System.out.println("List size : "+list.size+"\n");
		
		list.searchNode(2);
		
		list.insert(2);
		list.insert(4);
		list.insert(6);
		list.insert(8);	
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addNodeAtFirst(1);		
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addNodeAtLast(9);		
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeLastNode();
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeFirstNode();
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addAtIndex(5,2);
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addAtIndex(1,0);
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addAtIndex(9,list.size-1);
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addAtIndex(3,2);
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.addAtIndex(7,6);
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeFromIndex(6);;
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.removeFromIndex(list.size+2);;
		list.print();
		System.out.println("List size : "+list.size+"\n");
		
		list.searchNode(11);
		list.searchNode(9);
		
	}
	
	public void insert(T key) {
		DLLNode<T> newNode = new DLLNode<T>(key);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else if(head == tail) {
			head.next = newNode;
			newNode.previous = head;
			tail = newNode;
			size++;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			size++;
		}		
	}
	
	public void print() {
		if(head == null) {
			System.out.println("List is empty");
		}
		else {
			DLLNode<T> temp = head;
			while(temp != null) {
				System.out.print(temp.key + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	public void addNodeAtFirst(T key) {
		DLLNode<T> newNode = new DLLNode<T>(key);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			size++;
		}
	}
	
	public void addNodeAtLast(T key) {
		DLLNode<T> newNode = new DLLNode<T>(key);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void removeFirstNode() {
		if(head == null) {
			System.out.println("List is already empty");
		}
		else if(head == tail) {
			head = null;
			tail = null;
			size--;
		}
		else {
			DLLNode<T> temp = head;
			head = temp.next;
			head.previous = null;
			temp.next = null;
			size--;
		}
	}
	
	public void removeLastNode() {
		if(head == null) {
			System.out.println("List is already empty");
		}
		else if(head == tail) {
			head = null;
			tail = null;
			size--;
		}
		else {
			DLLNode<T> temp = tail;
			tail = temp.previous;
			tail.next = null;
			temp.previous = null;
			size--;
		}
	}
	
	public void addAtIndex(T key, int index) {
		
		DLLNode<T> newNode = new DLLNode<T>(key);
		int count = 0;
		if(index>=size) {
			System.out.println("Invalid index" + index);
		}
		else if(index == 0) {
			addNodeAtFirst(key);
		}
		else if(index == size-1) {
			addNodeAtLast(key);
		}
		else {
			DLLNode<T> temp = head;
			while(count<index) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp;
			newNode.previous = temp.previous;
			temp.previous.next = newNode;
			temp.previous = newNode;
			size++;
		}
	}
	
	public void removeFromIndex(int index) {
		if(head == null) {
			System.out.println("List has no elements to remove");
		}
		else if(index >= size) {
			System.out.println("Invalid index" + index);
		}
		else if(index == 0) {
			removeFirstNode();
		}
		else if(index == size-1) {
			removeLastNode();
		}
		else {
			int count = 0;
			DLLNode<T> temp = head;
			while(count < index){
				temp = temp.next;
				count++;
			}
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			temp.previous = null;
			temp.next = null;
			size--;
		}
	}
	
	
	public void searchNode(T key) {
		if(head == null) {
			System.out.println("List contains no elements");
		}
		else {
			DLLNode<T> temp = head;
			int index = 0;
			while(temp.key != key) {
				if(temp.next == null) {
					System.out.println("Element not found");
					return;
				}
				temp = temp.next;
				index++;
			}
			System.out.println("Element found at index : "+ index);
		}
	}
}

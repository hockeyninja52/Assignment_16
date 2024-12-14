package wk15d2;

public class Main {

	public static void main(String[] args) {
		int count = 0;
		BinarySearchTree BST = new BinarySearchTree();
		Node pNode = new Node(0);
		System.out.println("Insert");
		BST.Insert(1);
		BST.Insert(2);
		BST.Insert(3);
		BST.Insert(4);
		BST.Insert(5);
		BST.Insert(6);
		BST.Insert(7);
		BST.Insert(8);
		BST.Insert(9);
		BST.Insert(0);
		
		BST.Print();
		
		System.out.println("Delete");
		BST.Delete(7);
		BST.Delete(2);
		BST.Delete(4);   
		
		BST.Print();
		
		System.out.println("Search");
		BST.Search(8);
		BST.Search(6);
		BST.Search(3);
		
	}

}

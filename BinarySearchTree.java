package wk15d2;

public class BinarySearchTree {
	public Node Root;
	
	public BinarySearchTree() {
		this.Root = null;
	}
	
	public void Insert(Node newNode, Node node) {
		if(node.Payload >= newNode.Payload){
			if(node.Left == null){
				node.Left = newNode;
			}else{
				Insert(newNode, node.Left);
			}
		}else {
			if(node.Right == null) {
				node.Right = newNode;
			}else {
				Insert(newNode, node.Right);
			}
		}
}

	
	//insert
	public void Insert(int data) {
		Node newNode = new Node(data);
		if(this.Root == null) {
			this.Root = newNode;
		}else {
			Insert(newNode, this.Root);
		}
		//printPreOrder(newNode);
	}
	//delete
	/*
	public Node Delete(int data) {
		//if it is the leaf, delete the node
		//if there is a left child, make the left child to be the parent
		//move all the left child's children up
		Node dNode = this.Root;
		if(this.Root == null) {
			return this.Root;
		}
		dNode = Delete(dNode, data);
		return dNode;
	}
	*/
	
	public void Delete(int value) {
	    Root = Delete(Root, value);
	    //printPreOrder(Root);
	}

	public Node Delete(Node Root, int value) {
	    if (Root == null) return Root ;

	    // Traverse the tree
	    if (value < Root.Payload) {
	    	Root.Left = Delete(Root.Left, value);
	    } else if (value > Root.Payload) {
	    	Root.Right = Delete(Root.Right, value);
	    } else {
	        // Node to be deleted found
	        // Node with only one child or no child
	        if (Root.Left == null) return Root.Right;
	        else if (Root.Right == null) return Root.Left;

	        // Node with two children
	        // Get the inorder successor (smallest in the right subtree)
	        Root.Payload = minValue(Root.Right);

	        // Delete the inorder successor
	        Root.Right = Delete(Root.Right, Root.Payload);
	    }
	    return Root;
	}

	int minValue(Node Root) {
	    int minValue = Root.Payload;
	    while (Root.Left != null) {
	    	Root = Root.Left;
	        minValue = Root.Payload;
	    }
	    return minValue;
	}

	/*
	public Node Delete(Node Root, int data) {
		if(Root.Payload == data) {
			//delete Node
			int caseo = 0;
			if(Root.Left == null && Root.Right == null) { // When Node has no children
				caseo = 1;
			}else if(Root.Left == null && Root.Right != null) {// When Node has one right child
				caseo = 2;
			}else if(Root.Left != null && Root.Right == null) {// When Node has one left child
				caseo = 3;
			}else if(Root.Left != null && Root.Right != null) {// When Node has both children
				caseo = 4;
			}
			
			switch(caseo) {
			case 1: //If node is a leaf node
				Root = null;
				return Root;
			case 2: //When Node has one right child
				Node temp = Root;
				temp = Root.Right;
				Root = null;
				return temp;
				//make connection between grandpa node and current node
			case 3: //When Node has on left child
				Node temp1 = Root;
				temp = Root.Left;
				Root = null;
				return Root;
				//make connection between grandpa node and current node
			case 4:
				Root.Payload = minValue(Root.Right);
				Root.Right = Delete(Root.Right, Root.Payload);
			}
			return Root;
		}else if(data > Root.Payload) {
			Root = Root.Right;
			Delete(Root, data);
		}else if(data < Root.Payload) {
			Root = Root.Left;
			Delete(Root, data);
		}
		return Root;
	
*/
	public void Search(int data) {
		Node sNode = new Node(data);
		Node rNode = new Node(data);
		sNode = this.Root;
		Search(data,sNode);
	}
	
	//search
	public Node Search (int data, Node sNode) {
		//recursively to compare the node, and if not hit, call the search recursivly on the child
		if(data == sNode.Payload) {
			//return sNode; 
		}else {
			if(data >= sNode.Payload) {
				if(sNode.Right != null) {
					sNode = sNode.Right;
					sNode = Search(data, sNode);
					return sNode; 
				}
			}else if(data < sNode.Payload){
				if(sNode.Left != null) {
					sNode = sNode.Left;
					sNode = Search(data, sNode);
					return sNode; 
				}
			}
		}
		printSearch(sNode);
		return null;
	}
	
	public void printPreOrder(Node node) {
		Node lNode = new Node(0);
		Node rNode = new Node(0);
	    if (node == null) {
	        return;
	    }
	    System.out.println("   " + node.Payload);
	    if(node.Left != null) {
	    	System.out.print(node.Left.Payload + "   ");
	    }else {
	    	System.out.print("NA   ");
	    }
	    
	    if(node.Right != null) {
	    	System.out.print(node.Right.Payload);
	    }else {
	    	System.out.print("NA");
	    }
	    
	    System.out.println(" ");
	    	
	    lNode = node.Left;
	    printPreOrder(node.Left);
	    
	    rNode = node.Right;
	    printPreOrder(node.Right);
	     
	}
	
	public void printSearch(Node sNode) {
		System.out.println(sNode.Payload);
	}
	
	public void Print() {
		Node node = Root;
		printPreOrder(node);
	}
	
	/*
	public int minValue(Node Root) {
		int minValue = Root.Payload;
		while(Root.Left != null) {
			Root = Root.Left;
			minValue = Root.Payload;
		}
		return minValue;
	}
	*/

	//balance
	
	
}

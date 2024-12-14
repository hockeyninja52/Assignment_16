package wk15d2;

public class Node {
	public int Payload;
	public Node Left;
	public Node Right;
	
	public Node(int data) {
		this.Payload= data;
		this.Left = null;
		this.Right = null;
	}
}

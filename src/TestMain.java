
public class TestMain {
 public static void main(String []s) {
	 PolyLinkedList psl=new PolyLinkedList();
	 Node n=new Node(2,4,null); // 2x4
	 psl.add(n);
	 n=new Node(-1,3,null); // -1x3
	 psl.add(n);
	 n=new Node(7,1,null); // 7x
	 psl.add(n);
	 n=new Node(-8,0,null); // -8
	 psl.add(n);
	// psl.print();
	 
	 PolyLinkedList p1=new PolyLinkedList("2x^2+5x^1+7x^0");
	 p1.print();
	
	 PolyLinkedList p2=new PolyLinkedList("3x^2-2x^1+5x^0");
	 p2.print();
	
	 PolyLinkedList p3=p1.addTo(p2);
	 p3.print();// 5.0x^2+3.0x+12.0
	 
	 p3=p1.subtractFrom(p2);
	 p3.print();//-1.0x^2+7.0x+2.0
	 
	 p3=p1.mult(p2);
	 p3.print();
	 
 }
}

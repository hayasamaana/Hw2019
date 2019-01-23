
public class PolyLinkedList implements Poly{
    private Node head,tail;
    
	public PolyLinkedList() {
		head=tail=null;
	}
	
	public PolyLinkedList(String pol) {// parse string
		
		  //42x^4-1x^3+7x-8
		    int len=pol.length();
		    String s="";
		    char ch;
		    int exp;
		    int cof;
		    char sign='+';
		    
			for( int i=0;;i++){
				
			   if(i==len) break;
			   ch=pol.charAt(i);
			  
			   if(ch=='-'||ch=='+'){
				   sign=ch;
				   ch=pol.charAt(++i);
			   }
			    //make coef
			   while(ch!='x'){
				     s+=""+ch; 
			    	 ch=pol.charAt(++i);
			  
			    }
			   cof= Integer.parseInt(s);
			  
			   if (sign=='-'){ cof=-1*cof;}
			   s="";
			   
			   //^
			   ch=pol.charAt(++i); 
			   //exp
			   exp=pol.charAt(++i)-'0'; 
			   
		       Node n=new Node(cof,exp,null);
	           add(n);
			  // System.out.println(""+cof+"---"+exp);
	           
		    }  
	 }
	

	@Override
	public void add(Node n) {
		// TODO Auto-generated method stub
		if(head==null) {
			head=n;
			tail=n;
			return;
		}
		else {
			tail.next=n;
			tail=n;
		}
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		 System.out.println();
		Node p=head;
		while(p!=null) {
			if(p.getExp()==0) {
				if(p.getCoef()>0) System.out.print("+"+p.getCoef());
				else System.out.print(""+p.getCoef());
				}
			else if(p.getExp()==1) {
				if(p.getCoef()>0)System.out.print(""+p.getCoef()+"x");
				else System.out.print(""+p.getCoef()+"x");
				}
			else{
				if(p.getCoef()>0 && p.next.getCoef()>0) System.out.print(""+p.getCoef()+"x^"+p.getExp()+"+");
				else if(p.getCoef()<0 && p.next.getCoef()>0) System.out.print(""+p.getCoef()+"x^"+p.getExp()+"+");
				else System.out.print(""+p.getCoef()+"x^"+p.getExp());
				
			}
			p=p.next;
		}
		
	}

	public PolyLinkedList addTo(PolyLinkedList ply) {
		// TODO Auto-generated method stub
		Node p1=this.head;
		Node p2=ply.head;
		Node n3=new Node();
		PolyLinkedList ply3=new PolyLinkedList();
		int count=0;
		int ex1=p1.getExp();
		int ex2=p2.getExp();
		
		while(ex1>ex2){
				n3=new Node();
				n3.setCoef(p1.getCoef());
				n3.setExp(p1.getExp());
				ply3.add(n3);
				p1=p1.next;
				ex1=p1.getExp();
		}
		
		while(ex2>ex1){
			
			n3=new Node();
			n3.setCoef(p2.getCoef());
			n3.setExp(p2.getExp());
			ply3.add(n3);
			p2=p2.next;
			ex2=p2.getExp();
	}
		
		
		while(p1!=null){
			while(p2!=null){
				if(p1.getExp()==p2.getExp()){
					n3=new Node();
					n3.setCoef(p1.getCoef()+p2.getCoef());
					n3.setExp(p1.getExp());
					ply3.add(n3);
					count++;
					break;
				}
				
				else{
					p2=p2.next;
				}
			}
			if(count==0){
				n3=new Node();
				n3.setCoef(p1.getCoef());
				n3.setExp(p1.getExp());
				ply3.add(n3);	
			}
		p1=p1.next;
		p2=ply.head;
		count=0;
		
		}
		
		
		
		return ply3;
	}
	  

	public PolyLinkedList subtractFrom(PolyLinkedList ply) {
		// TODO Auto-generated method stub
		Node p1=this.head;
		Node p2=ply.head;
		Node n3=new Node();
		PolyLinkedList ply3=new PolyLinkedList();
		int count=0;
		int ex1=p1.getExp();
		int ex2=p2.getExp();
		
		while(ex1>ex2){
				n3=new Node();
				n3.setCoef(p1.getCoef());
				n3.setExp(p1.getExp());
				ply3.add(n3);
				p1=p1.next;
				ex1=p1.getExp();
		}
		
		while(ex2>ex1){
			
			n3=new Node();
			n3.setCoef(p2.getCoef());
			n3.setExp(p2.getExp());
			ply3.add(n3);
			p2=p2.next;
			ex2=p2.getExp();
	}
		
		
		while(p1!=null){
			while(p2!=null){
				if(p1.getExp()==p2.getExp()){
					n3=new Node();
					n3.setCoef(p1.getCoef()-p2.getCoef());
					n3.setExp(p1.getExp());
					ply3.add(n3);
					count++;
					break;
				}
				
				else{
					p2=p2.next;
				}
			}
			if(count==0){
				n3=new Node();
				n3.setCoef(p1.getCoef());
				n3.setExp(p1.getExp());
				ply3.add(n3);	
			}
		p1=p1.next;
		p2=ply.head;
		count=0;
		
		}
		
		
		
		return ply3;
	}
	  
	public PolyLinkedList mult(PolyLinkedList ply) {
		// TODO Auto-generated method stub
		Node p1=this.head;
		Node p2=ply.head;
		Node n3=new Node();
		PolyLinkedList ply3=new PolyLinkedList();
		while(p1!=null){
			while(p2!=null){
					n3=new Node();
					n3.setCoef(p1.getCoef()*p2.getCoef());
					n3.setExp(p1.getExp()+p2.getExp());
					ply3.add(n3);
					p2=p2.next;
				
			}
			p1=p1.next;
			p2=ply.head;
		}
		
		PolyLinkedList ply4=new PolyLinkedList();
		p1=ply3.head;
		p2=p1.next;
		while(p1.next!=null){
			while(p2!=null){
				if(p1.getExp()==p2.getExp()){
					n3=new Node();
					n3.setCoef(p1.getCoef()+p2.getCoef());
					n3.setExp(p1.getExp());
					ply4.add(n3);
					
				}
				p2=p2.next;
			}
			p1=p1.next;
			if(p1.next!=null)
			   p2=p1.next;
		}
		return ply4;
	}

}

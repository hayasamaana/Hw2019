
public class Node {
	  private double coef;
	  private int exp;
	  Node next;
	  
	  public Node() {
		  this.coef=0.0;
		  this.exp=0; 
		  this.next=null;  
	  }
	  public Node(double coef,int exp,Node next){
		  this.coef=coef; 
		  this.exp=exp; 
		  this.next=next;
	  }
	  
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	  
	  
	  
}


public class Link {
	
	public String bookName;
	
	public int millionsSold;
	
	public Link next; 
	
	public Link(String bookName, int millionsSold){
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}
	
	public void display(){
		System.out.println(bookName + ": " + millionsSold + ",000,000");
	}
	
	public String toString(){
		return bookName;
	}
	
	public static void main(String[] args){
		LinkedList myLinkedList = new LinkedList();
		
		myLinkedList.insertFirstLink("Don Quixote", 500);
		myLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		myLinkedList.insertFirstLink("The Lord of the Rings", 150);
		myLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
		
		myLinkedList.CycleDisplay();
		
		myLinkedList.removeFirst();
		
		myLinkedList.CycleDisplay();
		
		System.out.println(myLinkedList.find("The Lord of the Rings").bookName + " Was Found");
		
		myLinkedList.removeLink("The Lord of The Rings");
		
		myLinkedList.CycleDisplay();

	}
}

class LinkedList{
	
	public Link firstLink;
	
	LinkedList(){
		firstLink = null;
	}
	
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	public void insertFirstLink(String bookName, int millionsSold){
		
		Link newLink = new Link(bookName, millionsSold);
		
		newLink.next = firstLink;
		
		firstLink = newLink;
	}
	
	public Link removeFirst(){
		Link linkReference = firstLink;
		if(!isEmpty()){
			firstLink = firstLink.next;
		} else {
			System.out.println("Empty LinkedList.");
		}
		return linkReference;
	}
	
	public void CycleDisplay(){
		
		Link theLink = firstLink;
		
		while(theLink != null){
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;
			System.out.println();
		}
	}
	
	public Link find(String bookName){
		Link theLink = firstLink;
		if(!isEmpty()){
			while(theLink.bookName != bookName){
				if(theLink.next == null){
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			
			System.out.println("Empty LinkedList");
		}
		return theLink;
	}
	
	public Link removeLink(String bookName){
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		while(currentLink.bookName != bookName){
			if(currentLink.next == null){
				return null;
			}else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if(currentLink == firstLink){
			firstLink = firstLink.next;
		}else {
			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
	
}
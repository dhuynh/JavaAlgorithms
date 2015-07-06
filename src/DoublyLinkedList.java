
public class DoublyLinkedList {
	
	Neighbor firstLink;
	Neighbor lastLink;
	
	

	public void insertInFirstPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		if(isEmpty()){
			lastLink = theNewLink;
		} else {
			firstLink.previous = theNewLink;
		}
		
		theNewLink.next = firstLink;
		firstLink = theNewLink;
		
		
	}
	
	public void insertInLastPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if(isEmpty()){
			firstLink = theNewLink;
		}else {
			lastLink.next = theNewLink;
			
			theNewLink.previous = lastLink;
			
		}
		
		lastLink = theNewLink;
	}
	
	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key){
		
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		Neighbor currentNeighbor = firstLink;
		
		while(currentNeighbor.houseNumber != key){
			currentNeighbor = currentNeighbor.next;
			if(currentNeighbor == null){
				return false;
			}
		}
		
		if(currentNeighbor == lastLink){
			theNewLink.next = null;
			lastLink = theNewLink;
			
		}else {
			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;
		}
		
		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;
	}
	
	public void insertInOrder(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		Neighbor previousNeighbor = null;
		Neighbor currentNeighbor = firstLink;
		
		while((currentNeighbor !=null) && (houseNumber > currentNeighbor.houseNumber)){
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
			
		}
		if(previousNeighbor == null){
			firstLink = theNewLink;
		
		}else{
			previousNeighbor.next = theNewLink;
		}
		
		theNewLink.next = currentNeighbor;
	}
	
	public boolean isEmpty(){
		return (firstLink == null);
	}
	
	public void display(){
		Neighbor theLink = firstLink;
		
		while(theLink != null){
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;
			
			System.out.println();
		}
	}
	
	
	public static void main(String[] args){
		
		DoublyLinkedList theLinkedList = new DoublyLinkedList();
		
		theLinkedList.insertInOrder("Duy Huynh", 20);
		theLinkedList.insertInOrder("Will Bradbeer", 9);
		theLinkedList.insertInOrder("Anthony Duffy", 24);
		theLinkedList.insertInOrder("Cahr Chap ", 4);
		
		theLinkedList.insertAfterKey("Isaa H", 8, 4);

		theLinkedList.display();
		
		System.out.println("\n");
		
		NeighborIterator neighbors = new NeighborIterator(theLinkedList);
		
		neighbors.currentNeighbor.display();
		
		System.out.println(neighbors.hasNext());
		
		neighbors.next();
		
		neighbors.currentNeighbor.display();

		neighbors.remove();

		neighbors.currentNeighbor.display();

	}
}

class Neighbor {
	
	public String homeOwnerName;
	public int houseNumber;
	
	public Neighbor next;
	public Neighbor previous;
	
	public Neighbor(String homeOwnerName, int houseNumber){
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}
	
	public void display(){
		System.out.println(homeOwnerName +": " + houseNumber + " Banchory Drive");
	}
	
	public String toString(){
		return homeOwnerName;
	}
}

class NeighborIterator{
	
	Neighbor currentNeighbor;
	Neighbor previousNeighbor;
	
	DoublyLinkedList theNeighbors;
	
	NeighborIterator(DoublyLinkedList theNeighbors){
		
		this.theNeighbors = theNeighbors;
		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;
		
		
	}
	
	public boolean hasNext(){
		if(currentNeighbor.next != null){
			return true;
		}
		return false;
	}
	
	public Neighbor next(){
		if(hasNext()){
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
			
			return currentNeighbor;
		}
		return null;
	}
	
	public void remove(){
		if(previousNeighbor == null){
			theNeighbors.firstLink = currentNeighbor.next;
		}else {
			previousNeighbor.next = currentNeighbor.next;
			
			if(currentNeighbor.next == null){
				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;
			} else {
				currentNeighbor = currentNeighbor.next;
			}
		}
	}
}
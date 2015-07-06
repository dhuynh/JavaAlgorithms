import java.util.Arrays;


public class AStack {

		private String[] stackArray;
		
		private int stackSize;
		
		private int topOfStack = -1;
		
		AStack(int size){
			stackSize = size;
			
			stackArray = new String[size];
			
			Arrays.fill(stackArray, "-1");
		}
		
		public void push(String input){
			
			if(topOfStack + 1 < stackSize){
				topOfStack++;
				
				stackArray[topOfStack] = input;
			}else System.out.println("Stack Full");
			
			displayTheStack();
			
			System.out.println("Push" + input + " Was added to the Stack");
		}
		
		public String pop(){
			if(topOfStack >=0){
				
				displayTheStack();
				
				System.out.println("POP " + stackArray[topOfStack] + " Was removed from Stack");
				
				stackArray[topOfStack] = "-1";
				
				return stackArray[topOfStack--];
				
			}else {
				displayTheStack();
				
				System.out.println("Empty");
				
				return "-1";
			}
		}
		
		public String peek(){
			displayTheStack();
			
			System.out.println("PEEK" + stackArray[topOfStack] + " is at top of stack");
			return stackArray[topOfStack];
		}
		
		public void displayTheStack(){
			for(int n = 0; n < 61; n++)System.out.print("");
			
			System.out.println();
			
			for(int n = 0; n < stackSize; n++){
               System.out.format("| %2s "+ " ", n);
			}
			
			 System.out.println("|");
 
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
			 
			for(int n = 0; n < stackSize; n++){
					if(stackArray[n].equals("-1"))System.out.print("|     ");
					else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
					}
			System.out.println("|");
			for(int n = 0; n < 61; n++)System.out.print("-");
			System.out.println();
			
		}
		
		public void pushMany(String multipleValues){
			String[] tempString = multipleValues.split(" ");
			
			for(int i = 0; i< tempString.length; i++){
				push(tempString[i]);
			}
		}
		
		public void popAll(){
			while(topOfStack >= 0){
				pop();
			}
		}
				
		public static void main(String[] args){
			AStack stack = new AStack(10);
			
			stack.push("10");
			stack.push("11");
			
			stack.peek();
			
			stack.pop();
			
			stack.pushMany("12 13 14 15 16");
			
			stack.displayTheStack();
			
			stack.popAll();
			
			stack.displayTheStack();

		}
}



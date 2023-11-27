
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {

	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		int size = array.length;
		for (int i = 0; i < size / 2; i++) {
			E temp = array[i];
			array[i] = array[size - i - 1];
			array[size - i - 1] = temp;
		}
	}

	// This method checks the correctness of the given input//
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false//
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
					return false;
				}
			}
		}

		return stack.empty();
	}

	// This method evaluates the value of anexpression//
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		return (Integer) null;
	}
	
	 public static <E> void stutter(Queue<E> input) {
	        Queue<E> queue =  new LinkedList<>();
	        int size = input.size();
	        for(int i =0;i < size ; i++){
	            queue.add(input.peek());
	            queue.add(input.poll());
	        }
	        for(int i =0; i < size*2 ; i++){
	            input.add(queue.poll());
	        }
	    }
	 
	 public static <E> void mirror(Queue<E> input) {
	        Queue<E> tempQueue = new LinkedList<>();
	        Stack<E> tempStack = new Stack<>();
	        int sizeInput = input.size();
	        for(int i =0; i< sizeInput; i++){
	            tempQueue.add(input.peek());
	            tempStack.push(input.poll());
	        }
	        for(int i =0; i< sizeInput*2; i++){
	            if(!tempQueue.isEmpty()){
	                input.add(tempQueue.poll());
	            }else {
	                input.add(tempStack.pop());
	            }
	        }
	    }

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4 };
		reserve(array);
		System.out.println(Arrays.toString(array));

		System.out.println(isCorrect("()(())[]{(())}"));
		System.out.println(isCorrect("()(())[]{(())}]]"));
		
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        stutter(q);
        System.out.println(q.toString());
        
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        mirror(q1);
        System.out.println(q1.toString());
        
       

	}
}

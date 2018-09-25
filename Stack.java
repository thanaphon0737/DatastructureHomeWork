/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw4_group17;

/**
 *
 * @author Patiwet
 */
public class Stack implements List{
    // Implement Stack using Linked List without tail
    Node head;
    
    public void push(Node node){ // same pushFront in LinkedList.
        if (head == null){ // if stack is empty
            // Do something
            head = node;
        }else{
            node.next = head;
            head = node;
            // Do something else
        }
    }
    
    public void pop(){
        // Fix this function
        
        if (head != null){ // if stack is not empty.
            head = head.next;
            // Do something
        }else{
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){
        if(head != null){
            return head; //return top of stack.
        }else{
            return null;
        }
        
    }
    
}

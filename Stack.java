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
    
    public void push(Node node){
        if (head == null){
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
        
        if (head != null){
            head = head.next; //to delete head
            // Do something
        }else{
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){
        if(head != null){
            return head;
        }else{
            return null;
        }
        
    }
    
}

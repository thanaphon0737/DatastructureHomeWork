/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw4_group17;

/**
 *
 * @author Patiwet
 */
public class Queue implements List{
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;
    
    public void push(Node node){
        if (head == null){
            head = node;
            tail = node;
            // Do something (Empty list)
        }else{
            Node current = head;
            while(current != null){
                if(current.next == null){
                    current.next = node;
                    tail = node;
                    return;
                }
                current = current.next;
            }
            // Do something (Non-empty list)
        }
    }
    
    public void pop(){
        if (head != null){
            if (head != tail){
                head = head.next;
                // Do something (List of many nodes)
            }else{
                head = null;
                tail = null;
                // Do something (List of a single node)
            }
        }
    }
    
    public Node top(){
        // Fix this
        if(head != null){
            return head;
        }
        return null;
    }
    
}

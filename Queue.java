/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
 */
package hw4_group17;

/**
 *
 * @author Patiwet
 */
public class Queue implements List {

    // Implement Queue using Linked List with tail
    Node head;
    Node tail;

    public void push(Node node) { //  same pushBack in LinkedList.
        if (head == null) { // if empty List .
            head = node;
            tail = node;
            // Do something (Empty list)
        } else {
            tail.next = node;
            tail = node;
            // Do something (Non-empty list)
        }
    }

    public void pop() { //enqueue
        if (head != null) {
            if (head != tail) {
                head = head.next;
                // Do something (List of many nodes)
            } else {
                head = null;
                tail = null;
                // Do something (List of a single node)
            }
        }
    }

    public Node top() {
        // Fix this
        if (head != null) {
            return head; // return last element in queue.
        }
        return null;
    }

}

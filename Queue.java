/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
 */
package homework_group17;

public class Queue {

    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;

    public Queue(int cap) { //constructor
        this.capacity = cap; 
        arr = new Node[cap];// allocate array

    }

    public void enqueue(Node node) {
        if (!isFull()) {
            // do something
            arr[back] = node;
            back = (back+1) % capacity; // back is not more than capacity
            size++; // increasing size
        } else {
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue() {

        if (!isEmpty()) {
            // do something
            Node temp = arr[front]; // store node is deleted before delete
            front = (front+1) % capacity; // front is not more than capacity 
            size --; //decreasing size
            return temp;
        } else {
            System.out.println("Queue Underflow!!!");
        }
        return null;
         // fix this (out of place)
    }

    public boolean isEmpty() {
        // check size is equal zero
        return size == 0; // size is equal zero return true
        // fix this
    }

    public boolean isFull() {
        // check size is equal capacity
        return size == capacity; 
    }

    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.print("[Front] ");
                for (int i = front; i < size+front; i++) { // start form front follow size which have 
                        System.out.print(arr[i % capacity].data + " "); // index of array is not more than capacity run like cycle.
                }   
            System.out.println("[Back]");
        } else {
            System.out.println("Empty Queue!!!");
        }
    }
}

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

    public Queue(int cap) {
        this.capacity = cap;
        arr = new Node[cap];

    }

    public void enqueue(Node node) {
        if (!isFull()) {
            // do something
            arr[back] = node;
            back = (back+1) % capacity;
            size++;
        } else {
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue() {

        if (!isEmpty()) {
            // do something
            Node temp = arr[front];
            arr[front] = null;
            front = (front+1) % capacity;
            size --;
            return temp;
        } else {
            System.out.println("Queue Underflow!!!");return null;
        }
         // fix this (out of place)
    }

    public boolean isEmpty() {
        return front == back-1;
        // fix this
    }

    public boolean isFull() {
        return (back == (back+1)%capacity);
    }

    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.println("[Front] ");
            int []  index = new int[size];
            int j =front;
            for(int i =0; i < size;i++){
                
                index[i] = j%capacity;
                j++;
                System.out.print(arr[index[i]].data+" ");
            }
           
           
            
            

            System.out.println("[Back]");
        } else {
            System.out.println("Empty Queue!!!");
        }
    }
}

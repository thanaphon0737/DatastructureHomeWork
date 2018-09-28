/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package homework_group17;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){
        this.capacity = cap;
        arr = new Node[cap];
    }
    
    public void push(Node node){
        if (!isFull()){
            // do something
            arr[size] = node;
            size++;
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            Node temp = arr[size-1];
            size--;
            return temp;
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){
        return size == capacity; // fix this
    }
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            // do something here
            for(int i =0;i<size; i++){
                System.out.println(arr[i].data);
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}

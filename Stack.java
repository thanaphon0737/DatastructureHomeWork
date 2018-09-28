/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package homework_group17;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){ // constucttor set defalut
        this.capacity = cap;
        arr = new Node[cap];
    }
    
    public void push(Node node){
        if (!isFull()){
            // do something
            arr[size] = node; // node of array point to node
            size++; // increasing size
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            Node temp = arr[size-1]; //store node is deleted before delete
            size--; //decreasing size
            return temp;
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){
        // check size is equal capacity
        return size == capacity; 
    }
    public boolean isEmpty(){
        // check size is equal zero
        return size == 0; 
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            // do something here
            for(int i =0;i<size; i++){ // print data follow size
                System.out.println(arr[i].data);
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}

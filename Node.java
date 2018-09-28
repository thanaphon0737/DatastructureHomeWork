/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package homework_group17;

public class Node extends BTreePrinter {

    Node left;
    Node right;
    int data;

    public Node(int data) { // constructor set defalut data
        this.data = data;
        right = null;
        left = null;
    }


    public void printTree() {
        
         super.printTree(this);
    }

    public void printBFT() { // print tree form left to right and top to bottom
        Queue q = new Queue(50);
        Node node = this; // refer current class
        q.enqueue(node);
        System.out.print("BFT node sequence [ ");
        while(!(q.isEmpty())){
            node = q.dequeue();
            System.out.print(node.data + " ");
            if(node.left != null){ // check left node is not empty
                q.enqueue(node.left);
            }
            if(node.right != null){// check right node is not empty
                q.enqueue(node.right);
            }
            
        }
        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        Node node = this;
        s.push(node);
        System.out.print("DFT node sequence [ ");
        while(!s.isEmpty()){
            node = s.pop();
            System.out.print(node.data+" "); 
            if(node.right != null){ // check left node is not empty
                s.push(node.right);
            }
            if(node.left != null){ // check right node is not empty
                s.push(node.left);
            }
        }
        System.out.println("]");
    }
}

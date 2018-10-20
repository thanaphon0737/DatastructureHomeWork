/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
*/ 
package homework_group17;

public class Node {
    Node left;
    Node right;
    Node parent;
    int key;
    
    public Node(int data){
        this.key = data;
        this.left = null;
        this.right  = null;
        this.parent = null;
    }
    
    public int height(){
        return height(this); // fix this with a single line
    }
    
    public static int height(Node node){
        if(node == null){
            return -1;
        }else{
            return 1 + Math.max(height(node.left),height(node.right));
            
        }
    }

    public int size(){
        return size(this); // fix this
    }
    
    public static int size(Node node){
        // fix this
        if(node == null){
            return 0;
        }else {
            return(size(node.left)+ 1 + size(node.right));
        }
        
    }
    
    public Node findNext(){
        //fix this
        if(this.right != null){
            return leftDescendant(this.right);
        }else
            return rightAncestor(this);
    }
    
    public static Node leftDescendant(Node node){// Case 1
        // fix this
        if(node.left == null){
            return node;
        }else
            return leftDescendant(node.left);
    }
    
    public static Node rightAncestor(Node node) {// Case 1
        // fix this
        if(node.key < node.parent.key){
            return node.parent;
        }else
            return rightAncestor(node.parent);
    }
    
    public int depth(Tree tree){ // Node Depth
        // fix this
        int path=0;
        Node node = this;
        while(node.parent != null){
            node = node.parent;
            path++;
        }
        return path;
    }

    
 
}

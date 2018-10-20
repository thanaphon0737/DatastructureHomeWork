/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
 */
package homework_group17;

public class Main {

    public static void printNodeKey(Node node) {
        if (node == null) {
            System.out.println("Node not found.");
        } else {
            System.out.println(node.key);
        }

    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.printTree();
        int[] keyList = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i = 0; i < keyList.length; i++) {
            tree.insert(keyList[i]);
        }
        tree.printTree();

        Node node = tree.find(3);
        /*printNodeKey(node);
        node = tree.find(4);
        printNodeKey(node);
        node = tree.findClosest(4);
        printNodeKey(node);
        node = tree.findClosest(3);
        printNodeKey(node);
        node = tree.findClosest(-999);
        printNodeKey(node);
        node = tree.findClosest(999);
        printNodeKey(node);
        node = tree.findMin();
        printNodeKey(node);
        node = tree.findMax();
        printNodeKey(node);*/
        //node = node.findNext();
        //printNodeKey(node);
        node = tree.find(3);
        Node node3 = tree.find(7);
        
        System.out.println("size of node 7 "+node3.size());
        
        printNodeKey(node);
    }

}

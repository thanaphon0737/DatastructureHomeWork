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
        int[] keyList = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i = 0; i < keyList.length; i++) {
            tree.insert(keyList[i]);
        }
        tree.printTree();
        Node node = tree.findKthSmallest(9);
        printNodeKey(node);
       /* Node node = tree.find(9);
        node = node.parent;
        printNodeKey(node);*/
        /*System.out.println("----------------");
        tree.delete(7);
        tree.printTree();
        System.out.println("----------------");
        tree.delete(3);
        tree.printTree();
        tree.delete(9);
        tree.delete(1);
        tree.delete(5);
        tree.delete(5);
        System.out.println("----------------");
        tree.printTree();*/
    }

}

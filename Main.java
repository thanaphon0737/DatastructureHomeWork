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
        int[] keyList = {5, 2, 3, 9, 1, 10, 8, 7};
        for (int i = 0; i < keyList.length; i++) {
            tree.insert(keyList[i]);
        }
        tree.printTree();
        System.out.println(tree.depth());
        System.out.println(tree.height());
        Node node = tree.find(9);
        System.out.println(node.depth(tree));
        System.out.println(node.height());
        node = tree.findMax();
        printNodeKey(node);
        node = tree.findMin();
        printNodeKey(node);
        node = tree.findKthSmallest(6);
        printNodeKey(node);
        node = tree.findKthSmallest(3);
        printNodeKey(node);
    }

}

/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
 */
package homework_group17;

public class Main {

    public static void main(String[] args) {

        Node tree = constructTree1();
        tree.printTree();
        tree.printBFT();
        tree.printDFT();

    }

    private static Node constructTree1() {
        Node tree1 = new Node(3);// root tree
        // for left tree
        tree1.left = new Node(7);
        tree1.left.left = new Node(2);
        tree1.left.right = new Node(6);
        tree1.left.right.right = new Node(8);
        tree1.left.right.left = new Node(1);
        // for right tree
        tree1.right = new Node(5);
        tree1.right.right = new Node(9);
        tree1.right.right.left = new Node(4);
        return tree1;
    }

    private static Node constructTree2() {
        Node tree2 = new Node(1); // root tree
        // for right tree
        tree2.right = new Node(3);
        tree2.right.right = new Node(6);
        tree2.right.right.left = new Node(9);
        // for left tree
        tree2.left = new Node(2);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);
        tree2.left.right.left = new Node(7);
        tree2.left.right.right = new Node(8);
        tree2.left.right.right.right = new Node(9);
        return tree2;
    }

}

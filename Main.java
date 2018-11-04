/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
 */
package hw7_group17;

public class Main {

    public static BSTree generateTree1() {
        int[] keyList = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        BSTree tree = new BSTree();
        for (int i = 0; i < keyList.length; i++) {
            tree.insert(keyList[i]);
        }
        return tree;
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        int[] keyList = {51, 30, 69, 18, 42, 63, 87, 12, 24, 36, 45, 57, 66, 81,
            93, 15, 21, 27, 33, 39, 48, 54, 60, 75, 84, 90, 96, 72, 78};
        for (int i = 0; i < keyList.length; i++) {
            tree.insert(keyList[i]);
        }
        //tree.printTree();
        tree.insert(73); // must perform SingleRotationFromLeft(Node 81)
        //tree.printTree();
        tree.insert(77); // must perform DoubleRotationFromLeft(Node 87)
        tree.insert(76); // must perform SingleRotationFromLeft(Node 78)
        tree.insert(80); // must perform DoubleRotationFromRight(Node 69)
        tree.insert(74); // must perform SingleRotationFromRight(Node 72)
        tree.insert(64); // do nothing
        tree.insert(55); // must perform SingleRotationFromLeft(Node 69)
        tree.insert(70); // must perform DoubleRotationFromRight(Node 51)
    }
}

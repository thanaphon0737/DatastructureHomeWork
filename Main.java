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

        BSTree tree;
        tree = generateTree1();
        tree.printTree();

        System.out.println("---- Test7 doubleRotateFromRight at Lv 1 ----");
        tree.doubleRotateFromRight(tree.find(8));
        tree.printTree();
        System.out.println("---- Test8 doubleRotateFromLeft at Lv 1 ----");
        tree = generateTree1();
        tree.doubleRotateFromLeft(tree.find(8));
        tree.printTree();
        System.out.println("---- Test9.1 doubleRotateFromLeft at Lv 2 ----");
        tree = generateTree1();
        tree.doubleRotateFromLeft(tree.find(4));
        tree.printTree();
        System.out.println("---- Test9.2 doubleRotateFromLeft at Lv 2 ----");
        tree = generateTree1();
        tree.doubleRotateFromLeft(tree.find(12));
        tree.printTree();
        System.out.println("---- Test10.1 doubleRotateFromRight at Lv 2 ----");
        tree = generateTree1();
        tree.doubleRotateFromRight(tree.find(4));
        tree.printTree();
        System.out.println("---- Test10.2 doubleRotateFromRight at Lv 2 ----");
        tree = generateTree1();
        tree.doubleRotateFromRight(tree.find(12));
        tree.printTree();
    }
}

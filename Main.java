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

        System.out.println("---- Test1 singleRotateFromLeft at Lv 3 ----");
        tree.singleRotateFromLeft(tree.find(6));
        tree.singleRotateFromLeft(tree.find(2));
        tree.printTree();
        System.out.println("---- Test2 singleRotateFromRight at Lv 3 ----");
        tree = generateTree1();
        tree.singleRotateFromRight(tree.find(10));
        tree.singleRotateFromRight(tree.find(14));
        tree.printTree();
        System.out.println("---- Test3 singleRotateFromLeft at Lv 2 ----");
        tree = generateTree1();
        tree.singleRotateFromLeft(tree.find(4));
        tree.printTree();
        System.out.println("---- Test4 singleRotateFromRight at Lv 2 ----");
        tree = generateTree1();
        tree.singleRotateFromRight(tree.find(12));
        tree.printTree();
        System.out.println("---- Test5 singleRotateFromLeft at Lv 1 ----");
        tree.singleRotateFromLeft(tree.find(8));
        tree.printTree();
        System.out.println("---- Test6 singleRotateFromRight at Lv 1 ----");
        tree.singleRotateFromRight(tree.find(8));
        tree.printTree();

    }
}

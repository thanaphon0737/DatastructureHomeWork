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

        BSTree tree1 = new BSTree();
        long start = System.currentTimeMillis();
        int N = 13000;
        for (int i = 0; i < N; i++) {
            tree1.insert(i);
        }
        System.out.println("Time for sequentially inserting " + N
                + " objects into BST = " + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            tree1.find((int) (Math.random() * (N / 10)));
        }
        System.out.println("Time for finding " + (N / 10)
                + " different objects in BST= " + (System.currentTimeMillis() - start) + " msec");
        SplayTree tree2 = new SplayTree();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            tree2.insert(i);
        }
        System.out.println("Time for sequentially inserting " + N
                + " objects into SplayTree = " + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            tree2.find((int) (Math.random() * (N / 10)));
        }
        System.out.println("Time for finding " + (N / 10)
                + " different objects in SplayTree = " + (System.currentTimeMillis() - start) + " msec");
    }

}

/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
 */
package hw7_group17;

import com.sun.scenario.effect.impl.Renderer;
import java.util.ArrayList;
import javax.accessibility.AccessibleRole;

public class AVLTree extends BTreePrinter {

    Node root;

    public AVLTree() {

    }

    public AVLTree(Node root) {
        this.root = root;
        this.root.parent = null; // To make sure the root has no parent
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public Node find(int search_key) {
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {
        if (search_key == node.key) {
            return node;
        } else if ((search_key < node.key) && (node.left != null)) {
            return find(node.left, search_key);
        } else if ((search_key > node.key) && (node.right != null)) {
            return find(node.right, search_key);
        } else {
            return null;
        }
    }

    public Node findMin() {
        return findMin(root);
    }

    public static Node findMin(Node node) {
        if (node == null || node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax() {
        return findMax(root);
    }

    public static Node findMax(Node node) {
        if (node == null || node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
                while ((!(node.isImbalance())) && node.parent != null) {
                    node = node.parent;
                    if (node == tree.root) {
                        break;
                    }
                }
                rebalance(tree, node);
            } else {
                insert(tree, node.left, key);
            }
        } else { // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
                while ((!(node.isImbalance())) && node.parent != null) {
                    node = node.parent;
                    if (node == tree.root) {
                        break;
                    }
                }
                rebalance(tree, node);
            } else {
                insert(tree, node.right, key);
            }
        }
    }

    // Fix this
    // If you do not understant my code, feel free to implement your own code
    public static void rebalance(AVLTree tree, Node node) {
        if (node.isImbalance()) {

            /////////////////////////////////////////////////////////////////////////////
            // This code segment is make sure that we rebalance the first imbalance node closest to the leaves
            if (Node.height(node) > 2) {
                if (Node.height(node.left) > Node.height(node.right)) {
                    rebalance(tree, node.left);
                } else {
                    rebalance(tree, node.right);
                }
            }
            /////////////////////////////////////////////////////////////////////////////

            if (Node.height(node.left) > Node.height(node.right)) { // Left heavy?
                if (Node.height(node.left.left) > Node.height(node.left.right)) { // Outer?
                    System.out.println("Perform SingleRotateFromLeft (Node " + node.key + ")"); // fix ???
                    // Do something (just add one line here)
                    tree.singleRotateFromLeft(node);
                } else { // Inner?
                    System.out.println("Perform DoubleRotateFromleft (Node " + node.key + ")"); // fix ???
                    // Do something (just add one line here)
                    tree.doubleRotateFromLeft(node);
                }
            } else { // Right heavy?
                if (Node.height(node.right.right) > Node.height(node.right.left)) { //Outer?
                    System.out.println("Perform SingleRotateFromRight (Node " + node.key + ")"); // fix ???
                    // Do something (just add one line here)
                    tree.singleRotateFromRight(node);
                } else { // Inner?
                    System.out.println("Perform DoubleRotateFromRight (Node " + node.key + ")"); // fix ???
                    // Do something (just add one line here)
                    tree.doubleRotateFromRight(node);
                }
            }
        }
    }

    public void singleRotateFromLeft(Node y) {
        // Do something (just copy the code from BSTree)
        Node x = y.left;
        if (y == root) {// Is Root

            if (x.right != null) {
                x.right.parent = y;
            }
            y.left = x.right;
            y.parent = x;
            x.right = y;

            root = x;
            x.parent = null;
        } else {
            // not root
            if (y.parent.left == y) {
                y.parent.left = x;
                x.parent = y.parent;
            } else if (y.parent.right == y) {
                y.parent.right = x;
                x.parent = y.parent;
            }
            y.parent = x;
            y.left = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }

            x.right = y;
        }
    }

    public void singleRotateFromRight(Node y) {
        // Do something (just copy the code from BSTree)
        Node x = y.right;
        if (y == root) {// Is root
            if (x.left != null) {
                x.left.parent = y;
            }
            y.right = x.left;
            y.parent = x;
            x.left = y;
            root = x;
            x.parent = null;
        } else {
            //not root
            if (y.parent.left == y) {
                y.parent.left = x;
                x.parent = y.parent;
            } else if (y.parent.right == y) {
                y.parent.right = x;
                x.parent = y.parent;
            }
            y.parent = x;
            y.right = x.left;
            if (x.left != null) {
                x.left.parent = y;
            }
            x.left = y;
        }
    }

    public void doubleRotateFromLeft(Node y) {
        // Do something (just copy the code from BSTree)
        Node x = y.left;
        Node z = x.right;
        singleRotateFromRight(x);
        singleRotateFromLeft(y);
    }

    public void doubleRotateFromRight(Node y) {
        // Do something (just copy the code from BSTree)
        Node x = y.right;
        Node z = x.left;
        singleRotateFromLeft(x);
        singleRotateFromRight(y);
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete root or call the recursive delete function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if ((root.left == null) && (root.right == null)) { // Case 1 (leaf node)
                root = null;

            } else if ((root.left != null) && (root.right != null)) { // Case 3 (full node)
                Node minRightSubTree = findMin(root.right);
                Node temp = new Node(minRightSubTree.key);
                replace(root, temp);
                root = temp;
                // recursively delete the node
                delete(this, root.right, minRightSubTree.key);

            } else if (root.left != null) { // Case 2 (single child, left child)
                root.left.parent = null; // make left child the root
                root = root.left;

            } else { // Case 2 (single child, right child)
                root.right.parent = null; // make right child the root
                root = root.right;

            }
        } else { // Delete non-root node
            delete(this, root, key);

        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete non-root nodes
    public static void delete(AVLTree tree, Node node, int key) {
        if (node == null) {
            System.out.println("Key not found!!!");
        } else if (node.key > key) { // Go left
            delete(tree, node.left, key);
            while ((!(node.isImbalance())) && node.parent != null) {
                node = node.parent;
                if (node == tree.root) {
                    break;
                }
            }
            rebalance(tree, node);

        } else if (node.key < key) { // Go right
            delete(tree, node.right, key);
            while ((!(node.isImbalance())) && node.parent != null) {
                node = node.parent;
                if (node == tree.root) {
                    break;
                }
            }
            rebalance(tree, node);

        } else if (node.key == key) { // Node to be deleted is found
            if ((node.left == null) && (node.right == null)) { // Case 1(leaf node)
                if (node.key < node.parent.key) {
                    node.parent.left = null; // disown the left child
                } else {
                    node.parent.right = null; // disown the right child
                }
            } else if ((node.left != null) && (node.right != null)) { // Case 3 (full nodes)
                Node minRightSubTree = findMin(node.right);
                Node temp = new Node(minRightSubTree.key);
                replace(node, temp);
                // recursively delete the node
                delete(tree, node.right, minRightSubTree.key);

            } else {// Case 2 (single child)
                Node childNode;
                if (node.left != null) {  // only the left child
                    childNode = node.left;
                } else { // only the right child
                    childNode = node.right;
                }
                childNode.parent = node.parent;
                if (node.parent.key > node.key) {
                    node.parent.left = childNode;
                } else {
                    node.parent.right = childNode;
                }
            }
        }
    }

    // Replace node1 with a new node2
    // node2 must be created using "new Node(key)" before calling this function
    // This function is optional, you do not have to use it
    public static void replace(Node node1, Node node2) {
        if ((node1.left != null) && (node1.left != node2)) {
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if ((node1.right != null) && (node1.right != node2)) {
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if ((node1.parent != null) && (node1.parent != node2)) {
            node2.parent = node1.parent;
            if (node1.parent.key > node1.key) {
                node1.parent.left = node2;
            } else {
                node1.parent.right = node2;
            }
        }
    }

    public static ArrayList<Integer> storeInorder(Node node) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (node == null) {
            return list;
        }

        //recur on the left child 
        storeInorder(node.left);

        // Adds data to the list 
        list.add(node.key);
        //recur on the right child 
        storeInorder(node.right);

        return list;
    }

    public static boolean isMergeable(Node r1, Node r2) {
        int m = Math.max(storeInorder(r1).size(), storeInorder(r2).size());
        int n = Math.min(storeInorder(r1).size(), storeInorder(r2).size());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storeInorder(r1).get(j) > storeInorder(r2).get(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t) {
        if (isMergeable(r1, r2)) {
            // Do something
            // Do not forget to rebalance
            if (Math.abs(Node.height(r1) - Node.height(r2)) <= 1) {
                t.left = r1;
                t.right = r2;
                if (r1 != null && r2 != null) {
                    r1.parent = t;
                    r2.parent = t;
                }

                return t;
            } else if (Node.height(r1) > Node.height(r2)) {
                AVLTree tree = new AVLTree();
                tree.root = r1;
                Node rP = mergeWithRoot(r1.right, r2, t);
                r1.right = rP;
                rP.parent = r1;
                Node checknode = rP;
                while ((!(checknode.isImbalance())) && checknode.parent != null) {
                    checknode = checknode.parent;
                    if (rP == tree.root) {
                        break;
                    }
                }
                rebalance(tree, r1);
                return tree.root;
            } else if (Node.height(r1) < Node.height(r2)) {
                AVLTree tree = new AVLTree();
                tree.root = r1;
                Node rP = mergeWithRoot(r1.left, r2, t);
                r1.left = rP;
                rP.parent = r1;
                while ((!(rP.isImbalance())) && rP.parent != null) {
                    rP = rP.parent;
                    if (rP == tree.root) {
                        break;
                    }
                }
                rebalance(tree, r1);
                return tree.root;
            }
            // fix this
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
        return null;
    }

    public void merge(AVLTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            // do something
            Node t = findMax(this.root);
            delete(t.key);
            root = mergeWithRoot(this.root, tree2.root, t);
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }

    }

    public NodeList split(int key) {
        return split(this.root, key);// This is incorrect, fix this by calling the static split
    }

    public static NodeList split(Node r, int key) {

        if (r == null) {
            return new NodeList();
        } else if (key < r.key) {
            NodeList list;
            list = split(r.left, key);
            list.r2 = mergeWithRoot(list.r2, r.right, r);
            return list;
        } else { // key>=root.key
            NodeList list;
            list = split(r.right, key);
            list.r1 = mergeWithRoot(r.left, list.r1, r);
            return list;
        }
    }
}

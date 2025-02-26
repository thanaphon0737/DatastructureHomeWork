/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
 */
package homework_group17;

// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter {

    Node root;

    public Tree() {
        // can be left blank
    }

    public Tree(Node root) {
        this.root = root;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty Tree !!!");
        }
        super.printTree(root);
    }

    public Node find(int search_key) {
        // Fix this
        return find(this.root, search_key);
    }

    public static Node find(Node node, int search_key) {
        if (node == null) {
            return null;
        }
        if (node.key == search_key) {
            return node;
        } else if (search_key < node.key) {
            return find(node.left, search_key);
        } else if (search_key > node.key) {
            return find(node.right, search_key);
        } else {
            return null;
        }

    }

    public Node findClosest(int search_key) {
        return findClosest(this.root, search_key);

    }

    public static Node findClosest(Node node, int search_key) {
        if (node == null) {
            return null;
        }
        if (search_key == node.key) {
            return node;
        } else if (search_key < node.key) {
            if (findClosest(node.left, search_key) == null) {
                return node.left;
            }
            return findClosest(node.left, search_key);
        } else if (search_key > node.key) {
            if (findClosest(node.right, search_key) == null) {
                return node.right;
            }
            return findClosest(node.right, search_key);
        } else {
            return null;
        }

    }

    public Node findMin() {
        // fix this
        return findMin(root);
    }

    public static Node findMin(Node node) {
        // fix this
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public Node findMax() {
        // fix this 
        return findMax(root);
    }

    public static Node findMax(Node node) {
        // fix this
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public Node findKthSmallest(int k) {
        // fix this
        return findKthSmallest(root, k);
    }

    public static Node findKthSmallest(Node node, int k) {
        // fix this
        Node leftsubtree = node.left;
        int L = leftsubtree.size();
        if (k == L + 1) {
            return node;
        }
        if (k < L + 1) {
            return findKthSmallest(node.left, k);
        }
        if (k > L + 1) {
            return findKthSmallest(node.right, k - L - 1);
        } else {
            return null;
        }
    }

    public List rangeSearch(int x, int y) {
        List list = new List(100);
        Node node = findClosest(root, x);
        while(node.key <= y){
            if(node.key >= x){
                list.append(node);
            }
            node = node.findNext();
        }
        return list;
    }

    public void printPreOrderDFT() {
        System.out.print("PreOrder DFT node sequence [ ");
        // something is missing here
        printPreOrderDFT(root);
        System.out.println("]");
    }

    public static void printPreOrderDFT(Node node) {
        // fix this
        if (node == null) {
            return;
        } else {
            System.out.print(node.key + " ");
            printPreOrderDFT(node.left);
            printPreOrderDFT(node.right);
        }
    }

    public void printInOrderDFT() {
        System.out.print("InOrder DFT node sequence [ ");
        // something is missing here
        printInOrderDFT(root);
        System.out.println("]");
    }

    public static void printInOrderDFT(Node node) {
        // fix this
        if (node == null) {
            return;
        } else {
            printInOrderDFT(node.left);
            System.out.print(node.key + " ");
            printInOrderDFT(node.right);
        }
    }

    public void printPostOrderDFT() {
        System.out.print("PostOrder DFT node sequence [ ");
        // something is missing here
        printPostOrderDFT(root);
        System.out.println("]");
    }

    public static void printPostOrderDFT(Node node) {
        // fix this
        if (node == null) {
            return;
        } else {
            printPostOrderDFT(node.left);
            printPostOrderDFT(node.right);
            System.out.print(node.key + " ");
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);

        } else {
            if (key < root.key) {
                root.left = insert(root.left, key);
                root.left.parent = root;
            } else if (key > root.key) {
                root.right = insert(root.right, key);
                root.right.parent = root;
            }
            // do something
            // or
            if (key == root.key) {
                System.out.println("Duplicated key!!!");
            }

        }
    }

    // this method for implement recursive insert
    public static Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else {
            if (key < node.key) {
                node.left = insert(node.left, key);
                node.left.parent = node;
            } else if (key > node.key) {
                node.right = insert(node.right, key);
                node.right.parent = node;
            }
        }
        return node;
    }

    // You should include root node deletion in this function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            // delete the root
        } else {
            // Recursively delete non-root node
            // or
            System.out.println("Key not found!!!");
        }
    }

    // this function should delete only non-root node
    public static void delete(Node node) {
        // There should be three cases
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

    public int height() {
        return Node.height(root); // fix this with a single line
    }

    public int depth() {// Tree depth is equal to tree height
        return Node.height(root); // fix this with a single line
    }

    public int size() {
        return Node.size(root); // fix this with a single line
    }
}

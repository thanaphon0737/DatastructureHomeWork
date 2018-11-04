/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
 */
package hw7_group17;

public class SplayTree extends BTreePrinter {

    Node root;

    public SplayTree() {

    }

    public SplayTree(Node root) {

        if (root.parent != null) { // To make sure the root has no parent
            if (root.key < root.parent.key) {
                root.parent.left = null;
            } else {
                root.parent.right = null;
            }
            root.parent = null;
        }
        this.root = root;
    }

    public void printTree() {
        super.printTree(root);
    }

    public Node find(int search_key) {
        Node current = findWithoutSplaying(search_key);
        Node nodeKey = findWithoutSplaying(search_key);
        while(current != null){
            splay(nodeKey);
            current = current.parent;
        }
        
        return findWithoutSplaying(search_key); // fix this
    }

    // This function is already complete, no need to modify
    public Node findWithoutSplaying(int search_key) {
        return find(root, search_key);
    }

    // This function is already complete, no need to modify
    private static Node find(Node node, int search_key) {
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

    // This function is already complete, no need to modify
    private Node findMin() {
        return findMin(root);
    }

    // This function is already complete, no need to modify
    private static Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    // This function is already complete, no need to modify
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have splaying feature
    private static void insert(SplayTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
                Node current = node.left;
                Node nodeKey = node.left;
                while (current != null) {
                    tree.splay(nodeKey);
                    current = current.parent;
                }

            } else {
                insert(tree, node.left, key);
            }
        } else { // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
                Node current = node.right;
                Node nodeKey = node.right;
                while (current != null) {
                    tree.splay(nodeKey);
                    current = current.parent;

                }

            } else {
                insert(tree, node.right, key);
            }
        }
    }

    public void delete(int key) {
        // To delete a key in a splay tree, do the following steps
        // 1. splay node with the key to the root of tree1
        // 2. create another tree using the node of the right-subtree (tree2)
        // 3. Find min of the right-subtree and splay to the root
        // 4. Take left-subtree of the tree1 and hang as the left subtree of the tree2
        // 5. Reassign a new root (root of the tree2)
        delete(this, root, key);

    }

    public static void delete(SplayTree tree, Node node, int key) {
        if (node.key == key) {
            tree.splay(node);
            Node r1 = node.left;
            Node r2 = node.right;
            SplayTree treeNew = new SplayTree();
            treeNew.root = r2;
            treeNew.splay(findMin(treeNew.root));
            treeNew.root.left = r1;
            treeNew.root.right = r2;
            tree.root = treeNew.root;
        } else if (key < node.key) {
            delete(tree, node.left, key);
        } else if (key > node.key) {
            delete(tree, node.right, key);
        } else {
            System.out.println("Error");
        }

    }

    // Use this function to call zigzig or zigzag
    public void splay(Node node) {
        if (node != null && node != root) {
            if (node.parent == root) {
                // Do something (just add one line of code)
                zig(node);
            } else {
                if (node.key < node.parent.key) {
                    if (node.parent.key < node.parent.parent.key) {
                        // Left outer case
                        // Do something (just add one line of code)
                        zigzig(node);
                    } else {
                        // Left inner case
                        zigzag(node);
                        // Do something (just add one line of code)
                    }
                } else {
                    if (node.parent.key > node.parent.parent.key) {
                        // Right outer case
                        zigzig(node);
                        // Do something (just add one line of code)
                    } else {
                        zigzag(node);
                        // Do something (just add one line of code)
                    }
                }
                // Do something (just add one line of code)
            }
        }
    }

    // Use this function to call zig
    public void zigzig(Node node) { // Move two nodes up along the Outer path
        // Do something
        zig(node.parent);
        zig(node);
    }

    // Use this funciton to call zig
    public void zigzag(Node node) { // Move two nodes up along the Inner path
        // Do something
        zig(node);
        zig(node);
    }

    // This function should be called by zigzig or zigzag
    public void zig(Node node) {// Move up one step
        if (node.parent == null) {
            System.out.println("Cannot perform Zig operation on the root node");
        } else if (node.parent == root) { // If the node is a child of the root
            if (node.key < node.parent.key) {// Zig from left
                // Do something
                Node x = node;
                Node y = node.parent;
                if (x.right != null) {
                    x.right.parent = y;
                }
                y.left = x.right;
                y.parent = x;
                x.right = y;

                root = x;
                x.parent = null;

            } else { // Zig from right
                // Do something
                Node x = node;
                Node y = node.parent;
                if (x.left != null) {
                    x.left.parent = y;
                }
                y.right = x.left;
                y.parent = x;
                x.left = y;

                root = x;
                x.parent = null;
            }
        } else {// if the node is not a child of the root
            if (node.key < node.parent.key) {// Zig from left
                // Do something
                AVLTree tree = new AVLTree();
                tree.root = root;
                tree.singleRotateFromLeft(node.parent);
            } else {// Zig from left
                // Do something
                AVLTree tree = new AVLTree();
                tree.root = root;
                tree.singleRotateFromRight(node.parent);
            }
        }
    }
}

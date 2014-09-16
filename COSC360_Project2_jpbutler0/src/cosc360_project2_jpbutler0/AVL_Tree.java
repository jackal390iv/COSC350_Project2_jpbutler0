package cosc360_project2_jpbutler0;

/**
 *
 * @author Reaper
 */
public class AVL_Tree {

    public int size;
    public AVLnode root;

    public AVL_Tree() {
        root = null;
    }

    public void checker() {
        // theNodeBalance(root, root.left, root.right, 0, 0);
        System.out.println();

    }

    public void theNodeBalance(AVLnode currentNode, AVLnode leftNode,
            AVLnode rightNode, int leftCounter, int rightCounter) {

        if ((leftNode == null) && (rightNode == null)) {
            return;
        }
        if ((leftNode != null)) {
            leftCounter = theLeftCounter(currentNode, 0);
            System.out.println(leftCounter);
            theNodeBalance(currentNode, currentNode.left, currentNode.right,
                    leftCounter, rightCounter);
        }
        if (rightNode != null) {
            rightCounter = theRightCounter(currentNode, 0);
            System.out.println(rightCounter);
            theNodeBalance(currentNode, currentNode.left, currentNode.right,
                    leftCounter, rightCounter);
        } else {
            currentNode.theBalance = rightCounter - leftCounter;
            System.out
                    .println(currentNode.data + "  " + currentNode.theBalance);
            if ((currentNode.theBalance > 1) || (currentNode.theBalance < -1)) {
                rebuildTree(currentNode, currentNode.left, currentNode.right);
            } else {
            }
        }
        // theNodeBalance(currentNode.left, currentNode.left.left,
        // currentNode.left.right, 0,0);
        // theNodeBalance(currentNode.right, currentNode.right.left,
        // currentNode.right.right, 0,0);*/
    }

    public int theLeftCounter(AVLnode node, int left) {

        if (node.left != null) {
            System.out.println("hi");
            left++;
            theLeftCounter(node.left, left);
        }
        return left;
    }

    public int theRightCounter(AVLnode node, int right) {

        if (node.right != null) {
            right++;
            theLeftCounter(node.right, right);
        }
        return right;
    }

    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(AVLnode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print("\t" + node.data);
            inOrder(node.right);
        }
    }

    private void single_Rotate_right(AVLnode node) {
        AVLnode temp = node;
        node = node.left;
        node.left = temp;
        if (root == temp) {
            root = node;
        }
    }

    private void single_Rotate_left(AVLnode node) {
        AVLnode temp = node;
        node = node.right;
        node.right = temp;
        if (root == temp) {
            root = node;
        }
    }

    private void double_Rotate_right(AVLnode node) {
        AVLnode temp = node.left;
        node.left = node.left.right;
        temp.right = node;
        if (root == node) {
            root = temp;
        }
    }

    private void double_Rotate_left(AVLnode node) {
        AVLnode temp = node.right;
        node.right = node.right.left;
        temp.left = node;
        if (root == node) {
            root = temp;
        }
    }

    private void rebuildTree(AVLnode currentNode, AVLnode leftNode,
            AVLnode rightNode) {
        if (currentNode.theBalance < -1) {
            if (currentNode.right == null) {
                single_Rotate_right(currentNode);
            } else {
                double_Rotate_right(currentNode);
            }
        } else if (currentNode.theBalance > 1) {
            if (currentNode.left == null) {
                single_Rotate_left(currentNode);
            } else {
                double_Rotate_left(currentNode);
            }
        }
    }

    public void insert(int newItem) {
        insertHelper(root, new AVLnode(newItem));
    }

    public AVLnode insertHelper(AVLnode currentNode, AVLnode newNode) {

        if (root == null) {
            root = newNode;
            return root;
        }
        if (newNode.data > currentNode.data) {
            if (currentNode.right == null) {
                if (currentNode == root) {
                    root.setRightChild(newNode);
                } else {
                    currentNode.setRightChild(newNode);
                }
            }
            insertHelper(currentNode.right, newNode);
        } else if (newNode.data < currentNode.data) {
            if (currentNode.left == null) {
                if (currentNode == root) {
                    root.setLeftChild(newNode);
                } else {
                    currentNode.setLeftChild(newNode);
                }
            }
            insertHelper(currentNode.left, newNode);
        }
        checker();
        return newNode;
    }

    public void remove(int element) {

        AVLnode temp = findNode(root, element);
        if (temp == null) {
            return;
        } else if ((temp.right == null) && (temp.left == null)) {
            temp = null;
        }
        find_Left_Most_Child(temp);
    }

    private AVLnode findNode(AVLnode node, int element) {
        if (node.data == element) {
            return node;
        }
        findNode(node.left, element);
        findNode(node.right, element);
        return null;
    }

    private AVLnode find_Left_Most_Child(AVLnode node) {
        AVLnode temp = null;
        if ((node.right == null) && (node.right != null)) {
            temp = node.right;
            node.setLeftChild(null);
            size--;
            return temp;
        } else if ((node.right != null) & (node.right.left != null)) {
            find_Left_Most_Child(node.right);
        } else if ((node.right != null) & (node.right.left == null)) {
            temp = node.right;
            node.right = null;
            size--;
            return temp;
        }
        return null;

    }

    public void print_Children(int parent) {
        print_Children_Helper(parent, root);
    }

    public void print_Children_Helper(int parent, AVLnode node) {

        if (node.data == parent) {
            System.out.println("The Left Child of " + parent + " is: "
                    + node.left.data + " and it's right child is: "
                    + node.left.data);
        }
        print_Children_Helper(parent, node.left);
        print_Children_Helper(parent, node.right);
    }
}

class AVLnode {

    public int data;
    public int theBalance;
    public AVLnode left;
    public AVLnode right;

    public AVLnode(int datas) {
        data = datas;
        theBalance = 0;
        left = null;
        right = null;
    }

    public void setLeftChild(AVLnode lf) {
        left = lf;
    }

    public void setRightChild(AVLnode rt) {
        left = rt;
    }
}

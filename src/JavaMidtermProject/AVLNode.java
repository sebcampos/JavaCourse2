/**
 * From ZYbooks example
 * https://learn.zybooks.com/zybook/COLLEGEOFSANMATEOCIS256CalleFall2023/chapter/9/section/5
 */
package JavaMidtermProject;

public class AVLNode {

    // child enums
    public enum Child {
        LEFT, RIGHT
    }

    // task id for this node
    public int taskId;

    // priority for this node
    public int priority;

    // parent node
    public AVLNode parent;

    // left child
    public AVLNode left;

    // right child
    public AVLNode right;

    // height of tree
    public int height;

    /**
     * Constructor with a key parameter creates the Node object.
     */
    public AVLNode(int taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
        parent = null;
        left = null;
        right = null;
        height = 0;
    }

    /**
     * Override toString to allow informative print of node
     * @return String including node Task id nad priority
     */
    @Override
    public String toString()
    {
        return "Task Id: " + taskId + ", priority: " + priority + "\n";
    }


    /**
     * Calculate this nodes' balance factor, defined as
     * height(left subtree) - height(right subtree)
     * @return integer representing tree balance
     */
    public int getBalance() {
        // Get current height of left subtree, or -1 if null
        int leftHeight = -1;
        if (left != null) {
            leftHeight = left.height;
        }

        // Get current height of right subtree, or -1 if null
        int rightHeight = -1;
        if (right != null) {
            rightHeight = right.height;
        }

        // Calculate the balance factor.
        return leftHeight - rightHeight;
    }

    /**
     * Recalculate the current height of the subtree rooted at
     * the node, usually called after a subtree has been
     * modified.
     */
    public void updateHeight() {
        // Get current height of left subtree, or -1 if null
        int leftHeight = -1;
        if (left != null) {
            leftHeight = left.height;
        }

        // Get current height of right subtree, or -1 if null
        int rightHeight = -1;
        if (right != null) {
            rightHeight = right.height;
        }

        // Assign height with calculated node height.
        height = Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Assign either the left or right data member with a new
     * child. Returns true if the new child is successfully
     * assigned to this node, false otherwise.
     * @param whichChild the Child ENUM to determine which child
     * @param child AVLNode of the child being assigned
     * @return true if successfully assigned else false
     */
    public boolean setChild(Child whichChild, AVLNode child) {
        // Assign the left or right data member.
        if (whichChild == Child.LEFT) {
            left = child;
        }
        else {
            right = child;
        }

        // Assign the parent data member of the new child,
        // if the child is not null.
        if (child != null) {
            child.parent = this;
        }

        // Update the node's height, since the subtree's structure
        // may have changed.
        updateHeight();
        return true;
    }

    /**
     * Replace a current child with a new child. Determines if
     * the current child is on the left or right, and calls
     * setChild() with the new node appropriately.
     * Returns true if the new child is assigned, false otherwise.
     * @param currentChild the child to replace
     * @param newChild the new child to be assigned
     * @return true if successful else false
     */
    public boolean replaceChild(AVLNode currentChild, AVLNode newChild) {
        if (left == currentChild) {
            return setChild(Child.LEFT, newChild);
        }
        else if (right == currentChild) {
            return setChild(Child.RIGHT, newChild);
        }

        // If neither of the above cases applied, then the new child
        // could not be attached to this node.
        return false;
    }
}
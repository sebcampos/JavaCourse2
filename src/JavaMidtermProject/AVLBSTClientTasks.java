/**
 * @author Sebastian Campos
 * @description used to manage, read, and delete tasks for a
 * particular client
 */

package JavaMidtermProject;

public class AVLBSTClientTasks {


    // Root node of AVL
    private AVLNode root;


    // Task id for the newest task to add
    private int taskId = 0;

    // number of tasks in tree
    private int size = 0;

    /**
     * Init root as null
     */
    public AVLBSTClientTasks() {
        root = null;
    }


    /**
     * Performs a left rotation at the given node. Returns the
     *  subtree's new root.
     * @param node AVLNode to rotate
     * @return root AVLNode
     */
    public AVLNode rotateLeft(AVLNode node) {
        // Define a convenience pointer to the left child of the
        // right child.
        AVLNode rightLeftChild = node.right.left;

        // Step 1 - the right child moves up to the node's position.
        // node is temporarily detached from the tree, but will be reattached
        // later.
        if (node.parent != null) {
            node.parent.replaceChild(node, node.right);
        }
        else { // node is root
            root = node.right;
            root.parent = null;
        }

        // Step 2 - the node becomes the left child of what used
        // to be node's right child, but is now node's parent. This will
        // detach rightLeftChild from the tree.
        node.right.setChild(AVLNode.Child.LEFT, node);

        // Step 3 - reattach rightLeftChild as the right child of node.
        node.setChild(AVLNode.Child.RIGHT, rightLeftChild);

        return node.parent;
    }

    /**
     * Performs a right rotation at the given node. Returns the
     *  subtree's new root.
     * @param node AVLNode to rotate
     * @return root AVLNode
     */
    public AVLNode rotateRight(AVLNode node) {
        // Define a convenience pointer to the right child of the
        // left child.
        AVLNode leftRightChild = node.left.right;

        // Step 1 - the left child moves up to the node's position.
        // node is temporarily detached from the tree, but will be reattached
        // later.
        if (node.parent != null) {
            node.parent.replaceChild(node, node.left);
        }
        else { // node is root
            root = node.left;
            root.parent = null;
        }

        // Step 2 - the node becomes the right child of what used
        // to be node's left child, but is now node's parent. This will
        // detach leftRightChild from the tree.
        node.left.setChild(AVLNode.Child.RIGHT, node);

        // Step 3 - reattach leftRightChild as the right child of node.
        node.setChild(AVLNode.Child.LEFT, leftRightChild);

        return node.parent;
    }

    /**
     * Getter for the Trees root Node
     * @return AVLNode root
     */
    public AVLNode getRoot() { return root;}

    /**
     * Updates the given node's height and balances the subtree if
     * the balancing factor is now -2 or +2. Balancing is done by
     * performing a rotation. Returns the subtree's new root if
     * a rotation occurred, or the node if no balancing was required.
     * @param node Node to rebalance
     * @return returns the new Subtrees root
     */
    public AVLNode rebalance(AVLNode node) {
        // First update the height of this node.
        node.updateHeight();

        // Check for an imbalance.
        if (node.getBalance() == -2) {
            // The subtree is too big to the right.
            if (node.right.getBalance() == 1) {
                // Double rotation case. First do a right rotation
                // on the right child.
                rotateRight(node.right);
            }

            // A left rotation will now make the subtree balanced.
            return rotateLeft(node);
        }
        else if (node.getBalance() == 2) {
            // The subtree is too big to the left
            if (node.left.getBalance() == -1) {
                // Double rotation case. First do a left rotation
                // on the left child.
                rotateLeft(node.left);
            }

            // A right rotation will now make the subtree balanced.
            return rotateRight(node);
        }

        // No imbalance, so just return the original node.
        return node;
    }

    /**
     * Gets the current task id to create a new task with
     * @return integer representing the current task id
     */
    public int getCurrentTaskId() { return taskId; }

    /**
     * increments the task id after adding a task
     */
    public void incrementTaskId() { taskId++; }

    /**
     * Returns the number of tasks in the tree
     * @return integer representing number of tasks
     */
    public int getSize() {return size;}

    /**
     * Increments the number of tasks in the queue
     */
    public void incrementSize() { size++; }

    /**
     * Decrements the number of tasks in the queue
     */
    public void decrementSize() { size--; }


    /**
     * Inserts the provided node into the AVL Tree
     * @param node AVL Task Node to insert
     */
    void insert(AVLNode node) {
        // Check if tree is empty
        if (root == null) {
            root = node;
            incrementSize();
        }
        else {
            // Step 1 - do a regular binary search tree insert.
            AVLNode currentNode = root;
            while (currentNode != null) {
                // Choose to go left or right
                if (node.taskId < currentNode.taskId) {
                    // Go left. If left child is null, insert the new
                    // node here.
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        node.parent = currentNode;
                        currentNode = null;
                    }
                    else {
                        // Go left and do the loop again.
                        currentNode = currentNode.left;
                    }
                }
                else {
                    // Go right. If the right child is null, insert the
                    // new node here.
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        node.parent = currentNode;
                        currentNode = null;
                    }
                    else {
                        // Go right and do the loop again.
                        currentNode = currentNode.right;
                    }
                }
            }

            // Step 2 - Rebalance along a path from the new node's parent up
            // to the root.
            // System.out.println("incrementing tree size");
            incrementSize();
            node = node.parent;
            while (node != null) {
                rebalance(node);
                node = node.parent;
            }
        }
    }

    /**
     * Removes the provided node from the AVLTree
     * @param nodeToRemove taskNode to remove
     * @return true if removed false if not
     */
    boolean removeNode(AVLNode nodeToRemove) {
        // Base case:
        if (nodeToRemove == null) {
            return false;
        }

        // Parent needed for rebalancing.
        AVLNode parent = nodeToRemove.parent;

        // Case 1: Internal node with 2 children
        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            // Find successor
            AVLNode successorNode = nodeToRemove.right;
            while (successorNode.left != null) {
                successorNode = successorNode.left;
            }

            // Copy the value from the node
            nodeToRemove.taskId = successorNode.taskId;

            // Recursively remove successor
            removeNode(successorNode);

            // Nothing left to do since the recursive call will have rebalanced
            return true;
        }

        // Case 2: Root node (with 1 or 0 children)
        else if (nodeToRemove == root) {
            if (nodeToRemove.left != null) {
                root = nodeToRemove.left;
            }
            else {
                root = nodeToRemove.right;
            }

            if (root != null) {
                root.parent = null;
            }

            return true;
        }

        // Case 3: Internal with left child only
        else if (nodeToRemove.left != null) {
            parent.replaceChild(nodeToRemove, nodeToRemove.left);
        }

        // Case 4: Internal with right child only OR leaf
        else {
            parent.replaceChild(nodeToRemove, nodeToRemove.right);
        }

        // nodeToRemove is gone. Anything that was below nodeToRemove that has persisted
        // is already correctly balanced, but ancestors of nodeToRemove may need rebalancing.
        nodeToRemove = parent;
        while (nodeToRemove != null) {
            rebalance(nodeToRemove);
            nodeToRemove = nodeToRemove.parent;
        }

        return true;
    }

    /**
     * Searches for a node with a matching key. Does a regular
     * binary search tree search operation. Returns the node with the
     * matching key, or null if no matching key exists in the tree.
     * @param desiredKey Key / Task id to find
     * @return Node or null if not found
     */
    AVLNode search(int desiredKey) {
        AVLNode currentNode = root;
        while (currentNode != null) {
            // Return the node if the key matches
            if (currentNode.taskId == desiredKey) {
                return currentNode;
            }

            // Navigate to the left if the search key is
            // less than the node's key.
            else if (desiredKey < currentNode.taskId) {
                currentNode = currentNode.left;
            }

            // Navigate to the right if the search key is
            // greater than the node's key.
            else {
                currentNode = currentNode.right;
            }
        }

        // The key was not found in the tree.
        return null;
    }


    /**
     * Attempts to remove a node with a matching key. If no node has a matching key
     * then nothing is done and false is returned; otherwise the node is removed and
     * true is returned.
     * @param key Key / Task id to search for
     * @return True if successfully removed else false
     */
    boolean removeKey(int key) {
        AVLNode node = search(key);
        if (node == null) {
            return false;
        }
        else {
            //System.out.println("decrementing size");
            decrementSize();
            return removeNode(node);
        }
    }


}
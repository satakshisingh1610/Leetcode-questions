class Solution {

    // Finds the inorder successor (smallest node in right subtree)
    public TreeNode getInSucc(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case
        if (root == null) {
            return null;
        }

        // Search for the node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children

            // Find inorder successor
            TreeNode temp = getInSucc(root.right);

            // Copy its value
            root.val = temp.val;

            // Delete the inorder successor
            root.right = deleteNode(root.right, temp.val);
        }

        return root;
    }
}
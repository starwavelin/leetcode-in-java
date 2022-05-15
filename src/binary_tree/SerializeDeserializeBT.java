package binary_tree;

import utility.TreeNode;

public class SerializeDeserializeBT {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSer(root, sb);
        return sb.substring(0, sb.length() - 1);
    }
    private void preorderSer(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        preorderSer(root.left, sb);
        preorderSer(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        int[] count = new int[1];
        return dfsDes(strs, count);
    }
    private TreeNode dfsDes(String[] strs, int[] count) {
        if (count[0] == strs.length) {
            return null;
        }
        String s = strs[count[0]];
        count[0]++;
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = dfsDes(strs, count);
        root.right = dfsDes(strs, count);
        return root;
    }
	
}

//Your SerializeDeserializeBT object will be instantiated and called as such:
//SerializeDeserializeBT sd = new SerializeDeserializeBT();
//sd.deserialize(sd.serialize(root));
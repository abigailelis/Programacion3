package tp3;

public class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.key = value;
        this.left = left;
        this.right = right;
    }

    public int getKey(){
        return key;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public boolean hasTwoChildren(){
        return this.left != null && this.right != null;
    }

    public String toString(){
        return this.key + " ";
    }

	public void setKey(int key) {
		this.key = key;
	}
}

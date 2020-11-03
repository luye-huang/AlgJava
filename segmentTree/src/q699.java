import java.util.ArrayList;
import java.util.List;

public class q699 {
    class Node {
        public int l;
        public int r;
        public int height;
        public Node left;
        public Node right;

        public Node(int l, int r, int height) {
            this.l = l;
            this.r = r;
            this.height = height;
        }
    }

    public boolean intersect(Node root, int l, int r) {
        return !(l >= root.r || r <= root.l);
    }

    public int maxHeight(Node root, int l, int r) {
        if (null == root) return 0;
        int ret = 0;
        if (intersect(root, l, r)) {
            ret = root.height;
        }
        ret = Math.max(ret, maxHeight(root.left, l, r));
        if (r > root.l) {
            ret = Math.max(ret, maxHeight(root.right, l, r));
        }
        return ret;
    }

    public Node insertNode(Node root, int l, int r, int height) {
        if (null == root) {
            return new Node(l, r, height);
        }
        if (l < root.l) {
            root.left = insertNode(root.left, l, r, height);
        } else {
            root.right = insertNode(root.right, l, r, height);
        }
        return root;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        Node root = null;
        int curMax = 0;
        for (int[] position : positions) {
            int l = position[0];
            int r = position[0] + position[1];
            int height = position[1];
            int curHeight = maxHeight(root, l, r);
            root = insertNode(root, l, r, height + curHeight);
            curMax = Math.max(curHeight + height, curMax);
            ret.add(curMax);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new q699().fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
//        System.out.println(new q699().fallingSquares(new int[][]{{20, 30}, {1, 200}, {160, 1}}));
    }
}

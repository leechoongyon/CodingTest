package codingtest.site.datastructure;

public class BinaryTreeReal {
    int data;
    BinaryTreeReal left, right;
    public BinaryTreeReal(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        int num = 15;
        BinaryTreeReal nodes[] = new BinaryTreeReal[num+1];


        for(int i = 1 ; i <= num ; i++ ) {
            BinaryTreeReal node = new BinaryTreeReal(i);
            node.left = null;
            node.right = null;
            nodes[i] = node;
        }

        for(int i = 2 ; i <= num ; i++ ) {
            if( i % 2 == 0 ) {
                nodes[i/2].left = nodes[i];
            } else {
                nodes[i/2].right = nodes[i];
            }
        }

        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);


    }

    static void preorder(BinaryTreeReal ptr) {
        if(ptr != null) {
            System.out.print(ptr.data + " ");
            preorder(ptr.left);
            preorder(ptr.right);
        }
    }

    static void inorder(BinaryTreeReal ptr) {
        if(ptr != null) {
            inorder(ptr.left);
            System.out.print(ptr.data + " ");
            inorder(ptr.right);
        }
    }

    static void postorder(BinaryTreeReal ptr) {
        if(ptr != null) {
            postorder(ptr.left);
            postorder(ptr.right);
            System.out.print(ptr.data + " ");
        }
    }
}

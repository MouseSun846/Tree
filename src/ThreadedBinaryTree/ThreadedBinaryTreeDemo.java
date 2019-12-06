package ThreadedBinaryTree;
import static myPrint.Print.*;
/**
 * 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //中序遍历
        HeroNode root = new HeroNode(0, "tom");
        HeroNode node1 = new HeroNode(1, "jack");
        HeroNode node2 = new HeroNode(2, "smith");
        HeroNode node3 = new HeroNode(3, "mary");
        HeroNode node4 = new HeroNode(4, "king");
        HeroNode node5 = new HeroNode(5, "dim");
//        HeroNode node6 = new HeroNode(15, "tim");
        //二叉树创建
        root.setLeft(node1);
        root.setRight(node4);
//        node2.setLeft(node6);
        node1.setRight(node2);
        node2.setLeft(node3);
        node4.setRight(node5);
        //测试线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        //先序遍历
        threadBinaryTree.postOrder();
        //线索化
//        threadBinaryTree.prethreadedNodes();
//        threadBinaryTree.middlethreadedNodes();
        threadBinaryTree.postthreadedNodes();


        //测试
        HeroNode nodeLeft = node3.getLeft();
        println("结点对的前驱结点： "+nodeLeft);
        HeroNode nodeRight = node3.getRight();
        println("结点对的后继结点： "+nodeRight);

//        println("使用线索化的方式先序遍历线索化二叉树");
//        threadBinaryTree.prethreadedList();

//        println("使用线索化的方式后序遍历线索化二叉树");
//        threadBinaryTree.middlethreadedList();

        println("使用线索化的方式后序遍历线索化二叉树");
        threadBinaryTree.postthreadedList();




    }
}

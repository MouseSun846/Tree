package ThreadedBinaryTree;
import static myPrint.Print.*;
/**
 * ������������
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //�������
        HeroNode root = new HeroNode(0, "tom");
        HeroNode node1 = new HeroNode(1, "jack");
        HeroNode node2 = new HeroNode(2, "smith");
        HeroNode node3 = new HeroNode(3, "mary");
        HeroNode node4 = new HeroNode(4, "king");
        HeroNode node5 = new HeroNode(5, "dim");
//        HeroNode node6 = new HeroNode(15, "tim");
        //����������
        root.setLeft(node1);
        root.setRight(node4);
//        node2.setLeft(node6);
        node1.setRight(node2);
        node2.setLeft(node3);
        node4.setRight(node5);
        //����������
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        //�������
        threadBinaryTree.postOrder();
        //������
//        threadBinaryTree.prethreadedNodes();
//        threadBinaryTree.middlethreadedNodes();
        threadBinaryTree.postthreadedNodes();


        //����
        HeroNode nodeLeft = node3.getLeft();
        println("���Ե�ǰ����㣺 "+nodeLeft);
        HeroNode nodeRight = node3.getRight();
        println("���Եĺ�̽�㣺 "+nodeRight);

//        println("ʹ���������ķ�ʽ�������������������");
//        threadBinaryTree.prethreadedList();

//        println("ʹ���������ķ�ʽ�������������������");
//        threadBinaryTree.middlethreadedList();

        println("ʹ���������ķ�ʽ�������������������");
        threadBinaryTree.postthreadedList();




    }
}

import static myPrint.Print.*;
public class main {
    public static void main(String[] args) {
        //����������
        BinaryTree binaryTree = new BinaryTree();
        //�����ڵ�
        HeroNode root = new HeroNode(1,"�ν�");
        HeroNode node2 = new HeroNode(2,"����");
        HeroNode node3 = new HeroNode(3,"¬��");
        HeroNode node4 = new HeroNode(4,"�ֳ�");
        HeroNode node5 = new HeroNode(5,"��ʤ");
        HeroNode node6 = new HeroNode(6,"MouseSun");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setRight(node6);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        println("ǰ�����");
        binaryTree.preOrder();
//        println("�������");
//        binaryTree.middleOrder();
//        println("�������");
//        binaryTree.postOrder();
//        HeroNode node = binaryTree.postOrderSearch(5);
//        if (node != null){
//            println(node);
//        }else {
//            println("�Ҳ���");
//        }

        binaryTree.delNode(5);
        binaryTree.preOrder();


    }
}

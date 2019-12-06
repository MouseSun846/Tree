import static myPrint.Print.*;
public class main {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        HeroNode node6 = new HeroNode(6,"MouseSun");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setRight(node6);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        println("前序遍历");
        binaryTree.preOrder();
//        println("中序遍历");
//        binaryTree.middleOrder();
//        println("后序遍历");
//        binaryTree.postOrder();
//        HeroNode node = binaryTree.postOrderSearch(5);
//        if (node != null){
//            println(node);
//        }else {
//            println("找不到");
//        }

        binaryTree.delNode(5);
        binaryTree.preOrder();


    }
}

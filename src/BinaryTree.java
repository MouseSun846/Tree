import static myPrint.Print.*;
public class BinaryTree {
    private HeroNode  root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public  void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public  void middleOrder(){
        if (this.root != null){
            this.root.middleOrder();
        }else {
            println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public  void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            println("二叉树为空，无法遍历");
        }
    }


    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root != null )
        {
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序遍历查找
    public HeroNode middleOrderSearch(int no){
        if (root != null){
            return this.root.middleOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    //删除结点
    public void  delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {

            println("空树不能删除");
        }
    }
}

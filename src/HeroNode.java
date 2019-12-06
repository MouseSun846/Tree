import static myPrint.Print.*;
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
     //前序遍历
    public void preOrder(){
        println(this);
        //递归左子树
        if (this.left != null){
             this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null)
        {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void middleOrder(){

        //递归左子树
        if (this.left != null){
            this.left.middleOrder();
        }
        println(this);
        //递归向右子树遍历
        if (this.right != null)
        {
            this.right.middleOrder();
        }
    }

    //后序遍历
    public void postOrder(){

        //递归左子树
        if (this.left != null){
            this.left.postOrder();
        }
        //递归向右子树遍历
        if (this.right != null)
        {
            this.right.postOrder();
        }
        println(this);
    }

    /**
     * 前序遍历查找
     *  no 查找序号
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        println("前序遍历");
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    /**
     *中序遍历查找
     *  no 查找序号
     * @param no
     * @return
     */
    public HeroNode middleOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.middleOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        println("中序遍历");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.middleOrderSearch(no);
        }
        return resNode;
    }


    /**
     *后序遍历查找
     *  no 查找序号
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        println("后序遍历");
        //左右子树搜没有找到，比较当前节点
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    //递归删除结点
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left  != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }

    }

}

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
     //ǰ�����
    public void preOrder(){
        println(this);
        //�ݹ�������
        if (this.left != null){
             this.left.preOrder();
        }
        //�ݹ�������������
        if (this.right != null)
        {
            this.right.preOrder();
        }
    }

    //�������
    public void middleOrder(){

        //�ݹ�������
        if (this.left != null){
            this.left.middleOrder();
        }
        println(this);
        //�ݹ�������������
        if (this.right != null)
        {
            this.right.middleOrder();
        }
    }

    //�������
    public void postOrder(){

        //�ݹ�������
        if (this.left != null){
            this.left.postOrder();
        }
        //�ݹ�������������
        if (this.right != null)
        {
            this.right.postOrder();
        }
        println(this);
    }

    /**
     * ǰ���������
     *  no �������
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        println("ǰ�����");
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
     *�����������
     *  no �������
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
        println("�������");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.middleOrderSearch(no);
        }
        return resNode;
    }


    /**
     *�����������
     *  no �������
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
        println("�������");
        //����������û���ҵ����Ƚϵ�ǰ�ڵ�
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    //�ݹ�ɾ�����
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

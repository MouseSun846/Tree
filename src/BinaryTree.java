import static myPrint.Print.*;
public class BinaryTree {
    private HeroNode  root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //ǰ�����
    public  void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public  void middleOrder(){
        if (this.root != null){
            this.root.middleOrder();
        }else {
            println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public  void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            println("������Ϊ�գ��޷�����");
        }
    }


    //ǰ���������
    public HeroNode preOrderSearch(int no){
        if (root != null )
        {
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //�����������
    public HeroNode middleOrderSearch(int no){
        if (root != null){
            return this.root.middleOrderSearch(no);
        }else {
            return null;
        }
    }
    //�����������
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    //ɾ�����
    public void  delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {

            println("��������ɾ��");
        }
    }
}

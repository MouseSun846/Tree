package ThreadedBinaryTree;

import static myPrint.Print.println;

public class ThreadBinaryTree {
    private HeroNode root;
    //Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
    //�ڵݹ����������ʱ��pre���Ǳ���ǰһ�����
    private HeroNode pre = null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //����threadedNode����
    public void prethreadedNodes(){
        this.prethreadedNodes(root);
    }
    //����middlethreadedNode����
    public void middlethreadedNodes(){
        this.middlethreadedNodes(root);
    }
    //����threadedNode����
    public void postthreadedNodes(){
        this.postthreadedNodes(root);
    }

    //ǰ�����������������
    public void prethreadedList(){
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        while (node != null){

            //ѭ�����ҵ�leftType == 1�Ľ��
            //�������ű������仯����ΪleftType==1��˵���ý���ǰ�����������������Ч���
            while (node.getLefttype() == 0){
                //��ӡ��ǰ���
                println(node);
                node = node.getLeft();
            }
            //�����ǰ������ָ��ָ����Ǻ�̽�㣬��һֱ���
            while (node.getRighttype() == 1){
                //��ӡ��ǰ���
                println(node);
                //��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
            }
            println(node);
            //�滻��������Ľ��
            node  = node.getRight();
        }
    }

    //�������������������
    public void middlethreadedList(){
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        while (node != null){
            //ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ����ǽ��8
            //�������ű������仯����ΪleftType==1��˵���ý���ǰ�����������������Ч���
            while (node.getLefttype() == 0){
                 node = node.getLeft();
            }
            //��ӡ��ǰ���
            println(node);
            //�����ǰ������ָ��ָ����Ǻ�̽�㣬��һֱ���
            while (node.getRighttype() == 1){
                //��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
                println(node);
            }
            //�滻��������Ľ��
            node  = node.getRight();
        }
    }
    //�������������������
    public void postthreadedList(){
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        HeroNode Prev = null;
        while (node != null){
            //ѭ�����ҵ�leftType == 1�Ľ��
            //�������ű������仯����ΪleftType==1��˵���ý���ǰ�����������������Ч���
            while (node.getLefttype() == 0){
                node = node.getLeft();
            }
            //�����ǰ������ָ��ָ����Ǻ�̽�㣬��һֱ���
            while (node.getRighttype() == 1){
                println(node);
                Prev = node;
                //��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
            }
            if (node ==root){
                println(node);
                return;
            }
            while (node !=null && node.getRight()==Prev){
                println(node);
                Prev = node;
                //�滻��������Ľ��
                node  = node.getChild();
            }
            if(node!=null && node.getRighttype()==0) {
                node = node.getRight();
            }

        }
    }

    /**
     *����������ǰ���������ķ���
     * @param node ���ǵ�ǰ��Ҫ�������Ľڵ�
     */
    public void prethreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //һ����������ǰ�ڵ�
        //�ȴ���ǰ����ǰ�����
        if (node.getLeft() == null)
        {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�����ͣ�ָ��ǰ�����
            node.setLefttype(1);
        }
        //�����̽��
        if (pre!=null && pre.getRight() == null){
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRighttype(1);
        }

        // ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre  = node;
        //������������������
        if (node.getLefttype()==0)
            prethreadedNodes(node.getLeft());
        //������������������
        if (node.getRighttype()==0)
        prethreadedNodes(node.getRight());
    }




    /**
     *���������������������ķ���
     * @param node ���ǵ�ǰ��Ҫ�������Ľڵ�
     */
    public void middlethreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //һ����������������
        middlethreadedNodes(node.getLeft());
        //������������ǰ�ڵ�
        //�ȴ���ǰ����ǰ�����
        if (node.getLeft() == null)
        {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�����ͣ�ָ��ǰ�����
            node.setLefttype(1);
        }
        //�����̽��
        if (pre!=null && pre.getRight() == null){
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRighttype(1);
        }
        // ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre  = node;
        //������������������
        middlethreadedNodes(node.getRight());
    }
    /**
     *���������к����������ķ���
     * @param node ���ǵ�ǰ��Ҫ�������Ľڵ�
     */
    public void postthreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //һ����������������
        postthreadedNodes(node.getLeft());

        //������������������
        postthreadedNodes(node.getRight());

        //������������ǰ�ڵ�
        //�ȴ���ǰ����ǰ�����
        if (node.getLeft() == null)
        {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�����ͣ�ָ��ǰ�����
            node.setLefttype(1);
        }
        //�����̽��
        if (pre!=null && pre.getRight() == null){
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRighttype(1);
        }else if (pre!=null && pre.getRight()!=null){
            pre.setChild(node);
        }
        // ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre  = node;
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

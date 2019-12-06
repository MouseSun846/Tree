package ThreadedBinaryTree;

import static myPrint.Print.println;

public class ThreadBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre总是保留前一个结点
    private HeroNode pre = null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //重载threadedNode方法
    public void prethreadedNodes(){
        this.prethreadedNodes(root);
    }
    //重载middlethreadedNode方法
    public void middlethreadedNodes(){
        this.middlethreadedNodes(root);
    }
    //重载threadedNode方法
    public void postthreadedNodes(){
        this.postthreadedNodes(root);
    }

    //前序遍历线索化二叉树
    public void prethreadedList(){
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null){

            //循环的找到leftType == 1的结点
            //后面随着遍历而变化，因为leftType==1，说明该结点是按照线索化处理后的有效结点
            while (node.getLefttype() == 0){
                //打印当前结点
                println(node);
                node = node.getLeft();
            }
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRighttype() == 1){
                //打印当前结点
                println(node);
                //获取到当前结点的后继结点
                node = node.getRight();
            }
            println(node);
            //替换这个遍历的结点
            node  = node.getRight();
        }
    }

    //中序遍历线索化二叉树
    public void middlethreadedList(){
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null){
            //循环的找到leftType == 1的结点，第一个找到就是结点8
            //后面随着遍历而变化，因为leftType==1，说明该结点是按照线索化处理后的有效结点
            while (node.getLefttype() == 0){
                 node = node.getLeft();
            }
            //打印当前结点
            println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRighttype() == 1){
                //获取到当前结点的后继结点
                node = node.getRight();
                println(node);
            }
            //替换这个遍历的结点
            node  = node.getRight();
        }
    }
    //后序遍历线索化二叉树
    public void postthreadedList(){
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        HeroNode Prev = null;
        while (node != null){
            //循环的找到leftType == 1的结点
            //后面随着遍历而变化，因为leftType==1，说明该结点是按照线索化处理后的有效结点
            while (node.getLefttype() == 0){
                node = node.getLeft();
            }
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRighttype() == 1){
                println(node);
                Prev = node;
                //获取到当前结点的后继结点
                node = node.getRight();
            }
            if (node ==root){
                println(node);
                return;
            }
            while (node !=null && node.getRight()==Prev){
                println(node);
                Prev = node;
                //替换这个遍历的结点
                node  = node.getChild();
            }
            if(node!=null && node.getRighttype()==0) {
                node = node.getRight();
            }

        }
    }

    /**
     *二叉树进行前序线索化的方法
     * @param node 就是当前需要线索化的节点
     */
    public void prethreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //一、线索化当前节点
        //先处理当前结点的前驱结点
        if (node.getLeft() == null)
        {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLefttype(1);
        }
        //处理后继结点
        if (pre!=null && pre.getRight() == null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRighttype(1);
        }

        // 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre  = node;
        //二、先线索化左子树
        if (node.getLefttype()==0)
            prethreadedNodes(node.getLeft());
        //三、再线索化右子树
        if (node.getRighttype()==0)
        prethreadedNodes(node.getRight());
    }




    /**
     *二叉树进行中序线索化的方法
     * @param node 就是当前需要线索化的节点
     */
    public void middlethreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //一、先线索化左子树
        middlethreadedNodes(node.getLeft());
        //二、线索化当前节点
        //先处理当前结点的前驱结点
        if (node.getLeft() == null)
        {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLefttype(1);
        }
        //处理后继结点
        if (pre!=null && pre.getRight() == null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRighttype(1);
        }
        // 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre  = node;
        //三、再线索化右子树
        middlethreadedNodes(node.getRight());
    }
    /**
     *二叉树进行后序线索化的方法
     * @param node 就是当前需要线索化的节点
     */
    public void postthreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //一、先线索化左子树
        postthreadedNodes(node.getLeft());

        //二、再线索化右子树
        postthreadedNodes(node.getRight());

        //三、线索化当前节点
        //先处理当前结点的前驱结点
        if (node.getLeft() == null)
        {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLefttype(1);
        }
        //处理后继结点
        if (pre!=null && pre.getRight() == null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRighttype(1);
        }else if (pre!=null && pre.getRight()!=null){
            pre.setChild(node);
        }
        // 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre  = node;
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

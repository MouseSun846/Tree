import static myPrint.Print.*;

/**
 * 顺序二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder();
    }
}
//实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载preOrder
    public void preOrder(){
        preOrder(0);
    }
    //重载middleOrder
    public void middleOrder(){
        middleOrder(0);
    }
    //重载postOrder
    public void postOrder(){
        postOrder(0);
    }
    //完成二叉树的前序遍历
    /**
     * 数组的下标
     * @param index
     */
    public void preOrder(int index){
        //如果数组为空 或者arr.length  = 0
        if (arr == null || arr.length == 0){
            println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前元素
        println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length){
            preOrder(2*index+2);
        }
    }

    //完成二叉树的中序遍历
    /**
     * 数组的下标
     * @param index
     */
    public void middleOrder(int index){
        //如果数组为空 或者arr.length  = 0
        if (arr == null || arr.length == 0){
            println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length){
            middleOrder(2 * index + 1);
        }
        //输出当前元素
        println(arr[index]);
        //向右递归遍历
        if ((index * 2 + 2) < arr.length){
            middleOrder(2*index+2);
        }
    }
    //完成二叉树的后序遍历
    /**
     * 数组的下标
     * @param index
     */
    public void postOrder(int index){
        //如果数组为空 或者arr.length  = 0
        if (arr == null || arr.length == 0){
            println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length){
            postOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length){
            postOrder(2*index+2);
        }
        //输出当前元素
        println(arr[index]);
    }

}

import static myPrint.Print.*;

/**
 * ˳�������
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder();
    }
}
//ʵ��˳��洢����������
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //����preOrder
    public void preOrder(){
        preOrder(0);
    }
    //����middleOrder
    public void middleOrder(){
        middleOrder(0);
    }
    //����postOrder
    public void postOrder(){
        postOrder(0);
    }
    //��ɶ�������ǰ�����
    /**
     * ������±�
     * @param index
     */
    public void preOrder(int index){
        //�������Ϊ�� ����arr.length  = 0
        if (arr == null || arr.length == 0){
            println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }
        //�����ǰԪ��
        println(arr[index]);
        //����ݹ����
        if ((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        //���ҵݹ����
        if ((index * 2 + 2) < arr.length){
            preOrder(2*index+2);
        }
    }

    //��ɶ��������������
    /**
     * ������±�
     * @param index
     */
    public void middleOrder(int index){
        //�������Ϊ�� ����arr.length  = 0
        if (arr == null || arr.length == 0){
            println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }
        //����ݹ����
        if ((index * 2 + 1) < arr.length){
            middleOrder(2 * index + 1);
        }
        //�����ǰԪ��
        println(arr[index]);
        //���ҵݹ����
        if ((index * 2 + 2) < arr.length){
            middleOrder(2*index+2);
        }
    }
    //��ɶ������ĺ������
    /**
     * ������±�
     * @param index
     */
    public void postOrder(int index){
        //�������Ϊ�� ����arr.length  = 0
        if (arr == null || arr.length == 0){
            println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }
        //����ݹ����
        if ((index * 2 + 1) < arr.length){
            postOrder(2 * index + 1);
        }
        //���ҵݹ����
        if ((index * 2 + 2) < arr.length){
            postOrder(2*index+2);
        }
        //�����ǰԪ��
        println(arr[index]);
    }

}

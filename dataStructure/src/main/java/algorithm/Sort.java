package algorithm;

import java.util.Arrays;

/*** 八大排序算法
 * @author: xianchao.hua
 * @create: 2019-11-02 12:42
 **/
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 4, 2, 6};
        //测试冒泡排序
        /*bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/
        //测试堆排序
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //冒泡排序
    public static void bubbleSort(int[] arr) {
        //一共比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            //该轮次抽取的数需要与多少个数比较
            for (int k = 0; k < arr.length - 1 - i; k++) {
                if (arr[k] > arr[k + 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
    }


    //堆排序
    public static void heapSort(int[] arr) {
        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
        int startIndex = (arr.length - 1) / 2;
        //调整整个数组为大顶堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        //先把数组的第0个元素和最后一个元素交换位置 在把除最后一个元素外(此时已为最大值)调整为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            arr[0] = arr[0] ^ arr[i];
            arr[i] = arr[0] ^ arr[i];
            arr[0] = arr[0] ^ arr[i];
            for (int k = (i - 1) / 2; k >= 0; k--) {
                maxHeap(arr, i, k);
            }
        }
    }

    /**
     * 大顶堆排序 arr为要排序的数组,size为要排序的元素个数,index为要排序的子树的根节点
     */
    public static void maxHeap(int[] arr, int size, int index) {

        int leftParentNode = 2 * index + 1;
        int rightParentNode = leftParentNode + 1;

        //默认index坐标为最大值
        int max = index;
        //和左节点比较，max取最大值所在数组下标
        if (leftParentNode < size && arr[leftParentNode] > arr[max]) {
            max = leftParentNode;
        }
        //和右节点比较，max取最大值所在数组下标
        if (rightParentNode < size && arr[rightParentNode] > arr[max]) {
            max = rightParentNode;
        }
        //max取到最大值所在数组下标后,与index比较,使index位置值为最大
        if (max != index) {
            //此处使用抑或 ^ 不借助第三变量使两个变量互换位置
            arr[index] = arr[index] ^ arr[max];
            arr[max] = arr[index] ^ arr[max];
            arr[index] = arr[index] ^ arr[max];
            //交换位置以后，可能会破坏之前排好的堆，之前排好的堆需要重新调整,迭代本方法
            maxHeap(arr, size, max);
        }
    }
}

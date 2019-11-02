package dataStructure;

import java.util.Arrays;

/*** 自定义顺序存储线性表，使用数组实现
 * @author: xianchao.hua
 * @create: 2019-10-20 20:44
 **/
public class MyArrayList<E> {

    /**
     * 创建数组，用来存储数据，暂时定义为int类型
     */
    private Object[] elements = new Object[0];

    //添加元素
    public void add(E element) {
        //新建数组，长度为原数组长度+1
        Object[] newArr = new Object[elements.length + 1];
        //将原数组所有元素copy到新数组
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        //将要添加的元素存储进新数组的最后一个位置
        newArr[newArr.length - 1] = element;
        //将新数组赋值给原数组
        elements = newArr;
    }

    public void delete(int index) {
        //新建数组,长度为原数组长度-1
        Object[] newArr = new Object[elements.length - 1];

        for (int i = 0; i < newArr.length; i++) {
            //将原数组下标小于index的元素copy到新数组
            if (i < index) {
                newArr[i] = elements[i];
            }
            //将原数组下标大于index的元素copy到新数组
            else {
                newArr[i] = elements[i + 1];
            }
        }
        //将新数组赋值给原数组
        elements = newArr;
    }

    //打印链表中所有元素信息
    public void print() {
        System.out.println(Arrays.toString(elements));
    }

    //查找指定下标的元素
    public E get(int index) {
        return (E) elements[index];
    }

    //获取链表大小,即元素个数
    public int getSize() {
        return elements.length;
    }

    //链表是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }

    //判断链表是否包含某元素
    public boolean contain(Object obj) {
        return indexOf(obj) >= 0;
    }

    //返回某元素在链表中的序号
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println(myArrayList.get(0));//1
        System.out.println(myArrayList.indexOf(4));//1
        System.out.println(myArrayList.contain(5));//true
        myArrayList.delete(2);
        myArrayList.print();
    }
}

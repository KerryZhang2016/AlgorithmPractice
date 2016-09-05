package practice;

/**
 * 手写泛型栈（单链表方式）
 *
 * 相比于数组的实现方式，单链表结构的栈没有栈的容量。
 * 数组是一片连续的内存，所以读写的时间效率比较高，链表没有闲置的内存，所以空间效率比较高。
 *
 * Created by kerry on 16/8/11.
 */
public class Stack2<E extends Object> {

    /**
     * 实现单链表的内部类
     * */
    private final class Node {
        private Node pre;
        private E data;
    }

    private Node top;// 栈顶
    private int size;// 栈的长度

    public Stack2() {
        this.top = null;
        this.size = 0;
    }

    /**
     * 判断栈是否为空
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空栈
     * */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * 返回栈的长度
     * */
    public int size() {
        return size;
    }

    /**
     * 入栈
     * */
    public boolean push(E data) {
        Node node = new Node();
        node.data = data;
        node.pre = top;

        // 改变指针的位置
        top = node;
        size ++;
        return true;
    }

    /**
     * 出栈
     * */
    public E pop() throws Exception {
        if(top == null) {
            throw new Exception("栈为空");
        }

        Node node = top;

        // 改变指针位置
        top = top.pre;
        size --;
        return node.data;
    }

    /**
     * 出栈(不删除顶点)
     * */
    public E peek() throws Exception {
        if(top == null) {
            throw new Exception("栈为空");
        }

        Node node = top;
        return node.data;
    }

}

package practice;

/**
 * 手写一个泛型栈（还可以使用单链表来实现栈的结构）
 *
 * Created by Kerry on 16/8/11.
 */
public class Stack<E extends Object> {

    E[] datas;
    int maxSize;
    int top;// 栈顶的位置

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.datas = (E[])new Object[maxSize];
        this.top = -1;
    }

    public Stack() {
        this(64);
    }

    /**
     * 获取栈的长度
     * */
    public int size() {
        return top + 1;
    }

    /**
     * 判断栈是否为空
     * */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断栈是否满
     * */
    public boolean isFull() {
        return top + 1 == maxSize;
    }

    /**
     * 清空栈
     * */
    public void clear() {
        for (int i = 0; i < size(); i++) {
            datas[i] = null;
        }
        top = -1;
    }

    /**
     * 压栈
     * */
    public boolean push(E data) {
        if(isFull()) {
            System.out.println("堆栈已满");
            return false;
        }

        this.datas[++top] = data;
        return true;
    }

    /**
     * 出栈
     * */
    public E pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("栈已空！");
        }
        return this.datas[top--];
    }

    /**
     * 出栈(不删除顶点)
     * */
    public E peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("栈已空！");
        }
        return this.datas[top];
    }

    public static void main(String[] args) throws Exception{
        Stack<String> stack = new Stack<String>(1000);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("1");
        stack.push("8");
        stack.push("9");
        stack.push("2");
        stack.push("5");

        System.out.println(stack.size() + "@" + stack.pop());
    }



}

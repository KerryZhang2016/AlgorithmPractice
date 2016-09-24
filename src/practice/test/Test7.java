package practice.test;

/**
 * Created by admin on 16/9/22.
 */
public class Test7 {

    public static void main(String[] args) {
        new B();
    }

    static class A {

        private int value = 100;

        A() {
            System.out.println("construct A :" + value);
            getValue();
        }

        protected void getValue() {
            System.out.println("getValue A :" + value);
        }
    }

    static class B extends A {

        private int value = 200;

        B() {
            System.out.println("construct B :" + value);
            getValue();
        }

        protected void getValue() {
            System.out.println("getValue B :" + value);
        }
    }


}

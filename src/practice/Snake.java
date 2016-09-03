package practice;

/**
 * 蛇形算法
 *
 * Created by admin on 16/9/3.
 */
public class Snake {

    public void snake(int n) {
        int[][] array = new int[n][n];

        Node next = new Node();
        next.setType(0);
        next.setX(0);
        next.setY(0);
        int current = 1;

        while (next != null) {
            array[next.getX()][next.getY()] = current;

            current = nextValue(current, n);
            next = nextNode(array, n, next);
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
        }
    }

    private Node nextNode(int[][] array, int n, Node node) {
        int endX = n / 2;
        int endY;
        if(n % 2 == 0) {
            // 偶数
            endY = endX - 1;
        } else {
            // 奇数
            endY = endX;
        }
        if(node.getX() == endX && node.getY() == endY) {
            return null;// 结束
        }

        switch (node.getType()) {
            case 0:
                // 横向正方向
                Node next1 = new Node();
                next1.setType(0);
                next1.setX(node.getX());
                next1.setY(node.getY() + 1);

                if(needSwitch(array, n, next1)) {
                    // 需要转向
                    next1.setType(2);
                    next1.setX(node.getX() + 1);
                    next1.setY(node.getY());
                }
                return next1;
            case 1:
                // 横向反方向
                Node next2 = new Node();
                next2.setType(1);
                next2.setX(node.getX());
                next2.setY(node.getY() - 1);

                if(needSwitch(array, n, next2)) {
                    // 需要转向
                    next2.setType(3);
                    next2.setX(node.getX() - 1);
                    next2.setY(node.getY());
                }
                return next2;
            case 2:
                // 竖向正方向
                Node next3 = new Node();
                next3.setType(2);
                next3.setX(node.getX() + 1);
                next3.setY(node.getY());

                if(needSwitch(array, n, next3)) {
                    // 需要转向
                    next3.setType(1);
                    next3.setX(node.getX());
                    next3.setY(node.getY() - 1);
                }
                return next3;
            case 3:
                // 竖向反方向
                Node next4 = new Node();
                next4.setType(3);
                next4.setX(node.getX() - 1);
                next4.setY(node.getY());

                if(needSwitch(array, n, next4)) {
                    // 需要转向
                    next4.setType(0);
                    next4.setX(node.getX());
                    next4.setY(node.getY() + 1);
                }
                return next4;
        }
        return null;
    }

    private int nextValue(int current, int n) {
        if(current == n) {
          return 1;
        } else {
            return current + 1;
        }
    }

    private boolean needSwitch(int[][] array, int n, Node node) {
        if(node.getX() < 0 || node.getY() < 0 || node.getX() >= n || node.getY() >= n) {
            // 超出边界
            return true;
        } else if(array[node.getX()][node.getY()] != 0) {
            // 已赋值
            return true;
        } else {
            return false;
        }
    }

    private class Node {
        int type;// 当前行驶类型，0为横向正方向；1为横向反方向；2为竖向正方向，3为竖向反方向
        int x;
        int y;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}

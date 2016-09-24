package practice;

/**
 * 三角函数计算
 *
 * 已知sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
 * 写一个sin函数，只计算前10项,且已知Pi
 *
 * Created by admin on 16/9/21.
 */
public class TrigonometricFunction {

    private static float pi = 3.141592658f;

    // 刚开始看到题目是懵的，因为完全不知道这道题的考点是什么，然后就开始写，把每一项分开累加，分子、分母、符号分开进行计算。

    /**
     * 求前十项的泰勒公式展开
     * */
    private static float sin(float x) {
        int sign = 1;// 符号
        float item = x, frac = 0, fz = x, fm = 1;
        for (int i = 1; i <= 19; i+=2) {
            frac += item;// 累加每一项
            fz = fz * x * x;// 分子
            fm = fm * (i + 1) * (i + 2);// 分母
            sign = - sign;// 符号
            item = sign * (fz / fm);
        }
        return frac;
    }

    /** 到了这一步，差不多完成一半，至少你的写基本代码的能力得到了检验。最后，面试官会问你有没有什么问题和优化的地方，
     * 主要的问题在于float的越界问题，最后会处理到x^19这个的数量级别。
     *
     * 还是没有什么思路，最后面试官给了几点，说都是细节的优化：
     * （1）sin是周期函数，x的范围在0~2Pi循环，这样输入x的时候进行一下判断， 就可以避免x的值太大，导致越界问题和效率问题。
     * （2）分子需要计算fz * x * x,如果把x * x单独拿出来，先计算一个变量，就会减少一步的乘法运算。
     * （3）fm也有可能越界，但是fz/fm就比较小，能否每次保存fz/fm，然后下一步用之前保存的fz/fm * (x * x / (i + 1) / (i + 2)).
     * */
}

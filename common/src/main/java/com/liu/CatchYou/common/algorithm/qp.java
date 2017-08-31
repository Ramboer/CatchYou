package com.liu.CatchYou.common.algorithm;

/**
 * Created by simon.liu on 2017/8/24.
 */
public class qp {
    public void qs(int[] source, int start, int end) {
        if (end < start) {
            return;
        }
        int left = start;
        int right = end;
        int flag = source[left];
        while (start < end) {
            while (source[end] > flag && start < end) {
                end--;
            }
            source[start] = source[end];
            while (source[start] <= flag && start < end) {
                start++;
            }
            source[end] = source[start];
        }
        source[start] = flag;
        qs(source, left, end - 1);
        qs(source, end + 1, right);
    }

    public static void main(String[] args) {
        qp qp1 = new qp();
        int ss[] = new int[] {1,2,99,31,28,21,6,5,4,0,3,42,1,22,31};
        qp1.qs(ss,0, ss.length - 1);
        for (int i = 0; i < ss.length; i++) {
            System.out.print( ss[i] + " ");
        }
    }
}

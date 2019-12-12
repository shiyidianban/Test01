package com.example.demo.test01.offer;

import java.util.Arrays;

/**
 * @author wu161 2018年8月26日下午7:53:41
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 思路：先找到右子树的开始位置，然后分别进行左右子树递归处理。
 */
public class T24 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int rstart = 0;
        int length = sequence.length;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] < sequence[length - 1])
                rstart++;
        }
        if (rstart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            for (int i = rstart; i < length - 1; i++) {
                if (sequence[i] <= sequence[length - 1]) {
                    return false;
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rstart));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, rstart, length - 1));
        }
        return true;
    }
}

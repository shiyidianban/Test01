## 动态规划问题
#### 1. 经典的数字三角形问题(简单易懂, 经典动态规划);
>           7         
>           3 8
>          8 1 0
>         2 7 4 4
> 在数字三角形中寻找一个从顶部到底部数值最大的路径。每一步只能向左下或向右下执行

class 位置 [com.example.demo.test02.Suanfa.DynamicTest01.java](DynamicTest01.java)

#### 2. 最长的公共子串
>给定两个序列 X 和 Y，如果 Z 即是 X 的子串，又是 Y 的子串，我们就称它是 X 和 Y 的公共子串，注意子串是连续的。  
>例如 X = { A, B, C, D, E, F, G }，Y = { A, B, Z, D, E, F, K, G }，那么它们最长的公共子串即 { D, E, F }  

class 位置 [com.example.demo.test02.Suanfa.DynamicTest02.java](DynamicTest02.java)

#### 3. 编辑距离，又称Levenshtein距离
>编辑距离，又称Levenshtein距离（也叫做Edit Distance），是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。  
例如将kitten一字转成sitting：  
　　sitten （k->s）  
　　sittin （e->i）  
　　sitting （->g）   
所以kitten和sitting的编辑距离是3。俄罗斯科学家Vladimir Levenshtein在1965年提出这个概念。
给出两个字符串a,b，求a和b的编辑距离。  

class 位置 [com.example.demo.test02.Suanfa.DynamicTest03.java](DynamicTest03.java)

#### 4. 获得最大价值
>一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。  
例如：3 * 3的方格。  
　　1 3 3  
　　2 1 3  
　　2 2 1  
获取最大价值，也就是最大路径

class 位置 [com.example.demo.test02.Suanfa.DynamicTest04.java](DynamicTest04.java)

#### 5. 背包问题
>在N件物品取出若干件放在容量为W的背包里，每件物品的体积为W1，W2……Wn（Wi为整数），与之相对应的价值为P1,P2……Pn（Pi为整数）。  
求背包能够容纳的最大价值。

class 位置 [com.example.demo.test02.Suanfa.DynamicTest05.java](DynamicTest05.java)

#### 6. 最长递增子序列
>给出长度为N的数组，找出这个数组的最长递增子序列。  
(递增子序列是指，子序列的元素是递增的）  
例如：5 1 6 8 2 4 5 10，最长递增子序列是1 2 4 5 10。

class 位置 [com.example.demo.test02.Suanfa.DynamicTest06.java](DynamicTest06.java)

#### 7. 最大子段和
>N个整数组成的序列a[1],a[2],a[3],…,a[n]，求该序列如a[i]+a[i+1]+…+a[j]的连续子段和的最大值。  
当所给的整数均为负数时和为0。   
例如：-2,11,-4,13,-5,-2，和最大的子段为：11,-4,13。和为20。

class 位置 [com.example.demo.test02.Suanfa.DynamicTest07.java](DynamicTest07.java)

#### 8. 最长公共子序列Lcs
>给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。  
比如两个串为：  
　　abcicba  
　　abdkscab  
ab是两个串的子序列，abc也是，abca也是，其中abca是这两个字符串最长的子序列。

class 位置 [com.example.demo.test02.Suanfa.DynamicTest08.java](DynamicTest08.java)

#### 9. 正整数分组
>将一堆正整数分为2组，要求2组的和相差最小。    
例如：1 2 3 4 5，将1 2 4分为1组，3 5分为1组，两组和相差1，是所有方案中相差最少的。

class 位置 [com.example.demo.test02.Suanfa.DynamicTest09.java](DynamicTest09.java)


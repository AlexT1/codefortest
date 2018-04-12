package com.alexstudy.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName MyArray
 * @Description TODO()
 * @date 2018/4/11 15:00:13
 */
//《Java程序员面试笔试宝典》
public class MyArray {
    /**
     * 寻找数组中的最小值与最大值
     * 有2种方法：
     * 1.取单元素法：维持两个变量min和max，min标记最小值，max标记最大值，每次取出一个元素，
     * 先与已找到的最小值比较，再与已找到的最大值比较。此种方法只需要遍历一次数组即可。
     * 2.取双元素法：维持两个变量min和max，min标记最小值，max标记最大值，
     * 每次比较相邻两个数，较大者与max比较，较小者与min比较，通过比较找出最大值和最小值。此种方法的比较次数为1.5N次。
     */
    //取单元素法
    public void GetMinAndMax(int [] array){
        if(array==null || array.length<1){
            return ;
        }
        int min=array[0];
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]<min){//与最小值比较
                min=array[i];
            }
            if(array[i]>max){//与最大值比较
                max=array[i];
            }
        }
        System.out.println("数组的最小值为："+min);
        System.out.println("数组的最大值为："+max);
    }

    /**
     * 找出数组中的第二大的数
     * 思路：先定义两个变量：一个变量用来存储数组的最大值，初始值为数组首元素；另一个变量用来存储数组元素的第二大数，初始值为最小负整数。
     * 遍历数组元素，如果数组元素的值比最大数变量的值大，则将第二大变量的值更新为最大数变量的值，最大数变量的值更新为该数组元素的值；
     * 如果数组元素的值比最大数的值小，则判断该数组元素的值是否比第二大数的值大，若大则更新第二大数的值为该数组元素的值，否者不更新。
     */
    public int findSecMax(int [] array){
        if(array==null || array.length<2){
            throw new RuntimeException("数组元素个数小于2，无第二大的数");
        }
        int max1=array[0];//存储第一大数
        int max2=Integer.MIN_VALUE;//存储第二大数
        for(int i=1;i<array.length;i++){
            if(array[i]>max1){
                max2=max1;
                max1=array[i];
            }else{
                if(array[i]>max2){
                    max2=array[i];
                }
            }
        }
        return max2;
    }

    /**
     * 求最大子数组之和
     * 问题描述：一个有n个元素的数组，这n个元素可以是正数也可以是负数，数组中连续的一个或多个元素可以组成一个连续的字数组，
     * 一个数组可能有多个连续的子数组，求子数组和的最大值。
     * 1.“暴力法”。
     * 2.重复利用已经计算的子数组和。
     * 3.动态规划方法。
     * 4.优化的动态规划方法。
     */
    //1.“暴力法”:找出所有子数组，然后求出子数组的和，在所有子数组的和中取最大值
    public int maxSubArray1(int [] array){
        int len=array.length;
        int sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=array[k];
                }
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }
    //2.重复利用已经计算的子数组和:
    public int maxSubArray2(int [] array){
        int len=array.length;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            sum=0;
            for(int j=i;j<len;j++){
                sum+=sum;
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }
    //3.动态规划：
    //思路：首先可以根据数组的最后一个元素array[n-1]与最大子数组的关系分为以下3种情况：
    //①：最大子数组包含array[n-1],即以array[n-1]结尾；
    //②：array[n-1]单独构成最大子数组
    //③：最大子数组不包含array[n-1]，那么求array[1,...,n-1]的最大子数组可以转换为求array[1,...,n-1]的最大子数组
    public int maxSubArray3(int [] array){
        int n=array.length;
        int [] End=new int [n];
        int [] All=new int [n];
        End[n-1]=All[n-1]=array[n-1];
        End[0]=All[0]=array[0];
        for(int i=1;i<n;i++){
            End[i]=Math.max(End[i-1]+array[i], array[i]);
            All[i]=Math.max(End[i], All[i-1]);
        }
        return All[n-1];
    }
    //4.优化的动态规划方法
    //方法3每次只用到End[i-1]与All[i-1],而不是整个数组中的值，因此可以定义两个变量来保存End[i-1]与All[i-1]的值，并反复利用。
    public int maxSubArray4(int [] array){
        int n=array.length;
        int nAll=array[0];//有n个数字数组的最大子数组和
        int nEnd=array[0];//有n个数字数组包含最后一个元素的子数组的最大和
        for(int i=1;i<n;i++){
            nEnd=Math.max(nEnd+array[i], array[i]);
            nAll=Math.max(nEnd, nAll);
        }
        return nAll;
    }
    //另一种比较简单的动态规划
    public int maxSubArray(int [] array){
        int n=array.length;
        int [] dp=new int [n];//dp[i]表示以数组中第i(i从0开始)个元素结尾的子数组的最大值
        dp[0]=array[0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+array[i], array[i]);
            max=Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 找出数组中重复次数最多的数
     * 方法1：空间换时间。可以定义一个数组int count[MAX]，并将其数组元素都初始化为0，然后执行for(int i=0;i<n;i++) count[A[i]]++;操作，
     * 在count数组中找最大的数，即为重复次数最多的数。这是一种典型的空间换时间的算法。一般情况下，除非内存空间足够大，一般不采用这种方法。
     * 方法2：使用Map映射表。通过引入Map映射表，来记录每一个元素出现的次数，然后用判断次数大小，进而找出重复次数最多的元素。
     *
     * 这里给出方法2的代码实现
     */
    public int findMostFrequentInArray(int [] array){
        if(array==null || array.length<1){
            return Integer.MAX_VALUE;
        }
        int result=0;
        int len=array.length;
        Map<Integer,Integer> map=new HashMap<>();
        //记录每个元素出现的次数
        for(int i=0;i<len;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }else{
                map.put(array[i], 1);
            }
        }
        //找出出现次数最多的数
        int most=0;
        Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry=it.next();
            int key=entry.getKey();
            int val=entry.getValue();
            if(val>most){
                result=key;
                most=val;
            }
        }

        return result;
    }

    /**
     * 求数组中两两相加等于20的组合总数
     * 方法1：暴力法,时间复杂度为O(n2)
     * 方法2：排序法：先对数组进行排序，可选用对排序或快速排序，此时算法复杂度为O(nlogn),然后对排序后的数组分别从前到后和从后到前遍历。
     * 假设从前到后遍历的下标为begin,从后到前遍历的下标为end，那么当满足array[begin]+array[end]<20时，如果存在两个数的和为20，那么这两个数一定在[begin+1,end]之间；
     * 当满足array[begin]+array[end]>20时，如果存在两个数的和为20，那么这两个数一定在[begin,end-1]之间，这个过程的时间复杂度为O(n)。
     * 因此整个算法的空间复杂度为o(nlogn)。
     *
     * 这里给出方法2的代码实现
     */
    public void findSum(int [] array,int sum){
        Arrays.sort(array);//对数组进行排序
        int begin=0;
        int end=array.length-1;
        while(begin<end){
            if(array[begin]+array[end]<sum){
                begin++;
            }else if(array[begin]+array[end]>sum){
                end--;
            }else{
                System.out.println(array[begin]+","+array[end]);
                begin++;
                end--;
            }
        }
    }

    /**
     * 如何把一个数组循环右移k位
     * 思路：假设要把数组序列12345678右移2位变成78123456，比较移位前后数组序列的形式，不难看出，其中有两段序列的顺序是不变的，即78和123456,
     * 这样可以把这两段看作两个整体，右移k位就是把数组的两部分交换一下。
     * 步骤：
     * 1.逆序数组子序列123456，数组序列的形式变为65432178；
     * 2.逆序数组子序列78，数组序列的形式变为65432187；
     * 3.全部逆序，数组序列的形式变为78123456。
     */
    public void shift_k(int [] array,int k){
        int n=array.length;
        k=k%n;//为了防止k比n大，右移k位跟右移k%n位的结果相同
        reverse(array,0,n-k-1);
        reverse(array,n-k,n-1);
        reverse(array,0,n-1);
    }
    public void reverse(int [] array,int begin,int end){
        for(;begin<end;begin++,end--){
            int temp=array[begin];
            array[begin]=array[end];
            array[end]=temp;
        }
    }

    /**
     * 找出数组中第k个最小的数
     * 方法1：排序法。对数组进行排序，排序后的数组中第k-1个位置上的数字即为数组的第k个最小的数。
     * 方法2：“剪枝”法。选一个数temp=array[n-1]作为枢纽，把比它小的数都放在它的左边，比它大的数都放在它的右边，然后判断temp的位置，
     * 如果它的位置为k-1，那么它就是第k个最小的数；如果它的位置小于k-1，那么说明第k个小的元素一定在数组的右半部分，采用递归的方法在数组的右半部分继续查找；
     * 如果它的位置大于k-1，那么说明第k个小的元素一定在数组的左半部分，采用递归的方法在数组的左半部分继续查找；
     *
     * 这里给出方法2的代码实现
     */
    public int getKmin(int [] array,int k){
        if(array==null || array.length<k){
            return Integer.MIN_VALUE;
        }
        return quickSort(array,0,array.length-1,k);
    }
    public int quickSort(int [] array,int low,int high,int k){
        int left=low,right=high;
        int temp=array[low];
        while(left<right){
            while(left<right && array[right]>=temp){
                right--;
            }
            if(left<right){
                array[left]=array[right];
            }
            while(left<right && array[left]<=temp){
                left++;
            }
            if(left<right){
                array[right]=array[left];
            }
        }
        array[left]=temp;
        if(left+1==k){
            return array[left];
        }else if(left+1>k){
            return quickSort(array,low,left-1,k);
        }else{
            return quickSort(array,left+1,high,k);
        }

    }
    /**
     * 如何找出数组中只出现一次的数字
     * 问题描述：一个整型数组里除了一个数字之外，其他数字都出现了两次，找出这个只出现一次的数字。要求空间复杂度为O(n)，时间复杂度为O(1)。
     * 思路：题目中强调只有一个数字出现一次，其他数字出现两次，首先想到的是异或运算，根据异或运算的定义可知，任何一个数字异或它自己都等于0，
     * 所以，如果从头到尾一次异或数组中的每一个数字，那些出现两次的数字全部在异或中会被抵消，最终结果刚好是这个只出现一次的数字。
     */
    public int findOnce1(int [] array){
        int result=array[0];
        for(int i=1;i<array.length;i++){
            result^=array[i];
        }
        return result;
    }
    /**
     * 上述异或运算的方法只适用于其他数字出现的次数为偶数的情况，如果其他数字出现的次数为奇数，上述介绍的方法则不再使用。
     *
     * 如果数组中的所有书都出现n次，那么这个数组中的所有数对应的二进制数中，各个位上的1出现的个数均可以被n整除。
     */
    public int findOnce2(int [] array,int appearTimes){
        int n=array.length;
        int [] bitCount=new int[32];
        //计算数组中所有数组对应的二进制数各个位置上出现1的次数
        for(int i=0;i<n;i++){
            for(int j=0;j<32;j++){
                bitCount[j]+=((array[i]>>j)&1);
            }
        }
        //若某位上的结果不能被整除，则肯定目标数字在这一位上
        int appearOnce=0;
        for(int i=0;i<32;i++){
            if(bitCount[i]%appearTimes!=0){
                appearOnce+=(1<<i);
            }
        }
        return appearOnce;
    }

    /**
     * 找出数组中唯一出现一次的数字
     * 题目描述：数组a[N],1~N-1这n-1个数存在a[N]中，其中某个数重复1次。写一个函数，找出重复的数字。要求每个数组元素只能访问一次，并且不用辅助空间。
     * 思路：由于题目要求每个数组元素只能访问一次，且不用辅助空间，因此可以从原理上入手，采用数学求和法，因为只有一个数字重复1次，且又是连续的，根据累加原理，
     * 对数组所有项求和，然后减去1~N-1的和，即为所求的重复数。
     *
     * 如果没有“每个数组元素只能访问一次”这个约束条件，则可以使用“异或法”；
     * 如果没有“不用辅助空间”辅助空间这个约束条件，则可以使用“空间换时间”方法
     */
    public int findDup1(int [] array){
        int temp1=0;
        int temp2=0;
        for(int i=0;i<array.length-1;i++){
            temp1+=i+1;
            temp2+=array[i];
        }
        temp2+=array[array.length-1];
        int result=temp2-temp1;
        return result;
    }
    /**
     * 上题可以进行一个变形：取值为[1,n-1]含n个元素的正数数组，至少存在一个重复数，即可能存在多个重复数，O(n)时间内找出其中一个重复数。
     * 思路：取反法：如果遍历到数组中的元素为i，那么把a[i]的值取反，如果i出现两次，那么a[i]会经过两次取反操作，a[i]的值跟原始的值相等，且为整数；如果i出现1次，
     * 那么a[i]的值为原始值的相反数，且为负数。
     * 实现方法如下：将数组元素值作为索引，对于元素array[i],如果array[array[i]]的值大于0，那么设置array[array[i]]=-array[array[i]];
     * 如果array[array[i]]的值小于0，那么设置array[array[i]]=-array[-array[i]];
     * 最后从数组第二个元素开始遍历数组，如果array[i]>0,那么这个就是重复的。
     * 由于在进行遍历过程中对数值中的数据进行了修改，因此需要对数据进行还原。
     */
    public void findDup2(int [] array){
        int n=array.length;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(array[i]>0){
                array[array[i]]=-array[array[i]];
            }else{
                array[-array[i]]=-array[-array[i]];
            }
        }

        for(int i=1;i<n;i++){
            if(array[i]>0){
                result=i;
            }else{
                array[i]=-array[i];
            }
            System.out.println(result);
        }
    }

    /**
     * 求数对之差的最大值
     * 问题描述：数组中的一个数字减去它右边子数组中的一个数字可以得到一个差值，求所有可能的插值中的最大值。
     * 方法1：“暴力法”。首先遍历数组，找到所有可能的差值，然后从所有差值中找出最大值。
     * 方法2：动态规划。给定数组array,申请额外的数组diff和max，其中dff[i]是以数组中第i个数字为减数的所有数对之差的最大值(前i+1个数组成的子数组中最大差值)，
     * max[i]为前i+1个数的最大值。假设已经求得了diff[i]，diff[i+1]的值有两种可能：①等于diff[i]；②等于max[i-1]-array[i]。则动态规划的状态转移方程为diff[i+1]=max(diff[i],max[i-1]-array[i]),
     * max[i+1]=max(max[i],a[i+1])。数组最大插值为diff[n-1]（n为数组长度）
     */
    public int getMax(int [] array){
        if(array==null || array.length<=1){
            return Integer.MIN_VALUE;
        }
        int n=array.length;
        int [] diff=new int[n];
        int [] max=new int [n];
        diff[0]=Integer.MIN_VALUE;
        max[0]=array[0];
        for(int i=1;i<n;i++){
            diff[i]=Math.max(diff[i-1], max[i-1]-array[i]);
            max[i]=Math.max(max[i-1], array[i]);
        }
        return diff[n-1];
    }

    /**
     * 求绝对值最小的数
     * 有一个升序排列的数组，数组中可能有正数，负数，0，求数组中元素的绝对值最小的数。
     * 思路：求绝对值最小的数可以分为3种情况：①如果数组第一个元素为非负数，那么绝对值最小的数肯定为数组第一个元素；
     * ②如果数组最后一个元素为负数，那么绝对值最小的数可定是数组的最后一个数；
     * ③数组中既有正数又有负数，首先找到正数与负数的分界点，如果分界点恰好为0，那么0是绝对值最小的数，否者通过比较分界点左右的正数与负数的绝对值来确定最小的数。
     * 可以通过二分法来查找正数与负数的分界点。
     */
    public int getMinAbsoluteValue(int [] array){
        if(array==null || array.length<1){
            return Integer.MIN_VALUE;
        }
        int len=array.length;
        //数组中没有负数
        if(array[0]>=0){
            return array[0];
        }
        //数组中没有正数
        if(array[len-1]<=0){
            return array[len-1];
        }
        int begin=0,end=len-1,mid=0;
        int absMin=0;
        //数组中既有正数又有负数
        while(true){
            mid=(begin+end)/2;
            //如果值等于0，那么就是绝对值最小的数
            if(array[mid]==0){
                return array[mid];
            }
            //如果值大于0，那么正负数的分界点在左半部分
            else if(array[mid]>0){
                //继续在数组左半部分查找
                if(array[mid-1]>0){
                    end=mid-1;
                }else if(array[mid-1]==0){
                    return 0;
                }
                //找到正负数分界点
                else{
                    break;
                }
            }
            //如果值小于0，那么正负数的分界点在右半部分
            else{
                //继续在数组右半部分查找
                if(array[mid+1]<0){
                    begin=mid+1;
                }else if(array[mid]==0){
                    return 0;
                }
                //找到正负数分界点
                else{
                    break;
                }
            }
        }
        //获取正负数分界点中绝对值最小的值
        if(array[mid]>0){
            if(array[mid]<Math.abs(array[mid-1])){
                absMin=array[mid];
            }else{
                absMin=array[mid-1];
            }
        }else{
            if(Math.abs(array[mid])<array[mid+1]){
                absMin=array[mid];
            }else{
                absMin=array[mid+1];
            }
        }
        return absMin;
    }

    /**
     * 求数组中两个元素的最小距离
     * 问题描述：给定一个数组，数组中含有重复元素，给出两个数n1和n2，求这两个数在数组中所出现位置的最小距离。
     * 思路：遍历数组，，会遇到以下两种情况：
     * 1.当遇到n1时，记录下n1值对应的数组下标的位置n1_index,通过求n1_index与上次遍历到n2的下标值n2_index的差，可以求出最近一次遍历到的n1与n2的距离。
     * 2.当遇到n2时，记录下n2值对应的数组下标的位置n2_index,通过求n2_index与上次遍历到n1的下标值n1_index的差，可以求出最近一次遍历到的n1与n2的距离。
     */
    public int minDistance(int [] array,int n1,int n2){
        if(array==null || array.length<=1){
            return Integer.MIN_VALUE;
        }
        int n1_index=-1;
        int n2_index=-1;
        int min_dist=Integer.MIN_VALUE+1;
        for(int i=0;i<array.length;i++){
            if(array[i]==n1){
                n1_index=i;
                if(n2_index>=0){
                    min_dist=Math.min(Math.abs(min_dist), Math.abs(n1_index-n2_index));
                }
            }
        }
        return min_dist;
    }

    /**
     * 如何判断一个数组中数值是否连续相邻
     * 问题描述：一个数组序列，元素取值可能是0~65536中的任一一个，相同数值不会重复出现。0是例外，可以反复出现。
     * 设计一个算法，当从该数组序列中任意选取5个数值，判断这5个数值是否连续相邻。需注意以下几点：
     * 1.5个数值允许是乱序的，例如{8,7,5,0,6}
     * 2.0可以通配任意数值，例如{8,7,5,0,6}中的0可以通配成9或4
     * 3.0可以多次出现
     * 4.全0算连续，只有一个非0算连续
     *
     * 思路：如果没有0的存在，要组成连续的数列，最大值和最小值的差必须为4，存在0的情况，只要最大值和最小值的差小于4就可以。
     * 所以，只要最大值和最小值的差小于等于4，数组就是连续的。
     *
     */
    public boolean isContinuous(int [] array){
        int n=array.length;
        int min=-1,max=-1;
        for(int i=0;i<n;i++){
            if(array[i]!=0){
                if(min>array[i] || -1==min){
                    min=array[i];
                }
                if(max<array[i] || -1==max){
                    max=array[i];
                }
            }
        }
        if(max-min>n-1){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 求解数组中反序对的个数
     * 问题描述：给定一个数组，如果array[i]>array[j] (i<j)，那么array[i]与array[j]被称为一个反序。
     * 方法1：“暴力法”
     * 方法2：分治归并法：在归并排序的基础上额外使用一个计数器来记录逆序对的个数
     *
     * 这里给出方法1的代码实现
     */
    public int reverseCount(int [] array){
        int count=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 求解最小三元组距离
     * 问题描述：已知3个升序正数数组a[1]、b[m]、c[n]。请在3个数组中各找一个元素，使得组成的三元组距离最小。三元组的距离定义是：假设a[i]、b[j]、c[k]是一个三元组，
     * 那么距离为distance=max(|a[i]-b[j]|,|a[i]-c[k]|,|b[j]-c[k}|)，请设计一个求最小三元组距离的稀有算法。
     * 方法1：“暴力法”
     * 方法2：最小距离法：假设当前遍历到这3个数组中的元素分别为a[i],b[j],c[k]，并且a[i]<=b[j]<=c[k]，此时它们的距离肯定是d=c[k]-a[i]，那么分如下3种情况讨论：
     * ①如果接下来求a[i],b[j],c[k+1],那么由于c[k+1]>=c[k]，此时它们的距离必定为d'=c[k+1]-a[i]，显然d'>=d,因此d'不可能成为最小距离。
     * ②如果接下来求a[i],b[j+1],c[k],那么由于b[j+1]>=b[j]，如果b[j+1]<=c[k]，此时它们的距离仍然为d'=c[k]-a[i];如果b[j+1]>=c[k]，此时它们的距离仍然为d'=b[j+1]-a[i];显然d'>=d,因此d'不可能成为最小距离。
     * ③如果接下来求a[i+1],b[j],c[k],如果a[i+1]<|c[k]-a[i]|+c[k]，此时它们的距离为d'=c[k]-a[i+1]，显然d'<d,因此d'成为最小距离。
     *
     * 综上所述，在求最小距离时只需要考虑第三种情况。具体实现思路为：
     *从三个数组的第一个元素开始，先求出它们的距离minDist，接着找出这3个数中最小数对应的数组，只对这个数组的下标往后移动一位，接着求3个数组中当前元素的距离，如比minDist小，
     *则把当前距离赋值给minDist，以此类推，直到遍历完其中一个数组。
     */
    public int minDistance1(int [] a,int [] b,int [] c){
        int aLen=a.length;
        int bLen=b.length;
        int cLen=c.length;
        int minDist=Math.max(Math.abs(a[0]-b[0]), Math.abs(a[0]-c[0]));
        minDist=Math.max(minDist, Math.abs(b[0]-c[0]));
        int dist=0;
        for(int i=0;i<aLen;i++){
            for(int j=0;j<bLen;j++){
                for(int k=0;k<cLen;k++){
                    //求距离
                    dist=Math.max(Math.abs(a[i]-b[j]), Math.abs(a[i]-c[k]));
                    dist=Math.max(dist, Math.abs(b[j]-c[k]));
                    if(minDist>dist){
                        minDist=dist;
                    }
                }
            }
        }
        return minDist;
    }
    public int minDistance2(int [] a,int [] b,int [] c){
        int aLen=a.length;
        int bLen=b.length;
        int cLen=c.length;
        int curDist=0;
        int minDist=Integer.MAX_VALUE;
        int i=0;//数组a的下标
        int j=0;//数组b的下标
        int k=0;//数组c的下标
        int min=0;
        while(true){
            curDist=Math.max(Math.abs(a[i]-b[j]), Math.abs(a[i]-c[k]));
            curDist=Math.max(curDist, Math.abs(b[j]-c[k]));
            if(curDist<minDist){
                minDist=curDist;
            }
            //找出当前遍历到3个数组中的最小值
            min=Math.min(a[i], b[j]);
            min=Math.min(min, c[k]);
            if(min==a[i]){
                if(++i>=aLen){
                    break;
                }
            }else if(min==b[j]){
                if(++j>=bLen){
                    break;
                }
            }else{
                if(++k>=cLen){
                    break;
                }
            }
        }

        return minDist;
    }
}

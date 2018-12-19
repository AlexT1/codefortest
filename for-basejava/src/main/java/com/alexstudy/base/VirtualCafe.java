package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName VirtualCafe
 * @Description TODO()
 * @date 2018/9/20 17:04:47
 */
public class VirtualCafe {
    //Error:(10, 35) java: 非法前向引用
 //   private int chairsCount = 4 * tablesCount;
//    private int tablesCount = 20;
    private int chairsCount = initChairsCount();
    private int tablesCount = 20;
    private int initChairsCount() {
        return tablesCount * 4;
    }

    public static void main(String[] args) {
        VirtualCafe virtualCafe = new VirtualCafe();
        System.out.println(virtualCafe.chairsCount + "  tables: " + virtualCafe.tablesCount);
    }
}

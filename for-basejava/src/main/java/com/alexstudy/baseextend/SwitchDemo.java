package com.alexstudy.baseextend;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SwitchDemo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/4/11
 */
public class SwitchDemo {
    public void testSwithch(){
        int i = 2;
        switch (i){
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
        }
    }
    public static void main(String[] args) {
        System.out.println(Integer.parseInt(args[0])/Integer.parseUnsignedInt(args[1]));
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant((new Date()).toInstant(),zoneId);
        Calendar calendar = Calendar.getInstance();
        System.out.println("start :" + calendar.getTime());
        calendar.setTimeInMillis(1450000000000L);
        System.out.println("after :" + calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH,60);
        System.out.println("add :" + calendar.getTime());

        List<String> list = Arrays.asList("dog","over","good");
        System.out.println(list.stream().reduce("", (s1, s2) -> s1+=s2.charAt(0),(p, q)-> p+=q));
        System.out.println("heap size :" + Runtime.getRuntime().totalMemory());
        System.out.println("free memory :" + Runtime.getRuntime().freeMemory());
        System.out.println("run memory :" + Runtime.getRuntime().maxMemory());
        Double doubles = 206353d;
        Float floats = 2990f;
        Integer integers = new Integer(500);
        Long longs = 300L;
        Long lo = Long.MAX_VALUE;

        List<String> list2 = Arrays.asList("green","yellow","blue");
       System.out.println(list2.stream().max((s1,s2) -> s1.compareTo(s2)).filter(s-> s.endsWith("n")).orElse("yellow"));

    }
}

package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName TestForInner
 * @Description TODO()
 * @date 2018/9/20 14:51:40
 */
public class TestForInner {
        public String changeString(String inputString) {
            return "add " + inputString;
        }
        public static void main(String[] args) {
            TestForInner outer = new TestForInner();
            String s = "gz";
            Inner inner = outer.getInner("Inner", outer.changeString(s));
            System.out.println("return inner name : " + inner.getName());
            System.out.println("second change : " + outer.getInner("gz",s).getName());
        }

        public Inner getInner(String name, String city) {
            return new Inner(name, city) {
                private String nameStr = name + city;
                public String getName() {
                    return nameStr;
                }
            };
        }
    }

//注释后，编译时提示类Inner找不到
//interface Inner {
//    String getName();
//}

abstract class Inner {
    Inner(String name, String city) {
        System.out.println(city);
    }

    abstract String getName();
}
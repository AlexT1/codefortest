package com.alexstudy.base;

/**
 * @ClassName FilenameDemo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/18
 */
public class FilenameDemo {
    public static void main(String[] args) {
        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.');
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());

        String dot = FPATH.substring(0,FPATH.lastIndexOf(".")+1);
        System.out.println(dot.substring(0,dot.lastIndexOf(".")+1));
    }
}

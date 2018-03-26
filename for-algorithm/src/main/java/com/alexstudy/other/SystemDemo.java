package com.alexstudy.other;

/**
 * @author AlexTong
 * @ClassName SystemDemo
 * @Description TODO()
 * @date
 * 2018/3/26 14:55:53
 */
public class SystemDemo {

    public static void main(String[] args) throws Exception {

            // gets the value of the specified environment variable "PATH"
            System.out.println("System.getenv(PATH) = ");
            System.out.println(System.getenv("PATH"));

            // gets the value of the specified environment variable "TEMP"
            System.out.print("System.getenv(TEMP) = ");
            System.out.println(System.getenv("TEMP"));

            // gets the value of the specified environment variable "USERNAME"
            System.out.print("System.getenv(USERNAME) = ");
            System.out.println(System.getenv("USERNAME"));

        System.out.print("System.getenv(OUTPUT_PATH) = ");
        System.out.println(System.getenv("OUTPUT_PATH"));
        }
        /**
         * print result
         *System.getenv(PATH) =
         C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\lyj\JavaKit\apache-maven-3.2.5\bin;C:\Program Files\Git\cmd;C:\Program Files\MySQL\MySQL Utilities 1.6\;C:\Program Files\erl9.2\bin;C:\Program Files\Java\jdk1.8.0_152\bin;C:\Program Files\Java\jdk1.8.0_152\jre\bin;C:\Users\dixin\AppData\Local\Programs\Python\Python36\Scripts\;C:\Users\dixin\AppData\Local\Programs\Python\Python36\;C:\Users\dixin\AppData\Local\Microsoft\WindowsApps;C:\lyj\JavaKit\apache-maven-3.2.5\bin
         System.getenv(TEMP) = C:\Users\dixin\AppData\Local\Temp
         System.getenv(USERNAME) = dixin
         System.getenv(OUTPUT_PATH) = null
         * */
}

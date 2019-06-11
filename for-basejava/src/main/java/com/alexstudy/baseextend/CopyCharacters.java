package com.alexstudy.baseextend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName CopyCharacters
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/3/14
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        // buffered io stream
//        inputStream = new BufferedReader(new FileReader("xanadu.txt"));
//        outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

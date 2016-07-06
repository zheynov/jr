package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws DownloadException, IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String fileName  = reader.readLine();;
            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);

            if (count<1000) {

                reader.close();
                inputStream.close();

                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception{

    }
}

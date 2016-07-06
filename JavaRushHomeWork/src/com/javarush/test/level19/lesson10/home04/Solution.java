package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.*;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));

        while (true)
        {
            String s = reader.readLine();
            if (s==null) {break;}

            String[] alpha = s.split(" ");
            int count = 0;

            for (String word : alpha) {
                if (words.contains(word)) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(s);
            }
        }
        reader.close();
        br.close();
    }
}


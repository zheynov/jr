package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        args = new String[]{"F:/JAVA/111.txt"};

        ArrayList<Byte> list = new ArrayList<>();

        Map<Byte, Integer> map = new TreeMap<>();

        InputStream inStream = new FileInputStream(args[0]);

        while (inStream.available() > 0)
        {
            int symb = inStream.read();
            list.add((byte) symb);
        }

        for (Byte chr : list)
        {
            int count = Collections.frequency(list, chr);
            map.put(chr, count);
        }

       for (Map.Entry<Byte, Integer> mmm : map.entrySet())
            {
                System.out.println((char)mmm.getKey().intValue() + " " + mmm.getValue());
            }

        inStream.close();
    }
}



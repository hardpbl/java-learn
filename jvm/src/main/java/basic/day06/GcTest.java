package basic.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panbailiang
 * @Classname GcTest
 * @Date 2021/4/7 9:41 下午
 *
 * 打印GC日志
 *      -Xms9m -Xmx9m -XX:+PrintGCDetails
 *
 *      [PSYoungGen: 2001K->496K(2560K)]
 *      yongGC之后2001k->496k
 */
public class GcTest {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        String str = "hello world";
        try {
            while (true) {
                i++;
                str = str + str;
                list.add(str);
            }
        }finally {
            System.out.println("i = " + i);
        }
    }

}

package basic.day06;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname HeapInstanceDemo
 * @Date 2021/4/7 8:51 下午
 */
public class HeapInstanceDemo {

    public static void main(String[] args) throws InterruptedException {
        Byte[] buff = new Byte[new Random().nextInt(1024*200)];
        ArrayList<Object> objects = new ArrayList<>();
        while (true){
            objects.add(buff);
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}

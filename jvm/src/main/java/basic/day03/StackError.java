package basic.day03;

/**
 * @author panbailiang
 * @Classname StackError
 * @Date 2021/4/4 10:53 下午v
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class StackError {
    public static void main(String[] args) {
        main(args);
        return;
    }
}

package com.huhst.juc.ticket;

/**
 *
 * @author panbailiang
 * @Classname LambdaExpressDemo
 * @Date 2021/2/9 4:10 下午
 *
 * 有且仅有一个待实现方法，默认方法不算
 *
 * 口诀：
 *  拷贝小括号，写死右箭头，落地大括号
 *  Foo foo = () -> {System.out.println("****hello lambda express****");};
 *         foo.sayHello();
 *
 *  接口有且仅有一个方法的时候默认会加上一个@FunctionalInterface注解
 *  自动推断
 *
 *  默认方法
 *
 *
 *
 *
 *
 */
//interface Foo{
//    /**
//     * say
//     */
//    void sayHello();
//}
interface Foo{
    /**
     * say
     * @param x
     * @param y
     * @return
     */
    int sayHello(int x, int y);

    /**
     * div
     * @param x
     * @param y
     * @return
     */
    default int div(int x, int y){
        return x / y;
    }

    public static int mv(int x, int y){
        return x - y ;
    }
    public static int mv1(int x, int y){
        return x - y ;
    }

}
/**
 * @author panbailiang
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("****hello lambda express****");
//            }
//        };
//        foo.sayHello();
        Foo foo = (int x, int y)->{
            System.out.println("x + y = " + (x+y));
            return x+y;
        };
        foo.sayHello(3, 5);

    }
}

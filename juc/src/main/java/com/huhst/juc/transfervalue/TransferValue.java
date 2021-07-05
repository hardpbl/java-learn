package com.huhst.juc.transfervalue;

/**
 * @author panbailiang
 * @Classname TransferValue
 * @Date 2021/2/14 3:19 下午
 * <p>
 * 传值还是传引用
 * <p>
 * 方法的作用域
 * <p>
 * id :10
 * person.getName()XXX
 * str: xyz
 */
public class TransferValue {
    public void changeValue1(int id) {
        id = 30;
    }

    public void changeValue2(Person person) {
        person.setName("XXX");
    }

    public void changeValue3(String name) {
        name = "xxx";
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        int id = 10;
        transferValue.changeValue1(id);
        //传的是值，改的是副本，方法出栈，局部变量的消失
        System.out.println("id :" + id);

        Person person = new Person();
        person.setName("ABC");
        //传的是引用，地址
        transferValue.changeValue2(person);
        System.out.println("person.getName()" + person.getName());

        String str = "xyz";
        //字符串常量池 也就是方法区 有就复用，没有就新建一个
        transferValue.changeValue3(str);
        System.out.println("str: " + str);


        //输出ABCD
        String str1 = new String("ABCD");
        //字符串常量池 也就是方法区 有就复用，没有就新建一个
        transferValue.changeValue3(str1);
        System.out.println("str1: " + str1);
    }
}

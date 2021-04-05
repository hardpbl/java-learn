package com.huhst.transfer;

/**
 * @author panbailiang
 * @Classname TransFerDemo
 * @Date 2021/4/5 4:02 下午
 * 传值还是传址
 * 基本数据类型传的是值
 * 引用类型传的是地址
 *
 */
public class TransFerDemo {
    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(Person p){
        p.setName("XXX");
    }
    public void changeValue3(String str){
        str = "xxx";
    }
    public static void main(String[] args) {
        TransFerDemo transFerDemo = new TransFerDemo();
        int age = 20;
        //传的是值，方法出栈后内存被释放了
        transFerDemo.changeValue1(age);
        System.out.println("age：" + age);

        Person person = new Person(10,"只能告诉你");
        //引用对象传递的是地址
        transFerDemo.changeValue2(person);
        System.out.println("person.getName(): " + person.getName());

        String str = "abc";
        //
        transFerDemo.changeValue3(str);
        System.out.println("str:" + str);
    }
}
class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

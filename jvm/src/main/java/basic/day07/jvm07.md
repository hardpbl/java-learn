###方法区值的设置
![img.png](img.png)
![img_1.png](img_1.png)

MetaspaceSize调整会触发fullGC
如何解决OOM
![img_2.png](img_2.png)

方法区的结构
类定义的信息
![img_3.png](img_3.png)
![img_4.png](img_4.png)
方法区中的类型信息
![img_5.png](img_5.png)
####类型信息：实现了哪些接口，继承了哪些类，包，泛型
![img_8.png](img_8.png)
域信息
![img_9.png](img_9.png)
方法信息，记录方法的操作数深度，局部变量表长度，参数个数
![img_6.png](img_6.png)
![img_7.png](img_7.png)
static final xx的常量在编译的时候就已经赋值了
![img_10.png](img_10.png)

##运行时常量池和常量池
![img_11.png](img_11.png)
javap -v -p xxx.class
我们一个类可能会引入了太多的其他类，如果都放在一起的话文件会非常大，所以我们在
常量池里面维护符号引用
![img_12.png](img_12.png)

![img_13.png](img_13.png)
![img_14.png](img_14.png)

###运行时常量池
![img_15.png](img_15.png)
![img_16.png](img_16.png)
虚拟机栈，PC，方法区的关系
![img_17.png](img_17.png)


方法去演进细节
![img_20.png](img_20.png)

内存我们先分给虚拟机，相当于虚拟机它在自己的王国里面自己主宰自己分配
![img_21.png](img_21.png)
![img_22.png](img_22.png)
![img_23.png](img_23.png)

![img_24.png](img_24.png)
![img_25.png](img_25.png)

![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_28.png](img_28.png)
![img_29.png](img_29.png)

###对象实例化

![img_30.png](img_30.png)
![img_31.png](img_31.png)
####创建对象的方式
![img_32.png](img_32.png)

创建对象的六个步骤
![img_33.png](img_33.png)
![img_34.png](img_34.png)

####对象的内存布局
![img_35.png](img_35.png)
![img_36.png](img_36.png)

###对象访问定位
![img_37.png](img_37.png)
![img_38.png](img_38.png)
![img_39.png](img_39.png)

###直接内存
![img_40.png](img_40.png)
jdk8 metaspace基于直接内存实现
![img_41.png](img_41.png)
使用直接内存的例子
![img_43.png](img_43.png)
![img_44.png](img_44.png)
![img_45.png](img_45.png)
![img_47.png](img_47.png)

NIO->直接内存

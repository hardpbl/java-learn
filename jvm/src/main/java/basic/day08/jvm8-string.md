###String相关

####String的基本特性
![img_26.png](img_26.png)
jdk8是char类型数组，jdk9是byte[]数组
![img_27.png](img_27.png)
####String的不可变性
    底层数组，确定后长度就固定了，不可变性，有改变一定是重新去字符串常量池中创造
一个新的一个
StringTable的结构：hashTable 数组+链表
![img_28.png](img_28.png)
![img_29.png](img_29.png)
字符串常量池不会放重复的字符
![img_31.png](img_31.png)
字符串常量池的长度与性能正相关
![img_32.png](img_32.png)
![img_33.png](img_33.png)
####StringTable为什么要从栈移到堆空间
![img_34.png](img_34.png)
字符串操作不存在就会加入到常量池
![img_35.png](img_35.png)

####字符串的拼接操作
如果拼接的是常量会触发编译器优化，生成的结果位于字符串常量池
![img_36.png](img_36.png)
![img_37.png](img_37.png)
![img_38.png](img_38.png)
只要拼接的时候有一个是变量，则相当于在堆空间中new一个对象
![img_39.png](img_39.png)
![img_40.png](img_40.png)
![img_41.png](img_41.png)
字符串变量相加是通过StringBuilder来实现的
![img_42.png](img_42.png)



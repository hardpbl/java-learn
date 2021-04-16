###字符串拼接操作
![img.png](img.png)

####String左右两边有变量的情况
![img_1.png](img_1.png)
![img_3.png](img_3.png)

###直接使用+和使用StringBuilder的速度大概是几百倍的差距
![img_4.png](img_4.png)
改进的空间，提前确定StringBUilder(8)构造方法的大小，减少拷贝扩容

###Intern()的使用
![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)
![img_11.png](img_11.png)
###intern常量池指向堆空间，一句话，jdk8中s.intern()是没有在字符串常量池
中创建的，只是把引用指向了我们的堆空间
![img_12.png](img_12.png)
![img_13.png](img_13.png)
![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png)
####使用常量池重的字符串而不是使用堆空间的，堆空间的没有引用后期会被回收，从而减少了内存的使用
![img_17.png](img_17.png)

###堆空间内存去重
![img_18.png](img_18.png)
![img_19.png](img_19.png)
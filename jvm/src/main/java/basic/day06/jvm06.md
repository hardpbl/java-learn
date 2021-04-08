###堆部分参数设置
![img.png](img.png)

####对象分配过程
![img_1.png](img_1.png)
~~~
Eden区满的时候才会触发回收，也就是yongGC,此时也会回收幸存者s1，s2，而s1，s2
满的时候不会触发yongGC
~~~
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)

####回收图解
![img_5.png](img_5.png)

Minor GC==YongGC

Major GC== Full GC
![img_6.png](img_6.png)
![img_7.png](img_7.png)
MajorGC
![img_8.png](img_8.png)
Full GC
![img_9.png](img_9.png)

####堆空间分代思想
![img_10.png](img_10.png)

####内存分配策略
![img_11.png](img_11.png)
![img_12.png](img_12.png)
![img_13.png](img_13.png)
非TLAB会自动加锁保证原子性
位于堆区域的Eden区，每个线程私有
![img_14.png](img_14.png)

####堆空间的常用参数
![img_15.png](img_15.png)
![img_17.png](img_17.png)
方法出栈，对象不会立即回收，等待GC回收
![img_18.png](img_18.png)

堆内存是分配对象的唯一选择吗？
![img_19.png](img_19.png)
![img_20.png](img_20.png)
栈上分配
![img_21.png](img_21.png)
发生了逃逸，有可能被其他的方法调用
![img_22.png](img_22.png)
如何判断是否发生了逃逸分析，我们就看new的对象是否有可能
在方法外调用
jdk7之后默认开启了逃逸分析
 ![img_23.png](img_23.png)
![img_24.png](img_24.png)
![img_25.png](img_25.png)
![img_26.png](img_26.png)
因为没地方用这个对象，然后就会把聚合量拆为标量
![img_27.png](img_27.png)
![img_28.png](img_28.png)
![img_29.png](img_29.png)

栈堆方法区的关系
![img_30.png](img_30.png)

##方法区的理解
![img_31.png](img_31.png)
元空间就是方法区的一个具体实现
jdk8之前溢出报错和jdk8之后是不一样的，以前叫永久代，现在叫元空间
永久带之前使用的是堆内存，现在使用的是直接内存，也就是本地内存
![img_32.png](img_32.png)
![img_33.png](img_33.png)
![img_34.png](img_34.png)
![img_35.png](img_35.png)
![img_36.png](img_36.png)
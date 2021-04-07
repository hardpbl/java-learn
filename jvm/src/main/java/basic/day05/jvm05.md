####方法重写的本质
![img.png](img.png)
####虚方法表
主要是为了解决方法重写依次向上找对应方法的问题
![img_1.png](img_1.png)
####方法返回地址
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)
![img_5.png](img_5.png)

####本地方法
![img_6.png](img_6.png)

###本地方法栈
![img_7.png](img_7.png)
![img_8.png](img_8.png)

###Jvm学习路线即将
![img_9.png](img_9.png)


##堆
![img_10.png](img_10.png)
![img_11.png](img_11.png)
    一个进程就是一个虚拟机实例，每一个实例都有一个堆空间
![img_12.png](img_12.png)
![img_13.png](img_13.png)

方法一出栈，我们的堆里面的对象就会被回收吗？实际上不是的
，当内存不足的时候触发GC的时候才会去判断一个对象会不会被回收


###堆的核心概述
![img_14.png](img_14.png)
#####设置堆内存空间大小和OOM
![img_15.png](img_15.png)
![img_16.png](img_16.png)
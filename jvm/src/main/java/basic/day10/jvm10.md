###垃圾回收
####什么是垃圾
![img.png](img.png)
![img_1.png](img_1.png)

![img_2.png](img_2.png)
![img_3.png](img_3.png)

####垃圾回收算法
先找出哪些是垃圾：标记阶段（引用计数，可达性分析），清除阶段

###垃圾标记阶段的算法-引用计数法
GC，主要针对堆空间，虚拟机栈，PC，本地方法栈不存在GC，方法区（元空间是否回收由具体的虚拟机决定）
![img_4.png](img_4.png)
循环引用内存泄漏分析图（未实际采用的算法）
![img_5.png](img_5.png)
![img_6.png](img_6.png)

###垃圾标记阶段的算法-可达性分析算法
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)
####一致性快照
![img_11.png](img_11.png)
finalization
![img_12.png](img_12.png)
![img_13.png](img_13.png)
![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png)
![img_17.png](img_17.png)

##清除阶段

###标记-清除算法（执行效率低下）
![img_18.png](img_18.png)
标记的对象是可达的对象，而非垃圾
![img_19.png](img_19.png)
![img_20.png](img_20.png)

###复制算法（新生代，适合活下来小的空间，因为对象地址会发生变化）
![img_21.png](img_21.png)
![img_22.png](img_22.png)
![img_23.png](img_23.png)
应用场景
![img_24.png](img_24.png)

###标记-压缩算法
![img_25.png](img_25.png)
![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_28.png](img_28.png)




![img.png](img.png)

![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)

![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)

![img_11.png](img_11.png)
![img_12.png](img_12.png)
![img_13.png](img_13.png)

### AQS思想

![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png)

设计模式：模版设计模式，需要子类实现，否则就会报错
![img_17.png](img_17.png)
![img_18.png](img_18.png)
![img_19.png](img_19.png)

### Node封装的就是一个一个的线程

![img_20.png](img_20.png)
![img_21.png](img_21.png)
对应分析图
![img_23.png](img_23.png)
![img_25.png](img_25.png)
B节点入队完成 C节点

![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_28.png](img_28.png)

![img_29.png](img_29.png)
![img_30.png](img_30.png)
![img_31.png](img_31.png)
![img_32.png](img_32.png)
B和C客户因为park停在这了 自旋 java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued
![img_33.png](img_33.png)
![img_34.png](img_34.png)
![img_35.png](img_35.png)

我们lock.unlock()进行解锁状态
![img_36.png](img_36.png)
解锁B节点 FIFO先进先出
![img_40.png](img_40.png)
![img_38.png](img_38.png)
![img_37.png](img_37.png)
![img_39.png](img_39.png)
B节点抢占成功会把队列中的头节点干掉，自己滞空，成为新的头节点
![img_41.png](img_41.png)
如图
![img_42.png](img_42.png)

总结
![img_43.png](img_43.png)
![img_44.png](img_44.png)
![img_45.png](img_45.png)
![img_46.png](img_46.png)
![img_47.png](img_47.png)
队列中再抢抢
![img_48.png](img_48.png)

A调用unLock方法会唤醒阻塞中的B
![img_49.png](img_49.png)

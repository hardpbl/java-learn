###并行与并发
![img.png](img.png)
![img_1.png](img_1.png)

###安全点(safePoint)和安全区域(safeRegion)
所有线程停顿下来等待GC
####安全点
![img_3.png](img_3.png)
![img_2.png](img_2.png)
![img_4.png](img_4.png)
####安全区域
![img_5.png](img_5.png)

####引用
![img_6.png](img_6.png)
![img_7.png](img_7.png)

强：永不回收
![img_8.png](img_8.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)
软：内存不足就回收，不一定要等到OOM
![img_11.png](img_11.png)
![img_12.png](img_12.png)
弱：发现就回收，发生GC就会回收
![img_14.png](img_14.png)
![img_13.png](img_13.png)
虚：对象回收跟踪
![img_16.png](img_16.png)

##垃圾回收器
![img_17.png](img_17.png)
![img_18.png](img_18.png)
![img_19.png](img_19.png)
![img_20.png](img_20.png)
![img_21.png](img_21.png)
![img_22.png](img_22.png)


###垃圾回收器发展
![img_23.png](img_23.png)
![img_24.png](img_24.png)
![img_25.png](img_25.png)
![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_28.png](img_28.png)

###Serial回收器：串行回收(新生代)
![img_29.png](img_29.png)
![img_30.png](img_30.png)
![img_31.png](img_31.png)

###ParNew回收器：并行回收(新生代)
![img_32.png](img_32.png)
![img_33.png](img_33.png)
![img_34.png](img_34.png)

###Parallel回收器：吞吐量优先(新生代)
6大参数
![img_35.png](img_35.png)
![img_36.png](img_36.png)
![img_38.png](img_38.png)
![img_39.png](img_39.png)
![img_40.png](img_40.png)

###CMS-低延迟
![img_41.png](img_41.png)
![img_42.png](img_42.png)
![img_43.png](img_43.png)
![img_44.png](img_44.png)
![img_45.png](img_45.png)
![img_46.png](img_46.png)

###G1区域分代化
![img_47.png](img_47.png)
![img_48.png](img_48.png)   
![img_49.png](img_49.png)
![img_50.png](img_50.png)
![img_51.png](img_51.png)
![img_52.png](img_52.png)
![img_53.png](img_53.png)

####G1 region
![img_56.png](img_56.png)
![img_54.png](img_54.png)
![img_55.png](img_55.png)
![img_57.png](img_57.png)
####G1回收过程
![img_59.png](img_59.png)
![img_58.png](img_58.png)

![img_60.png](img_60.png)
记忆集的作用
![img_61.png](img_61.png) 

yongGC
![img_62.png](img_62.png)
![img_63.png](img_63.png)
![img_64.png](img_64.png)
![img_65.png](img_65.png)

![img_66.png](img_66.png)
![img_67.png](img_67.png)
![img_68.png](img_68.png)
![img_69.png](img_69.png)

![img_70.png](img_70.png)


















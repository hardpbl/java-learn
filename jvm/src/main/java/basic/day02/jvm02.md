![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)

##类加载器和加载器子系统
![img_4.png](img_4.png)

加载过程图
![img_5.png](img_5.png)
加载（整个加载过程中的一部分）
![img_6.png](img_6.png)
![img_7.png](img_7.png)
链接
![img_8.png](img_8.png)
初始化
![img_9.png](img_9.png)
![img_10.png](img_10.png)
![img_12.png](img_12.png)
number输出：10
类加载器
![img_13.png](img_13.png)
类加载器层级关系
![img_14.png](img_14.png)
![img_15.png](img_15.png)
用户自定义的类使用的是系统加载器加载
系统的核心类库都是使用的是引导类加载器加载
Bootstrap ClassLoader  
我们通过classLoader是获取不到的，获取到的是null
![img_16.png](img_16.png)

![img_17.png](img_17.png)

![img_18.png](img_18.png)
自定义加载器
![img_19.png](img_19.png)

![img_20.png](img_20.png)

![img_21.png](img_21.png)
![img_22.png](img_22.png)

###双亲委派机制
![img_23.png](img_23.png)
![img_24.png](img_24.png)
比如我们自定义一个类为什么是appClassLoader加载的呢，实际上是走了一波双亲委派再回来的，先去问扩展加载器，扩展加载
器发现自己有父类，那么就委托给引导类加载器，引导类加载器发现这个类不是属于他加载包范围，于是就让子类扩展加载器自己加载
扩展加载器发现也不是加载包下的，于是就让应用加载器自己加载，所以打印出来的加载器就是应用加载器
![img_25.png](img_25.png)
![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_28.png](img_28.png)
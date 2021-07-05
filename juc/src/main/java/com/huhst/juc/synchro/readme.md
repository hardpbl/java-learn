![img.png](img.png)

wait和notify需要和synchronized一起用
![img_1.png](img_1.png)

![img_2.png](img_2.png)

### Park /UnPark

![img_3.png](img_3.png)
![img_4.png](img_4.png)

无需与锁块连用，且无先后顺序，假如我们先调用unPark,那么我们的park阻塞将会 失效
![img_5.png](img_5.png)

许可证最大值只有1，多个会导致死锁
![img_6.png](img_6.png)
![img_7.png](img_7.png)
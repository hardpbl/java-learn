package com.huhst.threadlocal;

/**
 * @author panbailiang
 * @Classname ThreadLocalDemo
 * @Date 2021/4/25 3:05 下午
 *
 * ThreadLocal的理解
 *      ThreadLocal jdk包提供的一个类，让我们的线程拥有了一个本地变量，避免操作成员变量带来的线程安全问题
 *      实现原理:
 *          我们的Thread类维护了一个ThreadLocal.ThreadLocalMap threadLocals = null;变量，当我们调用ThreadLocal.set()方法的时候
 *          会获取到当前线程，如果我们的threadLocals不是空，那么就会往里面设置值，使得我们的当前线程与本地线程变量进行了绑定，如果调用线程
 *          一直不终止，那么这个本地变量将会一直存放在他的threadLocals中，所以不使用本地变量的时候需要调用remove方法将threadLocals中删除不用的本地变量
 *      set()方法:
 *              public void set(T value) {
 *               //(1)获取当前线程（调用者线程）
 *                  Thread t = Thread.currentThread();
 *                  //(2)以当前线程作为key值，去查找对应的线程变量，找到对应的map
 *                  ThreadLocalMap map = getMap(t);
 *                  //(3)如果map不为null，就直接添加本地变量，key为当前定义的ThreadLocal变量的this引用，值为添加的本地变量值
 *                  if (map != null)
 *                       map.set(this, value);
 *                      //(4)如果map为null，说明首次添加，需要首先创建出对应的map
 *                   else
 *                  createMap(t, value);
 *              }
 *
 *              ThreadLocalMap getMap(Thread t) {
 *                  //获取线程自己的变量threadLocals，并绑定到当前调用线程的成员变量threadLocals上
 *                  return t.threadLocals;
 *              }
 *
 *              //createMap方法不仅创建了threadLocals，同时也将要添加的本地变量值添加到了threadLocals中
 *              void createMap(Thread t, T firstValue) {
 *                  t.threadLocals = new ThreadLocalMap(this, firstValue);
 *              }
 *        get()方法
 *        在get方法的实现中，首先获取当前调用者线程，如果当前线程的threadLocals不为null，就直接返回当前线程绑定的本地变量值，
 *        否则执行setInitialValue方法初始化threadLocals变量。在setInitialValue方法中，类似于set方法的实现，都是判断当
 *        前线程的threadLocals变量是否为null，是则添加本地变量（这个时候由于是初始化，所以添加的值为null），否则创建
 *        threadLocals变量，同样添加的值为null。
 *              public T get() {
 *                      //(1)获取当前线程
 *                      Thread t = Thread.currentThread();
 *                      //(2)获取当前线程的threadLocals变量
 *                      ThreadLocalMap map = getMap(t);
 *                      //(3)如果threadLocals变量不为null，就可以在map中查找到本地变量的值
 *                      if (map != null) {
 *                           ThreadLocalMap.Entry e = map.getEntry(this);
 *                           if (e != null) {
 *                              @SuppressWarnings("unchecked")
 *                              T result = (T)e.value;
 *                              return result;
 *                          }
 *                      }
 *                      //(4)执行到此处，threadLocals为null，调用该更改初始化当前线程的threadLocals变量
 *                      return setInitialValue();
 *              }
 *
 *              private T setInitialValue() {
 *                   //protected T initialValue() {return null;}
 *                   T value = initialValue();
 *                  //获取当前线程
 *                  Thread t = Thread.currentThread();
 *                  //以当前线程作为key值，去查找对应的线程变量，找到对应的map
 *                  ThreadLocalMap map = getMap(t);
 *                  //如果map不为null，就直接添加本地变量，key为当前线程，值为添加的本地变量值null
 *                   if (map != null)
 *                       map.set(this, value);
 *                      //如果map为null，说明首次添加，需要首先创建出对应的map
 *                   else
 *                   createMap(t, value);
 *                  return value;
 *              }
 *
 *       remove()方法
 *       remove方法判断该当前线程对应的threadLocals变量是否为null，不为null就直接删除当前线程中指定的threadLocals变量
 *              public void remove() {
 *                  ThreadLocalMap m = getMap(Thread.currentThread());
 *                  if (m != null)
 *                  m.remove(this);
 *               }
 *
 *
 *
 */
public class ThreadLocalDemo {
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        t1.start();
        t2.start();
    }
}

package com.huhst.volatiles;

/**
 * @author panbailiang
 * @Classname TagAndSeekDemo
 * @Date 2021/3/27 6:14 下午
 *
 * 指令重排
 * 计算机在执行程序时，为了提高性能，编译器和处理器常常会对指令进行重排序
 *      源代码=>编译器优化重排 => 指令并行重排=> 内存系统重排=> 最终执行的指令
 * 处理器进行重排序的时候必须要考虑数据的依赖性
 *
 * 加了volatile会禁止指令重排
 *
 */
public class TagAndSeekDemo {

}

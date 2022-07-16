链接：
https://www.toutiao.com/article/6826526119072629255/?log_from=43f8f75c57dee_1657848561869




###相关面试题
1.ThreadLocal 为什么是线程安全的？
```doc
答：ThreadLocal 为每一个线程维护变量的副本，把共享数据的可见范围限制在同一个线程之内，
因此 ThreadLocal 是线程安全的，每个线程都有属于自己的变量。
```

2.ThreadLocal 如何共享数据？

```dockerfile
答：通过 ThreadLocal 的子类 InheritableThreadLocal 可以天然的支持多线程间的信息共享
```

3.以下程序打印的结果是 true 还是 false？

```markdown
ThreadLocal threadLocal = new InheritableThreadLocal();
threadLocal.set("老王");
ThreadLocal threadLocal2 = new ThreadLocal();
threadLocal2.set("老王");
new Thread(() -> {
    System.out.println(threadLocal.get().equals(threadLocal2.get()));
}).start();

答：false。题目分析：因为 threadLocal 使用的是 InheritableThreadLocal（共享本地线程），
所以 threadLocal.get() 结果为 老王，而 threadLocal2 使用的是 ThreadLocal，
因此在新线程中 threadLocal2.get() 的结果为 null，因而它们比较的最终结果为 false。
```
4.ThreadLocal 为什么会发生内存溢出？

```markdown
答：ThreadLocal 造成内存溢出的原因：如果 ThreadLocal 没有被直接引用（外部强引用），
在 GC（垃圾回收）时，由于 ThreadLocalMap 中的 key 是弱引用，所以一定就会被回收，
这样一来 ThreadLocalMap 中就会出现 key 为 null 的 Entry，并且没有办法访问这些数据，
如果当前线程再迟迟不结束的话，这些 key 为 null 的 Entry 的 value 
就会一直存在一条强引用链：Thread Ref -> Thread -> ThreaLocalMap -> Entry -> value 并且永远无法回收，从而造成内存泄漏。
```


5.解决 ThreadLocal 内存溢出的关键代码是什么？
```markdown
答：关键代码为 threadLocal.remove() ，使用完 ThreadLocal 之后，调用remove() 方法，
清除掉 ThreadLocalMap 中的无用数据就可以避免内存溢出了。
```

6.ThreadLocal 和 Synchonized 有什么区别？
```markdown
答：ThreadLocal 和 Synchonized 都用于解决多线程并发访问，
防止任务在共享资源上产生冲突，但是 ThreadLocal 与 Synchronized 有本质的区别，
Synchronized 用于实现同步机制，是利用锁的机制使变量或代码块在某一时刻只能被一个线程访问，
是一种 “以时间换空间” 的方式；而 ThreadLocal 为每一个线程提供了独立的变量副本，
这样每个线程的（变量）操作都是相互隔离的，这是一种 “以空间换时间” 的方式。
```

###总结
ThreadLocal 的主要方法是 set(T) 和 get()，用于多线程间的数据隔离，ThreadLocal 也提供了 InheritableThreadLocal 子类，
用于实现多线程间的数据共享。但使用 ThreadLocal 一定要注意用完之后使用 remove() 清空 ThreadLocal，不然会操作内存溢出的问题。
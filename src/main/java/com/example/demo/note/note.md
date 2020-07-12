###1. volatile原子型
1.volatile是java虚拟机提供额轻量级的同步机制
                
- 保证可见性
- 不保证原子性
- 禁止指令重排
    * 单线程环境里面确保程序最终执行结果和代码顺序执行的结果一致
    * 处理器在进行重排序时必须要考虑指令之间的数据依赖性
    * 多线程环境中线程交替执行，由于编译器优化重排的存在，
    两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
    > 由于编译器和处理器都能执行指令重排优化。如果在指令间插入一条memory barrier
     则会告诉编译器和CPU，不管什么指令都不能和这表memory barrier指令重排，也就是说
     通过插入内存屏障禁止在内存屏障前后的指令执行重排序优化。内存屏障另外一个作用
    是强制刷新出各种CPU的缓存数据，因此任何CPU的线程都能读取到这些数据的最新版本。
                                                                                                                                                   
2.JMM（java内存模型）

>由于jv运行的程序的实体是线程，而每个线程创建时JVM都会为其创建一个工作内存（有些地方称为栈空间），
>工作内存是每个线程的私有数据区域，而java内存模型中规定所有变量都存储在主内存中，朱内存是共享内存区域，
>所有线程都可以访问，但线程对变量的操作（读取赋值等）必须在工作内存中进行，
>首先要将变量从主内存中拷贝到自己的工作空间，然后对变量进行操作，操作完成后再将变量写回主内存，
>不能直接操作主内存中的变量，各个线程中的工作内存中储存着主内存中的变量拷贝副本，
>因此不同的线程间无法访问对方的工作内存，线程间的通信传值

主内存，工作内存

- 可见性
- 原子性
- VolatileDemo可见性+原子性代码
- 有序性
 
CAS  CompareAndSwap
不断重试

1. AtomicInteger里面的value原始值为3，既主内存中AtomicInteger的value为3，根据JMM模型，线程A和线程B各自持有一份为3的value的副本分别到各自的工作内存
2. 线程A通过getIntVolatile（var1，var2）拿到value值3，这时线程A被挂起
3. 线程B也通过getIntVolatile（var1，var2）的方法获取到value值3，此时刚好线程B没有被挂起并执行compareAndSwapInt方法比较内存值也为3，成功修改内存值为3，线程B打完收工，一切OK
4. 这时线程A恢复，执行compareAndSwapInt方法比较，发现自己的值数字3和主内存中的值数字4不一致，说明该值已经被其他线程抢先一步修改过了，那A线程本次修改失败，只能重新读取重来一遍了
5. 线程A重新获取value值，因为变量value被volatile修饰，所以其他线程对它的修改，线程A总是能看到，线程A继续执行compareAndSwapInt记性比较替换，直到成功

###集合问题

ArrayList线程不安全

Collections.SynchronizedList
CopyOnWriteArrayList();
Collections.SynchronizedSet
CopyOnWriterArraySet();
CopyOnWriteArraySet();

###锁
公平锁/非公平锁
>ReentrantLock 默认非公锁，可以创建公平锁
Synchronized是非公平锁

可重入锁/递归锁
>指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
>在同一个线程在外层方法获取锁的时候，在进入内层方法就会自动获取该锁
>也就说，线程可以进入任何一个它已经拥有的锁的同步着的代码块。  

Unsafe类+CAS思想（自旋锁）
 
是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU
CAS->Unsafe -> CAS底层 -> ABA -> 原子引用更新 ->如果规避ABA问题

独占锁/共享锁

独享锁
> 指该锁一次只能被一个线程锁持有，ReentrantLock和Synchronized都是独占锁

共享锁,互斥锁
>指该锁可以被多个线程持有，对ReentrantReadWriteLock其读锁是共享锁，其写锁是独占锁
>读锁的共享锁可以保证并发读是非常高效的，读写，写读，写写的过程是互斥的

乐观锁/悲观锁
>乐观锁与悲观锁不是指具体的什么类型的锁，而是指看待并发同步的角度。
 悲观锁认为对于同一个数据的并发操作，一定是会发生修改的，哪怕没有修改，也会认为修改。因此对于同一个数据的并发操作，悲观锁采取加锁的形式。悲观的认为，不加锁的并发操作一定会出问题。
 乐观锁则认为对于同一个数据的并发操作，是不会发生修改的。在更新数据的时候，会采用尝试更新，不断重新的方式更新数据。乐观的认为，不加锁的并发操作是没有事情的。
>从上面的描述我们可以看出，悲观锁适合写操作非常多的场景，乐观锁适合读操作非常多的场景，不加锁会带来大量的性能提升。
 悲观锁在Java中的使用，就是利用各种锁。
 乐观锁在Java中的使用，是无锁编程，常常采用的是CAS算法，典型的例子就是原子类，通过CAS自旋实现原子操作的更新

分段锁
>分段锁其实是一种锁的设计，并不是具体的一种锁，对于ConcurrentHashMap而言，其并发的实现就是通过分段锁的形式来实现高效的并发操作。
 我们以ConcurrentHashMap来说一下分段锁的含义以及设计思想，ConcurrentHashMap中的分段锁称为Segment，它即类似于HashMap（JDK7与JDK8中HashMap的实现）的结构，即内部拥有一个Entry数组，数组中的每个元素又是一个链表；同时又是一个ReentrantLock（Segment继承了ReentrantLock)。
 当需要put元素的时候，并不是对整个hashmap进行加锁，而是先通过hashcode来知道他要放在那一个分段中，然后对这个分段进行加锁，所以当多线程put的时候，只要不是放在一个分段中，就实现了真正的并行的插入。
 但是，在统计size的时候，可就是获取hashmap全局信息的时候，就需要获取所有的分段锁才能统计。
 分段锁的设计目的是细化锁的粒度，当操作不需要更新整个数组的时候，就仅仅针对数组中的一项进行加锁操作。

偏向锁/轻量级锁/重量级锁
>这三种锁是指锁的状态，并且是针对Synchronized。在Java 5通过引入锁升级的机制来实现高效Synchronized。这三种锁的状态是通过对象监视器在对象头中的字段来表明的。
偏向锁是指一段同步代码一直被一个线程所访问，那么该线程会自动获取锁。降低获取锁的代价。
轻量级锁是指当锁是偏向锁的时候，被另一个线程所访问，偏向锁就会升级为轻量级锁，其他线程会通过自旋的形式尝试获取锁，不会阻塞，提高性能。
重量级锁是指当锁为轻量级锁的时候，另一个线程虽然是自旋，但自旋不会一直持续下去，当自旋一定次数的时候，还没有获取到锁，就会进入阻塞，该锁膨胀为重量级锁。重量级锁会让其他申请的线程进入阻塞，性能降低。

阻塞队列

1. ArrayBlockingQueue：有数组结构组成的有界阻塞队列
2. LinkBlockingQueue：由链表结构组成的有界（但大小默认值为Integer.MAX_VALUE）阻塞队列
3. PriorityQueue：支持优先级排序的无界阻塞队列
4. DelayQueue：使用优先级队列实现的延迟无界阻塞队列
5. SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列。
6. LinkedTransferQueue：由链表结构组成的无界阻塞队列。
7. LinkedBlockingDeque：由链表结构组成的双向阻塞队列。

-------------------
方法类型
--------------------

| 方法类型  | 抛出异常   |  特殊值     | 阻塞      |  超时      |
| :-------:| :-------:  | :-------: |  :-------: | :-------: |
| 插入     |  add(e)    |  remove(e)  |  put(e)   |  offer(e,time,unit)|
| 移除     |  remove()  |  poll()    |  take()   |  poll(time,unit)|
| 检查     |  element() |  peek()    |  不可用    |  不可用    |

Synchronized / Lock 区别
synchronized是关键字属于JVM层面
>monitorenter(底层是通过monitor对象来完成，其实wait/notify等方法也是依赖于monitor对象只有在同步代码块中或者方法中才能调用wait/notify等方法)
>monitorexit

Lock
> Lock是具体类的锁(java.util.concurrent.locks.lock)是api层面的锁 


jps 
jinfo
jstack

标配参数
- -version
- -help
- -showversion

X参数了解
- -Xit 解释执行 
- -Xcomp 第一次使用就编译成本地代码
- -Xmixed 混合模式

XX参数
- Boolean 
    * 公式
        * -XX：+或者-某个属性值
        * +表示开启
        * -表示关闭
    * Case
        * 是否打印GC收集细节
        * 是否使用串行垃圾回收器
- KV设值类型
    * 公式
        * -XX：属性key=属性值value
    * Case
        * -XX：MetaspaceSize=128m
        * -XX：MaxTenuringThreshold=15
        * -Xms：-XX：InitialHeapSize  
        * -Xmx：-XX：MaxHeapSize   
   
第一种，查看参数盘点家底        
1. jps查看进程端口
2. jinfo -flags java进程编号 查看所有参数
3. jinfo -flag  具体参数 java进程编号 查看某个参数的赋值，或者使用情况   
   
第二种，查看参数盘点家底 
java -XX：+PrintFlagsInitial 查看所有的 初始默认值 

java -XX：+PrintFlagsFinal 查看所有修改更新的内容，运行java命令的同事的打印出参数

java -XX：+PrintCommandLineFlags -version 查看常用符号

>在java8中，永久代已经被移除了，被一个称为元空间的区域所取代。
>元空间的本质和永久代类似.
>元空间（Java8）与永久代（Java7）之间的最大区别在于：
>永久代使用的JVM的堆内存，但是Java8以后的元空间并不在虚拟机中而是使用本机物理内存。
>
>因此，默认情况下，元空间的大小仅受本地内存限制。类的元数据放入native memory，
>字符串池和类的静态变量放入java堆中，这样可以加载多少类的元数据就不再由MaxPermSize控制，
>而由系统的实际可用空间来控制。


调优参数：
- Xms
    * 初始大小内存，默认为物理内存1/64
    * 等价于-XX：InitialHeapSize
- XmX
    * 最大分配内存，默认为物理内存1/4
    * 等价于-XX：MaxHeapSize 
- Xss
    * 设置单个线程的大小，一般默认大小为512k~1024k
    * 等价于-XX：ThreadStackSize
- Xmn
    * 设置年轻代大小
-XX：MetaspaceSize
    * 设置元空间大小
        * 元空间的本质和永久代类似，都是对jvm规范中方法区的实现。
           不过元空间与永久代之间的最大区别在于：元空间并不在虚拟机中，而是使用本地内存。
           因此，默认情况下，元空间的带下仅受本地内存限制
        * -Xms10m -Xmx10m -XX:MetaspaceSize=1024m -XX:+PrintFlagsFinal
 

 


 
# Java

## 4.面向对象(三)

#####1. 类加载机制，双亲委派模型？
        
    考察点：类
    
    参考回答：
    某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，
    如果父类加载器可以完成类加载任务，就成功返回；
    只有父类加载器无法完成此加载任务时，才自己去加载。
    
    使用双亲委派模型的好处在于Java类随着它的类加载器一起具备了一种带有优先级的层次关系。
    例如类java.lang.Object，它存在在rt.jar中，无论哪一个类加载器要加载这个类，
    最终都是委派给处于模型最顶端的Bootstrap ClassLoader进行加载，
    因此Object类在程序的各种类加载器环境中都是同一个类。
    相反，如果没有双亲委派模型而是由各个类加载器自行加载的话，
    如果用户编写了一个java.lang.Object的同名类并放在ClassPath中，
    那系统中将会出现多个不同的Object类，程序将混乱。
    因此，如果开发者尝试编写一个与rt.jar类库中重名的Java类，可以正常编译，
    但是永远无法被加载运行。
    
#####2. Object类的方法并简要说明。

    考察点：面向对象
    
    参考回答：
    Object()默认构造方法。
    clone() 创建并返回此对象的一个副本。
    equals(Object obj) 指示某个其他对象是否与此对象“相等”。
    finalize()当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
    getClass()返回一个对象的运行时类。
    hashCode()返回该对象的哈希码值。 
    notify()唤醒在此对象监视器上等待的单个线程。
    notifyAll()唤醒在此对象监视器上等待的所有线程。
    toString()返回该对象的字符串表示。
    wait()导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
    wait(long timeout)导致当前的线程等待，
    直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，
    或者超过指定的时间量。
    wait(long timeout, int nanos) 导致当前的线程等待，
    直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，
    或者其他某个线程中断当前线程，或者已超过某个实际时间量。   
    
#####3. wait方法的底层原理
    
    考察点：基础
    
    参考回答：
    wait方法是继承自Object类中的方法，当对象调用wait方法时，其实是让执行对象方法的当前线程等待（而不是对象等待），
    线程会被放入等待队列中并释放锁，只有当其他线程调用notify或者notifyAll方法时，这个线程才会从等待队列中被唤醒，然后重新去争用锁
    
    ObjectSynchronizer::wait方法通过object的对象中找到ObjectMonitor对象调用方法 void ObjectMonitor::wait(jlong millis, bool interruptible, TRAPS)
    
    通过ObjectMonitor::AddWaiter调用把新建立的ObjectWaiter对象放入到 _WaitSet 的队列的末尾中然后在ObjectMonitor::exit释放锁，
    接着 thread_ParkEvent->park 也就是wait。 
                
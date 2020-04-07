# Java

## 2. java基础二

1. 数组(Array)和列表(ArrayList)的区别？什么时候应该使用Array而不是ArrayList？
        
        考察点：Array
        参考回答：
        Array和ArrayList的不同点：
        Array可以包含基本类型和对象类型，ArrayList只能包含对象类型。
        Array大小是固定的，ArrayList的大小是动态变化的。
        ArrayList提供了更多的方法和特性，比如：addAll()，removeAll()，iterator()等等。
        对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。

2. 什么是值传递和引用传递？
        
        考察点：JAVA引用传递
        参考回答：
        值传递是对基本型变量而言的,传递的是该变量的一个副本,改变副本不影响原变量.
        引用传递一般是对于对象型变量而言的,传递的是该对象地址的一个副本, 并不是原对象本身 。 所以对引用对象进行操作会同时改变原对象.
        一般认为,java内的传递都是值传递.
        
3. Java支持的数据类型有哪些？什么是自动拆装箱？

        考察点：JAVA数据类型
        参考回答：
        Java语言支持的8种基本数据类型是：
        byte
        short
        int
        long
        float
        double
        boolean
        char
        自动装箱是Java编译器在基本数据类型和对应的对象包装类型之间做的一个转化。比如：把int转化成Integer，double转化成Double，等等。反之就是自动拆箱。
4. 为什么会出现4.0-3.6=0.40000001这种现象？

        考察点：计算机基础
        
        参考回答：
        原因简单来说是这样：2进制的小数无法精确的表达10进制小数，计算机在计算10进制小数的过程中要先转换为2进制进行计算，这个过程中出现了误差。
        
5. 一个十进制的数在内存中是怎么存的？

        考察点：计算机基础
        
        参考回答：
        补码的形式。
6. Lamda表达式的优缺点。

        考察点：Java基础
        
        参考回答：
        优点：1. 简洁。2. 非常容易并行计算。3. 可能代表未来的编程趋势。
        缺点：1. 若不用并行计算，很多时候计算速度没有比传统的 for 循环快。（并行计算有时需要预热才显示出效率优势）2. 不容易调试。3. 若其他程序员没有学过 lambda 表达式，代码不容易让其他语言的程序员看懂。
7. java8的新特性
        
        考察点：java8
        
        参考回答：
        Lambda 表达式 − Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中。
        
        方法引用− 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
        
        默认方法− 默认方法就是一个在接口里面有了一个实现的方法。
        
        新工具− 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
        
        Stream API −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
        
        Date Time API − 加强对日期与时间的处理。
        
        Optional 类 − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
        
        Nashorn, JavaScript 引擎 − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。
        
8. 符号“==”比较的是什么

        考点：基础
        
        参考回答：
        “==”对比两个对象基于内存引用，如果两个对象的引用完全相同（指向同一个对象）时，“==”操作将返回true，否则返回false。“==”如果两边是基本类型，就是比较数值是否相等。
        
9. Object若不重写hashCode()的话，hashCode()如何计算出来的

        考点：基础
        
        参考回答：
        Object 的 hashcode 方法是本地方法，也就是用 c 语言或 c++ 实现的，该方法直接返回对象的 内存地址。
        
10. 为什么重写equals还要重写hashcode？

        考点：java基础
        
        参考回答：
        HashMap中，如果要比较key是否相等，要同时使用这两个函数！
        因为自定义的类的hashcode()方法继承于Object类，其hashcode码为默认的内存地址，这样即便有相同含义的两个对象，比较也是不相等的。
        HashMap中的比较key是这样的，先求出key的hashcode(),比较其值是否相等，若相等再比较equals(),若相等则认为他们是相等的。
        若equals()不相等则认为他们不相等。
        如果只重写hashcode()不重写equals()方法，当比较equals()时只是看他们是否为同一对象（即进行内存地址的比较）,所以必定要两个方法一起重写。
        HashMap用来判断key是否相等的方法，其实是调用了HashSet判断加入元素 是否相等。
        重载hashCode()是为了对同一个key，能得到相同的Hash Code，这样HashMap就可以定位到我们指定的key上。
        重载equals()是为了向HashMap表明当前对象和key上所保存的对象是相等的，这样我们才真正地获得了这个key所对应的这个键值对。
        
11. map的分类和常见的情况
        
        考点：java基础
        
        参考回答：
        java为数据结构中的映射定义了一个接口java.util.Map;它有四个实现类,分别是HashMap Hashtable LinkedHashMap 和TreeMap.
        
        Map主要用于存储健值对，根据键得到值，因此不允许键重复(重复了覆盖了),但允许值重复。
        
        Hashmap 是一个最常用的Map,它根据键的HashCode值存储数据,根据键可以直接获取它的值，具有很快的访问速度，遍历时，取得数据的顺序是完全随机的。 
        HashMap最多只允许一条记录的键为Null;允许多条记录的值为 Null;HashMap不支持线程的同步，即任一时刻可以有多个线程同时写HashMap;
        可能会导致数据的不一致。
        如果需要同步，可以用 Collections的synchronizedMap方法使HashMap具有同步的能力，或者使用ConcurrentHashMap。
        
        Hashtable与 HashMap类似,它继承自Dictionary类，
        不同的是:它不允许记录的键或者值为空;它支持线程的同步，即任一时刻只有一个线程能写Hashtable,因此也导致了 Hashtable在写入时会比较慢。
        
        LinkedHashMap 是HashMap的一个子类，保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，
        先得到的记录肯定是先插入的.也可以在构造时用带参数，按照应用次数排序。在遍历的时候会比HashMap慢，
        不过有种情况例外，当HashMap容量很大，实际数据较少时，遍历起来可能会比 LinkedHashMap慢，
        因为LinkedHashMap的遍历速度只和实际数据有关，和容量无关，而HashMap的遍历速度和他的容量有关。
        
        TreeMap实现SortMap接口，能够把它保存的记录根据键排序,默认是按键值的升序排序，也可以指定排序的比较器，
        当用Iterator 遍历TreeMap时，得到的记录是排过序的。
        
        一般情况下，我们用的最多的是HashMap,在Map 中插入、删除和定位元素，HashMap 是最好的选择。
        但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。
        如果需要输出的顺序和输入的相同,那么用LinkedHashMap 可以实现,它还可以按读取顺序来排列.
        
        HashMap是一个最常用的Map，它根据键的hashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度。
        HashMap最多只允许一条记录的键为NULL，允许多条记录的值为NULL。
        
        HashMap不支持线程同步，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致性。
        如果需要同步，可以用Collections的synchronizedMap方法使HashMap具有同步的能力。
        
        Hashtable与HashMap类似，不同的是：
        它不允许记录的键或者值为空；它支持线程的同步，即任一时刻只有一个线程能写Hashtable，因此也导致了Hashtable在写入时会比较慢。
        
        LinkedHashMap保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的。
        
        在遍历的时候会比HashMap慢TreeMap能够把它保存的记录根据键排序，默认是按升序排序，也可以指定排序的比较器。
        当用Iterator遍历TreeMap时，得到的记录是排过序的。
    

    
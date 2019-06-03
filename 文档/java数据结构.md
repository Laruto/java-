# Collection

![img](https://upload-images.jianshu.io/upload_images/2243690-9cd9c896e0d512ed.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/643/format/webp)

## List

### ArrayList

​	底层是使用数组实现，所以查询速度快，增删速度慢

　　ArrayList是基于数组的，在初始化ArrayList时，会构建空数组（Object[] elementData={}）。ArrayList是一个无序的，它是按照添加的先后顺序排列，当然，他也提供了sort方法，如果需要对ArrayList进行排序，只需要调用这个方法，提供Comparator比较器即可

#### add操作：

　　1）如果是第一次添加元素，数组的长度被扩容到默认的capacity，也就是10.

　　2) 当发觉同时添加一个或者是多个元素，数组长度不够时，就扩容，这里有两种情况：

　　只添加一个元素，例如：原来数组的capacity为10，size已经为10，不能再添加了。需要扩容，新的capacity=old capacity+old capacity>>1=10+10/2=15.即新的容量为15。

　　当同时添加多个元素时，原来数组的capacity为10，size为10，当同时添加6个元素时。它需要的min capacity为16，而按照capacity=old capacity+old capacity>>1=10+10/2=15。new capacity小于min capacity，则取min capacity。

　　对于添加，如果不指定下标，就直接添加到数组后面，不涉及元素的移动，如果要添加到某个特定的位置，那需要将这个位置开始的元素往后挪一个位置，然后再对这个位置设置。

#### Remove操作：

　Remove提供两种，按照下标和value。

　　1）**remove(int index)**：首先需要检查Index是否在合理的范围内。其次再调用System.arraycopy将index之后的元素向前移动。

　　2）**remove(Object o)**：首先遍历数组，获取第一个相同的元素，获取该元素的下标。其次再调用System.arraycopy将index之后的元素向前移动。

#### Get操作：

　　这个比较简单，直接对数组进行操作即可。

### LinkedList

​	是基于链表结构实现的，所以查询速度慢，增删速度快，提供了特殊的方法，对头尾的元素操作（进行增删查）。

　　LinkedList是基于链表的，它是一个双向链表，每个节点维护了一个prev和next指针。同时对于这个链表，维护了first和last指针，first指向第一个元素，last指向最后一个元素。LinkedList是一个无序的链表，按照插入的先后顺序排序，不提供sort方法对内部元素排序。

#### Add元素：

　　LinkedList提供了几个添加元素的方法：addFirst、addLast、addAll、add等，时间复杂度为O(1)。

#### Remove元素：

　　LinkedList提供了几个移除元素的方法：removeFirst、removeLast、removeFirstOccurrence、remove等，时间复杂度为O(1)。

#### Get元素：

　　根据给定的下标index，判断它first节点、last直接距离，如果index<size（数组元素个数)/2,就从first开始。如果大于，就从last开始。这个和我们平常思维不太一样，也许按照我们的习惯，从first开始。这也算是一点小心的优化吧。

## Set

### HashSet

　　HashSet是基于HashMap来实现的，操作很简单，更像是对HashMap做了一次“封装”，而且只使用了HashMap的key来实现各种特性，而HashMap的value始终都是PRESENT。

　　HashSet不允许重复（HashMap的key不允许重复，如果出现重复就覆盖），允许null值，非线程安全。

#### 原理

​	哈希表的存储数据过程（哈希表底层也维护了一个数组）：

​	根据存储的元素计算出hashCode值，然后根据计算得出的hashCode值和数组的长度进行计算出存储的下标；如果下标的位置无元素，那么直接存储；如果有元素，那么使用要存入的元素和该元素进行equals方法，如果结果为真，则已经有相同的元素了，所以直接不存；如果结果假，那么进行存储，以链表的形式存储。

#### 构造方法

**HashSet()** 
　　构造一个新的空 set，其底层 HashMap 实例的默认初始容量是 16，加载因子是 0.75。
**HashSet(Collection<? extends E> c)** 
　　构造一个包含指定 collection 中的元素的新 set。
**HashSet(int initialCapacity)** 
　　构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和默认的加载因子（0.75）。
**HashSet(int initialCapacity, float loadFactor)**
　　构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和指定的加载因子。

#### 方法

**boolean add(E e)** 
　　如果此 set 中尚未包含指定元素，则添加指定元素。
**void clear()**
　　从此 set 中移除所有元素。
** Object clone() 　　**返回此 HashSet 实例的浅表副本：并没有复制这些元素本身。**boolean contains(Object o) 　　**如果此 set 包含指定元素，则返回 true。**boolean isEmpty()**
　　如果此 set 不包含任何元素，则返回 true。
** Iterator iterator() 　　**返回对此 set 中元素进行迭代的迭代器。**boolean remove(Object o) 　　**如果指定元素存在于此 set 中，则将其移除。**int size()**
　　返回此 set 中的元素的数量（set 的容量）。

### LinkedHashSet

是基于链表和哈希表共同实现的，所以具有存取有序，元素唯一

### TreeSet

​	存取无序，元素唯一，可以进行排序（排序是在添加的时候进行排序）

　　基于 TreeMap 的 NavigableSet 实现。使用元素的自然顺序对元素进行排序，或者根据创建 set 时提供的 Comparator进行排序，具体取决于使用的构造方法。

#### 存储过程

​	如果是第一个元素，那么直接存入，作为根节点，下一个元素进来是会跟节点比较，如果大于节点放右边的，小于节点放左边；等于节点就不存储。后面的元素进来会依次比较，直到有位置存储为止



## Colleciton体系总结

- List  : "特点 :" 存取有序,元素有索引,元素可以重复.
- ArrayList : 数组结构,查询快,增删慢,线程不安全,因此效率高.
- Vector : 数组结构,查询快,增删慢,线程安全,因此效率低.
- LinkedList : 链表结构,查询慢,增删快,线程不安全,因此效率高.

```java
 addFirst()    removeFirst()    getFirst()
```

- Set   :"特点 :" 存取无序,元素无索引,元素不可以重复.
- HashSet : 存储无序,元素无索引,元素不可以重复.底层是哈希表.

- HashSet : 存储无序,元素无索引,元素不可以重复.底层是哈希表.

> 请问 : 哈希表如何保证元素唯一呢 ? 底层是依赖 hashCode 和 equals 方法.

当存储元素的时候,先根据 hashCode + 数组长度 计算出一个索引,判断索引位置是否有元素.

如果没有元素,直接存储,如果有元素,先判断 equals 方法,比较两个元素是否相同,不同则存储,相同则舍弃.

我们自定义对象存储的元素一定要实现 hashCode 和 equals.

- LinkedHashSet : 存储有序,元素不可以重复.
- TreeSet : 存取无序, 但是可以排序 (自然排序), 元素不可以重复.

**有两种排序方式 :**

- 自然排序 :

我们的元素必须实现 Comparable 接口.可比较的.实现     CompareTo 方法.

- 比较器排序 :

我们需要自定义类,实现Comparetor接口,这个类就是比较器实现 compare 方法.

然后在创建 TreeSet 的时候,把比较器对象作为参数传递给 TreeSet.


# Map

　　Map集合中存储的是键值对，键不能重复，值可以重复。根据键得到值，对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。

### HashMap

　　数组方式存储key/value，**线程非安全**，**允许null作为key和value**，key不可以重复，value允许重复，不保证元素迭代顺序是按照插入时的顺序，key的hash值是先计算key的hashcode值，然后再进行计算，每次容量扩容会重新计算所以key的hash值，会消耗资源，存储自定义对象作为键时，必须重写hasCode和equals方法。

　　默认初始容量16，加载因子0.75，扩容为旧容量乘2，查找元素快，如果key一样则比较value，如果value不一样，则按照链表结构存储value，就是一个key后面有多个value；

#### 原理

HashMap是基于哈希表的Map接口的非同步实现，继承自AbstractMap，AbstractMap是部分实现Map接口的抽象类。在平时的开发中，HashMap的使用还是比较多的。我们知道ArrayList主要是用数组来存储元素的，LinkedList是用链表来存储的，那么HashMap的实现原理是什么呢？先看下面这张图：

![img](https://upload-images.jianshu.io/upload_images/2243690-ec848d862c725e8d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/515/format/webp)

在之前的版本中，HashMap采用数组+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。但是当链表中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低。而JDK1.8中，HashMap采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

#### 方法

**1、添加：**

　　**V put(K key, V value)** （可以相同的key值，但是添加的value值会覆盖前面的，返回值是前一个，如果没有就返回null）

　　**putAll(Map<? extends K,? extends V> m)** 从指定映射中将所有映射关系复制到此映射中（可选操作）。

**2、删除**

　　**remove()** 删除关联对象，指定key对象

　　**clear()** 清空集合对象

**3、获取**

　　**value get(key)** 可以用于判断键是否存在的情况。当指定的键不存在的时候，返回的是null。

**４、判断：**

　　**boolean isEmpty()** 长度为0返回true否则false

　　**boolean containsKey(Object key)** 判断集合中是否包含指定的key

　　**boolean containsValue(Object value)** 判断集合中是否包含指定的value

4、长度：

　**Int size（）**

　　map的主要的方法就这几个

### Hashtable

　　Hashtable与HashMap类似，是HashMap的线程安全版，它支持线程的同步，即任一时刻只有一个线程能写Hashtable，因此也导致了Hashtale在写入时会比较慢，它继承自Dictionary类，不同的是它不允许记录的键或者值为null，同时效率较低。

### LinkedHashMap

LinkedHashMap保存了记录的插入顺序，在用Iteraor遍历LinkedHashMap时，先得到的记录肯定是先插入的，在遍历的时候会比HashMap慢，有HashMap的全部特性。

### TreeMap

　　基于红黑二叉树的NavigableMap的实现，线程非安全，不允许null，key不可以重复，value允许重复，存入TreeMap的元素应当实现Comparable接口或者实现Comparator接口，会按照排序后的顺序迭代元素，两个相比较的key不得抛出classCastException。主要用于存入元素的时候对元素进行自动排序，迭代输出的时候就按排序顺序输出

链接：https://juejin.im/post/5ad82dbef265da503825b240

来源：掘金

著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
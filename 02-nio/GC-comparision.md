## 串行GC

串行GC对年轻代使用mark-copy算法，对老年代使用mark-sweep-compact算法。两者都是单线程的垃圾收集器，不能进行并行处理，所以都会触发全线暂停(STW)，停止所有应用线程。适用于单核CPU或几百MB内存的JVM。


## 并行GC


年轻代和老年代的垃圾回收都会触发STW，对年轻代使用mark-copy算法，对老年代使用mark-sweep-compact算法。并行垃圾收集器适用于多核服务器，因为对系统资源的有效利用，能达到更高的吞吐量。JDK6/7/8默认为并行GC。

-XX:ParallelGCThreads=N 来指定GC线程数，其默认值为CPU核心数


## CMS GC

全称为：Mostly Concurrent Mark and Sweep Garbage Collector 最大程度并发的标记回收垃圾回收器。
其对年轻代采用并行STW方式的mark-copy算法（UseParNewGC），对老年代主要使用并发mark-sweep算法

CMS GC的设计目标是为了避免在老年代垃圾收集时出现长时间的卡顿，以下两种改进手段：
1. 不对老年代进行整理，而使用空闲列表（free-list）来管理内存空间的回收
2. 在mark-sweep阶段的大部分工作与应用线程一起并发执行

由于老年代内存没有做压缩处理，其内存区域会存在较多碎片。这样当堆内存较大，在给一些较大的对象需要分配空间时，会造成STW暂停时间较长，这是CMS GC的主要缺点。


## G1 GC

全称为：Garbage First。G1 GC 不在划分老年代，而是将堆内存划分为多个小块（通常是2048）: Region。每个小块，可能一会儿被定义成Eden区，一会儿被定义为Survivor区或者Old区。G1 GC 会记录每个小块可以释放的内存空间，在回收时会优先回收能释放较多内存的region，这是它名字的来历。

G1 GC的设计目的是将STW暂停时间和分布变成可预期且可配置。启动时可通过-XX:MaxGCPauseMillis=50来配置GC暂停的时间，G1 GC会调整GC执行的频率和每次回收内存的数量，来达到MaxGCPauseMillis配置的值，便于使用时在吞吐量和延迟时间上找到平衡点。
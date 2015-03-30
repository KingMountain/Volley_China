1:核心是RequestQueue.java, 过程为： new -> add -> start -> cancle

2:new: 2个参数，缓存目录，NetWork对象

3:add: 有一个 HashMap对象：private final Set<Request<?>> mCurrentRequests = new HashSet<Request<?>>(); 用来存储 add进来的所有Request对象
4:start:2个线程: CacheDispatcher.java      NetworkDispatcher.java 
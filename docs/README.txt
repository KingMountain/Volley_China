1:������RequestQueue.java, ����Ϊ�� new -> add -> start -> cancle

2:new: 2������������Ŀ¼��NetWork����

3:add: ��һ�� HashMap����private final Set<Request<?>> mCurrentRequests = new HashSet<Request<?>>(); �����洢 add����������Request����
4:start:2���߳�: CacheDispatcher.java      NetworkDispatcher.java 
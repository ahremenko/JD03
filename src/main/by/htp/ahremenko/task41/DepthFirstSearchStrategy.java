package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearchStrategy<T> implements Strategy<T> {

    private static final DepthFirstSearchStrategy instance = new DepthFirstSearchStrategy();

    @SuppressWarnings( "rawtypes")
    private Map<Class,Object> mapHolder = new HashMap<>();

    private DepthFirstSearchStrategy() {}

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> classOf) throws InstantiationException, IllegalAccessException {

        synchronized(instance){
            if(!instance.mapHolder.containsKey(classOf)){
                T obj = classOf.newInstance();
                instance.mapHolder.put(classOf, obj);
            }
            return (T)instance.mapHolder.get(classOf);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public T next(Deque<TreeNode<T>> stack) {
        TreeNode<T> node = stack.removeFirst();
        T result = node.getValue();
        if (node.getRight() != null) {
            stack.addFirst(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.addFirst(node.getLeft());
        }
        return result;
    }
}

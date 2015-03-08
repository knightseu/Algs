/**
 * 
 */


/**
 * @author xuanlin
 *
 */
public interface Queue<T> {
    public void put(T e);
    public T get();
    public boolean isEmpty();
}

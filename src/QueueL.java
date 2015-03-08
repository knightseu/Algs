/**
 * 
 */


import java.util.LinkedList;

/**
 * @author xuanlin
 *
 */
public class QueueL <T> implements Queue<T> {

	private LinkedList<T> list = new LinkedList<T>();
	@Override
	public void put(T e) {
		list.addFirst(e);
	}

	@Override
	public T get() {
		return list.removeLast();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}

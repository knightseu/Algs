/**
 * 
 */


import java.util.LinkedList;

/**
 * @author xuanlin
 *
 */
public class StackL <T> implements Stack<T> {

	private LinkedList<T> list = new LinkedList<T>();
	@Override
	public T pop() {
		return list.removeFirst();
	}

	@Override
	public void push(T e) {
		list.addFirst(e);
	}

	@Override
	public T top() {
		return list.getFirst();
	}

}

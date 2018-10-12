package 观察者模式;

import java.util.ArrayList;
import java.util.List;

import 观察者模式.实体观察者.Observer;

public class Subject {
	/** Subject 依赖于一个Observer对象组成的List */
	private List<Observer> observers = new ArrayList<>();
	/** int类型的状态变量 */
	private int state;

	public void attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 *  通知所有的观察者更新
	 */
	public void notifyAllObservers() {
		for (Observer o : observers)
			o.update();
	}

	// --------------GET/SET----------------

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
}

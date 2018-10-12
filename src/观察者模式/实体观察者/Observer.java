package 观察者模式.实体观察者;

import 观察者模式.Subject;

public abstract class Observer {

	protected Subject subject;

	public abstract void update();
}

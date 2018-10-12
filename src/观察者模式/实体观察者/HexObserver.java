package 观察者模式.实体观察者;

import 观察者模式.Subject;

public class HexObserver extends Observer {

	public HexObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String : " + Integer.toHexString(subject.getState()).toUpperCase());
	}

}

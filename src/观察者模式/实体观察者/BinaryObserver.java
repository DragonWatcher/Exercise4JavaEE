package 观察者模式.实体观察者;

import 观察者模式.Subject;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String : " + Integer.toBinaryString(subject.getState()));
	}
}

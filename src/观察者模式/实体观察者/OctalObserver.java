package 观察者模式.实体观察者;

import 观察者模式.Subject;

public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal String : " + Integer.toOctalString(subject.getState()));
	}

}

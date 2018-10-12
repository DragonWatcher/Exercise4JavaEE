package 观察者模式.实体观察者;

import 观察者模式.Converter;

public class OctalConverter extends BaseConverter {

	public OctalConverter(Converter subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal String : " + Integer.toOctalString(subject.getState()));
	}

}

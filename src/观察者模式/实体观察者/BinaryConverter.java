package 观察者模式.实体观察者;

import 观察者模式.Converter;

public class BinaryConverter extends BaseConverter {

	public BinaryConverter(Converter subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String : " + Integer.toBinaryString(subject.getState()));
	}
}

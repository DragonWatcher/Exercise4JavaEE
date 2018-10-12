package 观察者模式.实体观察者;

import 观察者模式.Converter;

public class HexConverter extends BaseConverter {

	public HexConverter(Converter subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String : " + Integer.toHexString(subject.getState()).toUpperCase());
	}

}

package 观察者模式.实体观察者;

import 观察者模式.Converter;

public class BinaryConverter extends BaseConverter {

	public BinaryConverter(Converter converter) {
		this.converter = converter;
		this.converter.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String : " + Integer.toBinaryString(converter.getState()));
	}
}

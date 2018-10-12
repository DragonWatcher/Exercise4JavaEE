package 观察者模式.实体观察者;

import 观察者模式.Converter;

public class HexConverter extends BaseConverter {

	public HexConverter(Converter converter) {
		this.converter = converter;
		this.converter.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String : " + Integer.toHexString(converter.getState()).toUpperCase());
	}
}

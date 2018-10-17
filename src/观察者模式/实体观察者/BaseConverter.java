package 观察者模式.实体观察者;

import 观察者模式.Converter;

public abstract class BaseConverter {

	protected Converter converter;

	public abstract void update();
}

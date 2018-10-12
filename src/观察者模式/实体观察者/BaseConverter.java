package 观察者模式.实体观察者;

import 观察者模式.Converter;

public abstract class BaseConverter {

	protected Converter subject;

	public abstract void update();
}

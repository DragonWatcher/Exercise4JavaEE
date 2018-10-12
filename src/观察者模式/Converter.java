package 观察者模式;

import java.util.ArrayList;
import java.util.List;

import 观察者模式.实体观察者.BaseConverter;

public class Converter {
	/** Converter 依赖于一个BaseConverter对象组成的List */
	private List<BaseConverter> baseConverters = new ArrayList<>();
	/** 待转换的十进制数 */
	private int state;

	public void attach(BaseConverter observer) {
		baseConverters.add(observer);
	}

	/**
	 * 通知所有的观察者更新
	 */
	public void notifyAllConverters() {
		for (BaseConverter cvter : baseConverters)
			cvter.update();
	}

	// --------------GET/SET----------------

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllConverters();
	}
}

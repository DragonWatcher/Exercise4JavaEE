package 观察者模式;

import 观察者模式.实体观察者.BinaryConverter;
import 观察者模式.实体观察者.HexConverter;
import 观察者模式.实体观察者.OctalConverter;

/**
 * 观察者模式<br>
 * 当对象间存在一对多关系时，可以使用观察者模式。比如，当一个对象被修改时，则会自动通知它的依赖对象。 观察者属于行为型模式 <br>
 * 类名：ObserverPatternProgram<br>
 * 作者： mht<br>
 * 日期： 2018年10月5日-下午12:11:12<br>
 */
public class ObserverPatternProgram {

	public static void main(String[] args) {
		Converter subject = new Converter();

		new HexConverter(subject);
		new OctalConverter(subject);
		new BinaryConverter(subject);

		System.out.println("First state change : 15");
		subject.setState(15);
		System.out.println("\nSecond state change : 10");
		subject.setState(10);
	}

}

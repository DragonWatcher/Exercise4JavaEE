package 观察者模式;

import 观察者模式.实体观察者.BinaryObserver;
import 观察者模式.实体观察者.HexObserver;
import 观察者模式.实体观察者.OctalObserver;

/**
 * 观察者模式<br>
 * 当对象间存在一对多关系时，可以使用观察者模式。比如，当一个对象被修改时，则会自动通知它的依赖对象。 观察者属于行为型模式 <br>
 * 类名：ObserverPatternProgram<br>
 * 作者： mht<br>
 * 日期： 2018年10月5日-下午12:11:12<br>
 */
public class ObserverPatternProgram {

	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change : 15");
		subject.setState(15);
		System.out.println("Second state change : 10");
		subject.setState(10);
	}

}

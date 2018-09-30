package java.designpattern23.prototype;

public class PrototypePattern{
	public static void main(String[] args) {
		ConcretePrototype c = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype c1 = (ConcretePrototype)c.clone();
			c1.show();
		}
	}
}

class ConcretePrototype extends Prototype{
	public void show(){
		System.out.println("原型模式实现类");
	}
}

class Prototype implements Cloneable{
	Prototype proType = null;

	@Override
	public Prototype clone() {
		try {
			proType = (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return proType;
	}
}

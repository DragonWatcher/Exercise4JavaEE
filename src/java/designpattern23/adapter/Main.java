package java.designpattern23.adapter;

/**
 * 
 * @author mht
 *
 */
public class Main {

	public static void main(String[] args) {
		// 创建一个德国插座对象，用一个德标接口引用他
		DBSocketInterface dbs = new DBSocket();

		// 创建一个旅馆对象
		Hotel hotel = new Hotel(dbs);

		// 在旅店给手机充电
		hotel.charge();

	}

}

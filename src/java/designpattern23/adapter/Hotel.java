package java.designpattern23.adapter;

/**
 * 德国旅店
 * @author mht
 *
 */
public class Hotel {
	/** 
	 * 旅店中有一个德国插口
	 */
	private DBSocketInterface dbSocket;

	public Hotel() {
	}

	public Hotel(DBSocketInterface dbSocket) {
		this.dbSocket = dbSocket;
	}

	public void setSocket(DBSocketInterface dbSocket) {
		this.dbSocket = dbSocket;
	}

	/**
	 * 旅店中的充电功能
	 */
	public void charge() {
		// 使用德标插口充电
		dbSocket.powerWithTwoRound();
	}
}

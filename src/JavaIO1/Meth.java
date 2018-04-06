package JavaIO1;

public class Meth {
	public void chuan(String ip, String cmd, String... port){
		String s = "";
		if(port != null){
			if(port.length != 0){
				s = port[0];
			}
		}
		System.out.println(s);
	}
}

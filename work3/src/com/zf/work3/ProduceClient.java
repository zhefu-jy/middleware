package com.zf.work3;

public class ProduceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		MqClient client = new MqClient();
		while (true){
			client.produce("Hello Java");
			Thread.sleep(50);
			System.out.println("成功发出消息");
		}

	}

}

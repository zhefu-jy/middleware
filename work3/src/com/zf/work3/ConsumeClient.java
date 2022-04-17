package com.zf.work3;

public class ConsumeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MqClient client = new MqClient();
		while (true) {
			String message = client.consume();
			System.out.println("获取的消息为： " + message);
			Thread.sleep(200);
		}
	}

}

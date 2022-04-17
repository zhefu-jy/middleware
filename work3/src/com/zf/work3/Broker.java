package com.zf.work3;

import  java.util.concurrent.ArrayBlockingQueue ;
import java.util.concurrent.BlockingDeque;

public class Broker {
	private  final  static  int  MAX_SIZE  =  3;
	private final  static   int  MAX_STORE_SIZE=10;
	private  static  ArrayBlockingQueue<String>  messageQueue = new ArrayBlockingQueue(MAX_SIZE) ;

	private static ArrayBlockingQueue<String>   blockingDeque=  new  ArrayBlockingQueue(MAX_STORE_SIZE);//消息队列满的话 放这个队列
	
	public  static  void  produce(String  msg){
		if(messageQueue.offer(msg)){
			System.out.println("成功向消息处理中心投递消息："+msg+", 当前暂存的消息数量是： " + messageQueue.size());

		}
		else{
			new Thread(()->{
				tryProduce(msg);
			},"t1").start();

			System.out.println("暂存的消息达到最大负荷，不能继续放入消息！  正在尝试");
		}
		System.out.println("=================");
	}
	
	public  static  String  consume(){
		String msg = messageQueue.poll();
		if(msg!=null){
			System.out.println("已经消费消息： "+ msg +", 当前暂存的消息数量是： "+messageQueue.size());
		}else{
			System.out.println("消息处理中心内没有消息可供消费！");
		}
		System.out.println("=================");
		return msg;
		
	}

	/**
	 * 如果当前队列满了的话  再开辟一个线程  循环100次等待消息被消费
	 * @param msg
	 */
	public  static  void  tryProduce(String msg){
		for (int i = 0; i <10 ; i++) {
			if(messageQueue.size()==MAX_SIZE){
				continue;
			}else{
				messageQueue.offer(msg);
				System.out.println("尝试放入成功");
				break;
			}
		}
		System.out.println("尝试了10次也没成功");
			blockingDeque.offer(msg);
			System.out.println("放入等待队列");
			new Thread(()->{
				messageQueue.offer(msg);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}




	
}

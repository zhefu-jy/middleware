package com.zf.work3;

import  java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class MqClient {

	public static void produce(String message)throws Exception{
		Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
		try{
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			out.println(message);
			out.flush();
			socket.close();}
			
		catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	public static String consume()throws Exception{
		Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		try{
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("CONSUME");
			out.flush();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		String message = in.readLine();
		return message;
	
	}
	

}

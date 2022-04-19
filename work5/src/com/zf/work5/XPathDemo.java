package com.zf.work5;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class XPathDemo{
    private static Document doc;
    private static XPath xpath;
 
    public static void main(String[] args) throws Exception {
        init();
        getFlight();
        beforeTimeFlight();
    }
 
    // 初始化Document、XPath对象
    public static void init() throws Exception {
        // 创建Document对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new FileInputStream(new File("D:\\java\\middleware\\work5\\resources\\FlightINFO.xml")));
 
        // 创建XPath对象
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
    }

   public static void getFlight() throws XPathExpressionException{
       NodeList nodeList=(NodeList) xpath.evaluate("/*/*/leaveairport[text()='北京首都机场']",doc,XPathConstants.NODESET);
       System.out.println("在北京机场起飞的航班信息--------------------------------");
       for (int i = 0; i < nodeList.getLength(); i++) {
           System.out.print(nodeList.item(i).getParentNode().getTextContent());
       }
   }


   public static void  beforeTimeFlight() throws XPathExpressionException{
       NodeList nodeList=(NodeList) xpath.evaluate("/*/*/arrivetime",doc,XPathConstants.NODESET);
       System.out.println("到达时间在10:00之前的----------------------------------------");
       for (int i = 0; i < nodeList.getLength(); i++) {
           String textContent = nodeList.item(i).getTextContent();
           String[] split = textContent.split(":");
           if (Integer.parseInt(split[0])<10){
               System.out.println(nodeList.item(i).getParentNode().getTextContent());
           }
       }
   }

}
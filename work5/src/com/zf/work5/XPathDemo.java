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
 
    // ��ʼ��Document��XPath����
    public static void init() throws Exception {
        // ����Document����
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new FileInputStream(new File("D:\\java\\middleware\\work5\\resources\\FlightINFO.xml")));
 
        // ����XPath����
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
    }

   public static void getFlight() throws XPathExpressionException{
       NodeList nodeList=(NodeList) xpath.evaluate("/*/*/leaveairport[text()='�����׶�����']",doc,XPathConstants.NODESET);
       System.out.println("�ڱ���������ɵĺ�����Ϣ--------------------------------");
       for (int i = 0; i < nodeList.getLength(); i++) {
           System.out.print(nodeList.item(i).getParentNode().getTextContent());
       }
   }


   public static void  beforeTimeFlight() throws XPathExpressionException{
       NodeList nodeList=(NodeList) xpath.evaluate("/*/*/arrivetime",doc,XPathConstants.NODESET);
       System.out.println("����ʱ����10:00֮ǰ��----------------------------------------");
       for (int i = 0; i < nodeList.getLength(); i++) {
           String textContent = nodeList.item(i).getTextContent();
           String[] split = textContent.split(":");
           if (Integer.parseInt(split[0])<10){
               System.out.println(nodeList.item(i).getParentNode().getTextContent());
           }
       }
   }

}
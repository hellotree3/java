package study.sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by �ھӵĶ���
 */
public class MyDefaultHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {

        System.out.println("�ĵ���ʼ��ȡ");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("�ĵ���ȡ���");
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        //�õ���ǰ�������ı�����
        String content = new String(chars,i,i1);
        System.out.println("MyDefaultHandler.characters()-->"+content);
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler.startElement()-->"+s);
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        System.out.println("MyDefaultHandler.endElement()-->"+s);
    }
}

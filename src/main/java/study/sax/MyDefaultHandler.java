package study.sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by 邻居的耳朵
 */
public class MyDefaultHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {

        System.out.println("文档开始读取");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档读取完毕");
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        //得到当前读到的文本内容
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

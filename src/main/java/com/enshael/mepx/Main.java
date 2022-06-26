package com.enshael.mepx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import sun.misc.BASE64Decoder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        ContentHandler handler = new ContentHandler();
        BASE64Decoder decoder = new BASE64Decoder();

        //Add the file to src/resources
        saxParser.parse("src/main/resources/config.xml", handler);

        for (String encodedText : handler.encodedTexts) {
            String decodedText = new String(decoder.decodeBuffer(encodedText));
            System.out.println("=======");
//            System.out.println(decodedText);

            Document doc = Jsoup.parse(decodedText);
            Elements elements = doc.getElementsByTag("span");
            elements.forEach(element -> {
                String text = element.text();
                if (text.length() > 0) {
                    System.out.println(text);
                }
            });
        }
    }
}

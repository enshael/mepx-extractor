package com.enshael.mepx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ContentHandler extends DefaultHandler {
    public static final String ENCODED_TEXT = "encodedText";
    public static final String VALUE = "value";

    List<String> encodedTexts = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName) {
            case ENCODED_TEXT:
                encodedTexts.add(attributes.getValue(VALUE));
        }
    }
}

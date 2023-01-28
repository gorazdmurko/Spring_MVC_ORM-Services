package org.example.spring.springmvcorm.user.parser;

import org.example.spring.springmvcorm.user.entity.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {

    private List<Person> persons = new ArrayList<>();
    private Person person;

    private boolean bfn = false;
    private boolean bln = false;
    private boolean boc = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if ("person".equals(qName)) {

            person = new Person();

            int id = Integer.valueOf(attributes.getValue("id"));
            person.setId(id);
        }

        switch (qName) {

            case "firstname":
                bfn = true;
                break;

            case "lastname":
                bln = true;
                break;

            case "occupation":
                boc = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if ("person".equals(qName)) {
            persons.add(person);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (bfn) {
            person.setFirstName(new String(ch, start, length));
            bfn = false;
        }

        if (bln) {
            person.setLastName(new String(ch, start, length));
            bln = false;
        }

        if (boc) {
            person.setOccupation(new String(ch, start, length));
            boc = false;
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}

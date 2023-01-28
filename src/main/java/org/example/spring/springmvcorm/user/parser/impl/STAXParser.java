package org.example.spring.springmvcorm.user.parser.impl;

import org.example.spring.springmvcorm.user.entity.Person;
import org.example.spring.springmvcorm.user.parser.IStaxParser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;

public class STAXParser implements IStaxParser {

    Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public Person xmlEventReader(InputStream stream) throws IOException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String url = null;
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(stream);
//        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path.toFile()));

        while (reader.hasNext()) {

            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                StartElement element = event.asStartElement();
                switch (element.getName().getLocalPart()) {
                    case "person":
                        Attribute id = element.getAttributeByName(new QName("id"));
                        // System.out.printf("Person id : %s%n", id.getValue());
                        break;
                    case "id":
                        event = reader.nextEvent();
                        int personsId = Integer.parseInt(event.asCharacters().getData());
                        System.out.printf("Person id : %s%n", personsId);
                        person.setId(personsId);
                    case "firstname":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            String firstName = event.asCharacters().getData();
                            System.out.printf("First name : %s%n", firstName);
                            person.setFirstName(firstName);
                        }
                        break;
                    case "lastname":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            String lastName = event.asCharacters().getData();
                            System.out.printf("Last name : %s%n", lastName);
                            person.setLastName(lastName);
                        }
                        break;
                    case "occupation":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            String occupation = event.asCharacters().getData();
                            System.out.printf("Occupation : %s%n", occupation);
                            person.setOccupation(occupation);
                        }
                        break;
                }
            }
        }
        return person;
    }
}

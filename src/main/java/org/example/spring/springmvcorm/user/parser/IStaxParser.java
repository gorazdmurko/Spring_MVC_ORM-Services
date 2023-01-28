package org.example.spring.springmvcorm.user.parser;

import org.example.spring.springmvcorm.user.entity.Person;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

public interface IStaxParser {

    Person xmlEventReader(InputStream inputStream) throws IOException, XMLStreamException;
}

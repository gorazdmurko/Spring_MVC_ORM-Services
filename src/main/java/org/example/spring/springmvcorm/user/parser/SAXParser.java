package org.example.spring.springmvcorm.user.parser;


import org.example.spring.springmvcorm.user.entity.Person;
import org.xml.sax.SAXException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SAXParser {

    private javax.xml.parsers.SAXParser createSaxParser() {

        javax.xml.parsers.SAXParser saxParser = null;

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();

            return saxParser;

        } catch (ParserConfigurationException | SAXException ex) {
            Logger lgr = Logger.getLogger(SAXParser.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return saxParser;
    }

    public List<Person> parseUsers(Path filePath) {

        Handler handler = new Handler();
        // get path of selected file
        String fileName = String.valueOf(filePath);

        File xmlDocument = Paths.get(fileName).toFile();
        System.out.println("\n\nxmlDocument: " + xmlDocument);

        try {

            javax.xml.parsers.SAXParser parser = createSaxParser();
            parser.parse(xmlDocument, handler);         // file, default handler as arguments

        } catch (SAXException | IOException ex) {
            Logger lgr = Logger.getLogger(SAXParser.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return handler.getPersons();
    }
};

package org.example.spring.springmvcorm.user.controller;

import org.example.spring.springmvcorm.user.entity.Person;
import org.example.spring.springmvcorm.user.parser.SAXParser;
import org.example.spring.springmvcorm.user.parser.impl.STAXParser;
import org.example.spring.springmvcorm.user.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping("/form")
@javax.servlet.annotation.MultipartConfig
public class FileUploadController {

    @Autowired
    private IPersonService personService;

    private static final String REDIRECT_TO_MULTIPART_PAGE = "redirect:/form/multipartForm";

    @RequestMapping("/multipartForm")
    public String openMultipartPage() { return "postMultipartPage"; }

    @RequestMapping("/xmlForm")
    public String openXmlContentPage() {
        return "postXmlContentPage";
    }

    @RequestMapping("/uploadForm")
    public String openUploadPage() {
        return "uploadFile";
    }

    // @PostMapping(path = "/uploadMultipart", consumes = "multipart/form-data")
    @RequestMapping(path = "/uploadMultipart", method = RequestMethod.POST)
    public String sendFile(@RequestParam("selectedFile") MultipartFile selectedFile,
                           @ModelAttribute("person") Person person) throws IOException, XMLStreamException {
        // @RequestPart ??

        System.out.println(selectedFile);

        String fileName = selectedFile.getOriginalFilename();
        InputStream inputStream = selectedFile.getInputStream();
        String contentType = selectedFile.getContentType();

        System.out.println("FILENAME: " + fileName);
        System.out.println("STREAM: " + inputStream);
        System.out.println("CONTENT: " + contentType);

        // PARSE
        STAXParser parser = new STAXParser();
        person = parser.xmlEventReader(inputStream);
        // person = parser.getPerson();
        System.out.println(person);

        // SERVICE
        int result = personService.savePerson(person);
        System.out.println("RESULT ID: " + result);

        String redirectPage = REDIRECT_TO_MULTIPART_PAGE;

        return redirectPage;
    }

    // POST has a body
    @RequestMapping(value = "/parseXml", method = RequestMethod.POST, produces = "text/plain")    // , consumes = "multipart/form-data", consumes = "text/plain" method = RequestMethod.GET
    public @ResponseBody
    String parseXml(@RequestBody String content) throws IOException {

        System.out.println("CONTENT\n" + content);

        final String FILE_NAME = "test.xml";

        // WRITE TO a FILE
        FileWriter writer = new FileWriter(FILE_NAME);
        writer.write(String.valueOf(content));  // writer.append("");
        // get absolute path
        File f = new File("test.xml");
        String path = f.getAbsolutePath();
        System.out.println("\n\nPATH of writer: " + path);
        writer.close();

        // READ FROM a FILE
        Path filePath = Path.of(path);
        System.out.println("PATH from reader: " + filePath);
        String result = Files.readString(filePath);
        System.out.println("\n\nRESULT\n" + result);


        // PARSE
        SAXParser parser = new SAXParser();
        List<Person> persons = parser.parseUsers(filePath);
        persons.forEach(System.out::println);

        return result;
    }

}

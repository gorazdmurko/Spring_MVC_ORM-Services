package org.example.spring.springmvcorm.user.controller;

import org.apache.commons.io.IOUtils;
import org.example.spring.springmvcorm.user.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

// https://github.com/TinaXing2012/Spring/tree/master/SpringValidationXML/src/main/java/xing/rujuan
// https://www.youtube.com/watch?v=U5JXDnMJVyo&ab_channel=MissXing
// https://www.youtube.com/watch?v=igEOUWb50l8&ab_channel=SindhiTutorials-English


@Controller
@RequestMapping(value = "/student")
public class StudentUploadController {

    @Autowired
    ServletContext servletContext;

    private String STUDENT_FORM_VIEW = "studentForm";
    private String STUDENT_DETAILS_REDIRECT = "/student/studentDetails";
    private String SUCCESS_VIEW = "success";
    private String ERROR_VIEW = "error";

    // 1
    @RequestMapping(value = "/studentUploadForm", method = RequestMethod.GET)
    public ModelAndView showForm() {
        System.out.println("First controller called");
        return new ModelAndView(STUDENT_FORM_VIEW, "student", new Student   ());
    }

    // 2
    @GetMapping("/addStudent")
    public String getStudentForm(@ModelAttribute("student") Student student, Model model) {
        System.out.println("Second controller called");
        return STUDENT_FORM_VIEW;
    }

    // called by spring form
    @PostMapping(value = "/addStudent")
    public String submit(@ModelAttribute("student") Student student,
                         BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) throws IOException {

        System.out.println("Saving posted user ...");
        if (result.hasErrors()) {
            return ERROR_VIEW;
        }

        MultipartFile multipartFile = student.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        String contentType = multipartFile.getContentType();
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        String stream = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));

        student.setContent(stream);

        System.out.println("Multipart: " + multipartFile);
        System.out.println("FILE NAME: " + fileName);
        System.out.println("INPUT STREAM: " + inputStream);
        System.out.println("CONTENT TYPE: " + contentType);
        System.out.println("BUFFERED IMAGE: " + bufferedImage);
        System.out.println("STUDENT: " + student);
        System.out.println("XML: " + student.getContent());

        redirectAttributes.addFlashAttribute("savedStudent", student);
        return "redirect:" + STUDENT_DETAILS_REDIRECT;

    }

    @GetMapping("/studentDetails")
    public String success() {

        return SUCCESS_VIEW;
    }

    @RequestMapping("/error")
    public String error() {
        return ERROR_VIEW;
    }

    @PostMapping(value = "/submitStudent")
    public String submitStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            return ERROR_VIEW;
        }

        MediaType media = student.getMediaType();
        MultipartFile multipartFile = student.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        String contentType = multipartFile.getContentType();
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        String stream = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));

        student.setContent(stream);

        System.out.println("MediaType: " + media);
        System.out.println("Multipart: " + multipartFile);
        System.out.println("FILE NAME: " + fileName);
        System.out.println("INPUT STREAM: " + inputStream);
        System.out.println("CONTENT TYPE: " + contentType);
        System.out.println("BUFFERED IMAGE: " + bufferedImage);
        System.out.println("STUDENT: " + student);
        System.out.println("XML: " + student.getContent());

        if (multipartFile != null || !multipartFile.isEmpty()) {

//            String filePath = servletContext.getRealPath("/") + "resources\\images\\" + multipartFile.getOriginalFilename();
//            System.out.println("Servlet context: " + filePath);
//            try {
//                multipartFile.transferTo(new File(filePath));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        model.addAttribute("name", student.getName());
        model.addAttribute("id", student.getId());
        model.addAttribute("age", student.getAge());
        model.addAttribute("street", student.getAddress().getStreet());
        model.addAttribute("state", student.getAddress().getState());
        model.addAttribute("zipcode", student.getAddress().getZipcode());
        model.addAttribute("multipart", student.getMultipartFile());
        model.addAttribute("mediaType", student.getMediaType());

        redirectAttributes.addFlashAttribute("savedStudent", student);
        return "redirect:/student/studentDetails";

    }
}


/*



*/
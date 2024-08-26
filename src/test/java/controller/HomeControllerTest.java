package controller;

import com.zemoso.formvalidation.controller.HomeController;
import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @Mock
    private StudentService studentService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private HomeController homeController;

    private Student student;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("Nikhil", "Sharma", "ZEM123", "1234567890", 85.0, 'M', "nikhil@zemoso.com");
    }

    @Test
    public void testHelloWorld() {
        String viewName = homeController.helloWorld(model);
        verify(model, times(1)).addAttribute(eq("student"), any(Student.class));
        assertEquals("studentForm", viewName);
    }


    @Test
    public void testShowStudentList() {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(student));

        String viewName = homeController.showStudentList(model);

        assertEquals("studentList", viewName);
        verify(studentService, times(1)).getAllStudents();
        verify(model, times(1)).addAttribute(eq("students"), anyList());
    }

    @Test
    public void testRedirectToStudentList() {
        String viewName = homeController.redirectToStudentList();
        assertEquals("redirect:/studentList", viewName);
    }
}

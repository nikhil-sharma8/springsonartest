package service;

import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.repository.StudentRepository;
import com.zemoso.formvalidation.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("Nikhil", "Sharma", "ZEM123", "1234567890", 85.5, 'M', "nikhil@zemoso.com");
    }

    @Test
    public void testRegisterStudent() {
        studentService.registerStudent(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(student);

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertEquals(1, result.size());
        assertEquals(student, result.get(0));
        verify(studentRepository, times(1)).findAll();
    }
    

    @Test
    public void testRemoveStudentById() {
        doNothing().when(studentRepository).deleteById("ZEM123");

        studentService.removeStudentById("ZEM123");
        verify(studentRepository, times(1)).deleteById("ZEM123");
    }
}

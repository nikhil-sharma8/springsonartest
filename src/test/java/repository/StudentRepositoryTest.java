package repository;

import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.repository.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Student student = new Student("John", "Doe", "ZEMruis", "9876543210", 75.5, 'M', "john.doe@example.com");
        studentRepository.save(student);

        Student foundStudent = studentRepository.findById("ZEMruis");
        assertNotNull(foundStudent);
        assertEquals("John", foundStudent.getFirstName());
    }

    @Test
    public void testFindAll() {
        List<Student> students = studentRepository.findAll();
        assertEquals(1, students.size());
    }

    @Test
    public void testFindById() {
        Student foundStudent = studentRepository.findById("ZEMrui");
        assertNotNull(foundStudent);
        assertEquals("Nikhil", foundStudent.getFirstName());
    }

    @Test
    public void testDeleteById() {
        studentRepository.deleteById("ZEMruis");
        Student foundStudent = studentRepository.findById("ZEMruis");
        assertNull(foundStudent);
    }
}

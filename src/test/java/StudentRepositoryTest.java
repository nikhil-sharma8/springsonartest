import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepository studentRepository;

    @Before
    public void setUp() {

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

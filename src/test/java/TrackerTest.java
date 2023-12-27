import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.learningProgressTracker.ClassRoom;
import org.learningProgressTracker.Student;
import static org.junit.jupiter.api.Assertions.*;
public class TrackerTest {
    @ParameterizedTest
    @ValueSource(strings = {"Joe.", "-Zizi", "-Joza", "z", "'Miho", "lea-", "l-'", "a-'b"})
    void badFirsName(String input) {
        Student student = new Student();
        assertFalse(student.setFirstName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mih'o", "Joe", "Jo-za", "Zi'zi", "Zi Zi", "le-a"})
    void goodLastName(String input) {
        Student student = new Student();
        assertTrue(student.setFirstName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "jozo.md@mail.edu", "miho@9.1", "korda@gmail.com", "zizi@commentator.best"})
    void goodEMail(String input) {
        Student student = new Student();
        assertTrue(student.setEmail(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "test@tribina", "tribina@tribina@2.3"})
    void badEMail(String input) {
        Student student = new Student();
        assertFalse(student.setEmail(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Miho Topic miho.topic@gmail.com", "Josip Korda josip.korda@tribina.com",
            "Andrija C'mrecnjak cmrecnjak@gmail.com", "Maja Bel 125367at@zzz90.z9",
            "Muhamed Ali test@a1s2f4f7.a1c2c5s4"})
    void goodAddLine(String input) {
        ClassRoom classRoom = new ClassRoom();
        assertTrue(classRoom.addStudent(input));
    }

}

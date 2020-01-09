import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonTest {

    static Person person;

    @BeforeAll
    public static void init() {
        person = new Person("Dombi", "Misi", 30, true, 1);
    }

    @Test
    void testGrow() {
        int initialAge = person.getAge();
        person.grow();
        assertEquals(initialAge + 1, person.getAge());

    }
}

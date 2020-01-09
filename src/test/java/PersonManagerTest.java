import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonManagerTest {

    static PersonManager pm = new PersonManager();

    @BeforeAll
    public static void init() throws FileNotFoundException {
        pm.readPersons("src/main/resources/person.json");
    }

    @Test
    void testReadPersons() throws FileNotFoundException {
        boolean result = pm.readPersons("src/main/resources/person.json");
        assertEquals(result, true);
    }

    @Test
    void testNullPointerExceptionWhenFileIsEmptyAtReadPerson(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            pm.readPersons("src/main/resources/valami.txt");
        });
    }

    @Test
    void testIOExceptionsAtReadPersons() {
        Assertions.assertThrows(IOException.class, () -> {
            pm.readPersons("src/main/resources/class.xl");
        });
    }

    @Test
    void testGrowMale() {
        pm.getPersonList().get(0).setMale(true);
        int initialAge = pm.getPersonList().get(0).getAge();
        pm.growMale();
        int growAge = pm.getPersonList().get(0).getAge();
        assertEquals(initialAge + 1, growAge);
    }

    @Test
    void testSaveToJson() {
        boolean result = pm.saveToJson("src/main/resources/person2.json");
        assertEquals(result, true);
    }

    @Test
    void testOutputFileFormatExtension() {
        boolean result = pm.saveToJson("src/main/resources/person2.jon");
        assertEquals(result, false);
    }

    @Test
    void testSaveToJsonMultipleLinesSaving() throws IOException {
        String path = "src/main/resources/person2.json";
        pm.saveToJson(path);
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int lineCounter = 0;
        while ((st = br.readLine()) != null) {
            lineCounter++;
        }
        System.out.println(lineCounter);
        assertNotEquals(lineCounter, 1);
        assertNotEquals(lineCounter, 0);
    }
}

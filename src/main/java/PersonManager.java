import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PersonManager {

    List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public boolean readPersons(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        personList = Arrays.asList(gson.fromJson(new FileReader(path), Person[].class));
        if (personList.size() > 0) return true;
        return false;
    }

    public void growMale() {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).isMale() == true) {
                personList.get(i).grow();
            }
        }
    }

    public boolean saveToJson(String path) {
        String[] array = path.split("\\.");
        String extension = array[array.length - 1];
        if (!extension.equals("json")) {
            System.out.println("Not Json format.");
            return false;
        }
        Person[] persons = personList.stream().toArray(Person[] ::new);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        try(FileWriter fw = new FileWriter(path)) {
            gson.toJson(persons, fw);
            return true;
        } catch (IOException e) {
            System.out.println("No file");
        }
        return false;
    }
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/person.json";
        String path2 = "src/main/resources/person2.json";
        PersonManager personManager = new PersonManager();
        personManager.readPersons(path);
        System.out.println(personManager.personList);
        personManager.personList.get(0).setMale(true);
        System.out.println(personManager.personList);
        personManager.growMale();
        System.out.println(personManager.personList);
        personManager.saveToJson(path2);
    }

    public static Person readFromJson(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        Person person = gson.fromJson(new FileReader(path), Person.class);
        return person;
    }

    public static Person writeToJson(String path) throws IOException {
        Gson gson = new Gson();
        Person person = new Person("Dombi", "Misi", 30, true, 1);
        try(FileWriter fw = new FileWriter(path)) {
            gson.toJson(person, fw);
        };
        return person;
    }
}

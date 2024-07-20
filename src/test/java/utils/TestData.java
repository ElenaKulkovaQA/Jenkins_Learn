package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TestData {

    Faker faker = new Faker(new Locale("en-US"));

    public String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomNumber(),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            address = getRandomAddres(),
            uploadFile = uploadFile();

    public HashMap<String, String> birthday = getRandomDateAsMapOfStrings();

    HashMap<String, List<String>> statesCities = new HashMap<>();

    {
        statesCities.put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        statesCities.put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
        statesCities.put("Haryana", List.of("Karnal", "Panipat"));
        statesCities.put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
    }

    Map<String, String> stateCityMap = getStateCityMap();

    public String
            state = stateCityMap.get("state"),
            userCity = stateCityMap.get("city");


    String getRandomFirstName() {
        return faker.name().firstName();
    }

    String getRandomLastName() {
        return faker.name().lastName();
    }

    String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    String getRandomNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    String getRandomAddres() {
        return faker.address().fullAddress();
    }

    String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return faker.options().option(gender);
    }

    String getRandomSubject() {
        String[] subject = {"English", "Maths", "Arts", "Hindi", "History"};
        return faker.options().option(subject);
    }

    String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    String uploadFile() {
        return faker.options().option("img.png");
    }


    public HashMap<String, String> getStateCityMap() {
        HashMap<String, String> result = new HashMap<>();

        String stateString = (String) faker.options().option(statesCities.keySet().toArray());

        result.put("state", stateString);

        String cityString = (String) faker.options().option(statesCities.get(stateString).toArray());

        result.put("city", cityString);

        return result;
    }

    public HashMap<String, String> getRandomDateAsMapOfStrings() {
        HashMap<String, String> result = new HashMap<>();

        var generatedDate = faker.date().birthday(18, 70);

        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");

        System.out.println(monthFormatter.format(generatedDate));

        result.put("year", yearFormatter.format(generatedDate));

        result.put("month", monthFormatter.format(generatedDate));

        result.put("day", dayFormatter.format(generatedDate));

        return result;
    }
}

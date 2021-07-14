package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.tests.pages.RegistrationPage;
import qa.guru.tests.utils.RandomUtils;

import java.text.DecimalFormat;

public class TextBoxTestsWithFaker {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    RandomUtils ru = new RandomUtils();
    DecimalFormat dF = new DecimalFormat("00");

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender =  ru.getRandomGender();
    String phone = faker.numerify("79########");
    String day = dF.format(faker.random().nextInt(1, 28));
    String month = ru.getRandomMonth();
    String year = faker.random().nextInt(1900, 2100).toString();
    String subjects = ru.getRandomSubject();
    String hobbies = ru.getRandomHobby();
    String picture = ru.getRandomPicture();
    String adress = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";


    @Test
    void positiveFillTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName).
                typeLastName(lastName).
                typeEmail(email).
                selectGender(gender).
                typePhone(phone).
                setDateOfBirth(day, month, year).
                typeSubjects(subjects).
                typeHobbies(hobbies).
                uploadFile(picture).
                typeAdress(adress).
                selectState(state).
                selectcity(city).submit();
    }

        @Test
        void assertsTest() {
            registrationPage.checkResultsTitle();
            registrationPage.checkResultsValue(firstName + " " + lastName)
                    .checkResultsValue(email)
                    .checkResultsValue(gender)
                    .checkResultsValue(phone)
                    .checkResultsValue(day + " " + month + "," + year)
                    .checkResultsValue(subjects)
                    .checkResultsValue(hobbies)
                    .checkResultsValue(picture)
                    .checkResultsValue(adress)
                    .checkResultsValue(state + " " + city);
            }
}

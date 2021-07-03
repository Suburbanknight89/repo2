package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
        @BeforeAll
        static void setup(){
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.startMaximized = true;
        }

        @Test
    void positiveFillTest() {
            open("/automation-practice-form");
            $(By.cssSelector("#firstName")).setValue("Bogdan");
            $(By.cssSelector("#lastName")).setValue("Shvets");
            $(By.cssSelector("#userEmail")).setValue("Bogdan@mail.ru");
            $(byText("Male")).click();
            $(By.cssSelector("#userNumber")).setValue("7412589632");
            $("#dateOfBirthInput").clear();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("1989");
            $(".react-datepicker__day--028").click();
            $("#subjectsInput").setValue("Maths").pressEnter();
            $("#subjectsInput").setValue("Social Studies").pressEnter();
            $(byText("Music")).click();
            $(byText("Sports")).click();
            $("#uploadPicture").uploadFile(new File("src/main/resources/KNPP1020.970.png"));
            $("#currentAddress").setValue("Moscow region, Kraskovo county");
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Panipat").pressEnter();
            $("#submit").scrollTo();
                $("#submit").click();

                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                $(".table-responsive").shouldHave(text("Bogdan"));
                $(".table-responsive").shouldHave(text("Shvets"));
                $(".table-responsive").shouldHave(text("Bogdan@mail.ru"));
                $(".table-responsive").shouldHave(text("Male"));
                $(".table-responsive").shouldHave(text("7412589632"));
                $(".table-responsive").shouldHave(text("28"));
                $(".table-responsive").shouldHave(text("May"));
                $(".table-responsive").shouldHave(text("1989"));
                $(".table-responsive").shouldHave(text("Maths"));
                $(".table-responsive").shouldHave(text("Social Studies"));
                $(".table-responsive").shouldHave(text("KNPP1020.970.png"));
                $(".table-responsive").shouldHave(text("Moscow region, Kraskovo county"));
                $(".table-responsive").shouldHave(text("Haryana"));
                $(".table-responsive").shouldHave(text("Panipat"));

        }

    }

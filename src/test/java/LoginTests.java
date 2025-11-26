import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {
    @Test
    void successfulLoginTest() {

        open("https://school.qa.guru/cms/system/login?required=true");
        $x("//*[@id=\"xdgetr4926_1_1\"]/div/div[1]/input").setValue("ryolkin90@gmail.com");
        $("[name=password]").setValue("Panisher89").pressEnter();
        $("[class=html-content]").shouldHave(text("Вы авторизованы в этом аккаунте"));
        $(byText("Перейти в аккаунт")).click();
    }

    @Test
    void negativeLoginTest() {

        open("https://school.qa.guru/cms/system/login?required=true");
        $("[name=email]").setValue("ryolkin90@gmail.com");
        $("[name=password]").setValue("qwerty").pressEnter();
        $x("//*[@id=\"xdgetr4464_1_1\"]").shouldHave(text("Неверный пароль"));

    }

    @Test
    void negativeLoginTest2() {

        open("https://school.qa.guru/cms/system/login?required=true");
        $x("//*[@id=\"xdgetr4926_1_1\"]/div/div[1]/input").setValue("").pressEnter();
        $x("//*[@id=\"xdgetr4464_1_1\"]").shouldHave(text("Не заполнено поле E-Mail"));
    }

    @Test
    void negativeLoginTest3() {

        open("https://school.qa.guru/cms/system/login?required=true");
        $x("//*[@id=\"xdgetr4926_1_1\"]/div/div[1]/input").setValue("ryolkin90@gmail.com");
        $x("//*[@id=\"xdgetr4147_1_1\"]/div/div[1]/input").setValue("").pressEnter();
        $x("//*[@id=\"xdgetr4464_1_1\"]").shouldHave(text("Не заполнено поле Пароль"));
    }
}


package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

  @Test
  void shouldFindSelenideRepositoryAtTheTop(){
    //открыть главную страницу
    Selenide.open("https://github.com/");
    //ввести в поле поиска selenide и нажать enter
    $("[placeholder='Search or jump to...']").click();
    $("#query-builder-test").setValue("selenide").pressEnter();
    //кликнуть на первый репозиторий из списка
    $$("[data-testid=results-list] div").first().$("a").click();
    //проверка: заголовок selenide/selenide
    $("#repository-container-header").shouldHave(text("selenide / selenide"));
  }
}

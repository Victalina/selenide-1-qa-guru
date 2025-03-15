package github;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HeaderMenuTest {

  @Test
  void HeaderMenuSolutionsEnterprisesTest(){
    open("https://github.com/");
    $$(".HeaderMenu-nav .HeaderMenu-item .HeaderMenu-link").findBy(text("Solutions")).parent().hover();
    $$(".HeaderMenu-nav .HeaderMenu-item .HeaderMenu-link").findBy(text("Solutions")).parent().$(".HeaderMenu-dropdown").$$(".HeaderMenu-column li a").findBy(text("Enterprises")).click();
    $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
  }
}

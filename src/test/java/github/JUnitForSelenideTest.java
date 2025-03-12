package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitForSelenideTest {

  @Test
    void jUnitShouldBeForSelenideTest(){

      // Откройте страницу Selenide в Github
      open("https://github.com/selenide/selenide");
      // Перейдите в раздел Wiki проекта
      $("nav.js-repo-nav").$("ul").$$("li").findBy(text("Wiki")).click();
      // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
      $("#wiki-pages-box").$("ul").$$("li a").shouldHave(itemWithText("SoftAssertions"));
      // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
      $("#wiki-pages-box .wiki-more-pages-link").$("button").click();
      $("#wiki-pages-box").$("ul").$$("li a").findBy(text("SoftAssertions")).click();
      $("#wiki-content").$("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).$("pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
              "class Tests {\n" +
              "  @Test\n" +
              "  void test() {\n" +
              "    Configuration.assertionMode = SOFT;\n" +
              "    open(\"page.html\");\n" +
              "\n" +
              "    $(\"#first\").should(visible).click();\n" +
              "    $(\"#second\").should(visible).click();\n" +
              "  }\n" +
              "}"));
    }
}


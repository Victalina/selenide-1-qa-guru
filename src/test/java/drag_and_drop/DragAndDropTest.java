package drag_and_drop;


import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

  @BeforeAll
  static void beforeAll(){
   baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
  }
  @AfterEach
  void teardown(){
    closeWebDriver();
  }

  @Test
  void DragAndDropOptionsTest(){

    open(baseUrl);
    actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
    $("#columns").$("div").shouldHave(text("B"));
  }

  @Test
  void DragAndDropDragAndDropTest(){
    open(baseUrl);
    $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
    $("#columns").$("div").shouldHave(text("B"));
  }
}

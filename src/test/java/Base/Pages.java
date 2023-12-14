package Base;
import Pages.DragAndDropPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class Pages extends TestBase{

    public DragAndDropPage dragAndDropPage;

    @BeforeEach
    public void initPages(){
      log.info(">> INITIALIZE PAGES <<");
      dragAndDropPage = new DragAndDropPage(driver);
    }
}

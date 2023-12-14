package Pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Getter
public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(css = "div .ditem"))
    private List<WebElement> elementsInDragZone;

    @FindBy(xpath = "//p[contains(text(), 'drop target')]/..")
    private WebElement dropZone;

    @FindAll(@FindBy(xpath = "//p[contains(text(), 'drop target')]/../div"))
    private List<WebElement> elementsInDropZone;

    public void moveElementToDropZone(WebElement element) {
        int xOffset = 10;
        int yOffset = 0;
        actions.clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .moveToElement(dropZone)
                .release()
                .build()
                .perform();
    }

    public void takeScreenshot(WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destDir = new File("target" + File.separator + "screenshots");
        if (!destDir.exists())
            destDir.mkdirs();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy_HH-mm-ss");
        String timestamp = formatter.format(new Date());

        File destFile = new File(destDir, "screen_" + timestamp + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            log.info("Screenshot saved as: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
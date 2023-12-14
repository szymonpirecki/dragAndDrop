package simpleTests;

import Base.Pages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropTest extends Pages {

    @Test
    public void shouldDragAndDropElementsTest() {
        int numberOfElementsToDrag = dragAndDropPage.getElementsInDragZone().size();
        dragAndDropPage.getElementsInDragZone()
                .forEach(element -> dragAndDropPage.moveElementToDropZone(element));

        int numberOfTransferredElements = dragAndDropPage.getElementsInDropZone().size();

        assertThat(numberOfTransferredElements).isEqualTo(numberOfElementsToDrag);
        dragAndDropPage.takeScreenshot(driver);
    }
}
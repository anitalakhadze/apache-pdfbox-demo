import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ReadText {

    public static void main(String[] args) {
        File loremIpsumFile = new File("src/main/resources/lorem-ipsum.pdf");

        try (PDDocument doc = PDDocument.load(loremIpsumFile)) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(doc);

            System.out.println("Text size: " + text.length() + " characters.\n");
            System.out.println(text);
        } catch (IOException ioException) {
            System.out.println("Handling IOException...");
        }
    }

}

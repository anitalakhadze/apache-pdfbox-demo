import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class CreateImage {

    public static void main(String[] args) {
        try (PDDocument doc = new PDDocument()) {
            PDPage pdPage = new PDPage();
            doc.addPage(pdPage);

            String imgFileName = "src/main/resources/deep_field.jpg";
            PDImageXObject pdImage = PDImageXObject.createFromFile(imgFileName, doc);

            int iw = pdImage.getWidth();
            int ih = pdImage.getHeight();
            float offset = 20f;

            try (PDPageContentStream contentStream = new PDPageContentStream(doc, pdPage)){
                contentStream.drawImage(pdImage, offset, offset, iw, ih);
            }

            doc.save("src/main/resources/deep_field.pdf");
        } catch (IOException ioException) {
            System.out.println("Handling IOException...");
        }
    }

}

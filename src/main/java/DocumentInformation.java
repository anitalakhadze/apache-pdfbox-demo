import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.Calendar;

public class DocumentInformation {

    public static void main(String[] args) {
        try (PDDocument doc = new PDDocument()) {
            PDPage pdPage = new PDPage();
            doc.addPage(pdPage);

            PDDocumentInformation pdi = doc.getDocumentInformation();

            pdi.setAuthor("Ani Talakhadze");
            pdi.setTitle("Apache PDFBox Practice");
            pdi.setCreator("Java Code");

            Calendar date = Calendar.getInstance();
            pdi.setCreationDate(date);
            pdi.setModificationDate(date);

            pdi.setKeywords("Apache, PDF");

            doc.save("src/main/resources/doc_inf.pdf");
        } catch (IOException ioException) {
            System.out.println("Handling IOException...");
        }
    }

}

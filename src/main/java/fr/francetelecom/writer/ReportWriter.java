package fr.francetelecom.writer;

import fr.francetelecom.model.Report;
import java.util.List;
import org.springframework.batch.item.ItemWriter;

/**
 *
 * @author GVLJ3568
 */
public class ReportWriter implements ItemWriter<Report> {

//    private ItemReaderFooter footerCallback;
    @Override
    public void write(List<? extends Report> reports) throws Exception {
        for (Report report : reports) {
            System.out.println(report);

        }
    }

//    public void setFooterCallback(ItemReaderFooter footerCallback) {
//        this.footerCallback = footerCallback;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.francetelecom.callback;

import fr.francetelecom.model.Report;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;

/**
 *
 * @author GVLJ3568
 */
public class ItemReaderFooter implements ItemWriter<Report>,
        FlatFileFooterCallback {

    private ItemWriter<Report> delegate;
    

    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Override
    public void write(List<? extends Report> items) throws Exception {
        BigDecimal chunkTotal = BigDecimal.ZERO;
        for (Report report : items) {
            System.out.println("footer : " + report);
        }

        delegate.write(items);

        // After successfully writing all items
        totalAmount = totalAmount.add(chunkTotal);
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("Total Amount Processed: " + totalAmount);
    }

    public void setDelegate(ItemWriter delegate) {
        this.delegate = delegate;
    }

}

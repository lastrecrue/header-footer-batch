/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.francetelecom.callback;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;

/**
 *
 * @author GVLJ3568
 */
public class ItemReaderHeader implements LineCallbackHandler {

    private DefaultLineMapper lineMapper;

    @Override
    public void handleLine(String string) {
        try {
            Object mapLine = lineMapper.mapLine(string, 1);
            System.out.println("header : " + mapLine);
        } catch (Exception ex) {
            Logger.getLogger(ItemReaderHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public DefaultLineMapper getLineMapper() {
        return lineMapper;
    }

    public void setLineMapper(DefaultLineMapper defaultLineMapper) {
        this.lineMapper = defaultLineMapper;
    }

}

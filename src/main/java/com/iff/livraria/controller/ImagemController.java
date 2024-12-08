
package com.iff.livraria.controller;

import com.iff.livraria.utils.exception.ImageError;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author jao
 */
public class ImagemController {
    private BufferedImage bfImage;
    private File file;
    private Image img;
    
    public ImagemController(File file) throws ImageError, Exception {
        this.file = file;
        this.bfImage = ImageIO.read(file);
    }
    
    public Image converterFileParaJFXImage() throws ImageError, Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bfImage, "png", outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        
        return new Image(inputStream);
    }
    
    public String retornaCaminho(){
        return file.getAbsolutePath();
    }
}

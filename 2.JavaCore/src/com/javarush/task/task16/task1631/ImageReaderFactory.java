package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

public static ImageReader getImageReader(ImageTypes file) throws IllegalArgumentException{
    if (file != null) {
        String name = file.toString();
        if (name.contains(ImageTypes.BMP.toString())) return new BmpReader();
        else if (name.contains(ImageTypes.JPG.toString())) return new JpgReader();
        else if (name.contains(ImageTypes.PNG.toString())) return new PngReader();
        else throw new IllegalArgumentException();
    } else throw new IllegalArgumentException();

}
}

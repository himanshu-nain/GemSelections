package tech.iosd.gemselections.Utils;

import android.graphics.drawable.Drawable;

/**
 * Created by SAM33R on 21-03-2018.
 */

public class Banner {
    Drawable mainImage;
    String name;

    public Banner(Drawable mainImage, String name) {
        this.mainImage = mainImage;
        this.name = name;
    }

    public Banner(){

    }

    public Drawable getMainImage() {
        return mainImage;
    }

    public void setMainImage(Drawable mainImage) {
        this.mainImage = mainImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package tech.iosd.gemselections.MainContent;

import java.util.ArrayList;

import tech.iosd.gemselections.R;

/**
 * Created by kushalgupta on 24/02/18.
 */

public class ModelSarvaManokaamnaPraptiYugalSlider {
    private int sliderImage;


    public int getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(int sliderImage) {
        this.sliderImage = sliderImage;
    }

    public static ArrayList<ModelSarvaManokaamnaPraptiYugalSlider> getObList() {

        ArrayList<ModelSarvaManokaamnaPraptiYugalSlider> dataaList = new ArrayList<>();

        int[] images = getImages();


        for (int i = 0; i<5; i++) {
            ModelSarvaManokaamnaPraptiYugalSlider modelSarvaManokaamnaPraptiYugalSlider=new ModelSarvaManokaamnaPraptiYugalSlider();
            // SkilledModel skilledModel = new SkilledModel();
            modelSarvaManokaamnaPraptiYugalSlider.setSliderImage(images[i]);
            //  professionalModel.setTitle(titles[i]);

            dataaList.add(modelSarvaManokaamnaPraptiYugalSlider);
        }
        return dataaList;
    }

    private static int[] getImages() {

        int[] images = {
                R.drawable.aabhimantarityugal,R.drawable.brudrakshamala,R.drawable.cshivachalisa,R.drawable.dabhimantaritshivaphoto,R.drawable.egulaabittar


        };
     return images;
    }
}

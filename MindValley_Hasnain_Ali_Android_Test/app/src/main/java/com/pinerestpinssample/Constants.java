package com.pinerestpinssample;


public class Constants {

    public static int screenWidth;
    public static int screenHeight;
    public static String socialImagewidth;
    public static String socialImageHeight;

    public static void dimensionReturner(String width, String height) {

        if (Integer.parseInt(width) > Constants.screenWidth) {
            float ratio = Float.parseFloat(width) / Constants.screenWidth;
            float widths = Float.parseFloat(width) / ratio;

            float heights = Float.parseFloat(height) / ratio;
            heights = (float) (heights * 0.9);

            widths = (float) (widths * 0.9);
            int heightss = (int) heights;

            socialImagewidth = "" + Constants.screenWidth;
            socialImageHeight = "" + heightss;


        } else if (Constants.screenWidth >= Float.parseFloat(width)) {
            float ratio = Constants.screenWidth / Float.parseFloat(width);
            float widths = Float.parseFloat(width) * ratio;

            float heights = Float.parseFloat(height) * ratio;
            heights = (float) (heights * 0.9);
            widths = (float) (widths * 0.9);

            int widthss = (int) widths;
            int heightss = (int) heights;

            socialImagewidth = "" + Constants.screenWidth;
            socialImageHeight = "" + heightss;
        }
    }

    public static void dimensionReturner(String width, String height, float percent) {
        if (Integer.parseInt(width) > Constants.screenWidth) {
            float ratio = Float.parseFloat(width) / Constants.screenWidth;
            float widths = Float.parseFloat(width) / ratio;

            float heights = Float.parseFloat(height) / ratio;
            heights = (float) (heights * percent);

            widths = (float) (widths * percent);
            int heightss = (int) heights;

            socialImagewidth = "" + Constants.screenWidth;
            socialImageHeight = "" + heightss;

        } else if (Constants.screenWidth >= Float.parseFloat(width)) {
            float ratio = Constants.screenWidth / Float.parseFloat(width);
            float widths = Float.parseFloat(width) * ratio;

            float heights = Float.parseFloat(height) * ratio;
            heights = (float) (heights * percent);
            widths = (float) (widths * percent);

            int widthss = (int) widths;
            int heightss = (int) heights;

            socialImagewidth = "" + Constants.screenWidth;
            socialImageHeight = "" + heightss;
        }
    }

}

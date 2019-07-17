package matrimonial.assignment.com.matrimonialassignment.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by ubuntu-dev007 on 4/10/17.
 */

public class BitmapOrImageMethods {

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public static Bitmap decodeFromBase64ToBitmap(String encodedImage)

    {

        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;

    }


    public static Bitmap getBitmapFromByteArray(byte[] decodedString)

    {

       // byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;

    }


    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public static String convertToBase64(String imagePath)

    {
        Bitmap bm = BitmapFactory.decodeFile(imagePath);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);

        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return encodedImage;

    }

    public static String convertToBase64(Bitmap imagePath)

    {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        imagePath.compress(Bitmap.CompressFormat.PNG, 100, baos);

        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return encodedImage;

    }


    public static  byte[] decodeFromBase64ToByteArray(String encodedImage)

    {

        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedString;

    }


    public static  byte[] convertFromBitmapToByteArray(Bitmap imagePath)

    {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        imagePath.compress(Bitmap.CompressFormat.PNG, 100, baos);

        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return byteArrayImage;

    }

}

package matrimonial.assignment.com.matrimonialassignment.utils;

import android.app.Activity;
import android.content.DialogInterface;

public class CommonMethods {

    public static void showDialog(final Activity activity, String message, String positiveButtonLabel, String negativeButtonLabel, DialogInterface.OnClickListener possitiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener, boolean cancelable) {

        new android.support.v7.app.AlertDialog.Builder(activity)
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(positiveButtonLabel, possitiveOnClickListener)
                .setNegativeButton(negativeButtonLabel, negativeOnClickListener)
                .show();
    }

}

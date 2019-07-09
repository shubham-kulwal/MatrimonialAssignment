package matrimonial.assignment.com.matrimonialassignment.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import savysoft.accl.utils.NetworkUtil;

public class CommonMethods {

    public static void showDialog(final Activity activity, String message, String positiveButtonLabel, String negativeButtonLabel, DialogInterface.OnClickListener possitiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener, boolean cancelable) {

        new android.support.v7.app.AlertDialog.Builder(activity)
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(positiveButtonLabel, possitiveOnClickListener)
                .setNegativeButton(negativeButtonLabel, negativeOnClickListener)
                .show();
    }

    public static void showInternetConnectionDialog(final Context context, final savysoft.accl.interfaces.InternetConnectionInterface internetConnectionInterface, final int serviceId, boolean isCancelableDialog) {
        try {
            final AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
            final AlertDialog alert2;
            if (!NetworkUtil.isNetworkAvailable(context)) {
                builder2.setMessage(Html.fromHtml("No internet connection, please try again."));
            } else {
                builder2.setMessage(Html.fromHtml("Something went wrong. Please try again later."));
            }
            builder2.setCancelable(isCancelableDialog);
            builder2.setPositiveButton(
                    "Retry",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });

            alert2 = builder2.create();
            alert2.show();
            alert2.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (NetworkUtil.isNetworkAvailable(context)) {
                        alert2.dismiss();
                        internetConnectionInterface.internetConnectionRetryClick(serviceId);
                    } else {
                        alert2.dismiss();
                        internetConnectionInterface.internetConnectionRetryClick(serviceId);
                        Toast.makeText(context, "Please check your internet connection.", Toast.LENGTH_LONG).show();
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

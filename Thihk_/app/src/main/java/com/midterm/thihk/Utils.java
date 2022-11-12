package com.midterm.thihk;

import android.app.AlertDialog;
import android.content.Context;

import com.midterm.thihk.api.PlantApi;
import com.midterm.thihk.api.PlantClient;


public class Utils {

    public static PlantApi getApi() {
        return PlantClient.getPlantClient().create(PlantApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}

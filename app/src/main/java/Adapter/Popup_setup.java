package Adapter;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class Popup_setup extends AppCompatActivity {
    Dialog myDialog;
    public Dialog set(Dialog dialog, int popup) {

        myDialog = dialog;
        myDialog.setContentView(popup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(myDialog.getWindow().getAttributes());
        lp.width = (WindowManager.LayoutParams.MATCH_PARENT);
        lp.height = 1800;
        myDialog.getWindow().setAttributes(lp);
        return myDialog;
    }
}

package Adapter;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.shipper.R;

import java.util.List;

import Enity.order_Demo;

public class popUpAdapter extends AppCompatActivity {
    Dialog myDialog;
    List<order_Demo> takenList;

    public void setDataPopup(int position, List<order_Demo> order_demoList, Dialog dialog) {

        myDialog = dialog;
        takenList = order_demoList;

        //TextView tvLoaixe = myDialog.findViewById(R.id.order_item_loaixe);
        TextView tvDichvu = myDialog.findViewById(R.id.tv_serviceType);
        TextView tvPhiship = myDialog.findViewById(R.id.tv_shipPrice);
        TextView tvPhithuho = myDialog.findViewById(R.id.tv_codPrice);
        TextView tvLoaihang = myDialog.findViewById(R.id.tv_packageType);
        TextView tvKichthuoc = myDialog.findViewById(R.id.tv_packageSize);
        TextView tvCannang = myDialog.findViewById(R.id.tv_packageWeight);

        TextView tvQuaylai = myDialog.findViewById(R.id.tv_goBack);
        TextView tvGiaotantay = myDialog.findViewById(R.id.tv_giveToReceiver);
        TextView tvHotro = myDialog.findViewById(R.id.tv_supportDriver);

        TextView status = myDialog.findViewById(R.id.tv_status);
        TextView note = myDialog.findViewById(R.id.tv_note);

        TextView tvDiemdi = myDialog.findViewById(R.id.tv_startLoca);
        TextView tvDiemđen = myDialog.findViewById(R.id.tv_endLoca);
        TextView tvKhoangcach = myDialog.findViewById(R.id.tv_distance);

        tvDichvu.setText(takenList.get(position).getDichvu());
        tvPhiship.setText(String.valueOf(takenList.get(position).getPhiship()));
        tvPhithuho.setText(String.valueOf(takenList.get(position).getPhithuho()));
        tvLoaihang.setText(takenList.get(position).getLoaihang());
        tvKichthuoc.setText(String.valueOf(takenList.get(position).getKichthuoc1())+" - "+String.valueOf(takenList.get(position).getKichthuoc2()));
        tvCannang.setText(String.valueOf(takenList.get(position).getCannang()));
        note.setText(takenList.get(position).getNote());

        tvDiemdi.setText(takenList.get(position).getDiemdi());
        tvDiemđen.setText(takenList.get(position).getDiemden());
        tvKhoangcach.setText(String.valueOf(takenList.get(position).getKhoangcach()));


        if(takenList.get(position).isQuaylai() == true) {
            tvQuaylai.setText("Có");
        }else {
            tvQuaylai.setText("Không");
        }
        if(takenList.get(position).isGiaotantay() == true) {
            tvGiaotantay.setText("Có");
        }else {
            tvGiaotantay.setText("Không");
        }
        if(takenList.get(position).isHotrotaixe() == true) {
            tvHotro.setText("Có");
        }else {
            tvHotro.setText("Không");
        }

        if(takenList.get(position).getStatus() == 0) {
            status.setText("Đang chờ");
        }
        if(takenList.get(position).getStatus() == 1) {
            status.setText("Chờ lấy hàng");
        }
        if(takenList.get(position).getStatus() == 2) {
            status.setText("Đang giao");
        }
        if(takenList.get(position).getStatus() == 3) {
            status.setText("Đã hoàn thành");
        }
        if(takenList.get(position).getStatus() == 3) {
            status.setText("Đã hủy");
        }
        myDialog.show();

    }
}

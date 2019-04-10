package com.example.shipper;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.OrderListAdapter;
import Adapter.Popup_setup;
import Enity.order_Demo;

public class Shipper_home extends AppCompatActivity {

    Dialog myDialog;

    private ListView listView;
    private OrderListAdapter orderListAdapter;
    private List<order_Demo> orderDemoList;

    Popup_setup popupSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipper_home);
        listView = findViewById(R.id.shipper_listview);
        orderDemoList = new ArrayList<>();
        myDialog = new Dialog(this);
        popupSetup = new Popup_setup();


        orderDemoList.add(new order_Demo("Xe máy", 50000, 7.2, "Ben xe My Dinh", "Ben xe giap bat"));
        orderDemoList.add(new order_Demo("Xe máy", 60000, 8.3, "WheyStore Cau Giay", "Kangnam"));
        orderDemoList.add(new order_Demo("O to", 200000, 5, "The Garden", "Nguyen Ngoc Vu"));
        orderDemoList.add(new order_Demo("Xe máy", 150000, 25, "Ben xe My Dinh", "Dai hoc FPT"));
        orderDemoList.add(new order_Demo("Xe máy", 60000, 8.3, "WheyStore Cau Giay", "Kangnam"));
        orderDemoList.add(new order_Demo("O to", 200000, 5, "The Garden", "Nguyen Ngoc Vu"));
        orderDemoList.add(new order_Demo("Xe máy", 150000, 25, "Ben xe My Dinh", "Dai hoc FPT"));

        orderListAdapter = new OrderListAdapter(getApplicationContext(), orderDemoList);
        listView.setAdapter(orderListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                myDialog = popupSetup.set(myDialog, R.layout.shipper_popup_delivery);
                myDialog.setContentView(R.layout.shipper_popup_delivery);
                myDialog.show();
                LinearLayout back = myDialog.findViewById(R.id.btn_back_popupDelivery);
                btnBackClick(back);
                LinearLayout giaongay = myDialog.findViewById(R.id.btn_giaongay_delivery);
                btnGiaoNgay(giaongay);
            }
        });
    }

    public void btnBackClick(LinearLayout button) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

//        giaongay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Nhan don thanh cong", Toast.LENGTH_SHORT).show();
//                myDialog.dismiss();
//            }
//        });
    }
    public void btnGiaoNgay(LinearLayout button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Nhan giao thanh cong", Toast.LENGTH_SHORT).show();
                myDialog.dismiss();
            }
        });
    }

}

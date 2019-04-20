package com.example.shipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Shipper_Profile extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btn_home;
    private LinearLayout btn_takenOrder;
    private LinearLayout btn_deliveringOrder;
    private LinearLayout btn_shipperHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipper__profile);

        btn_home = findViewById(R.id.btn_shipper_home);
        btn_takenOrder = findViewById(R.id.btn_shipper_takenOrder);
        btn_deliveringOrder = findViewById(R.id.btn_deliveringOrder);
        btn_shipperHistory = findViewById(R.id.btn_shipper_history);

//        btn_takenOrder.setOnClickListener(this);
//        btn_deliveringOrder.setOnClickListener(this);
//        btn_shipperHistory.setOnClickListener(this);
//        btn_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent intent;
//        switch (v.getId()) {
//            case R.id.btn_shipper_takenOrder:
//                intent = new Intent(Shipper_Profile.this, Shipper_TakeOrder.class);
//                startActivity(intent);
//                break;
//            case R.id.btn_deliveringOrder:
//                intent = new Intent(Shipper_Profile.this, Shipper_DeliveryOrder.class);
//                startActivity(intent);
//                break;
//            case R.id.btn_shipper_history:
//                intent = new Intent(Shipper_Profile.this, Shipper_History.class);
//                startActivity(intent);
//                break;
//            case R.id.btn_shipper_home:
//                intent = new Intent(Shipper_Profile.this, Shipper_home.class);
//                startActivity(intent);
//                break;
//        }
    }
}

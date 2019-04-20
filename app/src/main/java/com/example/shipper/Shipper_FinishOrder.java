package com.example.shipper;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import Adapter.OrderListAdapter;
import Adapter.PopUpAdapter;
import Adapter.Popup_setup;
import Enity.order_Demo;

public class Shipper_FinishOrder extends AppCompatActivity implements View.OnClickListener {

    Dialog myDialog;

    final List<order_Demo> showlist2 = new ArrayList<>();

    private ListView listView;
    private OrderListAdapter orderListAdapter;
    private PopUpAdapter popUpAdapter;
    private List<order_Demo> orderDemoList;
    private List<order_Demo> takenList;
    private Popup_setup popupSetup;
    private MaterialSearchView materialSearchView;

    private LinearLayout btn_home;
    //private LinearLayout btn_deliveringOrder;
    private LinearLayout btn_shipperHistory;
    private LinearLayout btn_shipperProfile;
    private LinearLayout btnBAck;
    private LinearLayout btn_deliver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipper__taken_order);

        popUpAdapter = new PopUpAdapter();
        popupSetup = new Popup_setup();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tìm đơn");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        materialSearchView = findViewById(R.id.search_view);

        btn_home = findViewById(R.id.btn_shipper_home);
        //btn_deliveringOrder = findViewById(R.id.btn_deliveringOrder);
        btn_shipperHistory = findViewById(R.id.btn_shipper_history);
        btn_shipperProfile = findViewById(R.id.btn_shipper_profile);
        btnBAck = findViewById(R.id.btn_back);

        listView = findViewById(R.id.listView);

        orderDemoList = new ArrayList<>();
        myDialog = new Dialog(this);
        //popupSetup = new Popup_setup();
        dataSample();

        takenList = new ArrayList<>();
        for(int i = 0; i < orderDemoList.size(); i++ ) {
            if(orderDemoList.get(i).getStatus() == 1) {
                takenList.add(orderDemoList.get(i));
            }
        }
        if(takenList != null) {
            orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
        }

        listView.setAdapter(orderListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myDialog = popupSetup.set(myDialog, R.layout.shipper_popup_finishorder);
                myDialog.setContentView(R.layout.shipper_popup_finishorder);
                //myDialog.show();
                //popUpAdapter.setDataPopup(position, takenList, myDialog);
                listItemClick(position);
            }
        });


        search();
        btnBAck.setOnClickListener(this);
        btn_home.setOnClickListener(this);
        //btn_deliveringOrder.setOnClickListener(this);
        btn_shipperHistory.setOnClickListener(this);
        btn_shipperProfile.setOnClickListener(this);
    }

    public void listItemClick(int position) {

        TextView tvLoaixe = myDialog.findViewById(R.id.order_item_loaixe);
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
        //tvLoaihang.setText("");
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

        LinearLayout back = myDialog.findViewById(R.id.btn_back);
        btnBackClick(back);
        LinearLayout giaongay = myDialog.findViewById(R.id.btn_deliver);
        btnGiaoHang(giaongay);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(this, Shipper_DeliveryOrder.class);
//        startActivity(intent);
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_shipper_home:
                intent = new Intent(Shipper_FinishOrder.this, Shipper_home.class);
                startActivity(intent);
                break;
            case R.id.btn_deliveringOrder:
                intent = new Intent(Shipper_FinishOrder.this, Shipper_DeliveryOrder.class);
                startActivity(intent);
                break;
            case R.id.btn_shipper_history:
                intent = new Intent(Shipper_FinishOrder.this, Shipper_History.class);
                startActivity(intent);
                break;
            case R.id.btn_shipper_profile:
                intent = new Intent(Shipper_FinishOrder.this, Shipper_Profile.class);
                startActivity(intent);
                break;
            case R.id.btn_back:
                intent = new Intent(Shipper_FinishOrder.this, Shipper_home.class);
                startActivity(intent);
                break;
            case  R.id.search_view:

                break;

        }
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

    public void btnGiaoHang(LinearLayout button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Dang giao don hang", Toast.LENGTH_SHORT).show();
                myDialog.dismiss();
            }
        });
    }

    public void search() {
        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                listView = findViewById(R.id.listView);
                orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist2);
                listView.setAdapter(orderListAdapter);
            }

            @Override
            public void onSearchViewClosed() {
                listView = findViewById(R.id.listView);
                orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
                listView.setAdapter(orderListAdapter);
            }
        });

        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null && !query.isEmpty()) {
                    List<order_Demo> showlist = new ArrayList<>();
                    for (int i = 0; i < takenList.size(); i++) {
                        if (takenList.get(i).getLoaixe().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                        }
                        if (orderDemoList.get(i).getDiemdi().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                        }
                        if (orderDemoList.get(i).getDiemden().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                        }
                    }
                    listView = findViewById(R.id.listView);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist);
                    listView.setAdapter(orderListAdapter);

                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()) {
                    List<order_Demo> showlist = new ArrayList<>();
                    for (int i = 0; i < takenList.size(); i++) {
                        if (takenList.get(i).getLoaixe().toLowerCase().contains(newText.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                        }
                        if (takenList.get(i).getDiemdi().toLowerCase().contains(newText.toLowerCase())) {
                            showlist.add(takenList.get(i));
                        }
                        if (takenList.get(i).getDiemden().toLowerCase().contains(newText.toLowerCase())) {
                            showlist.add(takenList.get(i));
                        }
                    }
                    listView = findViewById(R.id.listView);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist);
                    listView.setAdapter(orderListAdapter);
                } else {
                    listView = findViewById(R.id.listView);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);

                    listView.setAdapter(orderListAdapter);
                }
                return true;
            }
        });
    }

    public void dataSample() {
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 0, "", "Ben xe my dinh", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Túi giữ nhiệt", 80000, 10000, "Đồ ăn", 35, 50, 6, false, true, true, 0, "", "Ben xe my dinh", "Ben xe nuoc ngam", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ điện tử", 30, 50, 3, false, true, true, 1, "", "Wheystore Cau giay", "KangNam", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ dễ vỡ", 30, 50, 3, false, true, true, 1, "", "The Garden", "CGV Nguyen chi thanh", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ ăn", 30, 50, 3, false, true, true, 2, "", "Royal city", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 2, "", "Times City", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 1, "", "DH bach khoa", "DH Ngoai thuong", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ điện tử", 30, 50, 3, false, true, true, 0, "", "Trung tam hoi nghi quoc gia", "Ben xe My dinh", 10));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        materialSearchView.setMenuItem(menuItem);
        return true;
    }
}

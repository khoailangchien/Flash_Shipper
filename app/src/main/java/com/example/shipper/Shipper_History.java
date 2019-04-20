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

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import Adapter.OrderListAdapter;
import Adapter.Popup_setup;
import Enity.order_Demo;

public class Shipper_History extends AppCompatActivity implements View.OnClickListener {

    Dialog myDialog;

    final List<order_Demo> showlist2 = new ArrayList<>();

    private ListView listView;
    private OrderListAdapter orderListAdapter;
    private List<order_Demo> orderDemoList;
    private List<order_Demo> takenList;
    private Popup_setup popupSetup;
    private MaterialSearchView materialSearchView;


    private LinearLayout btn_home;
    private LinearLayout btn_takenOrder;
    private LinearLayout btn_deliveringOrder;
    private LinearLayout btn_shipperProfile;
    private LinearLayout btn_showAll;
    private LinearLayout btn_showTaken;
    private LinearLayout btn_showDelivering;
    private LinearLayout btn_showFinished;
    private LinearLayout btn_showCanceled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipper_history);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tìm đơn");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        materialSearchView = findViewById(R.id.search_view);
        takenList = new ArrayList<>();

        btn_home = findViewById(R.id.btn_shipper_home);
        btn_takenOrder = findViewById(R.id.btn_shipper_takenOrder);
        btn_deliveringOrder = findViewById(R.id.btn_deliveringOrder);
        btn_shipperProfile = findViewById(R.id.btn_shipper_profile);
        btn_showAll = findViewById(R.id.btn_show_allorder);
        btn_showTaken = findViewById(R.id.btn_show_takenorder);
        btn_showDelivering = findViewById(R.id.btn_show_deliveringorder);
        btn_showFinished = findViewById(R.id.btn_show_finishorder);
        btn_showCanceled = findViewById(R.id.btn_show_cancelorder);

        listView = findViewById(R.id.listView);

        orderDemoList = new ArrayList<>();
        myDialog = new Dialog(this);
        //popupSetup = new Popup_setup();
        dataSample();

        btn_showAll.setBackgroundColor(Color.parseColor("#F0ECEC"));
        orderListAdapter = new OrderListAdapter(getApplicationContext(), orderDemoList);
        listView.setAdapter(orderListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                myDialog = popupSetup.set(myDialog, R.layout.shipper_popup_finishorder);
//                myDialog.setContentView(R.layout.shipper_popup_finishorder);
//                myDialog.show();
//                LinearLayout back = myDialog.findViewById(R.id.btn_back_popupDelivery);
//                btnBackClick(back);
//                LinearLayout giaongay = myDialog.findViewById(R.id.btn_giaongay_delivery);
//                btnGiaoNgay(giaongay);
            }
        });

        search();

        btn_takenOrder.setOnClickListener(this);
        btn_deliveringOrder.setOnClickListener(this);
        btn_home.setOnClickListener(this);
        btn_shipperProfile.setOnClickListener(this);
        btn_showAll.setOnClickListener(this);
        btn_showTaken.setOnClickListener(this);
        btn_showDelivering.setOnClickListener(this);
        btn_showFinished.setOnClickListener(this);
    }

    public void setListView() {

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_shipper_takenOrder:
                intent = new Intent(Shipper_History.this, Shipper_TakeOrder.class);
                startActivity(intent);
                break;
            case R.id.btn_deliveringOrder:
                intent = new Intent(Shipper_History.this, Shipper_DeliveryOrder.class);
                startActivity(intent);
                break;
            case R.id.btn_shipper_home:
                intent = new Intent(Shipper_History.this, Shipper_home.class);
                startActivity(intent);
                break;
            case R.id.btn_shipper_profile:
                intent = new Intent(Shipper_History.this, Shipper_Profile.class);
                startActivity(intent);
                break;
            case R.id.btn_show_allorder:
                btn_showAll.setBackgroundColor(Color.parseColor("#F0ECEC"));
                btn_showTaken.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_showDelivering.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_showFinished.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_showCanceled.setBackgroundColor(Color.parseColor("#FFFFFF"));
                takenList.addAll(orderDemoList);
                orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
                listView.setAdapter(orderListAdapter);
                break;
            case R.id.btn_show_takenorder:
                takenList = new ArrayList<>();
                for(int i = 0; i < orderDemoList.size(); i++ ) {
                    if(orderDemoList.get(i).getStatus() == 1) {
                        takenList.add(orderDemoList.get(i));
                    }
                }
                if(takenList != null) {
                    btn_showAll.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showTaken.setBackgroundColor(Color.parseColor("#F0ECEC"));
                    btn_showDelivering.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showFinished.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showCanceled.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
                    listView.setAdapter(orderListAdapter);
                }
                break;
            case R.id.btn_show_deliveringorder:
                takenList = new ArrayList<>();
                for(int i = 0; i < orderDemoList.size(); i++ ) {
                    if(orderDemoList.get(i).getStatus() == 2) {
                        takenList.add(orderDemoList.get(i));
                    }
                }
                if(takenList != null) {
                    btn_showAll.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showTaken.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showDelivering.setBackgroundColor(Color.parseColor("#F0ECEC"));
                    btn_showFinished.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showCanceled.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
                    listView.setAdapter(orderListAdapter);
                }
                break;
            case R.id.btn_show_finishorder:
                takenList = new ArrayList<>();
                for(int i = 0; i < orderDemoList.size(); i++ ) {
                    if(orderDemoList.get(i).getStatus() == 3) {
                        takenList.add(orderDemoList.get(i));
                    }
                }
                if(takenList != null) {
                    btn_showAll.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showTaken.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showDelivering.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_showFinished.setBackgroundColor(Color.parseColor("#F0ECEC"));
                    btn_showCanceled.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    orderListAdapter = new OrderListAdapter(getApplicationContext(), takenList);
                    listView.setAdapter(orderListAdapter);
                }
                break;
        }
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
                            showlist2.add(takenList.get(i));
                            showlist.add(takenList.get(i));
                        }
                        if (takenList.get(i).getDiemdi().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(takenList.get(i));
                            showlist2.add(takenList.get(i));
                        }
                        if (takenList.get(i).getDiemden().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(takenList.get(i));
                            showlist2.add(takenList.get(i));
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
                            showlist.add(takenList.get(i));
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

package com.example.shipper;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import Adapter.OrderListAdapter;
import Adapter.Popup_setup;
import Enity.order_Demo;

public class Search_demo extends AppCompatActivity {

    MaterialSearchView materialSearchView;

    Dialog myDialog;
    private ListView listView;
    private OrderListAdapter orderListAdapter;
    private List<order_Demo> orderDemoList;
    private Popup_setup popupSetup;
    final List<order_Demo> showlist2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_demo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tìm đơn");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        materialSearchView = findViewById(R.id.search_view);
        dataSample();


        myDialog = new Dialog(this);
        //popupSetup = new Popup_setup();
        search();

//        orderListAdapter = new OrderListAdapter(getApplicationContext(), orderDemoList);
//
//        listView.setAdapter(orderListAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                myDialog = popupSetup.set(myDialog, R.layout.shipper_popup_delivery);
//                myDialog.setContentView(R.layout.shipper_popup_delivery);
//                myDialog.show();
//                LinearLayout back = myDialog.findViewById(R.id.btn_back_popupDelivery);
////                btnBackClick(back);
////                LinearLayout giaongay = myDialog.findViewById(R.id.btn_giaongay_delivery);
////                btnGiaoNgay(giaongay);
//            }
//        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        materialSearchView.setMenuItem(menuItem);
        return true;
    }

    public void search() {
        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                listView = findViewById(R.id.shipper_listview_SearchDEMO);
                orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist2);
                listView.setAdapter(orderListAdapter);
            }

            @Override
            public void onSearchViewClosed() {
                listView = findViewById(R.id.shipper_listview_SearchDEMO);
                orderListAdapter = new OrderListAdapter(getApplicationContext(), orderDemoList);
                listView.setAdapter(orderListAdapter);
            }
        });

        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null && !query.isEmpty()) {
                    List<order_Demo> showlist = new ArrayList<>();
                    for (int i = 0; i < orderDemoList.size(); i++) {
                        if (orderDemoList.get(i).getLoaixe().toLowerCase().contains(query.toLowerCase())) {
                            showlist2.add(orderDemoList.get(i));
                            showlist.add(orderDemoList.get(i));
                        }
                        if (orderDemoList.get(i).getDiemdi().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                            showlist2.add(orderDemoList.get(i));
                        }
                        if (orderDemoList.get(i).getDiemden().toLowerCase().contains(query.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                            showlist2.add(orderDemoList.get(i));
                        }
                    }
                    listView = findViewById(R.id.shipper_listview_SearchDEMO);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist);
                    listView.setAdapter(orderListAdapter);

                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()) {
                    List<order_Demo> showlist = new ArrayList<>();
                    for (int i = 0; i < orderDemoList.size(); i++) {
//                        if (orderDemoList.get(i).getLoaixe().contains(newText)) {
//                            showlist.add(orderDemoList.get(i));
//                        }
                        if (orderDemoList.get(i).getDiemdi().toLowerCase().contains(newText.toLowerCase())) {
                            showlist.add(orderDemoList.get(i));
                        }
//                        if (orderDemoList.get(i).getDiemden().contains(newText)) {
//                            showlist.add(orderDemoList.get(i));
//                        }
                    }
                    listView = findViewById(R.id.shipper_listview_SearchDEMO);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), showlist);
                    listView.setAdapter(orderListAdapter);
                } else {
                    listView = findViewById(R.id.shipper_listview_SearchDEMO);
                    orderListAdapter = new OrderListAdapter(getApplicationContext(), orderDemoList);

                    listView.setAdapter(orderListAdapter);
                }
                return true;
            }
        });
    }

    public void dataSample() {
        orderDemoList = new ArrayList<>();
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 0, "", "Ben xe my dinh", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Túi giữ nhiệt", 80000, 10000, "Đồ ăn", 35, 50, 6, false, true, true, 0, "", "Ben xe my dinh", "Ben xe nuoc ngam", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ điện tử", 30, 50, 3, false, true, true, 1, "", "Wheystore Cau giay", "KangNam", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ dễ vỡ", 30, 50, 3, false, true, true, 1, "", "The Garden", "CGV Nguyen chi thanh", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ ăn", 30, 50, 3, false, true, true, 2, "", "Royal city", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 2, "", "Times City", "Ben xe giap bat", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Quần áo", 30, 50, 3, false, true, true, 1, "", "DH bach khoa", "DH Ngoai thuong", 10));
        orderDemoList.add(new order_Demo("Xe máy", "Siêu Tốc", 100000, 10000, "Đồ điện tử", 30, 50, 3, false, true, true, 0, "", "Trung tam hoi nghi quoc gia", "Ben xe My dinh", 10));

    }
}

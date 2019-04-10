package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shipper.R;

import java.util.List;

import Enity.order_Demo;

public class OrderListAdapter extends BaseAdapter {

    private Context context;
    private List<order_Demo> orderDemoList;


    public OrderListAdapter(Context context, List<order_Demo> orderDemoList) {
        this.context = context;
        this.orderDemoList = orderDemoList;
    }

    @Override
    public int getCount() {
        return orderDemoList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDemoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.shipper_orderlist_item, null);
        TextView tvLoaixe = view.findViewById(R.id.order_item_loaixe);
        TextView tvGia = view.findViewById(R.id.order_item_gia);
        TextView tvKhoangcach = view.findViewById(R.id.order_item_khoangcach);
        TextView tvDiemdi = view.findViewById(R.id.order_item_diemdi);
        TextView tvDiemđen = view.findViewById(R.id.order_item_diemden);

        tvLoaixe.setText(orderDemoList.get(position).getLoaixe());
        tvGia.setText(String.valueOf(orderDemoList.get(position).getGia()));
        tvKhoangcach.setText(String.valueOf(orderDemoList.get(position).getKhoangcach()));
        tvDiemdi.setText(orderDemoList.get(position).getDiemdi());
        tvDiemđen.setText(orderDemoList.get(position).getDiemden());

        return view;

    }
}

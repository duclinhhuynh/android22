package admin.example.pheptinh_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterTacGia extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TacGia> arraylist;

    public AdapterTacGia(Context context, int layout, List<TacGia> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        TacGia phepTinh = arraylist.get(i); // trả về từng vị trí phép tính

        TextView textView1 = view.findViewById(R.id.name);
        TextView textView2 = view.findViewById(R.id.mota);
        ImageView imgV = view.findViewById(R.id.image);

        textView1.setText(phepTinh.getTen());
        textView2.setText(phepTinh.getMota());
        imgV.setImageResource(phepTinh.getHinh());
        return view;
    }

}


package admin.example.sytheticapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Food> foodsList;

    public FoodAdapter(Context context, int layout, List<Food> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        // ánh xạ view
        TextView txtName = (TextView)  view.findViewById(R.id.Name);
        TextView txtDetail = (TextView) view.findViewById(R.id.Detail);
        ImageView imgShape = (ImageView) view.findViewById(R.id.imgShape);
        // gán giá trị
        Food foods = foodsList.get(i);
        txtName.setText(foods.getName());
        txtDetail.setText(foods.getDetail());
        imgShape.setImageResource(foods.getShape());
        return view;
    }

}

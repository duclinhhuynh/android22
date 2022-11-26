package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import Domain.FoodDomain;
import Helper.ManagementCart;
import Interface.ChangeNumberItemListener;
import admin.example.sytheticapp.R;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<FoodDomain> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(ArrayList<FoodDomain> listFoodSelected, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.listFoodSelected = listFoodSelected;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }
// er
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(inflate);
    }

    //fix er
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText("$" + (listFoodSelected.get(position).getFee()));
        holder.TotalEachItem.setText("$" + (Math.round(listFoodSelected.get(position).getNumberInCart() * listFoodSelected.get(holder.getAdapterPosition()).getFee()) * 100) / 100);
        holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumberInCart()));

        int drawbleResounrceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(holder.getAdapterPosition()).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawbleResounrceId)
                .into(holder.pic);


        holder.minusItem.setOnClickListener(view -> managementCart.minusNumberFood(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListener.changed();
        }));
        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberFood(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListener.changed();
        }));
    }

    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView TotalEachItem, num;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.picCart);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            TotalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem= itemView.findViewById(R.id.plusbtn);
            minusItem = itemView.findViewById(R.id.minusItem);
            num = itemView.findViewById(R.id.numberOrderTxt);
        }

    }

}

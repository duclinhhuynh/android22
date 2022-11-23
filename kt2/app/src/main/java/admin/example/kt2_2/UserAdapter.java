package admin.example.kt2_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

        private List<User> mlistUsers;
        private IClickListener mIclickListener;

        public interface IClickListener{
            void onClickDeleteItem(User user);
        }
        public UserAdapter(List<User> mlistUsers, IClickListener listener) {
            this.mlistUsers = mlistUsers;
//            this.mIclickListener = listener;

        }

        @NonNull
        @Override
        public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);


            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            User user = mlistUsers.get(position);
            if(user == null)
                return;
            holder.tvId.setText("ID:" + user.getId());
            holder.tvName.setText("Name:" + user.getName());
            holder.btnD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIclickListener.onClickDeleteItem(user);
                }
            });
        }

        @Override
        public int getItemCount() {
            if(mlistUsers != null){
                return mlistUsers.size();
            }
            return 0;
        }

        public class UserViewHolder extends RecyclerView.ViewHolder {

            private TextView tvId;
            private TextView tvName;
            private Button btnD;

            public UserViewHolder(@NonNull View itemView) {
                super(itemView);
                tvId = itemView.findViewById(R.id.tv_id);
                tvName = itemView.findViewById(R.id.tv_name);
                btnD = itemView.findViewById(R.id.btn_D);
            }

        }


    }

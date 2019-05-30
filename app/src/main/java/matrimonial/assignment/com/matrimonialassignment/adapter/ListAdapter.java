package matrimonial.assignment.com.matrimonialassignment.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.callbacks.OnItemClickListener;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<DataResponse> dataResponse;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, dob, age, contact, address;
        CircleImageView profile_image;
        CardView cardLayout;
        ImageView favourite_iv;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            dob = (TextView) view.findViewById(R.id.dob);
            contact = (TextView) view.findViewById(R.id.contact);
            age = (TextView) view.findViewById(R.id.age);
            address = (TextView) view.findViewById(R.id.address);
            profile_image = (CircleImageView) view.findViewById(R.id.profile_image);
            cardLayout = view.findViewById(R.id.cardLayout);
            favourite_iv = view.findViewById(R.id.favourite_iv);
        }
    }


    public ListAdapter(Context context, List<DataResponse> dataResponse, OnItemClickListener onItemClickListener) {
        this.dataResponse = dataResponse;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final DataResponse dataResp = dataResponse.get(position);
        holder.name.setText("Name: " + dataResp.getFirstName() + " " + dataResp.getMName() + " " + dataResp.getLName());
        holder.contact.setText("Contact: " + dataResp.getMobileNo());
        holder.age.setText("Age: " + dataResp.getAge() + "");
        //  holder.dob.setText("Birth Date: "+dataResp.getDateOfBirth());
        holder.address.setText("Address: " + dataResp.getAddress());


            if (dataResponse.get(position).isFavourite() == 1) {
                holder.favourite_iv.setBackground(context.getResources().getDrawable(R.drawable.heart_red));
            } else {
                holder.favourite_iv.setBackground(context.getResources().getDrawable(R.drawable.heart_white));
            }

        Glide.with(context).load(dataResp.getImg1()).into(holder.profile_image);
        holder.cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(dataResponse.get(position));
            }
        });

        holder.favourite_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataResponse.get(position).isFavourite() == 0) {
                    holder.favourite_iv.setTag("Favourite");
                } else {
                    holder.favourite_iv.setTag("Unfavourite");
                }
                onItemClickListener.onMarkAsFavouriteClick(dataResponse.get(position), v.getTag().toString(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataResponse.size();
    }

    public List<DataResponse> getDataResponse(){
        return dataResponse;
    }

    public void setDataResponse(List<DataResponse> dataResponse){
         this.dataResponse=dataResponse;
    }
}

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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.callbacks.OnItemClickListener;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<DataResponse> dataResponse;
    private List<DataResponse> filter_List;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, dob, age, contact, address;
        CircleImageView profile_image;
        CardView cardLayout;
        ImageView favourite_iv, block_iv, express_interest_iv;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            dob = view.findViewById(R.id.dob);
            contact = view.findViewById(R.id.contact);
            age = view.findViewById(R.id.age);
            address = view.findViewById(R.id.address);
            profile_image = view.findViewById(R.id.profile_image);
            cardLayout = view.findViewById(R.id.cardLayout);
            favourite_iv = view.findViewById(R.id.favourite_iv);
            block_iv = view.findViewById(R.id.block_iv);
            express_interest_iv = view.findViewById(R.id.express_interest_iv);
        }
    }


    public ListAdapter(Context context, List<DataResponse> dataResponse, OnItemClickListener onItemClickListener) {
        this.dataResponse = dataResponse;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        filter_List = new ArrayList<>();
        filter_List.addAll(this.dataResponse);
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
        holder.name.setText(dataResp.getFirstName() + " " + dataResp.getMName() + " " + dataResp.getLName());
        holder.contact.setText("Contact: " + dataResp.getMobileNo());
        holder.age.setText(dataResp.getAge() + "");
        holder.dob.setText(dataResp.getDateOfBirthString());
        holder.address.setText("Address: " + dataResp.getAddress());


        if (dataResponse.get(position).isShorlisted()) {
            holder.favourite_iv.setBackground(context.getResources().getDrawable(R.drawable.heart_red));
        } else {
            holder.favourite_iv.setBackground(context.getResources().getDrawable(R.drawable.heart_white));
        }

        if (dataResponse.get(position).isBlocked()) {
            holder.block_iv.setBackground(context.getResources().getDrawable(R.drawable.block_user_red_icon));
        } else {
            holder.block_iv.setBackground(context.getResources().getDrawable(R.drawable.block_user_grey_icon));
        }

        if (dataResponse.get(position).isRequestSend()) {
            holder.express_interest_iv.setBackground(context.getResources().getDrawable(R.drawable.express_interest_red));
        } else {
            holder.express_interest_iv.setBackground(context.getResources().getDrawable(R.drawable.express_interest_white));
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
                if (!dataResponse.get(position).isShorlisted()) {
                    holder.favourite_iv.setTag("Favourite");
                    onItemClickListener.onMarkAsFavouriteClick(dataResponse.get(position), v.getTag().toString(), position);
                } else {
                    holder.favourite_iv.setTag("Unfavourite");
                }

            }
        });

        holder.express_interest_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dataResponse.get(position).isRequestSend()) {
                    onItemClickListener.onExpressInterestClick(dataResponse.get(position));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataResponse.size();
    }

    public List<DataResponse> getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(List<DataResponse> dataResponse) {
        this.dataResponse = dataResponse;
    }

    public void filterSearch(String searchQuery) {

        dataResponse.clear();
        if (searchQuery.length() == 0) {
            dataResponse.addAll(filter_List);
        } else {
            searchQuery = searchQuery.toLowerCase(Locale.getDefault());
            for (DataResponse returnValue : filter_List) {
                if (returnValue.getFirstName().toLowerCase(Locale.getDefault()).startsWith(searchQuery)) {
                    dataResponse.add(returnValue);
                }
            }
        }
        notifyDataSetChanged();
    }
}

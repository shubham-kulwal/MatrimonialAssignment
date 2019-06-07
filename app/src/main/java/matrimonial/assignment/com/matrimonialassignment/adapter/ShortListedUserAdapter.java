package matrimonial.assignment.com.matrimonialassignment.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import matrimonial.assignment.com.matrimonialassignment.R;

public class ShortListedUserAdapter  extends RecyclerView.Adapter<ShortListedUserAdapter.MyViewHolder> {

    private List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse> dataResponse;
    private Context context;

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


    public ShortListedUserAdapter(Context context, List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse> dataResponse) {
        this.dataResponse = dataResponse;
        this.context = context;
    }

    @Override
    public ShortListedUserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_row, parent, false);

        return new ShortListedUserAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ShortListedUserAdapter.MyViewHolder holder, final int position) {
        final matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse dataResp = dataResponse.get(position);
        holder.name.setText("Name: " + dataResp.getFirstName() + " " + " " + dataResp.getLName());
        holder.age.setText("Age: " + dataResp.getAge() + "");
        holder.dob.setText("Requested Date: "+dataResp.getRequestDate());
        holder.address.setText("Address: " + dataResp.getCity());


       /* if (dataResponse.get(position).isShorlisted()) {
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
                if (!dataResponse.get(position).isShorlisted()) {
                    holder.favourite_iv.setTag("Favourite");
                    onItemClickListener.onMarkAsFavouriteClick(dataResponse.get(position), v.getTag().toString(), position);
                } else {
                    holder.favourite_iv.setTag("Unfavourite");
                }

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return dataResponse.size();
    }
}

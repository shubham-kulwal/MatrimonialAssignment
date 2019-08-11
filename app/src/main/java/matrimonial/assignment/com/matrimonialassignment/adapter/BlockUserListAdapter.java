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
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.*;

public class BlockUserListAdapter extends RecyclerView.Adapter<BlockUserListAdapter.MyViewHolder> {

    private List<DataResponse> dataResponse;
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


    public BlockUserListAdapter(Context context, List<DataResponse> dataResponse) {
        this.dataResponse = dataResponse;
        this.context = context;
    }

    @Override
    public BlockUserListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.block_user_list_adapter_layout, parent, false);

        return new BlockUserListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BlockUserListAdapter.MyViewHolder holder, final int position) {
        final DataResponse dataResp = dataResponse.get(position);
        holder.name.setText(dataResp.getFirstName() + " " + " " + dataResp.getLName());
        holder.age.setText("Age: " + dataResp.getAge() + "");
        holder.address.setText("Address: " + dataResp.getCity());
        /*if (dataResp.getDateOfBirth().contains("Date")) {
            holder.dob.setText("Birth Date: " + "10-06-2019");
        } else {
            holder.dob.setText("Requested Date: " + dataResp.getDateOfBirth());
        }*/
        holder.dob.setText(dataResp.getDateOfBirthString());
        if (dataResp.getImg1() != null && !dataResp.getImg1().contains("http://varmalavivah.com")) {
            dataResp.setImg1("http://varmalavivah.com/" + dataResp.getImg1());
        }
        Glide.with(context).load(dataResp.getImg1()).into(holder.profile_image);
        /*holder.cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(dataResponse.get(position));
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return dataResponse.size();
    }
}

package matrimonial.assignment.com.matrimonialassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.DataResponse;

public class MaleUserRequestListAdapter extends RecyclerView.Adapter<MaleUserRequestListAdapter.MyViewHolder> {

    private List<DataResponse> dataResponse;
    private Context context;

    public MaleUserRequestListAdapter(Context context, List<DataResponse> dataResponse) {
        this.dataResponse = dataResponse;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.male_user_request_adapter_layout, parent, false);

        return new MaleUserRequestListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(dataResponse.get(position).getUserName());
        holder.cast.setText(dataResponse.get(position).getCastName());
    }

    @Override
    public int getItemCount() {
        return dataResponse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, cast;
        CircleImageView profile_image;
        Button decline, approve;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            approve = view.findViewById(R.id.approve);
            decline = view.findViewById(R.id.decline);
            cast = (TextView) view.findViewById(R.id.cast);
            profile_image = (CircleImageView) view.findViewById(R.id.profile_image);
        }
    }
}

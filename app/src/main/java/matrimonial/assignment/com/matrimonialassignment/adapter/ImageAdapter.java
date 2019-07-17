package matrimonial.assignment.com.matrimonialassignment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.callbacks.onImageViewListener;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.ImageList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<ImageList> data;
    private onImageViewListener onImageViewListener;

    public ImageAdapter(List<ImageList> data , onImageViewListener onImageViewListener) {
        this.data = data;
        this.onImageViewListener = onImageViewListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.user_image_list_adapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getImagePath())
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageViewListener.onImageClick(data.get(position).getImagePath());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}

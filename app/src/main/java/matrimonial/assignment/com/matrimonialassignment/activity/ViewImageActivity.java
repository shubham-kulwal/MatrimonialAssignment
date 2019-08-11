package matrimonial.assignment.com.matrimonialassignment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;

public class ViewImageActivity extends BaseActivity {

    private String imageUrl;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image_layout);
        if (getIntent().hasExtra("image")){
            imageUrl =  getIntent().getStringExtra("image");
        }
        init();
    }

    private void init() {
        userImage = findViewById(R.id.userImage);
        Glide.with(this)
                .load(imageUrl)
                .into(userImage);

   //     mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

    }


  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public
        boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            userImage.setScaleX(mScaleFactor);
            userImage.setScaleY(mScaleFactor);
            return true;
        }
    }*/
}

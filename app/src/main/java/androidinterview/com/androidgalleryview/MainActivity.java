package androidinterview.com.androidgalleryview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

	Integer[] imageIDs = {
	R.drawable.pic1,
	R.drawable.pic2,
	R.drawable.pic3,
	R.drawable.pic4,
	R.drawable.pic5,
	R.drawable.pic6,
	R.drawable.pic7
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

			Gallery gallery = (Gallery) findViewById(R.id.gallery1);
			gallery.setAdapter(new ImageAdapter(this));
			gallery.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v, int position,long id)
		{
					Toast.makeText(getBaseContext(),"圖 " + (position + 1) + " 被選取",
							Toast.LENGTH_SHORT).show();

					ImageView imageView = (ImageView) findViewById(R.id.image1);
					imageView.setImageResource(imageIDs[position]);
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;
		private int itemBackground;
		public ImageAdapter(Context c)
		{
			context = c;
			TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
			itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
			a.recycle();
		}

		public int getCount() {
			return imageIDs.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(imageIDs[position]);
			imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}
}

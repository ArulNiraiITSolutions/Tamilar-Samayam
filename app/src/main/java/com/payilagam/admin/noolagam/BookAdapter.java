package com.payilagam.admin.noolagam;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by Admin on 12/30/2017.
 */
public class BookAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Book> bookItems;
   // ImageLoader imageLoader = AppController.getInstance().getImageLoader();
   ImageLoader imageLoader = null;
    @Override
    public int getCount() {
        return bookItems.size();
    }

    @Override
    public Object getItem(int position) {
        return bookItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public BookAdapter(Activity activity, List<Book> bookItems) {
        this.activity = activity;
        this.bookItems = bookItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

       if (imageLoader == null)
           imageLoader = new ImageLoader(Volley.newRequestQueue(activity), new LruBitmapCache());
       // imageLoader = new AppController().getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);

      //     ImageView thumbNail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView bookName = (TextView) convertView.findViewById(R.id.title);
        TextView bookAuthor = (TextView) convertView.findViewById(R.id.rating);
        TextView publication = (TextView) convertView.findViewById(R.id.genre);
        TextView bookPrice = (TextView) convertView.findViewById(R.id.releaseYear);
        Book book = bookItems.get(position);
       thumbNail.setImageUrl(book.getBookImage(), imageLoader);
     ///   byte[] decodedString = Base64.decode(book.getBookImage(), Base64.DEFAULT);
     //   Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);


      //  thumbNail.setImageBitmap(decodedByte);
        // title
        bookName.setText(book.getBookName());
        bookAuthor.setText(book.getBookAuthor());
        publication.setText(book.getPublication());
        bookPrice.setText(book.getBookPrice());



        //ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
       // iv.setImageBitmap(decodedByte);

        return convertView;

    }
}

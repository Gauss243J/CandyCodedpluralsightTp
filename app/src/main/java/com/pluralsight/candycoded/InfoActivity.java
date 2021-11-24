package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

       // Uri uri = Uri.parse("android.resource://com.pluralsight.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        candyStoreImageView.setImageResource(R.drawable.store_front);
        //Picasso.with(this).load(uri).into(candyStoreImageView);

        TextView txt=(TextView)findViewById(R.id.text_view_address);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMapIntent(view);
            }
        });


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createMapIntent(View view){

        Intent mapIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"));
        if(mapIntent.resolveActivity(getPackageManager())!=null){
            startActivity(mapIntent);
        }
        else Toast.makeText(this,"Faux",Toast.LENGTH_LONG).show();
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view){
        Uri uri=Uri.parse("tel:0123456789");
        Intent callIntent=new Intent(Intent.ACTION_DIAL);
        callIntent.setData(uri);
        startActivity(callIntent);

    }
}

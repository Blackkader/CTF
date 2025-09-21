package io.securinets.solver8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Intent thirdIntent = new Intent();
        thirdIntent.setAction("intentac3");
        // Combine flag3 and flag4
        thirdIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);


        Intent secondIntent = new Intent();
        secondIntent.setAction("intentac2");
        secondIntent.setData(Uri.parse("intentu2"));
        secondIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        secondIntent.putExtra("thirdIntent", thirdIntent);


        Intent firstIntent = new Intent();
        firstIntent.setAction("intentac1");
        firstIntent.setData(Uri.parse("intentu1"));
        firstIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        firstIntent.putExtra("secondIntent", secondIntent);


        firstIntent.setClassName("io.securinets.level8", "io.securinets.level8.Unsolvable2");
        startActivity(firstIntent);
    }
}
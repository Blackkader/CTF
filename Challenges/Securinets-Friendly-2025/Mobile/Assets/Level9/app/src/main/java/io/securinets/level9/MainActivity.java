package io.securinets.level9;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final AppCompatButton loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIN("canyouchangethisargument?idontthinksohahahaahahahaha");

            }});

    }
    protected void WIN(String key){
        if(key.equals("CHANGED!")){
            WinHelper wh = new WinHelper(this);
            String winner=wh.magic(getString(R.string.waaat));
            Log.i("WINNNN",winner);
        }
        else{
            Log.i("LOSER","LOSER");
        }
    }
}
package io.securinets.level7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import io.securinets.level7.WinHelper;

public class Unsolvable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        WinHelper wh = new WinHelper(this);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null || !action.equals(getString(R.string.akshen))) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        wh.p0(action);

        Uri data = intent.getData();
        if (data == null || !data.toString().equals(getString(R.string.URI))) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        wh.p0(data);

        Bundle extras=intent.getExtras();
        if (extras == null) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (!extras.containsKey("whatisthis") ||
                !extras.containsKey("number") ||
                !extras.containsKey("verificator")) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        String secretValue = extras.getString("whatisthis");
        int numberValue = extras.getInt("number");
        boolean verificatorValue = extras.getBoolean("verificator");

        if (!getString(R.string.ekstra1).equals(secretValue) ||
                numberValue != getResources().getInteger(R.integer.ekstra2) ||
                !verificatorValue) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        wh.p0(numberValue);
        wh.p0(secretValue);
        String errorMsg = wh.magic(getString(R.string.errormsg));
        Log.i("Error, file not found : ",errorMsg);


    }


}

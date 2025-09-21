package io.securinets.level8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.securinets.level8.WinHelper;

public class Unsolvable2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WinHelper wh = new WinHelper(this);

        Intent firstIntent = getIntent();
        if (firstIntent == null ||
                !firstIntent.getAction().equals(getString(R.string.action1)) ||
                !firstIntent.getDataString().equals(getString(R.string.uri1)) ||
                firstIntent.getFlags() != getResources().getInteger(R.integer.flag1)) {

            Toast.makeText(this, "BYE BYE! First Intent check failed", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        wh.p0(firstIntent.getAction());
        wh.p0(firstIntent.getDataString());
        wh.p0(firstIntent.getFlags());

        Bundle firstExtras = firstIntent.getExtras();
        if (firstExtras == null || !firstExtras.containsKey("secondIntent")) {

            Toast.makeText(this, "BYE BYE! Second Intent missing", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Intent secondIntent = firstExtras.getParcelable("secondIntent");
        if (secondIntent == null ||
                !secondIntent.getAction().equals(getString(R.string.action2)) ||
                !secondIntent.getDataString().equals(getString(R.string.uri2)) ||
                secondIntent.getFlags() != getResources().getInteger(R.integer.flag2)) {

            Toast.makeText(this, "BYE BYE! Second Intent check failed", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        wh.p0(secondIntent.getAction());
        wh.p0(secondIntent.getDataString());
        wh.p0(secondIntent.getFlags());


        Bundle secondExtras = secondIntent.getExtras();
        if (secondExtras == null || !secondExtras.containsKey("thirdIntent")) {

            Toast.makeText(this, "BYE BYE! Third Intent missing", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Intent thirdIntent = secondExtras.getParcelable("thirdIntent");
        if (thirdIntent == null ||
                !thirdIntent.getAction().equals(getString(R.string.action3)) ||
                thirdIntent.getFlags() != (getResources().getInteger(R.integer.flag3)
                        | getResources().getInteger(R.integer.flag4))) {

            Toast.makeText(this, "BYE BYE! Third Intent check failed", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        wh.p0(thirdIntent.getAction());
        String errorMsg = wh.magic(getString(R.string.errormsg));
        Log.i("Error, file not found : ", errorMsg);
    }
}

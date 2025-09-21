package io.securinets.level10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        final AppCompatButton rollButton = findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dice1 = findViewById(R.id.dice1);
                dice1.setText(String.valueOf(generate()));
                TextView dice2 = findViewById(R.id.dice2);
                dice2.setText(String.valueOf(generate()));
                TextView dice3 = findViewById(R.id.dice3);
                dice3.setText(String.valueOf(generate()));
                TextView dice4 = findViewById(R.id.dice4);
                dice4.setText(String.valueOf(generate()));
                TextView dice5 = findViewById(R.id.dice5);
                dice5.setText(String.valueOf(generate()));
                if (dice1.getText().equals("6") && dice2.getText().equals("7") && dice3.getText().equals("8") && dice4.getText().equals("9") && dice5.getText().equals("10") )
                {
                    WinHelper wh = new WinHelper(MainActivity.this);
                    wh.y0(R.id.dice1);
                    wh.y0(R.id.dice2);
                    wh.y0(R.id.dice3);
                    wh.y0(R.id.dice4);
                    wh.y0(R.id.dice5);
                    wh.y0(dice1.getText());
                    wh.y0(dice2.getText());
                    wh.y0(dice3.getText());
                    wh.y0(dice4.getText());
                    wh.y0(dice5.getText());

                    String WIN=wh.magic(getString(R.string.winmsg));
                    try{
                        Log.i("WINNNNNEEEEEER",WIN);
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Caught exception: " + e.getMessage());
                    }
                }
                else{
                    Log.i("HAHHAHAHHAHA","AHAAHAHAHAHHAH");
                }

                rollButton.setVisibility(View.GONE);
            }});
    }

    protected int generate() {
        double r = Math.random();
        double a = r * 314159.2653589793;
        long b = Double.doubleToLongBits(a);
        int c = (int)(b ^ (b >>> 32));
        int d = c * 31 + 0x7;
        d = Integer.rotateLeft(d, 13);
        int e = d ^ 0x5A5A5A5A;
        int f = e == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(e);
        int g = (f >>> 3) | (f << 5);
        g = g ^ (g >>> 16);
        int h = g & 0x7FFFFFFF;
        int i = (h % 97) + 1;
        int j = i * 73 + (int)(a % 13);
        j = (j << 2) - (j >>> 3);
        j = j ^ (j << 7);
        int k = Math.abs(j) + 0xABC;
        long L = ((long)k * 0x27d4eb2dL) & 0xFFFFFFFFL;
        long M = L ^ (L >>> 16);
        int n = (int)(M & 0x7FFFFFFF);
        n = n ^ (int)(b & 0xFFFF);
        n = (n << 1) | (n >>> 31);
        n = Math.abs(n);
        int p = (n % 13) * 7;
        p = p ^ (int)((a * 1000) % 31);
        int q = p + (int)(r * 9999);
        q = q ^ (q >>> 5);
        int s = Math.abs(q) + 3;
        int t = (s * 1664525) + 1013904223;
        t = t ^ (t >>> 11);
        int u = Math.abs(t);
        int v = (u % 5) + 1;
        int x1 = (t >>> 3) ^ c;
        int z = (x1 + n) % 13;
        v = ((v * 17) ^ 0x3C) & 0xFF;
        int y = (z << 1) | (k & 3);
        int w = (y ^ j) + 31;
        v = (v % 7) + 1;
        int r1 = (w >>> 2) + (int)(a % 5);
        int s1 = (r1 * 3) ^ (n & 0xF);
        v = ((v << 2) ^ (v >> 1)) & 0xF;
        int m1 = (s1 + p) * 13;
        int o1 = (m1 ^ k) - (j & 0xFF);
        v = (v % 5) + 1;
        int mix = (o1 ^ x1) + (int)(r * 31);
        mix = (mix << 1) - (mix >>> 3);
        return v;
    }

}

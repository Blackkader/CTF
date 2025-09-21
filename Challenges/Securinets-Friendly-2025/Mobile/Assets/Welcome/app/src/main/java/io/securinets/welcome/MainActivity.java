package io.securinets.welcome;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private boolean isTemplate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTemplate) {
                    try {

                        InputStream is = getResources().openRawResource(R.raw.woho);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int read;
                        while ((read = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, read);
                        }
                        is.close();

                        byte[] bytes = baos.toByteArray();

                        for (int i = 0; i < bytes.length; i++) {
                            bytes[i] = (byte)(bytes[i] ^ 5);
                        }


                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        if (bitmap != null) {
                            rootLayout.setBackground(new BitmapDrawable(getResources(), bitmap));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    isTemplate = false;
                } else {

                    rootLayout.setBackgroundResource(R.drawable.template);
                    isTemplate = true;
                }


                loginButton.setVisibility(View.GONE);
            }
        });
    }
}

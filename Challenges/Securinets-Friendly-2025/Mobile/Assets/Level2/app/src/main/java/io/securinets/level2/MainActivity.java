package io.securinets.level2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private boolean isTemplate = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.loginButton);


        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();


                if (user.equals("od5el") && pass.equals("thiseasy??")) {
                    Toast.makeText(MainActivity.this, "Login successful?? NOPEEE!!!", Toast.LENGTH_SHORT).show();
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



                            int finalKey = pass.length();

                            for (int i = 0; i < bytes.length; i++) {
                                bytes[i] = (byte) (bytes[i] ^ finalKey);
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
                    username.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        }
package io.securinets.level4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private boolean isTemplate = true;
    private int[] secrets={89, 233, 49, 89, 1, 33, 121, 249, 217, 17, 185, 42};
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
                int[] encpass=encrypt(user,pass);

                if (user.equals("logedin") && Arrays.equals(encpass,secrets)) {
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
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


                            byte[] passBytes = pass.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                            for (int i = 0; i < bytes.length; i++) {
                                bytes[i] = (byte) (bytes[i] ^ passBytes[i % passBytes.length]);
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


    public static int[] encrypt(String login, String password) {
        int[] encrypted = new int[password.length()];
        int[] loginBytes = new int[login.length()];

        for (int i = 0; i < login.length(); i++) {
            loginBytes[i] = login.charAt(i);
        }

        for (int i = 0; i < password.length(); i++) {
            int xorChar = password.charAt(i) ^ loginBytes[i % loginBytes.length];
            int rotChar = ((xorChar << 3) & 0xFF) | ((xorChar & 0xFF) >> 5);
            encrypted[i] = rotChar;
        }

        return encrypted;

    }
    public static int[] chnoahetha(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashed) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        String hexResult = hexString.toString();


        int[] key2 = new int[hexResult.length()];
        for (int i = 0; i < hexResult.length(); i++) {
            key2[i] = (int) hexResult.charAt(i);
        }

        return key2;
    }

}

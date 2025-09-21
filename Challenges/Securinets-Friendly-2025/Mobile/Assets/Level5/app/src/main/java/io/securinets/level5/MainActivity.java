package io.securinets.level5;

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
import java.util.Arrays;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private boolean isTemplate = true;
    private int[] ahs={98, 53, 56, 54, 55, 97, 50, 97, 55, 54, 51, 54, 54, 98, 51, 48, 52, 102, 56, 51, 51, 52, 100, 51, 56, 101, 57, 52, 97, 55, 55, 100, 100, 101, 50, 57, 98, 52, 97, 57, 51, 53, 48, 57, 56, 100, 55, 97, 100, 50, 52, 52, 56, 97, 52, 102, 101, 102, 99, 56, 52, 49, 55, 52};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.loginButton);

        // Find UI elements by ID
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);


        // Set onClickListener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                int[] encpass= null;
                try {
                    encpass = encrypt(pass);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }

                if (user.equals("itsnothardiswear") && Arrays.equals(encpass,ahs)) {
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

                            // Decode the byte array into Bitmap
                            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bitmap != null) {
                                rootLayout.setBackground(new BitmapDrawable(getResources(), bitmap));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        isTemplate = false;
                    } else {
                        // Switch back to normal background
                        rootLayout.setBackgroundResource(R.drawable.template);
                        isTemplate = true;
                    }

                    // Hide the button
                    loginButton.setVisibility(View.GONE);
                    username.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static int[] encrypt(String password) throws NoSuchAlgorithmException {
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

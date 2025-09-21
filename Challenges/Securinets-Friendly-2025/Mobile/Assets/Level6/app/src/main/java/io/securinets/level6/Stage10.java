package io.securinets.level6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
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

public class Stage10 extends AppCompatActivity {
    private int[] ahs_652={53, 100, 53, 98, 48, 57, 102, 54, 100, 99, 98, 50, 100, 53, 51, 97, 53, 102, 102, 102, 99, 54, 48, 99, 52, 97, 99, 48, 100, 53, 53, 102, 97, 98, 100, 102, 53, 53, 54, 48, 54, 57, 100, 54, 54, 51, 49, 53, 52, 53, 102, 52, 50, 97, 97, 54, 101, 51, 53, 48, 48, 102, 50, 101};
    private boolean isTemplate = true;
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
        Log.i("LOTF", Arrays.toString(key2));
        return key2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (!getString(R.string.realflag).equals(action)) {
            Toast.makeText(this, "BYE BYE!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        setContentView(R.layout.activity_stage);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.answerButton);


        final EditText pz = findViewById(R.id.pz);
        pz.setHint(getString(R.string.puzzle10));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = pz.getText().toString();

                int[] whatsthis= null;
                try {
                    whatsthis = encrypt(answer);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                if ( Arrays.equals(whatsthis,ahs_652)) {
                    Toast.makeText(Stage10.this, "CORRECT!", Toast.LENGTH_SHORT).show();
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

                            byte[] answerBytes = answer.getBytes(java.nio.charset.StandardCharsets.UTF_8);

                            for (int i = 0; i < bytes.length; i++) {
                                bytes[i] = (byte) (bytes[i] ^ answerBytes[i%answerBytes.length]);
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
                    pz.setVisibility(View.GONE);

                } else {
                    Toast.makeText(Stage10.this, ":((((", Toast.LENGTH_SHORT).show();
                }
                }});

    }
    }

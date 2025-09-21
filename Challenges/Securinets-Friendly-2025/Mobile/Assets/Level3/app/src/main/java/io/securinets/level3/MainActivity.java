package io.securinets.level3;

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
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import android.util.Base64;

public class MainActivity extends AppCompatActivity {
    private boolean isTemplate = true;
    private int[] ahs={98, 53, 56, 54, 55, 97, 50, 97, 55, 54, 51, 54, 54, 98, 51, 48, 52, 102, 56, 51, 51, 52, 100, 51, 56, 101, 57, 52, 97, 55, 55, 100, 100, 101, 50, 57, 98, 52, 97, 57, 51, 53, 48, 57, 56, 100, 55, 97, 100, 50, 52, 52, 56, 97, 52, 102, 101, 102, 99, 56, 52, 49, 55, 52};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.loginButton);


        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final String key = "SuperSecretKey123";
        final String whattt="JBtDQAc6IV0gPiM5EC94cRBrJB1OMEYgBSwZKAwBdDR0bB4wAjk4HQgmCjwzIi08aW1gaQoyKF02EgcmEygfEmkbc14fGA5AEj4yJB82Aj0qLn11OmgzOBw/HB4KLTArHwJzHkd3VWE=";


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String encpass = encrypt(pass);


                if (user.equals("meowmeow") && encpass.equals("QUFBQUFBQUFBQUFBQUFBQQ==")) {
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
                                bytes[i] = (byte) (bytes[i] ^ pass.length());
                            }


                            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bitmap != null) {
                                rootLayout.setBackground(new BitmapDrawable(getResources(), bitmap));
                                String error = decrypt(whattt, key, 4);
                                Log.i("ERROR",error);
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


    public static String encrypt(String password)  {
        byte[] bytes = password.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
    private static byte[] unrot13Bytes(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            char c = (char) data[i];
            if (c >= 'a' && c <= 'z') {
                result[i] = (byte) ((c - 'a' - 13 + 26) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                result[i] = (byte) ((c - 'A' - 13 + 26) % 26 + 'A');
            } else {
                result[i] = data[i];
            }
        }
        return result;
    }
    private static int[] inversePermutation(int[] perm) {
        int[] inv = new int[perm.length];
        for (int i = 0; i < perm.length; i++) {
            inv[perm[i]] = i;
        }
        return inv;
    }
    private static byte[] applyPermutation(byte[] data, int[] perm) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[perm[i]];
        }
        return result;
    }
    private static int[] getStaticPermutation(int length) {
        int[] perm = new int[length];
        for (int i = 0; i < length; i++) {
            perm[i] = i;
        }
        for (int i = 0; i < length - 1; i += 2) {
            int temp = perm[i];
            perm[i] = perm[i + 1];
            perm[i + 1] = temp;
        }
        return perm;
    }
    public static String decrypt(String ciphertext, String key, int rounds) {
        byte[] data = ciphertext.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        for (int r = rounds - 1; r >= 0; r--) {
            // Base64 decode
            byte[] rotBytes = Base64.decode(data, Base64.NO_WRAP);

            // Unshuffle in 2nd and 4th rounds
            if (r == 1 || r == 3) {
                int[] perm = getStaticPermutation(rotBytes.length);
                int[] invPerm = inversePermutation(perm);
                rotBytes = applyPermutation(rotBytes, invPerm);
            }

            // Reverse ROT13
            byte[] xorBytes = unrot13Bytes(rotBytes);

            // XOR with key
            byte[] originalBytes = new byte[xorBytes.length];
            for (int i = 0; i < xorBytes.length; i++) {
                originalBytes[i] = (byte) (xorBytes[i] ^ keyBytes[i % keyBytes.length]);
            }

            data = originalBytes;
        }

        return new String(data, StandardCharsets.UTF_8);
    }


}

package io.securinets.template;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by ID
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        // Set onClickListener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                // Simple validation (for demo purposes, you can connect to an actual server or database)
                if (user.equals("admin") && pass.equals("password")) {
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

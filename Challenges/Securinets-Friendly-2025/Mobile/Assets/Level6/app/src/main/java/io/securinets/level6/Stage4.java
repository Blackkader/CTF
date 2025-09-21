package io.securinets.level6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Stage4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.answerButton);

        // Find UI elements by ID
        final EditText pz = findViewById(R.id.pz);
        pz.setHint(getString(R.string.puzzle4));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = pz.getText().toString();


                if (answer.equals("tefhem electrostatique :(")) {
                    Intent intent = new Intent(Stage4.this, Stage5.class);
                    startActivity(intent);
                }}});

    }
}

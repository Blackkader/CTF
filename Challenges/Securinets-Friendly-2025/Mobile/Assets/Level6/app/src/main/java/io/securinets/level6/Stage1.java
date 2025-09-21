package io.securinets.level6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Stage1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);
        final AppCompatButton loginButton = findViewById(R.id.answerButton);


        final EditText pz = findViewById(R.id.pz);
        pz.setHint(getString(R.string.puzzle1));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = pz.getText().toString();


                if (answer.equals("0 ebda rivez")) {
                    Intent intent = new Intent(Stage1.this, Stage2.class);
                    startActivity(intent);
                }}});

    }
}

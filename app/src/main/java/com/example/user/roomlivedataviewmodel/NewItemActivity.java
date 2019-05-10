package com.example.user.roomlivedataviewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewItemActivity extends AppCompatActivity {

    private EditText myEditText;
    public static final String EXTRA = ".REPLY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        myEditText = findViewById(R.id.add_item);

        final Button button = findViewById(R.id.save_item);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent reply = new Intent();
                if (TextUtils.isEmpty(myEditText.getText())) {
                    setResult(RESULT_CANCELED, reply);
                } else {
                    String item = myEditText.getText().toString();
                    reply.putExtra(EXTRA, item);
                    setResult(RESULT_OK, reply);
                }
                finish();
            }
        });
    }
}

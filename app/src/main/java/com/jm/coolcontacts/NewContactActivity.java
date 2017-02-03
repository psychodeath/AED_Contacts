package com.jm.coolcontacts;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jm.coolcontacts.model.Contact;
import com.jm.coolcontacts.model.ContactManager;

public class NewContactActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("New Contact");
        setContentView(R.layout.activity_new_contact);

        // inicialização
        this.editName = (EditText) findViewById(R.id.editName);
        this.editID = (EditText) findViewById(R.id.editID);

        editName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editName.setText("");
                return false;
            }
        });

        editID.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editID.setText("");
                return false;
            }
        });
    }

    public void onOkClicked(View view){
        Contact novoContacto = new Contact(editName.getText().toString(), Long.parseLong(editID.getText().toString()));

        ContactManager.INSTANCE.add(novoContacto);

        setResult(RESULT_OK);
        finish();
    }


}

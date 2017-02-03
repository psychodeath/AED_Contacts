package com.jm.coolcontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jm.coolcontacts.model.Contact;
import com.jm.coolcontacts.model.ContactManager;

import pt.ipleiria.estg.dei.colecoes.ListaSimplesCircularBaseLimite;

public class MainActivity extends AppCompatActivity {

    private static final int ACTION_NEW_CONTACT = 1;
    private TextView txtListaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Contacts");
        setContentView(R.layout.activity_main);

        startup();
    }

    private void startup(){
        this.txtListaContactos = (TextView) findViewById(R.id.txtListaContactos);

        ContactManager.INSTANCE.add(new Contact("Zé Manel", 11111111));
        ContactManager.INSTANCE.add(new Contact("Maria Odete", 22222222));
        ContactManager.INSTANCE.add(new Contact("Joaquim Silva", 33333333));
        ContactManager.INSTANCE.add(new Contact("Johnny Mota", 44444444));

        updateContactList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);


        menu.add("By name");
        menu.add("By ID");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_contact:
                newContact();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            Toast.makeText(this, "contact list updated", Toast.LENGTH_SHORT);
            switch(requestCode){
                case ACTION_NEW_CONTACT:
                    updateContactList();
                    break;
            }
        } else {
            Toast.makeText(this, "something went wrong while creating new contact", Toast.LENGTH_SHORT);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateContactList() {
        System.out.println("Updating contacts list");

        ListaSimplesCircularBaseLimite<Contact> contactos = ContactManager.INSTANCE.getAllContactsByName();

        StringBuilder sb = new StringBuilder();
        for (Contact c : contactos){
            sb.append("ID: " + c.getId() + "; Nome: " + c.getNome() + "\n");
        }

        txtListaContactos.setText(sb.toString());

    }

    private void newContact(){

        Intent intent = new Intent(this, NewContactActivity.class);
        startActivityForResult(intent, ACTION_NEW_CONTACT);

    }
}

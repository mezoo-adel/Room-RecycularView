package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.thedatabase.Database;
import com.example.roomdatabase.thedatabase.Table1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName = findViewById(R.id.editName);
        final EditText editGender = findViewById(R.id.editGender);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                try {
                    int gender = Integer.parseInt(editGender.getText().toString());
                    if (!editName.getText().toString().equals("") && gender == 0 | gender == 1) {
                        Database database = Database.getInstance(getBaseContext());
                        database.dao().insertAnimal(new Table1(name, gender));
                        Toast.makeText(getBaseContext(), "S A V I N G . . .", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Value .", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(getBaseContext(), "Invalid Value .", Toast.LENGTH_SHORT).show();
                }
              
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.showData) {
            startActivity(new Intent(MainActivity.this, MyDataBase.class));
        }

        return super.onOptionsItemSelected(item);
    }


}
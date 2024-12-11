package com.example.lesson12;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // Button 1: Permission Dialog
        button1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Permission Request")
                    .setMessage("Do you grant the app permission to access your location?")
                    .setPositiveButton("Allow", (dialog, which) -> {
                        Toast.makeText(this, "Selected: Allow", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Deny", (dialog, which) -> {
                        Toast.makeText(this, "Selected: Deny", Toast.LENGTH_SHORT).show();
                    })
                    .create()
                    .show();
        });

        // Button 2: List Selection Dialog
        button2.setOnClickListener(v -> {
            String[] items = {"Option 1", "Option 2", "Option 3"};
            final int[] selectedItem = {-1};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select an Option")
                    .setSingleChoiceItems(items, -1, (dialog, which) -> selectedItem[0] = which)
                    .setPositiveButton("Submit", (dialog, which) -> {
                        if (selectedItem[0] != -1) {
                            Toast.makeText(this, "Selected: " + items[selectedItem[0]], Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "No option selected", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create()
                    .show();
        });

        // Button 3: Login Dialog
        button3.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            builder.setTitle("Login")
                    .setView(inflater.inflate(R.layout.dialog_login, null))
                    .setPositiveButton("Login", (dialog, which) -> {
                        AlertDialog alertDialog = (AlertDialog) dialog;
                        EditText usernameField = alertDialog.findViewById(R.id.username);
                        EditText passwordField = alertDialog.findViewById(R.id.password);

                        if (usernameField != null && passwordField != null) {
                            String username = usernameField.getText().toString();
                            String password = passwordField.getText().toString();
                            Toast.makeText(this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create()
                    .show();
        });
    }
}

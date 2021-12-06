package gr.athtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    void uiSetup() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String login_mail = "getin@athtech.gr";
        String login_pass = "get123";

        EditText passwordValidate = findViewById(R.id.password_input);
        EditText emailValidate = findViewById(R.id.mail_input);


        Button login_btn = findViewById(R.id.btn_login);



        login_btn.setClickable(true);
        login_btn.setOnClickListener(v -> {


            String password = passwordValidate.getText().toString().trim();
            String email = emailValidate.getText().toString().trim();



            // check if email field is empty

            if ( email.isEmpty()){
                    emailValidate.setError("Email is required to login!");
            }

            //check if the password field is empty

            if (password.isEmpty()){

                passwordValidate.setError("Password is required to login!");
            }


//            use regex pattern to check email form

           else if (email.matches(emailPattern)){

//              check if email and password are correct

                if (email.equals(login_mail) && password.equals(login_pass)){
                        Toast.makeText(getApplicationContext(), "Correct, you can get in now!", Toast.LENGTH_SHORT).show();




                }

                else {
                    Snackbar.make(v,"Incorrect Email or Password!",Snackbar.LENGTH_SHORT).show();
                    }
                }


           else {
                Snackbar.make(v, "Invalid Email Form", Snackbar.LENGTH_SHORT).show();
           }

        });

    }

    @Override
    void startOperations() {

    }

    @Override
    void StopOperations() {

    }
}
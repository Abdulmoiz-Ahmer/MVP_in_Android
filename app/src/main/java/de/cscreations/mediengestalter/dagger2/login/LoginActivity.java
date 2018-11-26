package de.cscreations.mediengestalter.dagger2.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import de.cscreations.mediengestalter.dagger2.R;
import de.cscreations.mediengestalter.dagger2.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {
    @Inject
    LoginActivityMVP.Presenter presenter;

    EditText firstname;
    EditText lastname;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);
        firstname = findViewById(R.id.firstNameEdtTxt);
        lastname = findViewById(R.id.lastnameEdtTxt);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstname.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastname.getText().toString();
    }

    @Override
    public void setFirstName(String fname) {
        firstname.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        lastname.setText(lname);
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error the user is not available!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or Last Name cannot be void!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User Saved", Toast.LENGTH_LONG).show();
    }
}

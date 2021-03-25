package com.example.assignment5;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    EditText etname, etnum, etemail, etcountry, etaddress;
    Button btndob;
    RadioGroup rdogender;
    RadioButton rdomale, rdofemale;
    CheckBox chkreading, chktravelling, chkmusic;
    AppCompatButton btnnext;

    Context ctx = this;
    int defdate, defmonth, defyear;

    String name, num, email, country, address, dob, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AllocateMemory();
        SetEvents();
    }

    private void SetEvents() {
        btndob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GregorianCalendar gc = new GregorianCalendar();
                defdate = gc.get(Calendar.DAY_OF_MONTH);
                defmonth = gc.get(Calendar.MONTH);
                defyear = gc.get(Calendar.YEAR);
                DatePickerDialog dpd = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        btndob.setText(d + "/" + (m + 1) + "/" + y);
                    }
                }, defyear, defmonth, defdate);
                dpd.show();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidate()) {
                    Toast.makeText(ctx, "Sign up successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidate() {
        boolean isValid = true;
        name = etname.getText().toString().trim();
        num = etnum.getText().toString().trim();
        email = etemail.getText().toString().trim();
        country = etcountry.getText().toString().trim();
        address = etaddress.getText().toString().trim();
        dob = btndob.getText().toString().trim();

        if (name.length() == 0) {
            Toast.makeText(ctx, "Enter name", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (num.length() != 10) {
            Toast.makeText(ctx, "Number should be 10 digit long", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (email.length() == 0) {
            Toast.makeText(ctx, "Enter valid email address", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (country.length() == 0) {
            Toast.makeText(ctx, "Enter your country", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (address.length() == 0) {
            Toast.makeText(ctx, "Enter your address", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (dob.equals("CLICK HERE")) {
            Toast.makeText(ctx, "Select your Date of Birth", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (rdomale.isChecked())
            gender = "Male";
        if (rdofemale.isChecked())
            gender = "Female";
        if (!chkreading.isChecked() && !chktravelling.isChecked() && !chkmusic.isChecked()) {
            Toast.makeText(ctx, "Select your hobbies", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        return isValid;
    }

    private void AllocateMemory() {
        etname = findViewById(R.id.etname);
        etnum = findViewById(R.id.etnum);
        etemail = findViewById(R.id.etemail);
        etcountry = findViewById(R.id.etcountry);
        etaddress = findViewById(R.id.etaddress);
        btndob = findViewById(R.id.btndob);
        rdogender = findViewById(R.id.rdogender);
        rdomale = findViewById(R.id.rdomale);
        rdofemale = findViewById(R.id.rdofemale);
        chkreading = findViewById(R.id.chkreading);
        chktravelling = findViewById(R.id.chktravelling);
        chkmusic = findViewById(R.id.chkmusic);
        btnnext = findViewById(R.id.btnnext);
    }
}
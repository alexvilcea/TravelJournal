package com.example.alex.traveljournal.addtrip;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.alex.traveljournal.MainActivity;
import com.example.alex.traveljournal.R;

import java.text.DateFormat;
import java.util.Calendar;

public class AddTripActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText editText_name;
    private EditText editText_desc;
    private Button button;
    private EditText addStartDate;
    private EditText addEndDate;
    private int ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        Intent intent  = getIntent();
        editText_name = findViewById(R.id.add_trip_name);
        editText_desc = findViewById(R.id.add_trip_description);
        button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              openMainActivity();
                String[] result = new String[2];
                result[0] = editText_name.getText().toString();
                result[1] = editText_desc.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        addStartDate = findViewById(R.id.add_trip_date_start);
        addStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
                ok = 0;
            }
        });

        addEndDate = findViewById(R.id.add_trip_date_end);
        addEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
                ok = 1;
            }
        });


    }

//    public void openMainActivity(){
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
//    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        if(ok==0) {
            addStartDate.setText(currentDateString);
        }
        else{
            addEndDate.setText(currentDateString);
        }
    }
}

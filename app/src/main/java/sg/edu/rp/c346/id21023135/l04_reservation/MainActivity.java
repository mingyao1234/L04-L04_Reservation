package sg.edu.rp.c346.id21023135.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText mobile;
    EditText grpsize;
    DatePicker dp;
    TimePicker tp;
    Button btnSubmit;
    Button btnReset;
    CheckBox cbSmoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etName);
        mobile = findViewById(R.id.etMobileNo);
        grpsize = findViewById(R.id.etGroupSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);
        cbSmoking = findViewById(R.id.cbSmoking);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                String time = tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                String smokingarea = "";
                if (cbSmoking.isChecked() == true) {
                    smokingarea = "Yes";
                } else {
                    smokingarea = "No";
                }
                String stringresponse = "Name: " + name.getText() + "\n"
                        + "Mobile: " + mobile.getText() + "\n"
                        + "Group Size: " + grpsize.getText() + "\n"
                        + "Date booked: " + date + "\n"
                        + "Time booked: " + time + "\n"
                        + "Smoking Area: " + smokingarea + "\n";
                Toast.makeText(MainActivity.this, stringresponse, Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });
    }
}
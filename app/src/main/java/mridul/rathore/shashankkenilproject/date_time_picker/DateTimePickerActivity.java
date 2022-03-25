package mridul.rathore.shashankkenilproject.date_time_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityDateTimePickerBinding;

public class DateTimePickerActivity extends AppCompatActivity {
    private ActivityDateTimePickerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDateTimePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTime.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();

            int hour = c.get(Calendar.HOUR);
            int minuet = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    //                    binding.btnTime.setText(hourOfDay+":"+minute);

                    String oldTime = hourOfDay+":"+minute;  // 24 hour

                    SimpleDateFormat hr24 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                    SimpleDateFormat hr12 = new SimpleDateFormat("hh:mm a",Locale.ENGLISH);

                    try {

                        Date date24 = hr24.parse(oldTime);

                        String newDate = hr12.format(date24);

                        binding.btnTime.setText(newDate);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            },hour,minuet,true);

            dialog.setTitle("Choose time Wisely");
            dialog.setIcon(R.drawable.ic_sun);
            dialog.show();

        });


        binding.btnDate.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();

            int day1 = c.get(Calendar.DAY_OF_MONTH);
            int month1 = c.get(Calendar.MONTH);
            int year1 = c.get(Calendar.YEAR);

            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    binding.btnDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            },year1,month1,day1);

            dialog.setTitle("Choose time Wisely");
            dialog.getDatePicker().setMinDate(System.currentTimeMillis());   // for minimum date
            dialog.setIcon(R.drawable.ic_sun);
            dialog.show();


        });

//        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                Toast.makeText(DateTimePickerActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}
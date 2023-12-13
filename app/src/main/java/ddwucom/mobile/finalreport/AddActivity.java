package ddwucom.mobile.finalreport;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    DiaryDBManager diaryDBManager;
    EditText etDate;
    CalendarView cView;
    EditText etWeather;
    EditText etTitle;
    EditText etContent;
    EditText etPlace;
    int fin = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etDate = findViewById(R.id.etDate);
        cView = findViewById(R.id.cView);
        etWeather = findViewById(R.id.etWeather);
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        etPlace = findViewById(R.id.etPlace);

        diaryDBManager = new DiaryDBManager(this);

        cView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                etDate.setText(date);
            }
        });
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnAdd:
                if (etDate.getText().length() == 0 || etTitle.length() == 0 || etPlace.length() == 0) {
                    Toast.makeText(this, "필수 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    fin = 0;
                    break;
                }
                else {
                    diaryDBManager.addNewDiary(
                            new MyData(etDate.getText().toString(), etWeather.getText().toString()
                                    , etTitle.getText().toString(), etContent.getText().toString()
                                    , etPlace.getText().toString(), R.mipmap.day6));
                    fin = 1;
                    break;
                }
            case R.id.btnCancel:
                fin = 1;
                break;
        }
        if (fin == 1)
            finish();
    }
}

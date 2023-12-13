package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    MyData myData;

    ImageView iv;
    EditText etDate;
    EditText etWeather;
    EditText etTitle;
    EditText etContent;
    EditText etPlace;
    int fin = 1;

    DiaryDBManager diaryDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myData = (MyData)getIntent().getSerializableExtra("myData");

        iv = findViewById(R.id.iv_update);
        etDate = findViewById(R.id.eDate);
        etWeather = findViewById(R.id.eWeather);
        etTitle = findViewById(R.id.eTitle);
        etContent = findViewById(R.id.eContent);
        etPlace = findViewById(R.id.ePlace);

        iv.setImageResource(myData.getImg());
        etDate.setText(myData.getDate());
        etWeather.setText(myData.getWeather());
        etTitle.setText(myData.getTitle());
        etContent.setText(myData.getContent());
        etPlace.setText(myData.getPlace());

        diaryDBManager = new DiaryDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                if (etDate.getText().length() == 0 || etTitle.length() == 0 || etPlace.length() == 0) {
                    Toast.makeText(this, "필수 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    fin = 0;
                    break;
                }
                else {
                    myData.setDate(etDate.getText().toString());
                    myData.setWeather(etWeather.getText().toString());
                    myData.setTitle(etTitle.getText().toString());
                    myData.setContent(etContent.getText().toString());
                    myData.setPlace(etPlace.getText().toString());

                    if (diaryDBManager.modifyDiary(myData)) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("myData", myData);
                        setResult(RESULT_OK, resultIntent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                    fin = 1;
                    break;
                }
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                fin = 1;
                break;
        }
        if (fin == 1)
            finish();
    }
}
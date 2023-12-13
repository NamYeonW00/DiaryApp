package ddwucom.mobile.finalreport;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    private ArrayList<MyData> dataList;
    private MyAdapter myAdapter;
    private ListView listView;
    DiaryDBManager diaryDBManager;
    EditText etSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        etSelect = findViewById(R.id.etSelect);

        dataList = new ArrayList<MyData>();

        listView = (ListView) findViewById(R.id.listView2);

        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, dataList);
        listView.setAdapter(myAdapter);
        diaryDBManager = new DiaryDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:
                dataList.clear();
                dataList.addAll(diaryDBManager.getSelectDiary(etSelect.getText().toString()));
                myAdapter.notifyDataSetChanged();
                break;
        }
    }
}

package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DiaryDBHelper extends SQLiteOpenHelper {

    final static String TAG = "DiaryDBHelper";
    final static String DB_NAME = "diary.db";

    public final static String TABLE_NAME = "diary_table";
    public final static String COL_ID = "_id";
    public final static String COL_DATE = "date";
    public final static String COL_WEATHER = "weather";
    public final static String COL_TITLE = "title";
    public final static String COL_CONTENT = "content";
    public final static String COL_PLACE = "place";
    public final static String COL_IMG = "img";

    public DiaryDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + " ( " + COL_ID + " integer primary key autoincrement, "
                + COL_DATE + " text, " + COL_WEATHER + " text, "
                + COL_TITLE + " text, " + COL_CONTENT + " text, "
                + COL_PLACE + " text, " + COL_IMG + " integer)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        inputSample(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void inputSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME
                + " values (null, '2022/06/01', '맑음', '오랜만에 나들이', '오늘은 ㅇㅇ이와 오랜만에 만나서 라멘집을 갔다.', '서래마을', " + R.mipmap.day1 + ");");
        db.execSQL("insert into " + TABLE_NAME
                + " values (null, '2022/06/02', '맑음', '한강 산책', '한강에서 산책을 했다. 상쾌했다.', '한강공원', " + R.mipmap.day2 + ");");
        db.execSQL("insert into " + TABLE_NAME
                + " values (null, '2022/06/03', '맑음', '카페에서 공부', '오늘은 카페에서 공부를 했다.', '카페', " + R.mipmap.day3 + ");");
        db.execSQL("insert into " + TABLE_NAME
                + " values (null, '2022/06/04', '흐림', '친구들과 파티', '오늘은 친구들과 파티를 했다. 즐거웠다.', '홍대', " + R.mipmap.day4 + ");");
        db.execSQL("insert into " + TABLE_NAME
                + " values (null, '2022/06/05', '비', '비오는 날', '오늘은 비가 정말 많이 왔다.', '신촌', " + R.mipmap.day5 + ");");
    }
}
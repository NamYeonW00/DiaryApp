package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DiaryDBManager {
    DiaryDBHelper diaryDBHelper = null;
    Cursor cursor = null;

    public DiaryDBManager(Context context) {
        diaryDBHelper = new DiaryDBHelper(context);
    }

    public ArrayList<MyData> getAllDiary() {
        ArrayList diaryList = new ArrayList();
        SQLiteDatabase db = diaryDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DiaryDBHelper.TABLE_NAME, null);

        while (cursor.moveToNext()) {
            long _id = cursor.getLong(0);
            String date = cursor.getString(1);
            String weather = cursor.getString(2);
            String title = cursor.getString(3);
            String content = cursor.getString(4);
            String place = cursor.getString(5);
            int img = cursor.getInt(6);

            MyData data = new MyData(_id, date, weather, title, content, place, img);
            diaryList.add(data);
        }

        cursor.close();
        diaryDBHelper.close();
        return diaryList;
    }

    public ArrayList<MyData> getSelectDiary(String t) {
        ArrayList diaryList = new ArrayList();
        SQLiteDatabase db = diaryDBHelper.getReadableDatabase();

        String[] columns = null;
        String selection = "title=?";
        String[] selectArgs = new String[] {t};

        Cursor cursor = db.query(DiaryDBHelper.TABLE_NAME, columns, selection, selectArgs, null, null, null, null);

        while (cursor.moveToNext()) {
            long _id = cursor.getLong(0);
            String date = cursor.getString(1);
            String weather = cursor.getString(2);
            String title = cursor.getString(3);
            String content = cursor.getString(4);
            String place = cursor.getString(5);
            int img = cursor.getInt(6);

            MyData data = new MyData(_id, date, weather, title, content, place, img);
            diaryList.add(data);
        }

        cursor.close();
        diaryDBHelper.close();
        return diaryList;
    }

    public boolean addNewDiary(MyData newDiary) {

        SQLiteDatabase db = diaryDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put (DiaryDBHelper.COL_DATE, newDiary.getDate());
        row.put (DiaryDBHelper.COL_WEATHER, newDiary.getWeather());
        row.put (DiaryDBHelper.COL_TITLE, newDiary.getTitle());
        row.put (DiaryDBHelper.COL_CONTENT, newDiary.getContent());
        row.put (DiaryDBHelper.COL_PLACE, newDiary.getPlace());
        row.put (DiaryDBHelper.COL_IMG, newDiary.getImg());

        long count = db.insert(DiaryDBHelper.TABLE_NAME, null, row);

        if (count > 0) return true;
        return false;
    }

    public boolean modifyDiary(MyData data) {

        SQLiteDatabase sqLiteDatabase = diaryDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put (DiaryDBHelper.COL_DATE, data.getDate());
        row.put (DiaryDBHelper.COL_WEATHER, data.getWeather());
        row.put (DiaryDBHelper.COL_TITLE, data.getTitle());
        row.put (DiaryDBHelper.COL_CONTENT, data.getContent());
        row.put (DiaryDBHelper.COL_PLACE, data.getPlace());
        row.put (DiaryDBHelper.COL_IMG, data.getImg());

        String whereClause = DiaryDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(data.get_id()) };

        int result = sqLiteDatabase.update(diaryDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        diaryDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    public boolean removeDiary(long id) {

        SQLiteDatabase sqLiteDatabase = diaryDBHelper.getWritableDatabase();
        String whereClause = DiaryDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id)};
        int result = sqLiteDatabase.delete(DiaryDBHelper.TABLE_NAME, whereClause, whereArgs);
        diaryDBHelper.close();

        if (result > 0) return true;
        return false;
    }

    public void close() {
        if (diaryDBHelper != null) diaryDBHelper.close();
        if (cursor != null) cursor.close();
    };
}

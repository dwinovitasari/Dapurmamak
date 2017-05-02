package innovable.dev.warung.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import innovable.dev.warung.models.modelData;
import innovable.dev.warung.models.modelWarungFav;

public class SqliteHelper extends SQLiteOpenHelper {

    public static final String Nama_Database ="warung.db";
    public static String Nama_Table = "favorite";

    Context context;
    public SqliteHelper(Context context){
        super(context, Nama_Database, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Nama_Table +
                "(id integer primary key autoincrement, id_warung text, warung text)");
    }

//    public void createNew(SQLiteDatabase db){
//        try {
//            db.execSQL("create table " + Nama_Table +
//                    "(id integer primary key autoincrement, id_warung text, warung text)");
//            Toast.makeText(context, "Database Berhasil Dicreate", Toast.LENGTH_SHORT).show();
//        } catch (SQLiteException e){
//            Toast.makeText(context, "Database Sudah Ada", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Nama_Table);
        onCreate(db);
    }

    public boolean masukanData(String id_warung, String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("id_warung", id_warung);
        data.put("warung", nama);
        try {
            db.insert(Nama_Table, null, data);
            Toast.makeText(context, "Warung tersimpan dalam database favorite", Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e){
            Log.e("error", String.valueOf(e.getMessage()));
            Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public ArrayList<modelData> getAllData() {
        ArrayList<modelData> array_list = new ArrayList<modelData>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+Nama_Table, null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(new modelData(res.getString(res.getColumnIndex("id")), res.getString(res.getColumnIndex("warung"))));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<modelWarungFav> getAllDataFav() {
        ArrayList<modelWarungFav> array_list = new ArrayList<modelWarungFav>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+Nama_Table, null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(new modelWarungFav(res.getString(res.getColumnIndex("id")), res.getString(res.getColumnIndex("id_warung")),res.getString(res.getColumnIndex("warung"))));
            res.moveToNext();
        }
        return array_list;
    }

    public Integer deleteFav(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Nama_Table,
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
}

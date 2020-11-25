import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Admindatabase extends SQLiteOpenHelper {
    public Admindatabase(Context Context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(Context,"smile_for_me",factory,version);
    }
@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
{
    sqLiteDatabase.execSQL("Create table admindata(id integer primary key autoincrement, username text, password text)");
}
@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int ver, int ver2)
{
sqLiteDatabase.execSQL("drop table admindata");
onCreate(sqLiteDatabase);
}
public void insertintoadmin(String username, String password)
{
    this.getWritableDatabase().execSQL("insert into admindata(username,password) values('"+username+"','"+password+"')");

}


}

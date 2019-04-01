package cn.grass.meter.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.grass.meter.GrassApp;


public class DbHelper extends SQLiteOpenHelper {
    /**
     * 数据库名称，数据库版本代码
     */
    private static String DATABASE_NAME = "meter.db";
    /**
     * 数据库版本初始是1
     */
    private static final int DATABASE_VERSION = 4;
    private static DbHelper helper;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    public static synchronized DbHelper getInstance() {
        if (helper == null) {
            helper = new DbHelper(GrassApp.getInstance());
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(UserInfoDb.USERNAME_TABLE_CREATE);
        db.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");
//        db.execSQL(ChatUserDb.CHAT_USERS_TABLE_CREATE);
//        db.execSQL(VideosDb.LESSONS_TABLE_CREATE);
//        db.execSQL(MenuDb.MENU_TABLE_CREATE);
//        db.execSQL(TeaMenuDb.MENU_TABLE_CREATE);
//        db.execSQL(ManagerMenuDb.MENU_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //暂时不做更新数据处理
//		int ver=oldVersion;
//        if (oldVersion != newVersion) {
        try{
            db.execSQL(UserInfoDb.USERNAME_TABLE_DROP);
//            db.execSQL(ChatUserDb.CHAT_USERS_TABLE_DROP);
//            db.execSQL(VideosDb.LESSONS_TABLE_DROP);
            if(oldVersion>4){

//                    db.execSQL(MenuDb.MENUS_TABLE_DROP);
//                    db.execSQL(TeaMenuDb.MENUS_TABLE_DROP);
            }
        }catch (Exception e){

        }


//        }
//		if(ver==1){
//			//版本11升级到12需要执行
//		 //	db.execSQL(SearchDb.DROP_USERINFO);
//		}

    }

}

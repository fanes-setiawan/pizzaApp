import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "pizza"
        private const val DATABASE_VERSION = 1
        //table name
        private const val TABLE_ACCOUNT = "account"
        //column account table
        private val COLUMN_EMAIL ="email"
        private val COLUMN_NAME = "name"
        private val COLUMN_LEVEL = "level"
        private val COLUMN_PASSWORD = "password"
    }
    private  val CREATE_ACCOUNT_TABLE = ("CREATE TABLE" + TABLE_ACCOUNT + "(" + COLUMN_EMAIL + "TEXT PRIMARY KET, " + COLUMN_NAME + "TEXT, " + COLUMN_LEVEL + "TEXT, " + COLUMN_PASSWORD +" TEXT")

    //drop table account sql query

    private  val DROP_ACCOUNT_TABLE = "DROP TABLE IF EXISTS $TABLE_ACCOUNT"
    override fun onCreate(db: SQLiteDatabase) {
        db?.execSQL(CREATE_ACCOUNT_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_ACCOUNT_TABLE)
        onCreate(db)
    }

    fun checkLogin(email: String , password : String):Boolean{
        val column = arrayOf(COLUMN_NAME)
        val db = this.readableDatabase
        val selection = "$COLUMN_EMAIL = ? AND $$COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(email,password)

        val cursor = db.query(TABLE_ACCOUNT ,
            column,
            selection,
            selectionArgs,
            null,
            null,
            null)
        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if(cursorCount > 0)
            return true
        else
            return false
    }
}

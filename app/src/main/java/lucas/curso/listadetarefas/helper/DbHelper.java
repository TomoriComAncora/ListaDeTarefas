package lucas.curso.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELAS_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELAS_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);";

        try {
            db.execSQL(sql);
            Log.i("INFO_DB", "Tabela criada com sucesso");
        }catch (Exception e){
            Log.i("INFO_DB", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELAS_TAREFAS + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO_DB", "Tabela atualizada com sucesso");
        }catch (Exception e){
            Log.i("INFO_DB", "Erro ao atualizar a tabela" + e.getMessage());
        }
    }
}

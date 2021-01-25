package com.example.esnafim;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseOpenHelper extends SQLiteAssetHelper {
  private static final String DATABASE_NAME = "esnafim.db";
  private static final int DATABASE_VERSION =2;

  public DatabaseOpenHelper (Context context){
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
  }
}

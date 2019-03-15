package com.nicro.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.nicro.aidlserver.Book;
import com.nicro.aidlserver.BookControl;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Client";

    private BookControl bookControl;

    private boolean connected;

    private List<Book> bookList;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bookControl = BookControl.Stub.asInterface(iBinder);
            connected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            connected = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.nicro.aidlserver");
        intent.setAction("com.nicro.aidlserver.action");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void getBookList(View view) {
        if (connected) {
            try {
                bookList = bookControl.getBookList();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            log();
        }
    }

    public void addBook_InOut(View view) {
        if (connected) {
            Book book = new Book("这是一本新书 InOut");
            try {
                bookControl.addBookInOut(book);
                Log.e(TAG, "向服务器新增了一本书");
                Log.e(TAG, "新书名 " + book.getName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void addBook_In(View view) {
        if (connected) {
            Book book = new Book("这是一本新书 In");
            try {
                bookControl.addBookIn(book);
                Log.e(TAG, "向服务器新增了一本书");
                Log.e(TAG, "新书名 " + book.getName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void addBook_Out(View view) {
        if (connected) {
            Book book = new Book("这是一本新书 Out");
            try {
                bookControl.addBookOut(book);
                Log.e(TAG, "向服务器新增了一本书");
                Log.e(TAG, "新书名 " + book.getName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void log() {
        for (Book book : bookList) {
            Log.e(TAG, book.toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connected) {
            unbindService(serviceConnection);
        }
    }
}

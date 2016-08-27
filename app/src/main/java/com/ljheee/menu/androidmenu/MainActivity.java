package com.ljheee.menu.androidmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private String[] data = {"选项菜单（Options menu）", "上下文菜单（Context menu）", "Contextual Action Bar（CAB）", "弹出菜单（Popup menu）"};
    private ArrayAdapter<String> adapter;

    private Class[] items = {OptionsActivity.class, ContextActivity.class, CabActivity.class, PopupActivity.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置导航图标
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);


        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textView_item, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, items[position]));
    }


}

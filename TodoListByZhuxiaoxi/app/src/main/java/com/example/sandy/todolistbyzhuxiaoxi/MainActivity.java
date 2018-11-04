package com.example.sandy.todolistbyzhuxiaoxi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListItem> itemList = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"你点击了添加按钮！",Toast.LENGTH_SHORT).show();
                defaultInit();
                Intent intent1 = new Intent(MainActivity.this,EditActivity.class);
                intent1.putExtra("extra_index",itemList.size());//传给它该事项的位置
                startActivityForResult(intent1, 1);//ToDo 小心这里也许传入的各个list都指向一个edit。
                break;
            case R.id.delete_all:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("您正在执行删除操作");
                dialog.setMessage("您确定要删除全部？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("是哒^-^",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    itemList.clear();
                    adapter.notifyItemInserted(0);

                }
            });
                dialog.setNegativeButton("手抖*^*", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            default:
        }
        return true;
    }
     private void initialize(){
        for (int i=0;i<20;i++){
            ListItem item1 = new ListItem(new String("这是示例"),new String("初始化示例"),itemList.size());
            itemList.add(item1);
        }
     }

     private void defaultInit(){
        ListItem item = new ListItem(new String("默认标题"),new String(""),itemList.size());
        itemList.add(item);
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode==RESULT_OK){
            Toast.makeText(MainActivity.this,"内容保存成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

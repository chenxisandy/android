package com.example.sandy.todolistbyzhuxiaoxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent intentGet = getIntent();
        final int indexOfThis = intentGet.getIntExtra("extra_index", ItemAdapter.mList.size());//给一个默认值即最高index加一。
        final EditText editTextContent = findViewById(R.id.edit_content);
        editTextContent.setText(ItemAdapter.mList.get(indexOfThis).getContent());
        final EditText editTextName = findViewById(R.id.list_name);
        editTextName.setText(ItemAdapter.mList.get(indexOfThis).getName());
        Button button1 = findViewById(R.id.save_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemAdapter.mList.get(indexOfThis).setContent(editTextContent.getText().toString());
                ItemAdapter.mList.get(indexOfThis).setName(editTextName.getText().toString());
                String contentSend=ItemAdapter.mList.get(indexOfThis).getContent();
                Intent intentSend = new Intent();
                intentSend.putExtra("content_return",contentSend);
                setResult(RESULT_OK,intentSend);
                finish();
            }
        });
    }
}

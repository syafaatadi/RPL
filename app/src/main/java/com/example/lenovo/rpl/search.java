package com.example.lenovo.rpl;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class search extends AppCompatActivity {
    String [] items;
    ArrayList<String> listitems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView=(ListView)findViewById(R.id.listview);
        editText= (EditText)findViewById(R.id.txtsearch);
                initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().equals("")){
                        //reset listview
                        initlist();
                    }
                    else{
                        //perform search
                        searchItem(s.toString());
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initList() {
    }

    public void searchItem(String textToSearch){
        for (String item:items){
            if (!item.contains(textToSearch)){
                listitems.remove(item);
            }
        }

        adapter.notifyDataSetChanged();
    }

    public void initlist(){
        items=new String[]{"profile","matkul","file"};
                listitems=new ArrayList<>(Arrays.asList(items));
                adapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listitems);
                listView.setAdapter(adapter);
    }
}

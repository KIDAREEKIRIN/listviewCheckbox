package com.example.listviewcheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listViewData;
    ArrayAdapter<String> adapter;
    String[] arrayPeliculas = {"수련활동", "현장체험학습", "수학여행", "학부모상담", "학습준비물", "환경용품",
                "학생상담주간","친목"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewData = findViewById(R.id.listView_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,arrayPeliculas);
        listViewData.setAdapter(adapter);
    }

    //해당 함수에서는 Menu Inflater를 통하여 XML Menu 리소스에 정의된 내용을 파싱 하여 Menu 객체를 생성하고 추가를 하게 됩니다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    // 특정 아이템을 선택했을 때, 호출되는 함수.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // item 값의 id 값을 int id로 생성.
        int id = item.getItemId();
        if(id == R.id.item_done) {
            String itemSelected = "Selected items: \n ";
            for (int i=0; i<listViewData.getCount();i++){
                if(listViewData.isItemChecked(i)){
                    itemSelected += listViewData.getItemAtPosition(i) + "\n";
                }
            }
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
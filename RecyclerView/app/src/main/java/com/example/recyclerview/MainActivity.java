package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//어댑터에 들어갈 아이템의 데이터를 담아둘 클래스 정의하기
//각 아이템의 레이아웃 구성하기 (각 아이템을 카드처럼 보이도록 하기 위해서 CardView로 구성
//어댑터 만둘기
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("표자연","010-0000-0000"));
        adapter.addItem(new Person("김선린","010-0000-0000"));
        adapter.addItem(new Person("한선린","010-0000-0000"));

        recyclerView.setAdapter(adapter);
    }
}
package com.example.recyclerview;
//뷰홀더를 정의했으니까 어댑터 정의하기
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    //Person 객체를 관리 할 ArrayList 만들기
    ArrayList<Person> items = new ArrayList<>();

    //뷰홀더가 만들어질 때 호출
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //우리가 만들어둔 person_item xml 레이아웃을 인플레이션하여 뷰 객체 만듦 - > LayoutInflater 사용
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item,parent,false);


        //리턴할 떄 뷰홀더 객체를 만들면서 위에서 인플레이션해둔 itemView를 인자로 보냄

        return new ViewHolder(itemView);
    }

    //리사이클러뷰에서는 여러개의 아이템이 있을 떄, 스크롤하여 화면에서 사라지는 아이템 객체를
    //새로 화면에 나타날 아이템들이 재사용함 -> 뷰홀더 객체가 재사용됨
    //뷰홀더 객체를 재사용할 때 호출하는 메소드
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //items에서 position번째 객체를 꺼내서 세팅
        Person item = items.get(position);
        holder.setItem(item);
    }

    //어댑터에서 관리하는 아이템의 개수를 변환(리사이클러뷰가 어댑터에서 관리하는 아이템개수를 알아야할 때 사용)
    @Override
    public int getItemCount() {
        //아이템을 ArrayList로 관리하니까 사이즈/ 크기 반환

        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        //아이템마다 서로 다른 이름, 전화번호가 세팅될 수 있도록 뷰홀더 안에서 텍스트뷰 2개 참조변수 만들어서
        //세팅해주기
        TextView textView1,textView2;


       //리스트에 나타날 각 아이템들은 뷰로 만들어지고
        //그 뷰들은 뷰홀더에 담아둠
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //뷰 객체 안에 있는 텍스트뷰 주소값 담기
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);


        }

        //뷰 홀더에 들어있는 뷰 객체의 데이터 세팅
        public void setItem(Person item){
            textView1.setText(item.getName());
            textView2.setText(item.getMobile());

        }
    }

    //마지막으로 어댑터에 있는 ArrayList를 관리하기 위한 메소드
    public void addItem(Person item){items.add(item);}
    public void setItems(ArrayList<Person> items){this.items = items; }
    public Person getItem(int position){return  items.get(position);}
    public void setItem(int position, Person item){items.set(position, item);}
}

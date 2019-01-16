package memomaster.lunastratos.com.memomaster.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import memomaster.lunastratos.com.memomaster.Adapter.listviewAdapter;
import memomaster.lunastratos.com.memomaster.R;
import memomaster.lunastratos.com.memomaster.VO.memoVO;
import memomaster.lunastratos.com.memomaster.view.ItemView;
import memomaster.lunastratos.com.memomaster.view.ReadAndWriteView;

public class HomeFragment extends Fragment {

    ListView listview_id;
    listviewAdapter adapter;
    
    private static final int READ_NOTE = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_layout, container ,false);

        listview_id = v.findViewById(R.id.listview_id);
        adapter = new listviewAdapter();

        additemsforTest(); //테스트

        listview_id.setAdapter(adapter);

        listview_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ReadAndWriteView.class);
                memoVO item = (memoVO) adapter.getItem(position);
                intent.putExtra("number", item.getNumber());
                startActivityForResult(intent, READ_NOTE);

            }
        });

        return v;
    }

    /**
     * 테스트 용도
     */
    public void additemsforTest(){
        adapter.addItem(new memoVO("1", "1", 1));
        adapter.addItem(new memoVO("2", "2", 2));
    }

    /**
     * Sql연결해서 제목 날짜만 가져오기
     *
     */
    public void additems(){
        new memoVO("", "", 1);
    }
}

package com.hch.hooney.talkproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hch.hooney.talkproject.lists.RoomListAdapter;
import com.hch.hooney.talkproject.vo.ListData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private final int SIG_ADD = 101;

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference rootRef = database.getReference("TalkApp");

    public RecyclerView recyclerView;
    public RoomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        loadData();
    }

    private void loadData() {
        rootRef.child("List").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<ListData> list = new ArrayList<>();
                for(DataSnapshot node : dataSnapshot.getChildren()){
                    ListData item = new ListData();
                    item.setRid(node.getKey());
                    item.setName(node.child("name").getValue().toString());
                    item.setCreate(node.child("create").getValue().toString());
                    item.setPwd(node.child("pwd").getValue().toString());
                    item.setSecret((boolean)node.child("secret").getValue());
                    list.add(item);
                }

                adapter.setList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init() {
        adapter = new RoomListAdapter();
        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getApplicationContext(),
                RecyclerView.VERTICAL,
                false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_add_room:
                startActivityForResult(new Intent(getApplicationContext(), AddActivity.class), SIG_ADD);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case SIG_ADD:
                if(resultCode == Activity.RESULT_OK){

                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

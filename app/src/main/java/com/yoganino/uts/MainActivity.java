package com.yoganino.uts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter adapter;
    List<ContactModel> contactModels=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        adapter=new ContactAdapter(this,contactModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        isiData();
    }

    private void isiData() {
        ContactModel model = new ContactModel("Yoga", "Yoga@gmail.com","0897655566");
        contactModels.add(model);

        model = new ContactModel("Nino", "Nino@gmail.com","0897655566");
        contactModels.add(model);

        model = new ContactModel("Pradipta", "Pradipta@gmail.com","0897655566");
        contactModels.add(model);

        adapter.notifyDataSetChanged();

    }
}

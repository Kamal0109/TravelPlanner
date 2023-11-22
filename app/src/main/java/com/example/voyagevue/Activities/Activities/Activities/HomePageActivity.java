package com.example.voyagevue.Activities.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.voyagevue.Activities.Activities.Adapter.CategoryAdapter;
import com.example.voyagevue.Activities.Activities.Adapter.PopularAdapter;
import com.example.voyagevue.Activities.Activities.Domains.CategoryDomain;
import com.example.voyagevue.Activities.Activities.Domains.PopularDomain;
import com.example.voyagevue.R;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular,adapterCat;
    private RecyclerView recyclerViewPopular,recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initRecyclerView();
    }

    private void initRecyclerView(){
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("Mar Caible,avendia lago","Miami Beach","This is 2bed/1 bath home  boasts an enormous," +
                "open-living plan, accented by striking" +
                "architectural feature and high-end finishes."+
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning"+
                "coffered ceiling",2,true,4.8,"pic1",true,2000));
        items.add(new PopularDomain("Passo Rolle, TN","Hawai Beach","This is 2bed/1 bath home  boasts an enormous," +
                "open-living plan, accented by striking" +
                "architectural feature and high-end finishes."+
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning"+
                "coffered ceiling",1,true,4.6,"pic2",true,3000));
        items.add(new PopularDomain("Mar Caible, avendia lago","Miami Beach","This is 2bed/1 bath home  boasts an enormous," +
                "open-living plan, accented by striking" +
                "architectural feature and high-end finishes."+
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning"+
                "coffered ceiling",2,true,4.4,"pic3",true,5000));


        recyclerViewPopular = findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);


        ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches","cat1"));
        catsList.add(new CategoryDomain("Camps","cat2"));
        catsList.add(new CategoryDomain("Forest","cat3"));
        catsList.add(new CategoryDomain("Desert","cat4"));
        catsList.add(new CategoryDomain("Mountain","cat5"));


        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);

    }

}
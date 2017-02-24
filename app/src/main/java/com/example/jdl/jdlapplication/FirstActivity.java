package com.example.jdl.jdlapplication;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.i(TAG, "onCreate: ");
        Button bt = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent("com.example.jdl.jdlapplication.ACTION_START");
                intent.addCategory("android.intent.category.CAONIMA");
                startActivity(intent);*/
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
                //１是用来指定在返回这个acticity时判断是哪个activity返回的也就是requestCode请求码
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                startActivityForResult(intent,2);
                //２是用来指定在返回这个acticity时判断是哪个activity返回的也就是requestCode请求码
            }
        });
        /*LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(manager);//必须指定一个manager类型，否则recyclerview不知道该如何显示
        List list = initFruitList();
        recyclerView.setAdapter(new FruitAdapter(list));

    }

    private List initFruitList() {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
        return fruitList;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult: "+requestCode);
        //requestCode是用来区分哪个activity传递的(start时)，resultCode是判断是否成功的
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    Toast.makeText(this,data.getStringExtra("SecondActivity"),Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if(resultCode==RESULT_OK){
                    Toast.makeText(this,data.getStringExtra("ThirdActivity"),Toast.LENGTH_SHORT).show();
                    //data在get时，如果在传递数据时没有传入intent对象，把intent传递过来会报空指针
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }


    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this,"remove",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}

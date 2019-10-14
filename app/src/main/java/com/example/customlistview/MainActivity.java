package com.example.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView;
        listView = findViewById(R.id.ListView);
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre", "Word");
        map.put("description", "Editeur de text");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "Exel");
        map.put("description", "Tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "PowerPoint");
        map.put("description", "Logiciel de présentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier électronique ");
        map.put("img", String.valueOf(R.drawable.outlook));
        listItem.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.items,
                new String[]{"img", "titre", "description"},
                new int[]{R.id.img, R.id.titre, R.id.description});
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  HashMap<String,String> map=(HashMap<String,String>)  listView.getItemAtPosition(position);

                   Toast.makeText(MainActivity.this, map.get("titre"), Toast.LENGTH_SHORT).show();


                      }
            }
        );


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String,String> map=(HashMap<String,String>)  listView.getItemAtPosition(position);

                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection item");
                builder.setMessage("Votre choix:"+map.get("titre"));
                builder.setPositiveButton("ok",null);
                builder.show();
                return true;
            }
        });
    }
}

package com.example.vishwasbhatia.shoocal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import data.model.Post;
import data.model.remote.APIService;
import data.model.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SqlLite sqlLite=new SqlLite(this);
    private APIService mapiservice;
    private  List<String> list = new ArrayList<String>();
    public EditText fname, lname, phone, address, restaurantname;
    public TextView disp;
    private Button button;
    private Spinner spinner1;
    private int postion1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("Request By");
        list.add("Owner");
        list.add("Manager");
        list.add("Other");
        fname = (EditText) findViewById(R.id.edittext1);
        lname = (EditText) findViewById(R.id.edittext2);
        phone = (EditText) findViewById(R.id.edittext3);
        address = (EditText) findViewById(R.id.edittext4);
        restaurantname = (EditText) findViewById(R.id.edittext5);
        button = (Button) findViewById(R.id.SubmitButton);
        disp = (TextView) findViewById(R.id.display);
        spinner1=(Spinner)findViewById(R.id.Spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                postion1=position;
//                Toast.makeText(getApplicationContext(),position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mapiservice = ApiUtils.getAPIService();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = fname.getText().toString().trim();
                String lastname = lname.getText().toString().trim();
                String addr = address.getText().toString().trim();
                String restname = restaurantname.getText().toString().trim();
                long ph= Long.parseLong(phone.getText().toString());
                Log.i("Phone", String.valueOf(ph));
                Log.i("Pos", String.valueOf(postion1));
                sendPost(firstname, lastname, ph, addr, restname, postion1);
                boolean s=sqlLite.insertdata(firstname,lastname,String.valueOf(ph),addr,restname,String.valueOf(postion1));
                if(s)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });



    }

    public void sendPost(String f1, String f2, long d, String f3, String f4, int t) {
        mapiservice.savePost(f1, f2, d, f3, f4, t).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();
//                    showResponse(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Unsuccessfull",Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void showResponse(String response) {
//        if (disp.getVisibility() == View.GONE) {
//            disp.setVisibility(View.VISIBLE);
//        }
//        disp.setText(response);
//    }
}


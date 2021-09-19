package com.example.anushmp.threadsyouassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //savebutton inputname tvshowname

    Button savebutton;
    EditText inputname;
    TextView tvshowname;
    FileOutputStream fos;

    File dir;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        savebutton = findViewById(R.id.savebutton);
        inputname = findViewById(R.id.inputname);
        tvshowname = findViewById(R.id.tvshowname);


         dir = new File(getFilesDir() + File.separator + "names");

        if(!dir.exists()){dir.mkdir();}

        file = new File(dir,"names.txt");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            //fos = openFileOutput("listofnames",MODE_PRIVATE);

            fos = new FileOutputStream(file,true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        savebutton.setOnClickListener(v->{

            String name = inputname.getText().toString();

            SaveNameTaskHandler sv = new SaveNameTaskHandler(name,fos);

            sv.execute();

            //String[] objectarray  = {name};

            //String done = (String) sv.doInBackground(objectarray);
            //verbose.

            Toast.makeText(this, "Name saved to file", Toast.LENGTH_SHORT).show();







        });


        tvshowname.setOnClickListener(v->{

            try {

                FileInputStream fis = null;

                fis = new FileInputStream(file);

               // fis = openFileInput("listofnames");

                InputStreamReader isr = new InputStreamReader(fis);

                BufferedReader br = new BufferedReader(isr);

                StringBuilder sb = new StringBuilder();

                String text;



                while((text = br.readLine())!= null){
                    //text = text + br.readLine();

                    sb.append(text);
                    sb.append("\n");

                }

                //sb.append(text);


                if(sb != null){

                    tvshowname.setText(sb);

                }


            }catch (Exception e){

                Toast.makeText(this, "file not saved yet", Toast.LENGTH_SHORT).show();

            }

        });




    }
}
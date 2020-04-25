package com.example.protetris;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

class Elements {
    int score;
    String name;

    public Elements(int s, String st){
        this.score = s;
        this.name = st;
    }
}


public class GameOver extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 0;
    private static final String COLOR_KEY = "COLORKEY";
    private Uri photoUri;
    private Bitmap photoBitmap;
    private TextView namePhoto;
    private ImageView photo;
    private TextView scorePhoto;
    private Button btnSend;
    private Button btnReset;
    private Button btnNewGame;
    private Button btnColor;
    private Button btnMenu;
    private Button btnExit;
    private Button btnClose;
    private TextView txv1;
    private TextView txv2;
    private TextView txv3;
    private TextView txv4;
    private TextView txv5;
    private EditText edtx;
    private int points;
    private int color;
    private boolean sent = false;
    private boolean reset = true;
    public static final String SHARED_PREFS = "Shprefs";
    public static final String FIRSTAUX = "Nombre";
    public static final String SECONDAUX = "Puntuacion";
    public static final String FIRST = "Nombre0";
    public static final String SECOND = "Puntuacion0";
    public static final String FIRST2 = "Nombre1";
    public static final String SECOND2 = "Puntuacion1";
    public static final String FIRST3 = "Nombre2";
    public static final String SECOND3 = "Puntuacion2";
    public static final String FIRST4 = "Nombre3";
    public static final String SECOND4 = "Puntuacion3";
    public static final String FIRST5 = "Nombre4";
    public static final String SECOND5 = "Puntuacion4";

    private MediaPlayer media;
    private boolean played;


    LinkedList<Elements> pqueue = new LinkedList<Elements>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        this.played = getIntent().getBooleanExtra("played",false);

        if(this.played) {
            points = getIntent().getIntExtra("score", points);
            color = getIntent().getIntExtra(COLOR_KEY, color);

            this.media = MediaPlayer.create(this,R.raw.astronomia);
            this.media.start();
        }


        txv1 = findViewById(R.id.textView2);
        txv2 = findViewById(R.id.textView3);
        txv3 = findViewById(R.id.textView4);
        txv4 = findViewById(R.id.textView5);
        txv5 = findViewById(R.id.textView6);

        edtx = findViewById(R.id.Edit1);
        btnSend = findViewById(R.id.button2);

        if(!this.played) {
            points = getIntent().getIntExtra("score", points);
            color = getIntent().getIntExtra(COLOR_KEY, color);

            this.edtx.setEnabled(Boolean.FALSE);
            this.btnSend.setEnabled(Boolean.FALSE);
        }

        btnReset = findViewById(R.id.button3);
        btnNewGame = findViewById(R.id.button4);
        btnColor = findViewById(R.id.button5);
        btnMenu = findViewById(R.id.button6);
        btnExit = findViewById(R.id.button7);
        btnClose = findViewById(R.id.buttonClose);
        initScores();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                media.stop();

                if (!sent) {
                    takePhoto();
                }
                sortScores();
                edtx.setEnabled(false);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reset) {
                    reset = false;
                    resetScores();
                } else {
                    Toast.makeText(getBaseContext(),"Highscore already reset", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.newPhoto).setVisibility(View.GONE);
                btnSend.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePhoto();
                } else {
                    Toast.makeText(getBaseContext(),"Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void takePhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_IMAGE_CAPTURE);
            }

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
            }
        } else {
            openCamera();
        }
    }

    public void openCamera() {

        Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (photoIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;

            try {
                photoFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (photoFile != null) {

                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "Foto ProTetris");
                values.put(MediaStore.Images.Media.DESCRIPTION, "Tomada: " + System.currentTimeMillis());
                photoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(photoIntent, REQUEST_IMAGE_CAPTURE);

            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            namePhoto = findViewById(R.id.textView7);
            photo = findViewById(R.id.imageView2);
            scorePhoto = findViewById(R.id.textView8);

            try {
                photoBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), photoUri);
                photo.setImageBitmap(photoBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

            findViewById(R.id.newPhoto).setVisibility(View.VISIBLE);
            namePhoto.setText(edtx.getText().toString());
            scorePhoto.setText("Puntuación: " + points);
            btnSend.setVisibility(View.INVISIBLE);
            btnReset.setVisibility(View.INVISIBLE);

        }
    }

    private void save(String data, int data2, String key1, String key2) {
        SharedPreferences Sh = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor edit = Sh.edit();

        edit.putString(key1, data);
        edit.putInt(key2, data2);
        edit.apply();
    }

    private void resetScores() {
        save("...", -1, FIRST, SECOND);
        save("...", -1, FIRST2, SECOND2);
        save("...", -1, FIRST3, SECOND3);
        save("...", -1, FIRST4, SECOND4);
        save("...", -1, FIRST5, SECOND5);
        loadScores();
        Toast.makeText(getBaseContext(),"Changes saved", Toast.LENGTH_SHORT).show();
    }

    private void initScores() {
        pqueue.add(new Elements(loadInt(SECOND),loadSt(FIRST)));
        pqueue.add(new Elements(loadInt(SECOND2),loadSt(FIRST2)));
        pqueue.add(new Elements(loadInt(SECOND3),loadSt(FIRST3)));
        pqueue.add(new Elements(loadInt(SECOND4),loadSt(FIRST4)));
        pqueue.add(new Elements(loadInt(SECOND5),loadSt(FIRST5)));

        loadScores();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sortScores() {
        if (!sent) {
            sent = true;
            pqueue.add(new Elements(points, edtx.getText().toString()));

            pqueue.sort(new Comparator<Elements>() {
                @Override
                public int compare(Elements o1, Elements o2) {
                    return Integer.compare(o2.score,o1.score);
                }
            });

            if(pqueue.size()>6){
                pqueue.removeLast();
            }

            int n = 0;

            for(Elements aux: pqueue){
                save(aux.name, aux.score, FIRSTAUX + n, SECONDAUX + n);
                n++;
            }

            update(txv1, loadSt(FIRST), loadInt(SECOND));
            update(txv2, loadSt(FIRST2), loadInt(SECOND2));
            update(txv3, loadSt(FIRST3), loadInt(SECOND3));
            update(txv4, loadSt(FIRST4), loadInt(SECOND4));
            update(txv5, loadSt(FIRST5), loadInt(SECOND5));
        }
        else {
            Toast.makeText(getBaseContext(),"Can't send", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadScores(){
        update(txv1,loadSt(FIRST),loadInt(SECOND));
        update(txv2,loadSt(FIRST2),loadInt(SECOND2));
        update(txv3,loadSt(FIRST3),loadInt(SECOND3));
        update(txv4,loadSt(FIRST4),loadInt(SECOND4));
        update(txv5,loadSt(FIRST5),loadInt(SECOND5));

    }

    private String  loadSt(String key) {
        SharedPreferences Sh = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return Sh.getString(key, "...");
    }

    private int loadInt(String key) {
        SharedPreferences Sh = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return Sh.getInt(key, 0);
    }

    private long loadLong(String key){
        SharedPreferences Sh = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return Sh.getLong(key,0);
    }

    private void update (TextView Txv1, String d1, int d2) {
        if(d1.equals("...")){
            Txv1.setText(d1+": "+ 0 +" puntos");
        }
        else{
            Txv1.setText(d1+": "+ d2 +" puntos");
        }
    }

    @Override
    public void onBackPressed() {

        if (points < 250) {
            super.onBackPressed();
        } else {
            btnSend.setVisibility(View.INVISIBLE);
            btnReset.setVisibility(View.INVISIBLE);
            findViewById(R.id.newPhoto).setVisibility(View.GONE);
            findViewById(R.id.newGame).setVisibility(View.VISIBLE);
        }

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this,ProTetris.class);
                intent.putExtra(COLOR_KEY,color);
                startActivity(intent);
                GameOver.this.finish();
            }
        });
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this,MainColor.class);
                startActivity(intent);
                GameOver.this.finish();
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameOver.this.finish();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                GameOver.this.finish();
            }
        });
    }
}
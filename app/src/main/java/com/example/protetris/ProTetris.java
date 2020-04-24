package com.example.protetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class ProTetris extends AppCompatActivity implements MediaPlayer.OnCompletionListener{

    private ImageView rotateButton;
    private ImageView leftButton;
    private ImageView rightButton;
    private ImageView downButton;
    private TextView actualPoints;

    private RelativeLayout nextPiece;
    private TextView changePieceIndicator;

    private ImageView changeSong;
    private boolean musicEnabled;


    private TextView actualCombo;
    private boolean stop;

    private Button startButton;
    private MainBoard mainBoard;
    private MainGame game;
    private UpcomingPiece upcomingPiece;
    private MediaPlayer media;
    private int [] sounds = {R.raw.billie,R.raw.breakfree,R.raw.gonnalive,R.raw.high,R.raw.guns,R.raw.eury,R.raw.carro};
    private int sound;
    private int colornum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_tetris);

        sound = (int) Math.floor(Math.random() * sounds.length);
        this.media = MediaPlayer.create(this,sounds[sound]);
        this.media.setOnCompletionListener(this);

        this.mainBoard = new MainBoard();

        this.rotateButton = findViewById(R.id.rotateButton);
        this.leftButton = findViewById(R.id.leftButton);
        this.rightButton = findViewById(R.id.rightButton);
        this.downButton = findViewById(R.id.downButton);
        this.actualPoints =  findViewById(R.id.textScore);
        this.actualCombo=findViewById(R.id.textCombo);
        this.startButton = findViewById(R.id.start);
        this.stop = true;
        Bundle datos = this.getIntent().getExtras();
        this.colornum = datos.getInt("COLORKEY");
        this.musicEnabled = datos.getBoolean("MUSIC");

        this.nextPiece = findViewById(R.id.pieceView);
        this.changePieceIndicator = findViewById(R.id.changePieceIndicator);

        this.upcomingPiece = new UpcomingPiece(this, mainBoard,this.colornum, nextPiece);
        nextPiece.addView(upcomingPiece);

        this.game = new MainGame(this, this.upcomingPiece, this.mainBoard,this.colornum);
        RelativeLayout gameBoard = findViewById(R.id.tetrisBoard);
        gameBoard.addView(this.game);



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButton.getText().equals("Start") || startButton.getText().equals("Resume")) {
                    startButton.setText("Pause");
                    stop = false;

                    if(musicEnabled){
                        media.start();
                    }
                } else if (startButton.getText().equals("Pause")){
                    startButton.setText("Resume");
                    stop = true;

                    if(musicEnabled){
                        media.pause();
                    }
                }
            }
        });


        this.changeSong.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(musicEnabled) {
                    media.stop();
                    media.start();
                }
            }
        });
    }


    public RelativeLayout getNextPiece(){
        return this.nextPiece;
    }

    public ImageView getLeftButton() {
        return leftButton;
    }

    public ImageView getRightButton() {
        return rightButton;
    }

    public ImageView getRotateButton() {
        return rotateButton;
    }

    public ImageView getDownButton() {
        return downButton;
    }

    public TextView getPoints() {
        return actualPoints;
    }
    public TextView getActualCombo() {
        return actualCombo;
    }
    public boolean getStop() {
        return stop;
    }

    public TextView getChangePieceIndicator(){
        return this.changePieceIndicator;
    }




    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void onPause() {
        super.onPause();
        stop = true;
    }

    @Override
    public void onStart() {
        super.onStart();
        stop = true;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        media.stop();
        finish();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        int auxsound = sound;//para recuperar la cancion al pausar el juego
        sound = (int) Math.floor(Math.random() * sounds.length);
        while(auxsound == sound){
            sound = (int) Math.floor(Math.random()*sounds.length);//caso que se repita cancion
        }
        AssetFileDescriptor asset = this.getResources().openRawResourceFd(sounds[sound]);
        try{
            media.reset();
            media.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getDeclaredLength());
            media.prepare();
            media.start();
            asset.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
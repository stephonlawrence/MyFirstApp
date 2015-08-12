package com.example.android.myfirstapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public Context CTX;
    public Button[] buttons = new Button[10];
    public String[] btnText = {
            "Spotify Streamer",
            "Cores App",
            "Library App",
            "Build It Bigger",
            "XYZ Reader",
            "Capstone: My Own App"
    };
    public RelativeLayout Root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CTX = getApplicationContext();
        Root = (RelativeLayout) findViewById(R.id.root);

        createButtons();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Toast toast;

    public void createButtons(){
        LinearLayout LL = (LinearLayout) findViewById(R.id.layout);

        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        LP.setMargins(0,0,0,25);
        for(int i = 0; i < btnText.length; i++){
            buttons[i] = new Button(this);
            Button btn = buttons[i];

            btn.setLayoutParams(LP);
            btn.setPadding(10, 0, 10, 0);
            btn.setText(btnText[i]);
            if(i == btnText.length - 1) {
                btn.setBackgroundColor(Color.parseColor("#536DFE"));
            }else {
                btn.setBackgroundColor(Color.parseColor("#8C9EFF"));
            }
            btn.setId(i);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    createToast(v);
                }
            });
            LL.addView(btn);
        }
        //buttons[0] = new Button();
    }

    public void createToast(View view){
        Button b = (Button)view;

        CharSequence name = b.getText().toString();
        if(toast instanceof  Toast){
            toast.cancel();
        }
        toast = Toast.makeText(CTX, name, Toast.LENGTH_SHORT);

        toast.show();
    }
}

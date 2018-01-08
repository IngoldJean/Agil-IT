package com.example.ecepfe.agilit;

import android.content.ClipData;
import android.graphics.Color;
import android.opengl.Visibility;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //LinearLayout zonededrop;
    ScrollView zonededrop1, zonededrop2, zonededrop3;
    TextView textcont1, textcont2, textcont3, textcont4, textcont5, textcont6, texttemp;
    RelativeLayout container1, container2, container3, container4, container5, container6, containertemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zonededrop1 = (ScrollView) findViewById(R.id.zonedrop1);
        zonededrop2 = (ScrollView) findViewById(R.id.zonedrop2);
        zonededrop3 = (ScrollView) findViewById(R.id.zonedrop3);

        container1 = (RelativeLayout) findViewById(R.id.container1);
        container2 = (RelativeLayout) findViewById(R.id.container2);
        container3 = (RelativeLayout) findViewById(R.id.container3);
        container4 = (RelativeLayout) findViewById(R.id.container4);
        container5 = (RelativeLayout) findViewById(R.id.container5);
        container6 = (RelativeLayout) findViewById(R.id.container6);

        textcont1 = (TextView) findViewById(R.id.contenertext1);
        textcont2 = (TextView) findViewById(R.id.contenertext2);
        textcont3 = (TextView) findViewById(R.id.contenertext3);
        textcont4 = (TextView) findViewById(R.id.contenertext4);
        textcont5 = (TextView) findViewById(R.id.contenertext5);
        textcont6 = (TextView) findViewById(R.id.contenertext6);


        container1.setOnLongClickListener(longClickListener);
        container2.setOnLongClickListener(longClickListener);
        container3.setOnLongClickListener(longClickListener);
        container4.setOnLongClickListener(longClickListener);
        container5.setOnLongClickListener(longClickListener);
        container6.setOnLongClickListener(longClickListener);

        textcont1.setOnClickListener(affichagepopup);
        textcont2.setOnClickListener(affichagepopup);
        textcont3.setOnClickListener(affichagepopup);
        textcont4.setOnClickListener(affichagepopup);
        textcont5.setOnClickListener(affichagepopup);
        textcont6.setOnClickListener(affichagepopup);

        zonededrop1.setOnDragListener(onDragListener);
        zonededrop2.setOnDragListener(onDragListener);
        zonededrop3.setOnDragListener(onDragListener);
    }

    View.OnClickListener affichagepopup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.tachedeataille, null);

            texttemp = (TextView) findViewById(v.getId());
            TextView textView = (TextView) mView.findViewById(R.id.popuptextdetaille);
            textView.setText(texttemp.getText());

            mbuilder.setView(mView);
            AlertDialog dialog = mbuilder.create();
            dialog.show();
        }
    };


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        }
    };


    View.OnDragListener onDragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragevent=event.getAction();
            final View view = (View) event.getLocalState();

            Log.i("test", String.valueOf(view.getId()));
            //imagetemp = (ImageView) findViewById(view.getId());
            containertemp = (RelativeLayout) findViewById(view.getId());

            switch (dragevent){
                case DragEvent.ACTION_DRAG_STARTED:
                    //imagetemp.setVisibility(View.INVISIBLE);
                    containertemp.setVisibility(View.INVISIBLE);

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DROP:
                    Log.i("drag lisener", "drop");

                    //imagetemp.setVisibility(View.VISIBLE);
                    containertemp.setVisibility(View.VISIBLE);
                    if(v.getId()==R.id.zonedrop2){
                        Log.i("ok","ok");
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches2);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop1){
                        Log.i("ok","ok");
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches1);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop3){
                        Log.i("ok","ok");
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches3);
                        container.addView(view);
                        break;
                    }
                    break;
            }
            return true;
        }
    };
}

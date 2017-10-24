package com.example.ecepfe.agilit;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imagehelene;
    TextView zonededrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagehelene = (ImageView) findViewById(R.id.helenepicture);
        zonededrop = (TextView) findViewById(R.id.zonededrop);

        imagehelene.setOnLongClickListener(longClickListener);
        zonededrop.setOnDragListener(onDragListener);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener onDragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragevent=event.getAction();
            switch (dragevent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("drag lisener", "entered switch");
                    break;
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    zonededrop.setText("Laché dans zone");
                    Log.i("drag lisener", "drop action");
                    break;
            }
            return true;
        }
    };
}

package my.example.drawview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import my.example.drawview.widget.DrawView;

public class MainActivity extends AppCompatActivity {

    private DrawView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.my_view);

        myView.setText("myView");
    }
}
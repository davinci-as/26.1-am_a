package ar.edu.davinci.clasesam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BlogActivity extends AppCompatActivity {

    public void sendMessage(View view){
        Log.i("app-testing", "el click sobre la imagen está funcionando");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent.hasExtra("blog-id")) {
            int blogId = intent.getIntExtra("blog-id", 0);
            Log.i("app-testing", String.format("Está llegando el blogId: %d", blogId));
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package ar.edu.davinci.clasesam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public final  int BLOG_ID = 1;
    public final  int BLOG_DETAILS = 3;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode != BLOG_DETAILS) return;
        if(resultCode != RESULT_OK) return;
        if(!intent.hasExtra("blog-text")) return;

        Log.i("app-testing", intent.getStringExtra("blog-text"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /* evento de click sobre botón */
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                Log.i("app-testing", "el click sobre el botón está funcionando");
                //button.setText(R.string.login_cta_alternative_text);
                Intent intent = new Intent(getApplicationContext(), BlogActivity.class);
                intent.putExtra(getString(R.string.blog_id_key), BLOG_ID);
                startActivityForResult(intent, BLOG_DETAILS);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
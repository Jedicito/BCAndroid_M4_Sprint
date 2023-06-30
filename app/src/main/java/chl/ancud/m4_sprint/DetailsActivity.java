package chl.ancud.m4_sprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import chl.ancud.m4_sprint.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    protected ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initListeners();
    }

    private void initListeners() {

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/cesarseron/")));
            }
        });

        binding.btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            //https://faq.whatsapp.com/511210730860677/?cms_platform=android
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola, no tengo tu número");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);

            }
        });

        binding.btnEnviacorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, binding.etxMensaje.getText().toString());
                String[] correo = {"seron.cesar@gmail.com"};
                sendIntent.putExtra(Intent.EXTRA_EMAIL, correo);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Hola");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });



    }

}
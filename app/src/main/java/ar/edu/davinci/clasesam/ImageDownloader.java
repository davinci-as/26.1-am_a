package ar.edu.davinci.clasesam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        String urlDescarga = strings[0];
        try {
            URL urlConsulta = new URL(urlDescarga);
            InputStream inputStream = (InputStream) urlConsulta.getContent();
            Bitmap imagen = BitmapFactory.decodeStream(inputStream);
            return imagen;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

    }
}

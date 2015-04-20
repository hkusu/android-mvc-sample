package io.github.hkusu.droidkaigi_demo.api;

import android.os.AsyncTask;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.github.hkusu.droidkaigi_demo.entity.QiitaItemEntity;
import io.github.hkusu.droidkaigi_demo.common.Const;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class HogeAsyncTask extends AsyncTask<String, Integer, List<QiitaItemEntity>> {
    public interface AsyncCallback {
        void preExecute();
        void postExecute(List<QiitaItemEntity> result);
        void progressUpdate(int progress);
        void cancel();
    }

    private AsyncCallback mAsyncCallback = null;

    public HogeAsyncTask(AsyncCallback _asyncCallback) {
        mAsyncCallback = _asyncCallback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mAsyncCallback.preExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... _progress) {
        super.onProgressUpdate(_progress);
        mAsyncCallback.progressUpdate(_progress[0]);
    }

    @Override
    protected void onPostExecute(List<QiitaItemEntity> _result) {
        super.onPostExecute(_result);
        mAsyncCallback.postExecute(_result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        mAsyncCallback.cancel();
    }

    @Override
    protected List<QiitaItemEntity> doInBackground(String... _uri) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Const.QIITA_API_ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .build();

        QiitaApiService service = restAdapter
                .create(QiitaApiService.class);

        List<QiitaItemEntity> results = service.getItems();

        return results;
    }
}

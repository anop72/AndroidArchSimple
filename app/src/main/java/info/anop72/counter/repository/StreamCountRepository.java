package info.anop72.counter.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import info.anop72.counter.service.response.CounterModel;
import info.anop72.counter.service.ApiServiceGenerator;
import info.anop72.counter.service.StreamCounterService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StreamCountRepository {

    StreamCounterService streamCounterService;

    public StreamCountRepository() {
        this.streamCounterService = ApiServiceGenerator.createService(StreamCounterService.class);
    }

    public LiveData<CounterModel> getCount() {

        final MutableLiveData<CounterModel> data = new MutableLiveData<>();

        String params = "params";

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        streamCounterService.getDailyCount(body).enqueue(new Callback<CounterModel>() {

            @Override
            public void onResponse(Call<CounterModel> call, Response<CounterModel> response) {
                Log.d("StreamCountRepository", response.body() + "");
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CounterModel> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return data;
    }
}

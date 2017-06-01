package info.anop72.counter.service;

import info.anop72.counter.service.response.CounterModel;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StreamCounterService {

    @POST("/endpoint")
    Call<CounterModel> getDailyCount(@Body RequestBody body);

}

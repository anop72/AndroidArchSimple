package info.anop72.counter.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import info.anop72.counter.repository.StreamCountRepository;
import info.anop72.counter.service.response.CounterModel;

public class CounterViewModel extends ViewModel {

    StreamCountRepository repository;

    public CounterViewModel() {
        this.repository = new StreamCountRepository();
    }

    public LiveData<CounterModel> getCount() {
        return this.repository.getCount();
    }

}

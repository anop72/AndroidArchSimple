package info.anop72.counter;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.anop72.counter.model.CounterViewModel;

public class MainActivity extends LifecycleActivity {

    TextView inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = (TextView) findViewById(R.id.field);

        if (savedInstanceState != null) {
            inputField.setText(savedInstanceState.getString("input"));
        }

        CounterViewModel counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        counterViewModel.getCount().observe(this, counterModel -> {
            inputField.setText(counterModel.hits.total);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("input", inputField.getText().toString());

        super.onSaveInstanceState(outState);

    }
}

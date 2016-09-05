package argaaya.helloprocessing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*--- new ---*/
import android.app.Fragment;
import android.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*--- new ---*/
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new App();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}

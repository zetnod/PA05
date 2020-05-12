package andriodbootcamp.net.pa05;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        /*  enable custom launcher
            to be displayed in the action bar
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_list);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

         /*  create an array of String to hold
            strings that will be displayed in
            the ListView
         */

        String[] newsList = {"Newspaper picture", "KSAT", "MSN", "Weather Channel"};


        /*  create a ListView object and an ArrayAdapter
            object to fill in the ListView widget
         */
        ListView lvNews = (ListView) findViewById(R.id.lvNews);
        ArrayAdapter adapter = new ArrayAdapter(NewsActivity.this,
                android.R.layout.simple_list_item_1, newsList);
        lvNews.setAdapter(adapter);

        /*  create a listener to react to the user's
            selection on the list
         */

        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0: startActivity(new Intent(NewsActivity.this,
                            NewspaperPicActivity.class));
                        break;

                    case 1: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.ksat.com")));
                        break;

                    case 2: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.msn.com")));
                        break;

                    case 3: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.weather.com")));
                        break;

                    default: Toast toast1 = Toast.makeText(NewsActivity.this,
                            "Incorrect item selected", Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0,0);
                    toast1.show();
                } // end switch statement

            } // end method onItemClick
        });

    } // end method onClick
} // end class NewsActivity

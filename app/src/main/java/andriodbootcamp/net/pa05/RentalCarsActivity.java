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

public class RentalCarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_cars);

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
        String[] rentalList = {"Car picture", "Hertz", "Alamo", "Avis"};


        /*  create a ListView object and an ArrayAdapter
            object to fill in the ListView widget
         */
        ListView mylist = (ListView) findViewById(R.id.lvRentalCars);
        ArrayAdapter adapter = new ArrayAdapter(RentalCarsActivity.this,
                android.R.layout.simple_list_item_1, rentalList);
        mylist.setAdapter(adapter);

        /*  create a listener to react to the user's
            selection on the list
         */
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0: startActivity(new Intent(RentalCarsActivity.this,
                            CarPicActivity.class));
                    break;

                    case 1: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.hertz.com")));
                    break;

                    case 2: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.alamo.com")));
                    break;

                    case 3: startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.avis.com")));
                    break;

                    default:
                        Toast toast1 = Toast.makeText(RentalCarsActivity.this,
                                "Incorrect item selected", Toast.LENGTH_LONG);
                        toast1.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0,0);
                        toast1.show();

                } // end switch statement
            } // end method onItemClick
        });

    } // end method onCreate

} // end class RentalCarsActivity

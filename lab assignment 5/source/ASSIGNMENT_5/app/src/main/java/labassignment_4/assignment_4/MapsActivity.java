package labassignment_4.assignment_4;
        import android.Manifest;
        import android.content.Context;
        import android.content.pm.PackageManager;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.location.Address;
        import android.location.Geocoder;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.graphics.BitmapFactory;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.FragmentActivity;

        import com.google.android.gms.common.images.Size;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

        import java.util.List;


        import static labassignment_4.assignment_4.MainActivity.browse_flag;
        import static labassignment_4.assignment_4.MainActivity.cam_flag;
        import static labassignment_4.assignment_4.MainActivity.picturePath;
        import static labassignment_4.assignment_4.Photo.photo;//getting pix taken from Photo module.



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public Geocoder geocoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // getActionBar().setTitle("Map location");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(this);
        StringBuilder userAddress = new StringBuilder();
        // Add a marker in Sydney and move the camera
        LocationManager userCurrentLocation = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        LocationListener userCurrentLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        LatLng userCurrentLocationCorodinates = null;
        double latitute = 0, longitude = 0;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //show message or ask permissions from the user.
            return;
        }
        //Getting the current location of the user.
        userCurrentLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, userCurrentLocationListener);

        // System.out.println(String.format("in while loop net work provider " + userCurrentLocation.getLastKnownLocation(LocationManager.NETWORK_PROVIDER).getLatitude()));
        // while(userCurrentLocation.getLastKnownLocation(LocationManager.GPS_PROVIDER) != null){

        System.out.println(" Gps provider  :::: lat::" + userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude() + "::long::" + userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude());

        latitute = userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                .getLatitude();
        longitude = userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                .getLongitude();

        // }

        userCurrentLocationCorodinates = new LatLng(latitute,longitude);
        //Getting the address of the user based on latitude and longitude.
        try {
            List<Address> addresses = geocoder.getFromLocation(latitute, longitude, 1);
            Address address = addresses.get(0);
            userAddress =  new StringBuilder();
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                userAddress.append(address.getAddressLine(i)).append("\t");
            }
            userAddress.append(address.getCountryName()).append("\t");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        //checking flags
        //System.out.println("cam flag::" + cam_flag + ">>>>>>>>browse flag::: " +browse_flag);
        //Setting our image as the marker icon.
        try {

            System.out.println("cam flag::" + cam_flag + ">>>>>>>>browse flag::: " +browse_flag);

            if (cam_flag) {
                System.out.println("in cam path----------------->cam flag ::" + cam_flag);
                mMap.addMarker(new MarkerOptions().position(userCurrentLocationCorodinates)
                        .title("Your current address.").snippet(userAddress.toString())
                        .icon(BitmapDescriptorFactory.fromBitmap(photo)));//Getting bitmap pic from PhotoActivity page.
                //to locate a pic from drawable folder -->BitmapDescriptorFactory.fromResource(R.drawable.marker_maps)));


            }else if (browse_flag) {


                System.out.println("i am in browse path::.............->>>>>>>browse flag:" + browse_flag);
                mMap.addMarker(new MarkerOptions().position(userCurrentLocationCorodinates)
                        .title("Your current address.").snippet(userAddress.toString())
                        .icon(BitmapDescriptorFactory.fromPath(picturePath)));

            } else {
                System.out.println("in default map---->");
                mMap.addMarker(new MarkerOptions().position(userCurrentLocationCorodinates)
                        .title("Your current address.").snippet(userAddress.toString())
                        .icon((BitmapDescriptorFactory.defaultMarker())));//getting default marker incase if we havent updated any pic yet.

            }




        }
        catch (Exception e){
            System.out.print(e.toString() + "exception occured .............");

        }
        //Setting the zoom level of the map.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userCurrentLocationCorodinates, 7));
    }
}
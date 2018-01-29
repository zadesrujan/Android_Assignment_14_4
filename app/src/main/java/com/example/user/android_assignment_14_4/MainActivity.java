package com.example.user.android_assignment_14_4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    private  int PERMISSION_REQUEST_CODE = 200;
    Button button;
    //Intializing the button and permission request code
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        button = (Button) findViewById(R.id.button);
        //giving button one id
        button.setOnClickListener(new View.OnClickListener() {
            //attaching that button to the set on click listner where it will check while clicking on the button
            @Override
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
                //givig selfcheckpermissionn from the manifest file
                if (result == PackageManager.PERMISSION_GRANTED) {
                    //reslut is ok then permission is granted
                    Toast.makeText(MainActivity.this, "permission granted", Toast.LENGTH_LONG).show();
                    //it wil show the message that permission is granted
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                    //givinng the request code as 1 as base of string
                }
            }
        });
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //getting the request code which we had given and requesting the permissions
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //getting request code,permissions and grant results
        if     (requestCode==1&&grantResults.length>0){
            Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
            //if permission is given as sucessfully then permission is granted toast will be appear.
        }

    }
}

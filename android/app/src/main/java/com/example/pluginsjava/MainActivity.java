package com.example.pluginsjava;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugins.GeneratedPluginRegistrant;
import android.os.Bundle;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "com.channels/test";
  @Override
  protected void onCreate(Bundle savedInstanceState) {



    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);

    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
            new MethodCallHandler(){
              @Override
              public void  onMethodCall(MethodCall call, Result result){
                if(call.method.equals("test")){
                 boolean response = javaChannel();

                  if(response){
                    result.success("Java");
                  }else {
                    result.error("UNAVAILABLE", "not available.", null);
                  }
                }else {
                  result.notImplemented();
                }
              }
            }
    );
  }

  private boolean javaChannel(){


    return true;
  }

}

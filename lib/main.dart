import 'dart:async';
import 'dart:isolate';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
  // DO NOT spawn background Isolate if you want prewam FlutterEngine
  // or it will crash on FlutterEngine.destory() on release build
  // see https://github.com/flutter/flutter/issues/47784
  Isolate.spawn<void>(background, null, debugName: 'background');
}

void background(void message) {
  Timer.periodic(const Duration(seconds: 3), (Timer timer) {
    debugPrint("Background isolate: ${Isolate.current.debugName} working...");
  });
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("test"),
        ),
        body: Column(
          children: <Widget>[
            Text("hello world"),
            RaisedButton(
              onPressed: () => SystemNavigator.pop(),
              child: Text("SystemNavigator.pop()"),
            )
          ],
        ),
      ),
    );
  }
}

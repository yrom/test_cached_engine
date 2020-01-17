package com.example.test_destroy_cached_engine
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.*
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.view.FlutterMain
import io.flutter.app.FlutterApplication
const val CACHE_ENGINE_ID = "cache"
fun prewarm(context: Context) {
    if(!FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
        val flutterEngine = FlutterEngine(context)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        flutterEngine.dartExecutor.executeDartEntrypoint(DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put(CACHE_ENGINE_ID, flutterEngine)
    }
}
class MainApplication: FlutterApplication() {
    override fun onCreate() {
        super.onCreate()
        FlutterMain.ensureInitializationComplete(this, null);
        prewarm(this);
    }
}
class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(
                Button(this@MainActivity).apply {
                    text = "prewarm engine"
                    setOnClickListener {
                        if (FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
                            Toast.makeText(applicationContext, "Already prewarmed!", Toast.LENGTH_SHORT)
                        } else {
                            prewarm(applicationContext)
                        }
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
            addView(
                Button(this@MainActivity).apply {
                    text = "open flutter with prewarm engine"
                    setOnClickListener {
                        if (!FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
                            Toast.makeText(applicationContext, "Already destroyed!", Toast.LENGTH_SHORT)
                        } else {
                            startActivity(
                                FlutterActivity.withCachedEngine(CACHE_ENGINE_ID)
                                    .destroyEngineWithActivity(true)
                                    .build(applicationContext)
                            )
                        }
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
        })
    }
}
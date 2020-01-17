# test_destroy_cached_engine

Clone this project then run with `release` build on any Android device.

```
$ flutter run --relase
```

Open the `FlutterActivity`, then pop,  you will see this crash.

```
2020-01-17 11:04:57.294 6517-6558/? A/libc: Fatal signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr 0x50 in tid 6558 (Thread-4), pid 6517 (y_cached_engine)
2020-01-17 11:04:57.355 6847-6847/? A/DEBUG: *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***
2020-01-17 11:04:57.355 6847-6847/? A/DEBUG: Build fingerprint: 'HUAWEI/VOG-AL10/HWVOG:10/HUAWEIVOG-AL10/10.0.0.185C00:user/release-keys'
2020-01-17 11:04:57.355 6847-6847/? A/DEBUG: Revision: '0'
2020-01-17 11:04:57.355 6847-6847/? A/DEBUG: ABI: 'arm64'
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: SYSVMTYPE: Maple
    APPVMTYPE: Art
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: Timestamp: 2020-01-17 11:04:57+0800
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: pid: 6517, tid: 6558, name: Thread-4  >>> com.example.test_destroy_cached_engine <<<
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: uid: 10301
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr 0x50
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG: Cause: null pointer dereference
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x0  000000760e30e300  x1  000000769e3a1c54  x2  000000760a001870  x3  0000000000000000
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x4  00000000000001fe  x5  0000000000000008  x6  00000076a16c1000  x7  000000000fe7392a
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x8  0000000000000000  x9  0000000000000001  x10 0000000000000001  x11 0000000000000000
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x12 0000000000000000  x13 ffffffffffffffb0  x14 0004536d08d5706d  x15 00000e62f68aa13d
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x16 00000075aec63368  x17 000000769e3a2950  x18 00000075ad7e8000  x19 000000760e30e300
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x20 000000760e30e300  x21 000000760e2a61c0  x22 00000076120170f0  x23 0000000000000001
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x24 0000007603cc3050  x25 000000760e3ee8f0  x26 000000760e3ee920  x27 00000075aec71000
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     x28 0000007603cc3000  x29 000000760a001bb0
2020-01-17 11:04:57.356 6847-6847/? A/DEBUG:     sp  000000760a001400  lr  00000075aeaef6f0  pc  00000075aea7a6e0
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG: backtrace:
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #00 pc 000000000062d6e0  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #01 pc 00000000006a26ec  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #02 pc 00000000004c66f4  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #03 pc 0000000000290000  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #04 pc 00000000002926ec  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #05 pc 0000000000017d8c  /system/lib64/libutils.so (android::Looper::pollInner(int)+856) (BuildId: 868b138f3e4abfebd8910c8133e83b50)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #06 pc 0000000000017994  /system/lib64/libutils.so (android::Looper::pollOnce(int, int*, int*, void**)+56) (BuildId: 868b138f3e4abfebd8910c8133e83b50)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #07 pc 0000000000013684  /system/lib64/libandroid.so (ALooper_pollOnce+96) (BuildId: d98cd12b5c84aaf027fff709255998e4)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #08 pc 0000000000292808  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #09 pc 000000000028f1d8  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #10 pc 0000000000291290  /data/app/com.example.test_destroy_cached_engine-sNLyQ2_mykz3sR3cA6MKqQ==/lib/arm64/libflutter.so!libflutter.so (offset 0x270000) (BuildId: 741afda8f9ff0f9c)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #11 pc 00000000000ce190  /apex/com.android.runtime/lib64/bionic/libc.so (__pthread_start(void*)+36) (BuildId: 2f04208be3c24ae761428c0bcfa6bcdf)
2020-01-17 11:04:57.358 6847-6847/? A/DEBUG:       #12 pc 0000000000070ba8  /apex/com.android.runtime/lib64/bionic/libc.so (__start_thread+64) (BuildId: 2f04208be3c24ae761428c0bcfa6bcdf)
```
package io.github.robertaguilera712.cisojr4droid.core;

import android.os.Handler;

import android.os.Looper;
import androidx.core.os.HandlerCompat;
import io.github.robertaguilera712.cisojr4droid.model.Rom;
import io.github.robertaguilera712.cisojr4droid.utils.Callback;

public class Task {

  protected static Handler handler;

  protected final Rom rom;
  protected final Callback.UpdateProgress updateProgressCallback;
  protected final Callback.Finish finishCallback;

  public Task(
      Rom rom, Callback.UpdateProgress updateProgressCallback, Callback.Finish finishCallback) {
    this.rom = rom;
    this.updateProgressCallback = updateProgressCallback;
    this.finishCallback = finishCallback;
  }

  public static void setHandler(Handler handler) {
    Task.handler = handler;
  }

  public static void RunInUi(Runnable d) {
    var handler = HandlerCompat.createAsync(Looper.getMainLooper());
    handler.post(d);
  }
}

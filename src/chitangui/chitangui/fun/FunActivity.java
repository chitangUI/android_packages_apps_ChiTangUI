package chitangui.chitangui.fun;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.FrameLayout;

public class FunActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = new FrameLayout(this);
        setContentView(layout);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("chitangui.chitangui_unpriv", "chitangui.chitangui_unpriv.fun.FunActivity"));
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 1) {
            Intent intent = new Intent(Intent.ACTION_REQUEST_SHUTDOWN);
            intent.putExtra(Intent.EXTRA_KEY_CONFIRM, false);
            intent.putExtra(Intent.EXTRA_REASON, "chitangui_fun");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        finishActivity(0);
    }

}

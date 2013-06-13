package mc.inappbilling.v3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class InAppBillingActivity extends Activity
{
    private static final String LOGTAG = InAppBillingActivity.class.getSimpleName();

    private InAppBillingHelper inAppBillingHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setVisible(false);

        int requestId = getIntent().getIntExtra("requestId", 0);
        if(requestId == 0)
        {
            finish();
            return;
        }

        InAppBillingV3Impl inAppBillingV3Impl = InAppBillingV3Impl.getCachedInstance(requestId);
        if(inAppBillingV3Impl == null)
        {
            finish();
            return;
        }

        String sku = getIntent().getStringExtra("sku");
        if(TextUtils.isEmpty(sku))
        {
            finish();
            return;
        }

        inAppBillingHelper = inAppBillingV3Impl.getInAppBillingHelper();
        if(inAppBillingHelper != null && inAppBillingHelper.mSetupDone)
        {
            Log.d(LOGTAG, "Launching purchase flow for " + sku);
            try
            {
                inAppBillingHelper.launchPurchaseFlow(this, sku, requestId, inAppBillingV3Impl);
                return;
            }
            catch(IllegalStateException e)
            {
                Log.e(LOGTAG, e.getMessage(), e);
            }
        }
        if(inAppBillingV3Impl != null)
        {
            InAppBillingResult res = new InAppBillingResult(InAppBillingHelper.IABHELPER_UNKNOWN_ERROR, "InAppBillingHelper not valid state or null");
            inAppBillingV3Impl.onIabPurchaseFinished(res, null);
        }
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.d(LOGTAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if(!inAppBillingHelper.handleActivityResult(requestCode, resultCode, data))
        {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        else
        {
            Log.d(LOGTAG, "onActivityResult handled by InAppBillingHelper.");
            finish();
        }
    }
}

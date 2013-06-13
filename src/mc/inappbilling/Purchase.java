/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mc.inappbilling;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents an in-app billing purchase.
 */
public class Purchase implements Serializable
{
    private static final long serialVersionUID = 1L;

    protected String sku;
    protected String json;
    protected String token;
    protected String orderId;
    protected String packageName;
    protected String developerPayload;
    protected long purchaseTime;
    protected int purchaseState;
    protected String signature;

    public Purchase(String sku)
    {
        this.sku = sku;
    }

    public Purchase(String json, String signature) throws JSONException
    {
        this.json = json;
        JSONObject o = new JSONObject(json);
        this.orderId = o.optString("orderId");
        this.packageName = o.optString("packageName");
        this.sku = o.optString("productId");
        this.purchaseTime = o.optLong("purchaseTime");
        this.purchaseState = o.optInt("purchaseState");
        this.developerPayload = o.optString("developerPayload");
        this.token = o.optString("token", o.optString("purchaseToken"));
        this.signature = signature;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public String getSku()
    {
        return sku;
    }

    public long getPurchaseTime()
    {
        return purchaseTime;
    }

    public int getPurchaseState()
    {
        return purchaseState;
    }

    public String getDeveloperPayload()
    {
        return developerPayload;
    }

    public String getToken()
    {
        return token;
    }

    public String getJson()
    {
        return json;
    }

    public String getSignature()
    {
        return signature;
    }

    @Override
    public String toString()
    {
        return sku + "\n" + json;
    }
}

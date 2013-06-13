package mc.inappbilling;

import org.json.JSONException;
import org.json.JSONObject;

public class Product
{
    String sku;
    String type;
    String price;
    String title;
    String description;
    String json;

    public Product(String json) throws JSONException
    {
        JSONObject o = new JSONObject(json);
        sku = o.optString("productId");
        type = o.optString("type");
        price = o.optString("price");
        title = o.optString("title");
        description = o.optString("description");
        this.json = json;
    }

    public String getSku()
    {
        return sku;
    }

    public String getType()
    {
        return type;
    }

    public String getPrice()
    {
        return price;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return json;
    }
}

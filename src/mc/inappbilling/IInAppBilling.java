package mc.inappbilling;

import java.io.Closeable;

public interface IInAppBilling extends Closeable
{
    /**
     * 
     * @return
     */
    boolean isBillingSupported();

    /**
     * 
     * @param productId
     * @param listener
     */
    void getProduct(String productId, OnCompleteListener<Product> listener);

    /**
     * 
     * @param purchase
     * @param listener
     */
    void buyProduct(String productId, OnCompleteListener<Purchase> listener);

    /**
     * 
     * @param listener
     */
    void getPurchases(OnCompleteListener<Inventory> listener);

    /**
     * 
     * @param purchase
     * @param listener
     */
    void consumePurchase(Purchase purchase, OnCompleteListener<Boolean> listener);

    /**
     * Never forget to call close method after you done with all billing operations
     */
    void close();
}

package mc.inappbilling.v3;


public class InAppBillingException extends Exception
{
    private static final long serialVersionUID = 1L;
    private InAppBillingResult mResult;

    public InAppBillingException(InAppBillingResult r)
    {
        this(r, null);
    }

    public InAppBillingException(int response, String message)
    {
        this(new InAppBillingResult(response, message));
    }

    public InAppBillingException(InAppBillingResult r, Exception cause)
    {
        super(r.getMessage(), cause);
        mResult = r;
    }

    public InAppBillingException(int response, String message, Exception cause)
    {
        this(new InAppBillingResult(response, message), cause);
    }

    /** Returns the IAB result (error) that this exception signals. */
    public InAppBillingResult getResult()
    {
        return mResult;
    }

}

mc.inappbilling
===============

Lib to deal with Google Play in-app purchasing for android



To use this lib you have to declare:

    <uses-permission android:name="com.android.vending.BILLING" />
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    
and

	<activity
    	android:name="mc.inappbilling.v3.InAppBillingActivity"
        android:theme="@android:style/Theme.NoDisplay" />
        
in your AndroidMainfest.xml file.
// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.0

package cy.its.service.imageQuery.ice.generated;

// <auto-generated>
//
// Generated from file `PassingImageStore.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


public abstract class Callback_PassingImageStore_StoreVehicle2 extends Ice.TwowayCallback
{
    public abstract void response(boolean __ret, PassingVehicle savedVehicle);

    public final void __completed(Ice.AsyncResult __result)
    {
        PassingImageStorePrx __proxy = (PassingImageStorePrx)__result.getProxy();
        boolean __ret = false;
        PassingVehicleHolder savedVehicle = new PassingVehicleHolder();
        try
        {
            __ret = __proxy.end_StoreVehicle2(savedVehicle, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, savedVehicle.value);
    }
}

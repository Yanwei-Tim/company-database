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
// Generated from file `PlateImageStore.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


final class _AMD_PlateImageStore_StoreVehicle2 extends IceInternal.IncomingAsync implements AMD_PlateImageStore_StoreVehicle2
{
    public
    _AMD_PlateImageStore_StoreVehicle2(IceInternal.Incoming in)
    {
        super(in);
    }

    public void
    ice_response(boolean __ret, PassingVehicle savedVehicle)
    {
        if(__validateResponse(true))
        {
            try
            {
                IceInternal.BasicStream __os = this.__os();
                savedVehicle.__write(__os);
                __os.writeBool(__ret);
            }
            catch(Ice.LocalException __ex)
            {
                ice_exception(__ex);
            }
            __response(true);
        }
    }
}

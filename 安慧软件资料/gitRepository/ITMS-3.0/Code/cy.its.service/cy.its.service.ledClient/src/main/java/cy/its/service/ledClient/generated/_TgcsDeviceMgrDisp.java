// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.0

package cy.its.service.ledClient.generated;

// <auto-generated>
//
// Generated from file `tgcs_device_mgr.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


@SuppressWarnings("serial")
public abstract class _TgcsDeviceMgrDisp extends Ice.ObjectImpl implements TgcsDeviceMgr
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::TgcsIce::TgcsDeviceMgr"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public final void
    AddDevice_async(AMD_TgcsDeviceMgr_AddDevice __cb, TgcsDevice[] listDev)
    {
        AddDevice_async(__cb, listDev, null);
    }

    public final void
    DeleteDevice_async(AMD_TgcsDeviceMgr_DeleteDevice __cb, TgcsDevice[] listDev)
    {
        DeleteDevice_async(__cb, listDev, null);
    }

    public final void
    GetDevices_async(AMD_TgcsDeviceMgr_GetDevices __cb)
    {
        GetDevices_async(__cb, null);
    }

    public final void
    ModifyDevice_async(AMD_TgcsDeviceMgr_ModifyDevice __cb, TgcsDevice[] listDev)
    {
        ModifyDevice_async(__cb, listDev, null);
    }

    public static Ice.DispatchStatus
    ___AddDevice(TgcsDeviceMgr __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        TgcsDevice[] listDev;
        listDev = TgcsDeviceListHelper.read(__is);
        __is.endReadEncaps();
        AMD_TgcsDeviceMgr_AddDevice __cb = new _AMD_TgcsDeviceMgr_AddDevice(__inS);
        try
        {
            __obj.AddDevice_async(__cb, listDev, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___ModifyDevice(TgcsDeviceMgr __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        TgcsDevice[] listDev;
        listDev = TgcsDeviceListHelper.read(__is);
        __is.endReadEncaps();
        AMD_TgcsDeviceMgr_ModifyDevice __cb = new _AMD_TgcsDeviceMgr_ModifyDevice(__inS);
        try
        {
            __obj.ModifyDevice_async(__cb, listDev, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___DeleteDevice(TgcsDeviceMgr __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        TgcsDevice[] listDev;
        listDev = TgcsDeviceListHelper.read(__is);
        __is.endReadEncaps();
        AMD_TgcsDeviceMgr_DeleteDevice __cb = new _AMD_TgcsDeviceMgr_DeleteDevice(__inS);
        try
        {
            __obj.DeleteDevice_async(__cb, listDev, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___GetDevices(TgcsDeviceMgr __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        AMD_TgcsDeviceMgr_GetDevices __cb = new _AMD_TgcsDeviceMgr_GetDevices(__inS);
        try
        {
            __obj.GetDevices_async(__cb, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    private final static String[] __all =
    {
        "AddDevice",
        "DeleteDevice",
        "GetDevices",
        "ModifyDevice",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___AddDevice(this, in, __current);
            }
            case 1:
            {
                return ___DeleteDevice(this, in, __current);
            }
            case 2:
            {
                return ___GetDevices(this, in, __current);
            }
            case 3:
            {
                return ___ModifyDevice(this, in, __current);
            }
            case 4:
            {
                return ___ice_id(this, in, __current);
            }
            case 5:
            {
                return ___ice_ids(this, in, __current);
            }
            case 6:
            {
                return ___ice_isA(this, in, __current);
            }
            case 7:
            {
                return ___ice_ping(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type TgcsIce::TgcsDeviceMgr was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type TgcsIce::TgcsDeviceMgr was not generated with stream support";
        throw ex;
    }
}

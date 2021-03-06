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


public abstract class _PassingImageStoreDisp extends Ice.ObjectImpl implements PassingImageStore
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
        "::LDTSSInterface::PassingImageStore"
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

    public final int
    CountVehicleByTime(String startTime, String endTime, String deviceNo)
    {
        return CountVehicleByTime(startTime, endTime, deviceNo, null);
    }

    public final PassingVehicle[]
    QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex)
    {
        return QueryVehicleByTime(startTime, endTime, deviceNo, pageSize, pageIndex, null);
    }

    public final VehicleImage[]
    RetrieveVehicleImages(String deviceNo, String snapNbr)
    {
        return RetrieveVehicleImages(deviceNo, snapNbr, null);
    }

    public final PassingVehicle[]
    RetrieveVehicleInfo(String deviceNo, String snapNbr)
    {
        return RetrieveVehicleInfo(deviceNo, snapNbr, null);
    }

    public final void
    StoreVehicle_async(AMD_PassingImageStore_StoreVehicle __cb, PassingVehicle vehicle, VehicleImage[] vehicleImages)
    {
        StoreVehicle_async(__cb, vehicle, vehicleImages, null);
    }

    public final void
    StoreVehicle2_async(AMD_PassingImageStore_StoreVehicle2 __cb, PassingVehicle vehicle, byte[] imageData)
    {
        StoreVehicle2_async(__cb, vehicle, imageData, null);
    }

    public final boolean
    UpdateVehicleInfo(PassingVehicle vehicle, PassingVehicleHolder savedVehicle)
    {
        return UpdateVehicleInfo(vehicle, savedVehicle, null);
    }

    public static Ice.DispatchStatus
    ___StoreVehicle(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        PassingVehicle vehicle;
        vehicle = new PassingVehicle();
        vehicle.__read(__is);
        VehicleImage[] vehicleImages;
        vehicleImages = VehicleImageSeqHelper.read(__is);
        __is.endReadEncaps();
        AMD_PassingImageStore_StoreVehicle __cb = new _AMD_PassingImageStore_StoreVehicle(__inS);
        try
        {
            __obj.StoreVehicle_async(__cb, vehicle, vehicleImages, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___StoreVehicle2(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        PassingVehicle vehicle;
        vehicle = new PassingVehicle();
        vehicle.__read(__is);
        byte[] imageData;
        imageData = Ice.ByteSeqHelper.read(__is);
        __is.endReadEncaps();
        AMD_PassingImageStore_StoreVehicle2 __cb = new _AMD_PassingImageStore_StoreVehicle2(__inS);
        try
        {
            __obj.StoreVehicle2_async(__cb, vehicle, imageData, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___RetrieveVehicleInfo(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String deviceNo;
        deviceNo = __is.readString();
        String snapNbr;
        snapNbr = __is.readString();
        __is.endReadEncaps();
        IceInternal.BasicStream __os = __inS.os();
        PassingVehicle[] __ret = __obj.RetrieveVehicleInfo(deviceNo, snapNbr, __current);
        PassingVehicleSeqHelper.write(__os, __ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___RetrieveVehicleImages(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String deviceNo;
        deviceNo = __is.readString();
        String snapNbr;
        snapNbr = __is.readString();
        __is.endReadEncaps();
        IceInternal.BasicStream __os = __inS.os();
        VehicleImage[] __ret = __obj.RetrieveVehicleImages(deviceNo, snapNbr, __current);
        VehicleImageSeqHelper.write(__os, __ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___QueryVehicleByTime(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String startTime;
        startTime = __is.readString();
        String endTime;
        endTime = __is.readString();
        String deviceNo;
        deviceNo = __is.readString();
        int pageSize;
        pageSize = __is.readInt();
        int pageIndex;
        pageIndex = __is.readInt();
        __is.endReadEncaps();
        IceInternal.BasicStream __os = __inS.os();
        PassingVehicle[] __ret = __obj.QueryVehicleByTime(startTime, endTime, deviceNo, pageSize, pageIndex, __current);
        PassingVehicleSeqHelper.write(__os, __ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___CountVehicleByTime(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String startTime;
        startTime = __is.readString();
        String endTime;
        endTime = __is.readString();
        String deviceNo;
        deviceNo = __is.readString();
        __is.endReadEncaps();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.CountVehicleByTime(startTime, endTime, deviceNo, __current);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___UpdateVehicleInfo(PassingImageStore __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        PassingVehicle vehicle;
        vehicle = new PassingVehicle();
        vehicle.__read(__is);
        __is.endReadEncaps();
        PassingVehicleHolder savedVehicle = new PassingVehicleHolder();
        IceInternal.BasicStream __os = __inS.os();
        boolean __ret = __obj.UpdateVehicleInfo(vehicle, savedVehicle, __current);
        savedVehicle.value.__write(__os);
        __os.writeBool(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "CountVehicleByTime",
        "QueryVehicleByTime",
        "RetrieveVehicleImages",
        "RetrieveVehicleInfo",
        "StoreVehicle",
        "StoreVehicle2",
        "UpdateVehicleInfo",
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
                return ___CountVehicleByTime(this, in, __current);
            }
            case 1:
            {
                return ___QueryVehicleByTime(this, in, __current);
            }
            case 2:
            {
                return ___RetrieveVehicleImages(this, in, __current);
            }
            case 3:
            {
                return ___RetrieveVehicleInfo(this, in, __current);
            }
            case 4:
            {
                return ___StoreVehicle(this, in, __current);
            }
            case 5:
            {
                return ___StoreVehicle2(this, in, __current);
            }
            case 6:
            {
                return ___UpdateVehicleInfo(this, in, __current);
            }
            case 7:
            {
                return ___ice_id(this, in, __current);
            }
            case 8:
            {
                return ___ice_ids(this, in, __current);
            }
            case 9:
            {
                return ___ice_isA(this, in, __current);
            }
            case 10:
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
        ex.reason = "type LDTSSInterface::PassingImageStore was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type LDTSSInterface::PassingImageStore was not generated with stream support";
        throw ex;
    }
}

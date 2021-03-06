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
// Generated from file `tgcs_base.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


/**
 * �豸��Ϣ
 **/
@SuppressWarnings("serial")
public class DeviceInfo implements java.lang.Cloneable, java.io.Serializable
{
    public String regionNo;

    public String devNo;

    public String devIp;

    public String devModel;

    public int screenNo;

    public int devPort;

    public int colorType;

    public DeviceInfo()
    {
    }

    public DeviceInfo(String regionNo, String devNo, String devIp, String devModel, int screenNo, int devPort, int colorType)
    {
        this.regionNo = regionNo;
        this.devNo = devNo;
        this.devIp = devIp;
        this.devModel = devModel;
        this.screenNo = screenNo;
        this.devPort = devPort;
        this.colorType = colorType;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        DeviceInfo _r = null;
        try
        {
            _r = (DeviceInfo)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(regionNo != _r.regionNo && regionNo != null && !regionNo.equals(_r.regionNo))
            {
                return false;
            }
            if(devNo != _r.devNo && devNo != null && !devNo.equals(_r.devNo))
            {
                return false;
            }
            if(devIp != _r.devIp && devIp != null && !devIp.equals(_r.devIp))
            {
                return false;
            }
            if(devModel != _r.devModel && devModel != null && !devModel.equals(_r.devModel))
            {
                return false;
            }
            if(screenNo != _r.screenNo)
            {
                return false;
            }
            if(devPort != _r.devPort)
            {
                return false;
            }
            if(colorType != _r.colorType)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 0;
        if(regionNo != null)
        {
            __h = 5 * __h + regionNo.hashCode();
        }
        if(devNo != null)
        {
            __h = 5 * __h + devNo.hashCode();
        }
        if(devIp != null)
        {
            __h = 5 * __h + devIp.hashCode();
        }
        if(devModel != null)
        {
            __h = 5 * __h + devModel.hashCode();
        }
        __h = 5 * __h + screenNo;
        __h = 5 * __h + devPort;
        __h = 5 * __h + colorType;
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(regionNo);
        __os.writeString(devNo);
        __os.writeString(devIp);
        __os.writeString(devModel);
        __os.writeInt(screenNo);
        __os.writeInt(devPort);
        __os.writeInt(colorType);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        regionNo = __is.readString();
        devNo = __is.readString();
        devIp = __is.readString();
        devModel = __is.readString();
        screenNo = __is.readInt();
        devPort = __is.readInt();
        colorType = __is.readInt();
    }
}

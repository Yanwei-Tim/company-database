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


public enum EHorizontalAlign implements java.io.Serializable
{
    
    HorizontalAlignLeft,
    
    HorizontalAlignMid,
    
    HorizontalAlignRight;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static EHorizontalAlign
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(3);
        return values()[__v];
    }
}

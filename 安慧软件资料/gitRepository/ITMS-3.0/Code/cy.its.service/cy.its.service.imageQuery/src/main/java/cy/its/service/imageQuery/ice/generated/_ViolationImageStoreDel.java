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
// Generated from file `ViolationImageStore.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


public interface _ViolationImageStoreDel extends Ice._ObjectDel
{
    boolean StoreViolation(ViolationVehicle violation, VehicleImage[] vehicleImages, ViolationVehicleHolder savedViolation, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean StoreViolation2(ViolationVehicle violation, byte[] imageData, ViolationVehicleHolder savedViolation, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    ViolationVehicle[] RetrieveViolationInfo(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    VehicleImage[] RetrieveViolationImages(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    VehicleImage[] RetrieveViolationMedia(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    ViolationVehicle[] QueryViolationByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int CountViolationByTime(String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean UpdateViolaitonInfo(ViolationVehicle vehicle, ViolationVehicleHolder savedVehicle, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}

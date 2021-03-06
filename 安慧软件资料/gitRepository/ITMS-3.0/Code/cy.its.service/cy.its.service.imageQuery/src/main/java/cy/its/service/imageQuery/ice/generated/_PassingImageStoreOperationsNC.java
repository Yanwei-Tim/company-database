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


public interface _PassingImageStoreOperationsNC
{
    void StoreVehicle_async(AMD_PassingImageStore_StoreVehicle __cb, PassingVehicle vehicle, VehicleImage[] vehicleImages);

    void StoreVehicle2_async(AMD_PassingImageStore_StoreVehicle2 __cb, PassingVehicle vehicle, byte[] imageData);

    PassingVehicle[] RetrieveVehicleInfo(String deviceNo, String snapNbr);

    VehicleImage[] RetrieveVehicleImages(String deviceNo, String snapNbr);

    PassingVehicle[] QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex);

    int CountVehicleByTime(String startTime, String endTime, String deviceNo);

    boolean UpdateVehicleInfo(PassingVehicle vehicle, PassingVehicleHolder savedVehicle);
}

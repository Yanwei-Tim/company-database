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


public interface PassingImageStorePrx extends Ice.ObjectPrx
{
    public boolean StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, PassingVehicleHolder savedVehicle);

    public boolean StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, PassingVehicleHolder savedVehicle, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, Ice.Callback __cb);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, Callback_PassingImageStore_StoreVehicle __cb);

    public Ice.AsyncResult begin_StoreVehicle(PassingVehicle vehicle, VehicleImage[] vehicleImages, java.util.Map<String, String> __ctx, Callback_PassingImageStore_StoreVehicle __cb);

    public boolean end_StoreVehicle(PassingVehicleHolder savedVehicle, Ice.AsyncResult __result);

    public boolean StoreVehicle_async(AMI_PassingImageStore_StoreVehicle __cb, PassingVehicle vehicle, VehicleImage[] vehicleImages);

    public boolean StoreVehicle_async(AMI_PassingImageStore_StoreVehicle __cb, PassingVehicle vehicle, VehicleImage[] vehicleImages, java.util.Map<String, String> __ctx);

    public boolean StoreVehicle2(PassingVehicle vehicle, byte[] imageData, PassingVehicleHolder savedVehicle);

    public boolean StoreVehicle2(PassingVehicle vehicle, byte[] imageData, PassingVehicleHolder savedVehicle, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData, Ice.Callback __cb);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData, Callback_PassingImageStore_StoreVehicle2 __cb);

    public Ice.AsyncResult begin_StoreVehicle2(PassingVehicle vehicle, byte[] imageData, java.util.Map<String, String> __ctx, Callback_PassingImageStore_StoreVehicle2 __cb);

    public boolean end_StoreVehicle2(PassingVehicleHolder savedVehicle, Ice.AsyncResult __result);

    public boolean StoreVehicle2_async(AMI_PassingImageStore_StoreVehicle2 __cb, PassingVehicle vehicle, byte[] imageData);

    public boolean StoreVehicle2_async(AMI_PassingImageStore_StoreVehicle2 __cb, PassingVehicle vehicle, byte[] imageData, java.util.Map<String, String> __ctx);

    public PassingVehicle[] RetrieveVehicleInfo(String deviceNo, String snapNbr);

    public PassingVehicle[] RetrieveVehicleInfo(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr, Ice.Callback __cb);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr, Callback_PassingImageStore_RetrieveVehicleInfo __cb);

    public Ice.AsyncResult begin_RetrieveVehicleInfo(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx, Callback_PassingImageStore_RetrieveVehicleInfo __cb);

    public PassingVehicle[] end_RetrieveVehicleInfo(Ice.AsyncResult __result);

    public boolean RetrieveVehicleInfo_async(AMI_PassingImageStore_RetrieveVehicleInfo __cb, String deviceNo, String snapNbr);

    public boolean RetrieveVehicleInfo_async(AMI_PassingImageStore_RetrieveVehicleInfo __cb, String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public VehicleImage[] RetrieveVehicleImages(String deviceNo, String snapNbr);

    public VehicleImage[] RetrieveVehicleImages(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr, Ice.Callback __cb);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr, Callback_PassingImageStore_RetrieveVehicleImages __cb);

    public Ice.AsyncResult begin_RetrieveVehicleImages(String deviceNo, String snapNbr, java.util.Map<String, String> __ctx, Callback_PassingImageStore_RetrieveVehicleImages __cb);

    public VehicleImage[] end_RetrieveVehicleImages(Ice.AsyncResult __result);

    public boolean RetrieveVehicleImages_async(AMI_PassingImageStore_RetrieveVehicleImages __cb, String deviceNo, String snapNbr);

    public boolean RetrieveVehicleImages_async(AMI_PassingImageStore_RetrieveVehicleImages __cb, String deviceNo, String snapNbr, java.util.Map<String, String> __ctx);

    public PassingVehicle[] QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex);

    public PassingVehicle[] QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, Ice.Callback __cb);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, Callback_PassingImageStore_QueryVehicleByTime __cb);

    public Ice.AsyncResult begin_QueryVehicleByTime(String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx, Callback_PassingImageStore_QueryVehicleByTime __cb);

    public PassingVehicle[] end_QueryVehicleByTime(Ice.AsyncResult __result);

    public boolean QueryVehicleByTime_async(AMI_PassingImageStore_QueryVehicleByTime __cb, String startTime, String endTime, String deviceNo, int pageSize, int pageIndex);

    public boolean QueryVehicleByTime_async(AMI_PassingImageStore_QueryVehicleByTime __cb, String startTime, String endTime, String deviceNo, int pageSize, int pageIndex, java.util.Map<String, String> __ctx);

    public int CountVehicleByTime(String startTime, String endTime, String deviceNo);

    public int CountVehicleByTime(String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo, Ice.Callback __cb);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo, Callback_PassingImageStore_CountVehicleByTime __cb);

    public Ice.AsyncResult begin_CountVehicleByTime(String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx, Callback_PassingImageStore_CountVehicleByTime __cb);

    public int end_CountVehicleByTime(Ice.AsyncResult __result);

    public boolean CountVehicleByTime_async(AMI_PassingImageStore_CountVehicleByTime __cb, String startTime, String endTime, String deviceNo);

    public boolean CountVehicleByTime_async(AMI_PassingImageStore_CountVehicleByTime __cb, String startTime, String endTime, String deviceNo, java.util.Map<String, String> __ctx);

    public boolean UpdateVehicleInfo(PassingVehicle vehicle, PassingVehicleHolder savedVehicle);

    public boolean UpdateVehicleInfo(PassingVehicle vehicle, PassingVehicleHolder savedVehicle, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle, Ice.Callback __cb);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle, Callback_PassingImageStore_UpdateVehicleInfo __cb);

    public Ice.AsyncResult begin_UpdateVehicleInfo(PassingVehicle vehicle, java.util.Map<String, String> __ctx, Callback_PassingImageStore_UpdateVehicleInfo __cb);

    public boolean end_UpdateVehicleInfo(PassingVehicleHolder savedVehicle, Ice.AsyncResult __result);

    public boolean UpdateVehicleInfo_async(AMI_PassingImageStore_UpdateVehicleInfo __cb, PassingVehicle vehicle);

    public boolean UpdateVehicleInfo_async(AMI_PassingImageStore_UpdateVehicleInfo __cb, PassingVehicle vehicle, java.util.Map<String, String> __ctx);
}

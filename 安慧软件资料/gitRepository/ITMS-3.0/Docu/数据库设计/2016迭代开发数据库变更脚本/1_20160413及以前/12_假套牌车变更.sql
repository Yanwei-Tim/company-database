set define off
spool 12_�����Ƴ����.log

-- Add/modify columns 
alter table T_VEHTRACK_CLONE_VEHICLE add plate_type VARCHAR2(2);
alter table T_VEHTRACK_CLONE_VEHICLE add org_authority_code VARCHAR2(32);
-- Add comments to the columns 
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_type
  is '��������';
comment on column T_VEHTRACK_CLONE_VEHICLE.org_authority_code
  is '�������Ȩ�޴���';
  
-- Add/modify columns 
alter table T_VEHTRACK_FAKE_CLONE add org_authority_code VARCHAR2(32);
-- Add comments to the columns 
comment on column T_VEHTRACK_FAKE_CLONE.org_authority_code
  is '�������Ȩ�޴���';
  
-- Add/modify columns 
alter table T_VEHTRACK_FAKE_VEHICLE add plate_type VARCHAR2(2);
alter table T_VEHTRACK_FAKE_VEHICLE add org_authority_code VARCHAR2(32);
-- Add comments to the columns 
comment on column T_VEHTRACK_FAKE_VEHICLE.plate_type
  is '��������';
comment on column T_VEHTRACK_FAKE_VEHICLE.org_authority_code
  is '�������Ȩ�޴���';

spool off

exit;
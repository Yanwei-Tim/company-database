set define off
spool 5_4_����ά������.log

alter table T_DEVICE_FAULT_LOG modify fault_sub_type VARCHAR2(5);
-- Add comments to the columns 
comment on column T_DEVICE_FAULT_LOG.fault_type
  is '����/�������͡�11:����ӹ���;12:�״��ӹ���;13:��Դ�ӹ���;14:��Ȧ�ӹ���;15:�����ӹ���;16:GPS�����ӹ���;17:�ܼ������ӹ���;18:LED�ӹ���;99:��������;';

-- Add/modify columns 
alter table T_DEVICE_FAULT modify fault_sub_type VARCHAR2(5);
-- Add comments to the columns 
comment on column T_DEVICE_FAULT.fault_type
  is '����/�������͡�11:����ӹ���;12:�״��ӹ���;13:��Դ�ӹ���;14:��Ȧ�ӹ���;15:�����ӹ���;16:GPS�����ӹ���;17:�ܼ������ӹ���;18:LED�ӹ���;99:��������;';
  
  
spool off

exit;

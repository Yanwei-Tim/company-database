set define off
spool 6_�豸��װ�����Ӽ춨��ʶ.log

alter table T_DEVICE_EQUIPMENT add(verification_mark varchar2(5));
alter table T_DEVICE_SYS add(verification_mark varchar2(5));
alter table T_DEVICE_REGION add(verification_mark varchar2(5));


COMMENT ON COLUMN T_DEVICE_EQUIPMENT."VERIFICATION_MARK" IS
'�춨��ʶ 0 ����Ҫ�춨 1 ��Ҫ�춨';

COMMENT ON COLUMN T_DEVICE_SYS."VERIFICATION_MARK" IS
'�춨��ʶ 0 ����Ҫ�춨 1 ��Ҫ�춨';

COMMENT ON COLUMN T_DEVICE_REGION."VERIFICATION_MARK" IS
'�춨��ʶ 0 ����Ҫ�춨 1 ��Ҫ�춨';


spool off

exit;
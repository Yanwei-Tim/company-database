set define off
spool 4_1_�춨�������.log

--ɾ���춨��Ϣ��deviceId�ֶ�
alter table T_DEVICE_CERTIFICATION drop (device_id);

alter table T_DEVICE_CERTIFICATION_RECORD add(REMARK varchar2(256));

COMMENT ON COLUMN T_DEVICE_CERTIFICATION_RECORD.REMARK IS '��ע';

spool off

exit;
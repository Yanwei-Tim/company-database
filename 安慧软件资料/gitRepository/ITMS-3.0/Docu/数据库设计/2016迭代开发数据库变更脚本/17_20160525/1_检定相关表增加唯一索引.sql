set define off
spool 17_1_�춨��ر�����Ψһ����.log

--�춨��Ϣ����[֤����]��Ψһ����
create unique index IDX_DEVICECERTIFICATION_01 on T_DEVICE_CERTIFICATION (CERTIFICATION_NBR);
--�춨֤�����������¼��[�춨֤��,����]�����������
create unique index IDX_CERTIFICATIONRECORD_01 on T_DEVICE_CERTIFICATION_RECORD (CERTIFICATION_NBR,IMPORT_DATE);


spool off

exit;
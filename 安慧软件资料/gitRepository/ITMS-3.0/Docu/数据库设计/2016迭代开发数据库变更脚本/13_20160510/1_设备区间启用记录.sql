set define off
spool 13_1_�豸�������ü�¼.log


--�޸�����ϵͳ������ʹ��״̬����ʱ���ֶ�
alter table T_DEVICE_REGION ADD ENABLE_UPDATE_DATE DATE ;
comment on column T_DEVICE_REGION.ENABLE_UPDATE_DATE is 'ʹ��״̬����ʱ��';

--�޸�ʹ��״̬��־��
alter table T_DEVICE_SYS_USE_STATUS ADD DEVICE_OR_REGION CHAR(1) ;
comment on column T_DEVICE_SYS_USE_STATUS.DEVICE_OR_REGION is '�豸�����䡣1.�豸��2.����';



spool off

exit;
